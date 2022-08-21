package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import view.BookMenu;

public class RentalDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static BookMenu bMenu = null;
	static BookVo bVo = null;

	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	LocalDate now = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");

	public RentalDao() {
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

	// 렌탈 리스트에 대여현황 입력
	public ArrayList getRentalList(String id) {
		ArrayList<String[]> list = new ArrayList<String[]>();

		String sqlString = "SELECT RENTAL.BOOK_NUMBER, BOOK.TITLE, RENTAL.RETURN_DATE, RENTAL.RENTAL_STATUS"
				+ " FROM LIB_RENTAL RENTAL " + " INNER JOIN LIB_BOOK BOOK ON BOOK.b_number = RENTAL.BOOK_NUMBER"
				+ " WHERE RENTAL.MEMBER_ID = ?";
		String book_number = "";
		String title = "";
		String return_date = "";
		String rental_status = "";

		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				ArrayList<String[]> outlist = new ArrayList<String[]>();
				book_number = rs.getString("BOOK_NUMBER");
				title = rs.getString("TITLE");
				return_date = rs.getString("RETURN_DATE");
				rental_status = rs.getString("RENTAL_STATUS");

				outlist.add(new String[] { book_number, title, return_date, rental_status });
				list.addAll(outlist);

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
		return list;

	}

	public ArrayList RentalInfoView(String memberId) {

		ArrayList list2 = new ArrayList();

		String sqlString = "SELECT RENTAL_STATUS,BOOK_NUMBER,RENTAL_DATE,RETURN_DATE,RETURN_PERIOD,POINT"
				+ " FROM LIB_RENTAL " + " WHERE MEMBER_ID = ?";
		String rental_status = "";
		String book_number = "";
		String rental_date = "";
		String return_date = "";
		String return_period = "";
		String point = "";

		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rental_status = rs.getString("rental_status");
				book_number = rs.getString("book_number");
				rental_date = rs.getString("rental_date");
				return_date = rs.getString("return_date");
				return_period = rs.getString("return_period");
				point = rs.getString("point");

				if (rental_date != null) {
					list2.add(rental_status);
					list2.add(book_number);
					list2.add(rental_date);
					list2.add(return_date);
					list2.add(return_period);
					list2.add(point);
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
		return list2;

	}

	public void RentalBook(String status, String memid, int book_number, int point) {

		String sqlString = "INSERT INTO LIB_RENTAL(RENTAL_STATUS, MEMBER_ID, BOOK_NUMBER, RENTAL_DATE, RETURN_DATE, RETURN_PERIOD, POINT) ";
		sqlString += "VALUES (?, ?, ?, ?, ?, ?, ? )";
		try {

			Calendar cal = Calendar.getInstance(); // 현재 날짜
			cal.setTime(new Date());
			Calendar cal1 = Calendar.getInstance(); //
			cal1.setTime(new Date());
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(new Date());

			cal.add(Calendar.DATE, 7);
			cal2.add(Calendar.DATE, 7);
			cal2.add(Calendar.DATE, -(cal1.get(Calendar.DATE)));

			String RD = df.format(cal1.getTime());
			String RP = df.format(cal2.getTime());
			String rD = df.format(cal.getTime());

			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, status);
			pstmt.setString(2, memid);
			pstmt.setInt(3, book_number);
			pstmt.setString(4, RD);
			pstmt.setString(5, rD);
			pstmt.setString(6, RP);
			pstmt.setInt(7, point);
			pstmt.executeUpdate();

		} catch (SQLException e) {
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

	// 책 반납
	public void returnBook(int b_number) {
		String sqlString = "DELETE FROM LIB_RENTAL WHERE BOOK_NUMBER = ?";
		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setInt(1, b_number);
			rs = pstmt.executeQuery();
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

	// 책 반납 북카운트
	public void PlusCount(int book_number) {

		String sqlString = "UPDATE LIB_BOOK ";
		sqlString += " SET BOOK_COUNT =  BOOK_COUNT + 1 ";
		sqlString += " WHERE B_NUMBER = ? ";
		try {

			pstmt = conn.prepareStatement(sqlString);

			pstmt.setInt(1, book_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
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

	// 책 대여 북카운트
	public void MinusCount(int book_number) {

		String sqlString = "UPDATE LIB_BOOK ";
		sqlString += " SET BOOK_COUNT = BOOK_COUNT - 1 ";
		sqlString += " WHERE B_NUMBER = ? ";
		try {

			pstmt = conn.prepareStatement(sqlString);

			pstmt.setInt(1, book_number);

			pstmt.executeUpdate();

		} catch (SQLException e) {
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

}
