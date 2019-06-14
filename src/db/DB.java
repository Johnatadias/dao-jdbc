package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// CRIANDO UMA CONNEÇÃO COM BANCO DE DADOS
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = LoadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
		return conn;
	}

	//FECHANDO A CONNEÇÃO COM BANCO DE DADOS
	public static void CloseConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
	}

	// MEtODO PARA CARREGAR PROPERtIES DO DB
	private static Properties LoadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbExceptions(e.getMessage());
		}
	}
}
