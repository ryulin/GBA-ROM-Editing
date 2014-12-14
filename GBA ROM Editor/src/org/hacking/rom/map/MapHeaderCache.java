package org.hacking.rom.map;

import java.util.HashMap;

import org.hacking.rom.map.data.MapHeader;

/**
 * The cache of headers we use to get map information from. These headers are set in 
 * {@link MapArchive}.

 * @author kurroku
 */
public class MapHeaderCache {
	
	/**
	 * The cache of headers we use to get map information from. These headers are set in 
	 * {@link MapArchive}.
	 */
	private static java.util.Map<String, MapHeader> headers = new HashMap<String, MapHeader>();
	
	/**
	 * Place a map header into the map cache
	 * 
	 * @param index
	 * 			The index of the map header. The {@link String} is in bank.map format. 
	 * 			For example, Pallet Town in FireRed would be "3.0", bank index 3 and map index 0
	 * @param header
	 */
	public static void put(String index, MapHeader header) {
		headers.put(index, header);
	}
	
	/**
	 * Get a map header instance which contains map metadata from the specific header.
	 * 
	 * @param index
	 * 			The index of the map header. The {@link String} is in bank.map format. 
	 * 			For example, Pallet Town in FireRed would be "3.0", bank index 3 and map index 0
	 * @return
	 * 			A {@link MapHeader} with metadata pre-contained
	 */
	public static MapHeader get(String index) {
		return headers.get(index);
	}
}
