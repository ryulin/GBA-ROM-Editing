package org.hacking.rom;

/**
 * A container for GBA ROM information, such as the ROM title, maker code, header code, and more! 
 * 
 * @author kurroku
 */
public class AccessROMInformation {
	private String gameName;
	private String headerCode;
	private String language;
	private String version;
	
	/**
	 * Default Constructor
	 */
	public AccessROMInformation() {
		this("", "", "", "");
	}
	
	/**
	 * @param gameName
	 * 			The name of the game
	 */
	public AccessROMInformation(String gameName) {
		this(gameName, "", "", "");
	}
	
	/**
	 * @param gameName
	 * 			The name of the game
	 * @param headerCode
	 * 			The game's header code
	 */
	public AccessROMInformation(String gameName, String headerCode) {
		this(gameName, headerCode, "", "");
	}
	
	/**
	 * @param gameName
	 * 			The name of the game
	 * @param headerCode
	 * 			The game's header code
	 * @param language
	 * 			The language of the game
	 */
	public AccessROMInformation(String gameName, String headerCode, String language) {
		this(gameName, headerCode, language, "");
	}
	
	/**
	 * @param gameName
	 * 			The name of the game
	 * @param headerCode
	 * 			The game's header code
	 * @param language
	 * 			The language of the game
	 * @param version
	 * 			The current version of the game
	 */
	public AccessROMInformation(String gameName, String headerCode, String language, String version) {
		setGameName(gameName);
		setHeaderCode(headerCode);
		setLanguage(language);
		setVersion(version);
	}
	
	/**
	 * Updates the game's name to be used internally. This does not change anything in the ROM at all.
	 * 
	 * @param name
	 * 		The game name
	 */
	public void setGameName(String name) {
		this.gameName = name;
	}
	
	/**
	 * Updates the game's header code to be used internally. This does not change anything in the ROM at all.
	 * 
	 * @param headerCode
	 * 		The header code of the game
	 */
	public void setHeaderCode(String headerCode) {
		this.headerCode = headerCode;
	}
	
	/**
	 * Updates the game's language to be used internally. This does not change anything in the ROM at all.
	 * 
	 * @param language
	 * 		The language of the game
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Ypdates the game's version to be used internally. This does not change anything in the ROM at all.
	 * 
	 * @param version
	 * 		The version of the game
	 */
	public void setVersion(String version) {
		this.version = "1." + version;
	}
	
	/**
	 * Get the game's name
	 * 
	 * @return
	 * 		Game name
	 */
	public String getGameName() {
		return gameName;
	}
	
	/**
	 * Get the game's header code
	 * 
	 * @return
	 * 		Header code
	 */
	public String getHeaderCode() {
		return headerCode;
	}
	
	/**
	 * Get the game's language
	 * 
	 * @return
	 * 		Game language
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Get the game's version
	 * 
	 * @return
	 * 		Game version
	 */
	public String getVersion() {
		return version;
	}
}

