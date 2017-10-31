package dto;

import java.sql.Timestamp;


public class MemberVO {
	private int me_code;
	private String id;
	private String me_pwd;
	private String sns;
	private String me_genre;
	private String email;
	private Timestamp p_date;

	public int getMe_code() {
		return me_code;
	}

	public void setMe_code(int me_code) {
		this.me_code = me_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMe_pwd() {
		return me_pwd;
	}

	public void setMe_pwd(String me_pwd) {
		this.me_pwd = me_pwd;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public String getMe_genre() {
		return me_genre;
	}

	public void setMe_genre(String me_genre) {
		this.me_genre = me_genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getP_date() {
		return p_date;
	}

	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}

	@Override
	public String toString() {
		return "MemberVO [me_code=" + me_code + ", id=" + id + ", me_pwd=" + me_pwd + ", sns=" + sns + ", me_genre="
				+ me_genre + ", email=" + email + ", p_date=" + p_date + "]";
	}
	
		

}
