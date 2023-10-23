package model;

import java.util.Objects;

public class ReservationVO {
	private int no; // 예약 일련번호
	private String reservation_id; // 예약자 아이디
	private String site_id; // 사이트 아이디
	private String date; // 예약일자
	private String r_date; // 예약 작성일자

	public ReservationVO() {

	}

	public ReservationVO(int no, String reservation_id, String site_id, String date, String r_date) {
		super();
		this.no = no;
		this.reservation_id = reservation_id;
		this.site_id = site_id;
		this.date = date;
		this.r_date = r_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, reservation_id, site_id);
	}

	@Override
	public boolean equals(Object obj) {
		ReservationVO rvo = (ReservationVO) obj;
		if (!(obj instanceof ReservationVO))
			return false;
		return rvo.no == this.no && rvo.reservation_id.equals(this.reservation_id) && rvo.site_id.equals(this.site_id);
	}

}
