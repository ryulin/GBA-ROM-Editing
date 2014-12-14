package org.hacking.rom.map;

import org.hacking.rom.map.data.MapFooter;
import org.hacking.rom.map.data.MapHeader;
import org.hacking.rom.map.data.blockset.Blockset;
import org.hacking.rom.map.data.tile.Tileset;
import org.hacking.rom.map.data.tile.TilesetHeader;

/**
 * A container of all current map information.
 * 
 * @author kurroku
 */
public class Map {
	private MapHeader header;
	private MapFooter footer;
	private TilesetHeader secondaryTSHeader;
	private TilesetHeader primaryTSHeader;
	private Tileset secondaryTileset;
	private Tileset primaryTileset;
	private Blockset blockset;
	
	public Map(String index) {
		header = MapHeaderCache.get(index);
		
	}
}
