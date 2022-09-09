package com.codewithkrishanthi.dao;

public class FactoryDao {
	
	
	public DbConnector getDb(String type) {
		if(type=="MySql") {
			return new DbConnectorImplMySql();
		}
		else
		{
			return null;
		}
		
	}

}
