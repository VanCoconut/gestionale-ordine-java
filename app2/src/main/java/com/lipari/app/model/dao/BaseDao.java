package com.lipari.app.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.lipari.app.exception.DataException;

public class BaseDao {
	
	
	
	
	public Connection getConnection() throws DataException {
		try {
			DbConnection dbCon = DbConnection.getInstance();
			//dbCon=DbConnection.getInstance();
			return dbCon.initService();
		} catch (SQLException e) {
			throw new DataException(e);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

}
