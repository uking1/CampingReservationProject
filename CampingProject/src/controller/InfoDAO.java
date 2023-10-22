package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.InfoVO;

public class InfoDAO {
	
	// 예약자 등록
	public void setInfoRegiste(InfoVO ivo) throws Exception{
		
		String sql = "insert into reservationinfo values(reservationinfo_no_seq.nextval,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			
			
			
			
			
			
			
			
		}catch(SQLException se) {
			System.out.println(se);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
				
			}catch(SQLException se) {
				System.out.println(se);
			}
		}
		
		
	}
}
