package com.lipari.app.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lipari.app.model.dao.DbConnection;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/app-context.xml");
		
		  DbConnection c = (DbConnection) context.getBean("dbConnection");
		  System.out.println(c.getConfigBean()==null);
		  System.out.println(c.getConfigBean().getDatabaseUsername());
		  System.out.println(c.getConfigBean().getDatabasePassword());
		 
		/*
		 * Class1 c = (Class1) context.getBean("class1");
		 * System.out.println(c.getPassword());
		 * System.out.println(c.getClass2().getDatabasePassword());
		 */
	}

}
