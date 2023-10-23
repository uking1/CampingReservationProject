package model;

import java.util.Objects;

public class ReservationVO {
	private int no; // 예약 일련번호
	private String site_id; // 사이트 아이디
	private String site_num; // 사이트 번호

	public ReservationVO() {

	}

	public ReservationVO(int no, String site_id, String site_num) {
		super();
		this.no = no;
		this.site_id = site_id;
		this.site_num = site_num;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getSite_num() {
		return site_num;
	}

	public void setSite_num(String site_num) {
		this.site_num = site_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, site_id, site_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ReservationVO rvo = (ReservationVO) obj;
		return no == rvo.no && Objects.equals(site_num, rvo.site_num) && Objects.equals(site_id, rvo.site_id);
	}
}
