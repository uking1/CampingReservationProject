package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.InfoVO;
import model.ReservationVO;

public class ReservationDAO {
    // 예약 신청
    public void setReservationRegiste(ReservationVO rvo) throws Exception {
        String sql = "insert into reservation values(reservation_no_seq.nextval,?, ?, ?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, rvo.getSite_id());
            pstmt.setString(2, rvo.getSite_num());
            

            int i = pstmt.executeUpdate();

            if (i == 1) {
                System.out.println("예약 완료되었습니다.");
            } else {
                System.out.println("예약에 실패했습니다.");
            }
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                System.out.println(se);
            }
        }
    }

    // 예약 취소(삭제)
    public void setReservationDelete(int no) throws Exception {
    	String sql = "delete from reservation where no = " + no; 

	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DBUtil.makeConnection();
	        pstmt = con.prepareStatement(sql);
	        
	        int i = pstmt.executeUpdate();

	        if (i == 1) {
	            System.out.println("예약 취소 완료.");
	        } else {
	            System.out.println("예약 취소에 실패했습니다.");
	        }
	    } catch (SQLException se) {
	        System.out.println(se);
	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        try {
	            if (con != null)
	                con.close();
	            if (pstmt != null)
	                pstmt.close();
	        } catch (SQLException se) {
	            System.out.println(se);
	        }
	    }
	}

    // 예약 신청 전체 목록
    public void getReservationTotalList(InfoVO info) throws Exception {
        String sql = "select * from reservation";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, info.getReservation_id());
            rs = pstmt.executeQuery();

            System.out.println("일련번호\t사이트ID\t사이트번호\t이름\t연락처\t예약자ID");

            while (rs.next()) {
                int no = rs.getInt("no");
                String site_id = rs.getString("site_id");
                String site_num = rs.getString("site_num");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String reservation_id = rs.getString("reservation_id");

                System.out.println(no + "\t" + site_id + "\t" + site_num + "\t" + name + "\t" + phone
                        + "\t" + reservation_id );
            }
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                System.out.println(se);
            }
        }
    }
}
