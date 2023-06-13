package com.lipari.app.model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lipari.app.services.ConfigBean;

public class DbConnection {

	private static DbConnection _instance = null;

	static private ConfigBean configBean;

	private DbConnection() {
	}

	public Connection initService() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/app","root","root");

	}

	public static DbConnection getInstance() throws SQLException, FileNotFoundException, IOException {
		configBean = new ConfigBean();
		if (_instance != null) {
			return _instance;
		} else {
			_instance = new DbConnection();

		}
		return _instance;
	}

	public ConfigBean getConfigBean() {
		return this.configBean;
	}

}
