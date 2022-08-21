package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDao {

	private boolean idCheck = false;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	Scanner scanner = new Scanner(System.in);

	public MemberDao() {
		open();
	}

	public Connection open() {

		try {
			conn = DBConn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 회원 가입 관련 다오 시작
	// 아이디 중복 확인
	public boolean checkID(String id) throws SQLException {

		String sql = "select ID from LIB_MEMBER";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("ID").equals(id)) {
				idCheck = true;
			}
		}
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();

		return idCheck;
	}

	// 회원가입 성공해서 회원 정보 추가
	public void addmem(String Id, String Pw, String Name, String Birth, String Phone, String Mail, String Gender,
			String job) {

		String sqlString = "insert into LIB_MEMBER " + "values (?, ?, ?, ?, ?, ?, ?, ?)";
		String sqlString1 = "INSERT INTO LIB_RENTAL(MEMBER_ID)" + "VALUES(?)";

		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, Id);
			pstmt.setString(2, Pw);
			pstmt.setString(3, Name);
			pstmt.setString(4, Gender);
			pstmt.setString(5, Mail);
			pstmt.setString(6, Phone);
			pstmt.setString(7, Birth);
			pstmt.setString(8, job);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sqlString1);
			pstmt.setString(1, Id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// 로그인 관련 다오 시작
	// 아이디 비밀번호 동일한지 체크
	public boolean login(String id, String pw) {

		String sqlString = "select ID, PW from LIB_MEMBER WHERE ID = ? AND PW = ?";
		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				if (rs.getString("PW").equals(pw)) {
					idCheck = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return idCheck;
	}

	// 멤버 리스트에 회원 정보 입력
	public ArrayList MemberInfoView(String memberId) {

		ArrayList list1 = new ArrayList();

		String sqlString = "SELECT ID,PW,NAME,GENDER,EMAIL,TEL,BIRTH,JOB" + " FROM LIB_MEMBER WHERE ID = ?";
		String id = "";
		String pw = "";
		String name = "";
		String gender = "";
		String email = "";
		String tel = "";
		String birth = "";
		String job = "";

		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				gender = rs.getString("gender");
				email = rs.getString("email");
				tel = rs.getString("tel");
				birth = rs.getString("birth");
				job = rs.getString("job");

				list1.add(id);
				list1.add(pw);
				list1.add(name);
				list1.add(gender);
				list1.add(email);
				list1.add(tel);
				list1.add(birth);
				list1.add(job);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list1;

	}

	// 조회

	// 회원수정

	public String updateMember(MemberVo member) {
		String result = "";

		String sqlString = "UPDATE LIB_MEMBER " + " SET PW = ?," + " NAME = ?," + " TEL = ?," + " EMAIL = ? "
				+ " WHERE ID = ?";
		try {
			pstmt = conn.prepareStatement(sqlString);

			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			switch (e.getErrorCode()) {
			default:
				result = e.getMessage();
			}

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
