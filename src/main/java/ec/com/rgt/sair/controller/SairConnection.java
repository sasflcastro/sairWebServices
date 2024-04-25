package ec.com.rgt.sair.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;

public class SairConnection {
	private final String CADENA_CONNECT = "jdbc:oracle:thin:@10.31.32.164:1521:AIC4";//"jdbc:oracle:thin:@localhost:2000:BSCSD";
	private final String USUARIO_SAIR = "USRSAIR";
	private final String USUARIO_PASS = "SAIR";
	private Connection connection;
	
	public void conectar() throws SQLException {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(CADENA_CONNECT,USUARIO_SAIR,USUARIO_PASS);
		} catch (SQLException e) {
			throw new SQLException("Error al Conectar a la base de datos. " + e.getMessage()); 
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection() throws SQLException{
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new SQLException("Error al cerrar la conexion a la BD.");
		}
	}
	
	public boolean isClose() throws SQLException{
		try {
			return this.connection.isClosed();
		} catch (SQLException e) {
			throw new SQLException("No es posible obtener el estado de la conexion.");
		}
	}	
}
