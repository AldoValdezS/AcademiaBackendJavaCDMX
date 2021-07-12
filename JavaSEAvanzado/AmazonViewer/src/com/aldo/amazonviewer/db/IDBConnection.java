package com.aldo.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.aldo.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connecToDB() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =DriverManager.getConnection(URL+DB,USER,PASSWORD);
			if (connection!=null) {
				System.out.println("Se estableció la conexión");
			}else {
				System.out.println("Problema al conectar a la bd");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return connection;
		}
		
	}

}
