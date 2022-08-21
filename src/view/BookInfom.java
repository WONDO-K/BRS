package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BookDao;
import model.BookVo;
import model.MemberDao;
import model.MemberVo;
import model.RentalDao;
import model.RentalVo;

public class BookInfom extends JFrame implements ActionListener, MouseListener {
	private JTextField tf_bookTitle;
	private JTextField tf_bookAuthor;
	private JTextField tf_bookPublisher;
	private JTextField tf_searchResult;
	private JTextField tf_bookCount;
	private JTextField tf_allowLabel;
	private JTextField tf_bookNumber;
	private BookVo book;
	private JButton btnPrevious;
	private JButton btnRent;
	private BookMenu bookMenu;
	private RentalVo rentalVo;
	private MemberVo memvo;

	// 책 제목으로 검색
	public BookInfom(String title, BookMenu bookMenu) {
		this.bookMenu = bookMenu;

		// 해당 책 제목으로 조회 - 화면 출력
		viewData(title);
	}

	// 책 번호로 검색
	public BookInfom(int b_number, BookMenu bookMenu) {
		this.bookMenu = bookMenu;

		// 해당 책 번호로 조회 - 화면 출력
		viewData(b_number);
	}

	// 기본 화면
	public void setDefaultLayout() {
		getContentPane().setLayout(null);
		

		// bookInfoPanel : 책 정보 불러올 패널
		JPanel bookInfoPanel = new JPanel();
		bookInfoPanel.setBackground(Color.LIGHT_GRAY);
		bookInfoPanel.setBounds(240, 84, 200, 290);
		getContentPane().add(bookInfoPanel);
		bookInfoPanel.setLayout(null);

		// numLabel : 책 번호 표시할 이름
		JLabel numLabel = new JLabel("번호");
		numLabel.setBackground(Color.RED);
		numLabel.setBounds(10, 10, 57, 23);
		bookInfoPanel.add(numLabel);

		// tf_bookNumber : 책 번호 표시할 텍스트 필드
		tf_bookNumber = new JTextField();
		tf_bookNumber.setEnabled(false);
		tf_bookNumber.setColumns(10);
		tf_bookNumber.setBounds(10, 40, 50, 20);
		bookInfoPanel.add(tf_bookNumber);

		// titleLbel : 책 제목 표시할 이름
		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(10, 80, 57, 15);
		bookInfoPanel.add(titleLabel);

		// tf_bookNumber : 책 제목 텍스트 필드
		tf_bookTitle = new JTextField();
		tf_bookTitle.setEnabled(false);
		tf_bookTitle.setBounds(10, 110, 180, 20);
		bookInfoPanel.add(tf_bookTitle);
		tf_bookTitle.setColumns(10);

		JLabel authorLabel = new JLabel("저자");
		authorLabel.setBounds(10, 150, 57, 15);
		bookInfoPanel.add(authorLabel);

		tf_bookAuthor = new JTextField();
		tf_bookAuthor.setEnabled(false);
		tf_bookAuthor.setBounds(10, 180, 110, 20);
		bookInfoPanel.add(tf_bookAuthor);
		tf_bookAuthor.setColumns(10);

		JLabel publisherLabel = new JLabel("출판사");
		publisherLabel.setBounds(10, 220, 57, 15);
		bookInfoPanel.add(publisherLabel);

		tf_bookPublisher = new JTextField();
		tf_bookPublisher.setEnabled(false);
		tf_bookPublisher.setBounds(10, 250, 110, 20);
		bookInfoPanel.add(tf_bookPublisher);
		tf_bookPublisher.setColumns(10);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(30, 20, 430, 40);
		getContentPane().add(searchPanel);
		searchPanel.setLayout(new BorderLayout(0, 0));

		tf_searchResult = new JTextField();
		searchPanel.add(tf_searchResult, BorderLayout.CENTER);
		tf_searchResult.setText("검색 결과");
		tf_searchResult.setColumns(10);

		JPanel statusPanel = new JPanel();
		statusPanel.setBounds(30, 404, 430, 97);
		getContentPane().add(statusPanel);
		statusPanel.setLayout(null);

		JLabel allowLabel = new JLabel("대여 여부");
		allowLabel.setBounds(12, 57, 57, 15);
		statusPanel.add(allowLabel);

		JLabel bookcountLabel = new JLabel("수량(권)");
		bookcountLabel.setBounds(12, 23, 57, 15);
		statusPanel.add(bookcountLabel); // BookCount = BOOK_COUNT가 들어갈 JLabel의 이름

		tf_bookCount = new JTextField();
		tf_bookCount.setEnabled(false);
		tf_bookCount.setBounds(99, 20, 116, 21);
		statusPanel.add(tf_bookCount);
		tf_bookCount.setColumns(10);

		tf_allowLabel = new JTextField();
		tf_allowLabel.setEnabled(false);
		tf_allowLabel.setBounds(99, 54, 116, 21);
		statusPanel.add(tf_allowLabel);
		tf_allowLabel.setColumns(10);

		btnPrevious = new JButton("창 닫기");
		btnPrevious.setBounds(99, 511, 124, 23);
		btnPrevious.addActionListener(this);
		getContentPane().add(btnPrevious);

		btnRent = new JButton("대여하기");

		btnRent.addActionListener(this);
		btnRent.setBounds(271, 511, 117, 23);
		getContentPane().add(btnRent);

		// 화면 설정
		this.setTitle("도서 정보");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 600);
		this.setVisible(true);
	}

	// 제목으로 책정보 조회
	private void viewData(String title) {
		BookDao bookDao = new BookDao();
		this.book = bookDao.getbook(title);

		// 데이터 있는지 확인
		int b_number = this.book.getB_number();
		if (b_number > 0) {
			setDefaultLayout();
			setViewData(book);
		} else {
			JOptionPane.showMessageDialog(null, "조회된 자료가 없습니다", "자료없음", JOptionPane.OK_OPTION);
			// 화면 초기화
			// clearViewData();
		}
	}

	// 번호로 책정보 조회
	private void viewData(int b_number) {
		BookDao bookDao = new BookDao();
		this.book = bookDao.getbook(b_number);

		// 데이터 있는지 확인
		if (b_number > 0) {
			setDefaultLayout();
			setViewData(book);
		} else {
			JOptionPane.showMessageDialog(null, "조회된 자료가 없습니다", "자료없음", JOptionPane.OK_OPTION);
			// 화면 초기화
			// clearViewData();
		}
	}

	private BookVo getViewData() {

		int b_number = Integer.parseInt(this.tf_bookNumber.getText().toString());
		String title = this.tf_bookTitle.getText();
		String author = this.tf_bookAuthor.getText();
		String publisher = this.tf_bookPublisher.getText();

		int book_count = Integer.parseInt(this.tf_bookCount.getText().toString());

		String rental = this.tf_allowLabel.getText();

		BookVo book = new BookVo(b_number, title, author, publisher, book_count, rental);

		return book;
	}

	private void setViewData(BookVo book) {
		int number = book.getB_number();
		String title = book.getTitle();
		String author = book.getAuthor();
		String publisher = book.getPublisher();
		int book_count = book.getBook_count();
		String rental = "불가능";
		if (book_count > 0) {
			rental = "가능";
		}
		String img_url = book.getImg_url();

		this.tf_bookNumber.setText(String.valueOf(number));
		this.tf_searchResult.setText(title);
		this.tf_bookTitle.setText(title);
		this.tf_bookAuthor.setText(author);
		this.tf_bookPublisher.setText(publisher);
		this.tf_bookCount.setText(String.valueOf(book_count));
		this.tf_allowLabel.setText(rental);

		// ImagePanel : 이미지 파일 불러올 패널
		JPanel ImagePanel = new JPanel();
		ImagePanel.setBounds(30, 77, 200, 300);
		getContentPane().add(ImagePanel);
		// 패널 안에 이미지 넣기
		BookImage getBookCover = new BookImage(new ImageIcon(img_url).getImage()); // 이미지 넣기
		getBookCover.setBounds(30, 77, 200, 300);
		ImagePanel.add(getBookCover);
		getBookCover.setLayout(null);
	}

	private void clearViewData() {
		this.tf_bookNumber.setText("");
		this.tf_bookTitle.setText("");
		this.tf_bookAuthor.setText("");
		this.tf_bookPublisher.setText("");
		this.tf_bookCount.setText("");
	}

	private Component BookImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRent) {
			// 책의 잔여 개수 가져오기
			int book_count = book.getBook_count();
			// 잔여 개수가 0보다 크면 대여 가능
			if (book_count > 0) {
				// 대여선택 yes/no
				int reusult = JOptionPane.showConfirmDialog(null, "대여하시겠습니까?", "대여여부", JOptionPane.YES_NO_OPTION);

				if (reusult == JOptionPane.CLOSED_OPTION) {
					// 대여선택 no

				} else if (reusult == JOptionPane.YES_OPTION) {
					// 대여선택 yes
					RentalDao rentalDao = new RentalDao();
					MemberDao memDao = new MemberDao();
					
					String status = "";
					String memid = bookMenu.memberId;
					int book_number = book.getB_number();
					
					int point = 1000;
					// DB에 저장
					rentalDao.RentalBook(status, memid, book_number, point);
					rentalDao.MinusCount(book_number);
					JOptionPane.showMessageDialog(null, "대여되었습니다.", "대여여부", JOptionPane.OK_OPTION);
					bookMenu.rentalTableRefresh();
					dispose();
				} else {
					// 그 외 상황들
					JOptionPane.showMessageDialog(null, "대여 불가능합니다.", "대여여부", JOptionPane.NO_OPTION);
				}
			} else {
				// 잔여 개수 0개부터는 대여 불가능
				JOptionPane.showMessageDialog(null, "대여 불가능합니다.", "대여여부", JOptionPane.NO_OPTION);
			}

		} else if (e.getSource() == btnPrevious) {
			dispose();
		}
	}
}