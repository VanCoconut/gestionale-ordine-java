package com.lipari.app.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

public class ConfigBean {

	private String databaseUrl;
	private String databaseUsername;
	private String databasePassword;

	public ConfigBean() throws FileNotFoundException, IOException {
		/*
		 * Properties p = new Properties(); p.load(new
		 * FileInputStream("database.properties")); this.databaseUrl =
		 * p.getProperty("url"); this.databaseUsername = p.getProperty("username");
		 * this.databasePassword = p.getProperty("password");
		 */
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

}
