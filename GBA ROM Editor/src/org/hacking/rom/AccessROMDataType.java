package org.hacking.rom;

/**
 * Enums used to control how many bytes we read from the {@link AccessROM}.
 * 
 * @author kurroku
 */
public enum AccessROMDataType {
	/**
	 * A byte is the value of one byte in the ROM
	 */
	BYTE,
	
	/**
	 * A character is the ASCII character of one byte in the ROM
	 */
	CHARACTER,
	
	/**
	 * A short (sometimes called 'word' is a 2-byte value in the ROM
	 */
	SHORT,
	
	/**
	 * An integer (sometimes called 'pointer' because pointers are of this size), is a 4-byte 
	 * value in the ROM.
	 */
	INTEGER

}
