package org.hacking.rom.map.data;

import static org.hacking.rom.AccessROMDataType.BYTE;
import static org.hacking.rom.AccessROMDataType.SHORT;

import org.hacking.rom.AccessROM;

/**
 * This class contains a map header, which is a collection of map metadata. This metadata includes 
 * important information which is needed for other components of the map, including {@link MapConnection} 
 * and {@link MapFooter} data.
 * 
 * @author kurroku
 */
public class MapHeader {
	
	/**
	 * The map footer, which contains information on tiles and tile structure
	 */
	private int footerAddress;
	
	/**
	 * The address in which map events are written
	 */
	private int eventsAddress;
	
	/**
	 * Where to read the map scripts from
	 */
	private int scriptsAddress;
	
	/**
	 * The address of relations (also called 'connections'
	 */
	private int relationsAddress;
	
	/**
	 * The music ID
	 */
	private short musicID;
	
	/**
	 * The label ID
	 */
	private short labelID;
	
	/**
	 * The map's visibility
	 */
	private byte visibilityType;
	
	/**
	 * The weather of the map
	 */
	private byte weatherType;
	
	/**
	 * The environment of the map
	 */
	private byte environmentType;
	
	/**
	 * Whether the map's label shows or not
	 */
	private boolean showLabel;
	
	/**
	 * The type of battles that take place on the map
	 */
	private byte battleType;
	
	/**
	 * Creates an instance of a parsed map header
	 * 
	 * @param rom
	 * 		The GBA ROM instance to read from
	 * @param address
	 * 		The address of the map header in ROM memory
	 */
	public MapHeader(AccessROM rom, int address) {
		this.footerAddress = rom.getPointer(address);
		this.eventsAddress = rom.getPointer();
		this.scriptsAddress = rom.getPointer();
		this.relationsAddress = rom.getPointer();
		this.musicID = (short) rom.get(SHORT);
		rom.skip(2); // there is an unknown short, no use reading
		this.labelID = (short) rom.get(SHORT);
		this.visibilityType = (byte) rom.get(BYTE);
		this.weatherType = (byte) rom.get(BYTE);
		this.environmentType = (byte) rom.get(BYTE);
		rom.skip(2); // there is an unknown short, no use reading
		this.showLabel = ((byte)rom.get(BYTE) == 1);
		this.battleType = (byte) rom.get(BYTE);
	}
	
	/**
	 * @return
	 * 		The address of footer (tilemap) data
	 */
	public int getFooterAddress() {
		return footerAddress;
	}
	
	/**
	 * @return
	 * 		The address of events data
	 */
	public int getEventsAddress() {
		return eventsAddress;
	}
	
	/**
	 * @return
	 * 		The address of script data
	 */
	public int getScriptsAddress() {
		return scriptsAddress;
	}
	
	/**
	 * @return
	 * 		The address of relation (also called 'connection') data
	 */
	public int getRelationsAddress() {
		return relationsAddress;
	}
	
	/**
	 * @return
	 * 		The map's music ID
	 */
	public short getMusicID() {
		return musicID;
	}
	
	/**
	 * @return
	 * 		The map's label ID
	 */
	public short getLabelID() {
		return labelID;
	}
	
	/**
	 * @return
	 * 		The visibility of the map
	 */
	public byte getVisibilityType() {
		return visibilityType;
	}
	
	/**
	 * @return
	 * 		The weather type of the map
	 */
	public byte getWeatherType() {
		return weatherType;
	}
	
	/**
	 * @return
	 * 		The environment type of the map
	 */
	public byte getEnvironmentType() {
		return environmentType;
	}
	
	/**
	 * @return
	 * 		Whether to show the map's label or not
	 */
	public boolean showLabel() {
		return showLabel;
	}
	
	/**
	 * @return
	 * 		The battle type of the map
	 */
	public byte getBattleType() {
		return battleType;
	}
}
