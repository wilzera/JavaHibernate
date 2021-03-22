package org.libertas.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoJdbc {
	
	private Connection conexao;
	
	public ConexaoJdbc() {
		try {
			String url = "jdbc:mariadb://localhost:3306/lib";
			conexao = DriverManager.getConnection(url, "root", "123");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desconecta() {
		try {
			conexao.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
}
