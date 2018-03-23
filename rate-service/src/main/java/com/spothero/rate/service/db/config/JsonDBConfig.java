package com.spothero.rate.service.db.config;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.DefaultAESCBCCipher;
import io.jsondb.crypto.ICipher;

/**
 * 
 * @author carlosdlr
 * Class that allows initialize the persistence context
 */
public class JsonDBConfig {

	private ObjectMapper objectMapper = null;
	private JsonDBTemplate jsonDBTemplate = null;
	private final static Logger LOGGER = Logger.getLogger(JsonDBConfig.class.getName());

	private static JsonDBConfig instance = null;

	private String dbFilesLocation = "src/main/resources/dbfiles";
	private File dbFilesFolder = new File(dbFilesLocation);
	private File instancesJson = new File(dbFilesFolder, "rates.json");
	private ICipher cipher;

	private JsonDBConfig(){}

	public static JsonDBConfig getInstance() {
		if (instance == null) {
			instance = new JsonDBConfig();
		}

		return instance;
	}

	public void setup() throws IOException {
		if(!dbFilesFolder.exists()){
			dbFilesFolder.mkdir();
			Files.copy(new File("src/main/resources/dbfiles/rates.json"), instancesJson);
		}

		try {
			cipher = new DefaultAESCBCCipher("1r8+24pibarAWgS85/Heeg==");
			 jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, "com.spothero.rate.service.model", cipher);
		} catch (GeneralSecurityException e) {
			LOGGER.log(Level.CONFIG, e.getMessage());
		}
		objectMapper = new ObjectMapper();
	}

	public ObjectMapper getObjectMapper(){
		return this.objectMapper;
	}

	public ICipher getICipher(){
		return this.cipher;
	}
	
	public JsonDBTemplate getJsonDBTemplate(){
		return this.jsonDBTemplate;
	}

}
