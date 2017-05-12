package mario.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mario.beans.ChineseWord;
import mario.utils.DatabaseUtils;

public class ChineseWordService {
	private Connection connection = null;
	
	public ChineseWord getChineseWordInfo(String word) {
		this.connection = DatabaseUtils.getCon();
		
		ChineseWord chineseWord = null;
		try {
			if (!this.connection.isClosed()) {
				 String sql = "select * from tt where zi = ?";
				 PreparedStatement psql = this.connection.prepareStatement(sql);
				 psql.setString(1, word);       
				 ResultSet rs = psql.executeQuery();
				 
				 while(rs.next()){
					 chineseWord = new ChineseWord(rs.getString("zi"), rs.getInt("sheng"), rs.getString("yun"));
				 }
				 rs.close();
				 this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chineseWord;
	}
}
