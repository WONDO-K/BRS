package model;

public class RentalVo {

	String rental_status;
	String member_id;
	String book_number;
	String rental_date;
	String return_date;
	String return_period;
	int point;
	
	public RentalVo(String rental_status, String member_id, String book_number, String rental_date, String return_date,
			String return_period, int point) {
		this.rental_status = rental_status;
		this.member_id = member_id;
		this.book_number = book_number;
		this.rental_date = rental_date;
		this.return_date = return_date;
		this.return_period = return_period;
		this.point = point;
	}

	public RentalVo(String rental_status2, String book_number2, String rental_date2, String return_date2,
			String return_period2, int point2) {
		this.rental_status = rental_status;
		this.book_number = book_number;
		this.rental_date = rental_date;
		this.return_date = return_date;
		this.return_period = return_period;
		this.point = point;
	}

	public String getRental_status() {
		return rental_status;
	}

	public void setRental_status(String rental_status) {
		this.rental_status = rental_status;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getBook_number() {
		return book_number;
	}

	public void setBook_number(String book_number) {
		this.book_number = book_number;
	}

	public String getRental_date() {
		return rental_date;
	}

	public void setRental_date(String rental_date) {
		this.rental_date = rental_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getReturn_period() {
		return return_period;
	}

	public void setReturn_period(String return_period) {
		this.return_period = return_period;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "RentalVO [rental_status=" + rental_status + ", member_id=" + member_id + ", book_number=" + book_number
				+ ", rental_date=" + rental_date + ", return_date=" + return_date + ", return_period=" + return_period
				+ ", point=" + point + "]";
	}
	
}
