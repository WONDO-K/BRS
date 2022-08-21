package model;

public class BookVo {
	
	// Field
	int    b_number; 
	String title;
	String author;
	String publisher; 
	int    book_count;
	String rental;
	String img_url;
	
	// Constructor
	public BookVo() {
		
	}
	
	public BookVo(int b_number, String title, String author, String publisher, int book_count, String rental, String img_url) {
		super();
		this.b_number = b_number;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.book_count = book_count;
		this.rental = rental;
		this.img_url = img_url;
	}

	public BookVo(int b_number, String title, String author, String publisher, int book_count, String rental) {
		super();
		this.b_number = b_number;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.book_count = book_count;
		this.rental = rental;
	}

	// Getter / Setter
	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getBook_count() {
		return book_count;
	}

	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}

	public String getRental() {
		return rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}
	
	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	// toString
	@Override
	public String toString() {
		return "BookVo [b_number=" + b_number + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", book_count=" + book_count + ", rental=" + rental + ", img_url=" + img_url + "]";
	}

	
	
	
	
	
	
	
}
