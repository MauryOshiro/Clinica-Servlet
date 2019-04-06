package br.com.maury.clinicaCristiano.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	private static DataSource dataSource;
	private static ComboPooledDataSource combo;
	
	static {
		String portaMySQL = "3306";
		String bd = "clinica_servlet";
		//ComboPooledDataSource pool = new ComboPooledDataSource();
		combo = new ComboPooledDataSource();
		try {
			combo.setDriverClass("com.mysql.cj.jdbc.Driver");
			//pool.setJdbcUrl("jdbc:mysql://localhost:3308/clinica_cristiano?useTimezone=true&serverTimezone=UTC");
			combo.setJdbcUrl("jdbc:mysql://localhost:"+portaMySQL+"/"+bd+"?useTimezone=true&serverTimezone=UTC");
			combo.setUser("root");
			combo.setPassword("");
			combo.setMinPoolSize(10);
			combo.setMaxPoolSize(50);
			combo.setInitialPoolSize(10);
			//this.dataSource = pool;
			dataSource = combo;
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	/*public ConnectionPool() throws Exception {
		//Este construtor cria a pool de conexões 
		String portaMySQL = "3306";
		String bd = "clinica_cristiano";
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setDriverClass("com.mysql.cj.jdbc.Driver");
		pool.setJdbcUrl("jdbc:mysql://localhost:"+portaMySQL+"/"+bd+"?useTimezone=true&serverTimezone=UTC");
		pool.setUser("root");
		pool.setPassword("");
		pool.setMinPoolSize(5);
		pool.setMaxPoolSize(30);
		pool.setInitialPoolSize(5);
		this.dataSource = pool;
		System.out.println("Qtd de conexões: "+pool.getNumBusyConnections());
	} */
	
	public static Connection getConnection() throws SQLException {
		/*	Este método retorna uma conexão
		 * */
		//Connection con = this.dataSource.getConnection();
		Connection con = dataSource.getConnection();
		//System.out.println("Conexões abertas: "+combo.getNumConnections());
		
		return con;
	}
}
