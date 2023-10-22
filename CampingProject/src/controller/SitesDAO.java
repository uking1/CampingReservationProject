package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SitesVO;

public class SitesDAO {

	// 사이트 목록

	public void getSitesTotalList() throws Exception {
		String sql = "select * from reservationsites order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SitesVO svo = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("일련번호\t사이트 구역\t사이트 번호\t사이트 사이즈");

			while (rs.next()) {
				svo = new SitesVO();
				svo.setNo(rs.getInt("no"));
				svo.setSite_id(rs.getString("site_id"));
				svo.setSite_num(rs.getString("site_num"));
				svo.setSite_size(rs.getString("site_size"));

				System.out.println();
			}

			System.out.println(
					svo.getNo() + "\t" + svo.getSite_id() + "\t" + svo.getSite_num() + "\t" + svo.getSite_size());

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {

			}
		}

	}

	// 사이트 등록
	public void setSitesRegiste(SitesVO svo) throws Exception {
		String sql = "insert into sites values(reservation_sites_no_seq.nextval, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getSite_id());
			pstmt.setString(2, svo.getSite_num());
			pstmt.setString(3, svo.getSite_size());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(svo.getSite_num() + "사이트 등록 완료.");
			} else {
				System.out.println("사이트 등록에 실패했습니다.");
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

	// 사이트 수정
	public void setSitesUpdate(SitesVO svo) throws Exception {
		String sql = "update reservationsites set site_id = ?, site_num = ?, site_size = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getSite_id());
			pstmt.setString(2, svo.getSite_num());
			pstmt.setString(3, svo.getSite_size());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("사이트 수정 완료.");
			} else {
				System.out.println("사이트 수정에 실패했습니다.");
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
	
	// 사이트 삭제
	public void setSitesDelete(int no) throws Exception{
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from subject where no = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("사이트 삭제 완료.");
			} else {
				System.out.println("사이트 삭제에 실패했습니다.");
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

}
