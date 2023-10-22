package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ReservationVO;

public class ReservationDAO {
	// 예약 신청
	public void setReservationRegiste(ReservationVO rvo) throws Exception{
		String sql = "insert into reservation values(reservation_no_seq.nextval,?,?,?,sysdate)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rvo.getSite_id());
			pstmt.setString(2, rvo.getReservation_id());
			
			int i = pstmt.executeUpdate();
			
			if (i ==1){
				System.out.println("예약 완료되었습니다.");
			}else {
				System.out.println("예약에 실패했습니다.");
			}
			
			
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
