package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.Vector;

import view.BookMenu;

public class BookDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static BookMenu bMenu = null;

	public BookDao() {
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

	public ArrayList getBookList() {
		ArrayList<String[]> list = new ArrayList<String[]>();
		String sqlString = "SELECT B_NUMBER, TITLE, AUTHOR, PUBLISHER ";
		sqlString += " FROM LIB_BOOK";

		String number = "";
		String author = "";
		String publisher = "";
		String title = "";

		try {
			pstmt = conn.prepareStatement(sqlString);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				ArrayList<String[]> outlist = new ArrayList<String[]>();
				number = rs.getString("B_NUMBER");
				title = rs.getString("TITLE");
				author = rs.getString("AUTHOR");
				publisher = rs.getString("PUBLISHER");

				outlist.add(new String[] { number, title, author, publisher });
				list.addAll(outlist);

			}

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
		return list;
	}

	public BookVo getbook(String title) {
		BookVo book = new BookVo();

		String sqlString = "SELECT B_NUMBER, TITLE, AUTHOR, PUBLISHER, BOOK_COUNT, RENTAL, IMG_URL ";
		sqlString += " FROM  LIB_BOOK ";
		sqlString += " WHERE TITLE = ? ";

		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int number = rs.getInt("B_NUMBER");
				String btitle = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				String publisher = rs.getString("PUBLISHER");
				int book_count = rs.getInt("BOOK_COUNT");
				String rental = rs.getString("RENTAL");
				String img_url = rs.getString("IMG_URL");
				book = new BookVo(number, btitle, author, publisher, book_count, rental, img_url);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return book;
	}

	public BookVo getbook(int b_number) {
		BookVo book = new BookVo();

		String sqlString = "SELECT B_NUMBER, TITLE, AUTHOR, PUBLISHER, BOOK_COUNT, RENTAL, IMG_URL ";
		sqlString += " FROM  LIB_BOOK ";
		sqlString += " WHERE B_NUMBER = ? ";

		try {
			pstmt = conn.prepareStatement(sqlString);
			pstmt.setInt(1, b_number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int number = rs.getInt("B_NUMBER");
				String btitle = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				String publisher = rs.getString("PUBLISHER");
				int book_count = rs.getInt("BOOK_COUNT");
				String rental = rs.getString("RENTAL");
				String img_url = rs.getString("IMG_URL");
				book = new BookVo(number, btitle, author, publisher, book_count, rental, img_url);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return book;
	}
	
	

}
