package org.hacking.rom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel.MapMode;
import static org.hacking.rom.AccessROMDataType.*;
/**
 * The main ROM controller. This class is responsible for reading and writing data in the GBA 
 * ROM.
 * 
 * @author kurroku
 */
public class AccessROM {
	/**
	 * The file we are reading/writing
	 */
	private RandomAccessFile accessedROM;
	
	/**
	 * The ROM buffer which allows fast access and safe manipulation, since it's a full copy of data.
	 */
	private ByteBuffer romBuffer;
	
	/**
	 * Creates a new GBA ROM container.
	 * 
	 * @param romFile
	 * 		The GBA ROM file
	 * @throws IOException
	 * 		Thrown if something goes wrong (file missing, corrupted, ect)
	 */
	public AccessROM(File romFile) throws IOException {
		this.accessedROM = new RandomAccessFile(romFile, "rw");
		this.romBuffer = accessedROM.getChannel().map(MapMode.READ_WRITE, 0, accessedROM.length());
		AccessROM.currentROM = this;
	}
	
	/**
	 * Reads a pointer in little endian format from the ROM. 
	 * Since the value at the address is 0x8000000 greater than the actual pointer's address 
	 * (I assume due to GBA RAM), this method must be used for reading pointers. 
	 * Do not use this method for reading standard GBA Integers.
	 * 
	 * @return
	 * 		A correct file pointer in little endian format
	 */
	public int getPointer() {
		return getPointer(getPosition());
	}
	
	/**
	 * Reads a pointer in little endian format from the ROM at a specific address. 
	 * Since the value at the address is 0x8000000 greater than the actual pointer's address 
	 * (I assume due to GBA RAM), this method must be used for reading pointers. 
	 * Do not use this method for reading standard GBA Integers.
	 * 
	 * @param cursor
	 * @return
	 */
	public int getPointer(int cursor) {
		if(cursor >= 0x8000000)
			cursor -= 0x8000000;
		
		return (int) get(INTEGER);
	}
	
	/**
	 * Gets a value from the ROM. The location it reads from corresponds to the last value set, 
	 * but offset by the number of bytes read or written (1 for byte/char, 2 for short, 4 for int).
	 * 
	 * @param dataType
	 * 		The data type determines how many bytes are read
	 * @return
	 * 		The value, which is automatically in little endian format
	 */
	public Object get(AccessROMDataType dataType) {
		return get(getPosition(), dataType);
	}
	
	/**
	 * Gets a value from the ROM at a specific location.
	 * 
	 * @param dataType
	 * 		The data type determines how many bytes are read
	 * @return
	 * 		The value, which is automatically in little endian format
	 */
	public Object get(int cursor, AccessROMDataType dataType) {
		romBuffer.position(cursor);
		
		switch (dataType) {
		case BYTE:
			return romBuffer.get();
		case CHARACTER:
			return (char) romBuffer.get();
		case SHORT:
			return romBuffer.order(ByteOrder.LITTLE_ENDIAN).getShort();
		case INTEGER:
			return romBuffer.order(ByteOrder.LITTLE_ENDIAN).getInt();
		default:
			throw new IllegalArgumentException("Unsupported data type: " + dataType);
		}
	}
	
	/**
	 * @return
	 * 		The current position we are reading or writing in the ROM
	 */
	public int getPosition() {
		return romBuffer.position();
	}
	
	/**
	 * Skip a number of bytes in the rom buffer.
	 * 
	 * @param offset
	 * 		The amount to offset, cannot be negative
	 */
	public void skip(int offset) {
		if(offset < 0)
			offset = 0;
		romBuffer.position(getPosition() + offset);
	}
	
	// These two should be kept at the bottom of this class and out of the way :)
	
	/**
	 * The current ROM in which we load all data from.
	 */
	private static AccessROM currentROM;
	
	/**
	 * A static method used when we can't obtain the current ROM from an instance.
	 * 
	 * @return
	 * 		The current ROM loaded into memory for manipulation
	 */
	public static AccessROM getROM() {
		return currentROM;
	}
}
