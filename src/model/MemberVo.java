package model;

public class MemberVo {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String email;
	private String tel;
	private String birth;
	private String job;
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVo(String id,String pw,String name,String email, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}
	
	public MemberVo(String id, String pw, String name, String gender, String email, String tel, String birth,
			String job) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
		this.email = email;
		this.birth = birth;
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", gender=" + gender
				+ ", email=" + email + ", birth=" + birth + ", job=" + job + "]";
	}
	
}
