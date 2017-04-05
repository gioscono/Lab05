package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma){
		
		
		String sql = "SELECT * "+
				"FROM dizionario.parola "+
				"WHERE nome=?;";
			
		
		String jdbcURL  = "jdbc:mysql://localhost/dizionario?user=root";
		boolean ris=false;
		
		try{
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setString(1, anagramma);
			
			ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				ris = true;
			}
			conn.close();
			return ris;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
	}

}
