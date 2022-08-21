package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MemberVo;
import model.RentalVo;
import model.MemberDao;
import model.MemberVo;
import model.RentalVo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Up01  {

	private JFrame frame;
	private JTextField ID_textField;
	private JTextField PW_textField;
	private JTextField NAME_textField;
	private JTextField GENDER_textField;
	private JTextField EMAIL_textField;
	private JTextField BIRTH_textField;
	private JTextField STATUS_textField;
	private JTextField RENTAL_BOOK_textField;
	private JTextField RETURN_DATE_textField;
	private JTextField TEL_textField;
	private JTextField RETURN_PERIOD_textField;
	private JTextField POINT_textField;
	private JTextField RENTAL_DATE_textField;
	private JTextField JOB_textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Up01 window = new Up01();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Up01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("수정하기");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==btnNewButton_2) {
					ID_textField.setEnabled(false);
					GENDER_textField.setEnabled(false);
					BIRTH_textField.setEnabled(false);
					JOB_textField.setEnabled(false);
					STATUS_textField.setEnabled(false);
					RENTAL_BOOK_textField.setEnabled(false);
					RENTAL_DATE_textField.setEnabled(false);
					RETURN_DATE_textField.setEnabled(false);
					RETURN_PERIOD_textField.setEnabled(false);
					POINT_textField.setEnabled(false);
				}
			}
		});
		btnNewButton_2.setBounds(161, 24, 97, 23);
		panel.add(btnNewButton_2);
		
			
		ID_textField = new JTextField();
		ID_textField.setBounds(98, 70, 160, 20);
		panel.add(ID_textField);
		ID_textField.setColumns(10);
		ArrayList list1= new ArrayList();

		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(29, 73, 57, 15);
		panel.add(lblNewLabel);
		
		
		PW_textField = new JTextField();
		PW_textField.setColumns(10);
		PW_textField.setBounds(98, 100, 160, 20);
		panel.add(PW_textField);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(29, 103, 57, 15);
		panel.add(lblPw);
		
		NAME_textField = new JTextField();
		NAME_textField.setColumns(10);
		NAME_textField.setBounds(98, 131, 160, 20);
		panel.add(NAME_textField);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(29, 134, 57, 15);
		panel.add(lblNewLabel_2);
		
		GENDER_textField = new JTextField();
		GENDER_textField.setColumns(10);
		GENDER_textField.setBounds(98, 160, 160, 20);
		panel.add(GENDER_textField);
		
		JLabel lblNewLabel_3 = new JLabel("성별");
		lblNewLabel_3.setBounds(29, 163, 57, 15);
		panel.add(lblNewLabel_3);
		
		EMAIL_textField = new JTextField();
		EMAIL_textField.setColumns(10);
		EMAIL_textField.setBounds(98, 191, 160, 20);
		panel.add(EMAIL_textField);
		
		JLabel lblNewLabel_4 = new JLabel("이메일");
		lblNewLabel_4.setBounds(29, 194, 57, 15);
		panel.add(lblNewLabel_4);
		
		BIRTH_textField = new JTextField();
		BIRTH_textField.setColumns(10);
		BIRTH_textField.setBounds(98, 253, 160, 20);
		panel.add(BIRTH_textField);
		
		JLabel lblNewLabel_5 = new JLabel("생년월일");
		lblNewLabel_5.setBounds(29, 256, 57, 15);
		panel.add(lblNewLabel_5);
		
		STATUS_textField = new JTextField();
		STATUS_textField.setColumns(10);
		STATUS_textField.setBounds(98, 325, 160, 20);
		panel.add(STATUS_textField);
		
		JLabel lblNewLabel_6 = new JLabel("대여현황");
		lblNewLabel_6.setBounds(29, 328, 57, 15);
		panel.add(lblNewLabel_6);
		
		RENTAL_BOOK_textField = new JTextField();
		RENTAL_BOOK_textField.setColumns(10);
		RENTAL_BOOK_textField.setBounds(98, 356, 160, 20);
		panel.add(RENTAL_BOOK_textField);
		
		JLabel lblNewLabel_7 = new JLabel("대여한 책");
		lblNewLabel_7.setBounds(29, 359, 57, 15);
		panel.add(lblNewLabel_7);
		
		RETURN_DATE_textField = new JTextField();
		RETURN_DATE_textField.setColumns(10);
		RETURN_DATE_textField.setBounds(98, 418, 160, 20);
		panel.add(RETURN_DATE_textField);
		
		JLabel lblNewLabel_8 = new JLabel("반납일자");
		lblNewLabel_8.setBounds(29, 421, 57, 15);
		panel.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(29, 506, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("완료");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setBounds(161, 506, 97, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("MY PAGE");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(12, 24, 114, 20);
		panel.add(lblNewLabel_1);
		

		
		JLabel lblNewLabel_4_1 = new JLabel("전화번호");
		lblNewLabel_4_1.setBounds(29, 224, 57, 15);
		panel.add(lblNewLabel_4_1);
		
		TEL_textField = new JTextField();
		TEL_textField.setColumns(10);
		TEL_textField.setBounds(98, 221, 160, 20);
		panel.add(TEL_textField);
		
		JLabel lblNewLabel_8_1 = new JLabel("반납기간");
		lblNewLabel_8_1.setBounds(29, 451, 57, 15);
		panel.add(lblNewLabel_8_1);
		
		RETURN_PERIOD_textField = new JTextField();
		RETURN_PERIOD_textField.setColumns(10);
		RETURN_PERIOD_textField.setBounds(98, 448, 160, 20);
		panel.add(RETURN_PERIOD_textField);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("포인트");
		lblNewLabel_8_1_1.setBounds(29, 479, 57, 15);
		panel.add(lblNewLabel_8_1_1);
		
		POINT_textField = new JTextField();
		POINT_textField.setColumns(10);
		POINT_textField.setBounds(98, 476, 160, 20);
		panel.add(POINT_textField);
		
		JLabel lblNewLabel_7_1 = new JLabel("반출일자");
		lblNewLabel_7_1.setBounds(29, 389, 64, 15);
		panel.add(lblNewLabel_7_1);
		
		RENTAL_DATE_textField = new JTextField();
		RENTAL_DATE_textField.setColumns(10);
		RENTAL_DATE_textField.setBounds(98, 386, 160, 20);
		panel.add(RENTAL_DATE_textField);
		
		JLabel lblNewLabel_5_1 = new JLabel("직업");
		lblNewLabel_5_1.setBounds(29, 286, 57, 15);
		panel.add(lblNewLabel_5_1);
		
		JOB_textField = new JTextField();
		JOB_textField.setColumns(10);
		JOB_textField.setBounds(98, 283, 160, 20);
		panel.add(JOB_textField);
		
		
	} 
	private void setMemberInfo(MemberVo memvo){
		String id = memvo.getId();
		String pw = memvo.getPw();
		String name = memvo.getName();
		String gender = memvo.getGender();
		String email = memvo.getEmail();
		String tel = memvo.getTel();
		String birth = memvo.getBirth();
		String job = memvo.getJob();
		
		this.ID_textField.setText(id);
		this.PW_textField.setText(pw);
		this.NAME_textField.setText(name);
		this.GENDER_textField.setText(gender);
		this.EMAIL_textField.setText(email);
		this.TEL_textField.setText(tel);
		this.BIRTH_textField.setText(birth);
		this.JOB_textField.setText(id);
		
	}
	/*멤버 데이터 조회
	   private ArrayList ViewList() {
	      
	      MemberDAO memberDAO = new MemberDAO();
	      
	      ArrayList list = memberDAO.view();
	      String sql = "SELECT * FROM MEMBER";
	      pstmt = conn.prepareStatement(sql);
	      
	      memberDAO.view(id); 
	      // 아이디로 멤버 조회 해야함
	      // ex)memberDAO.view(id)
	      
	      //급해서 형태만 잡고 상세 코딩은 안함
	      ArrayList list2 = new ArrayList();
	      for (int i = 0; i < memberDAO.view().size(); i++) {
	         
	         //생성한 배열에 값 전부 add
	        list2.add(memberDAO.view().get(i));
	        ID_textField.setText(); ///-> 특정 텍스트 필드에 list2[i]에 저장된 값을 세팅 -> ex)이름 텍스트 필드에 list2[0](이름)을 세팅
	      }
	      
	   }*/
	//렌탈 정보 조회
	private  RentalVo getViewRental() {

		String rental_status2 = this.STATUS_textField.getText();
		String book_number2 = this.RENTAL_BOOK_textField.getText();
		String rental_date2 = this.RENTAL_DATE_textField.getText();
		String return_date2 = this.RETURN_DATE_textField.getText();
		String return_period2 = this.RETURN_PERIOD_textField.getText();
		String point2 = this.POINT_textField.getText();
		int point2_1 = Integer.parseInt(point2);
		
		RentalVo rental = new RentalVo(rental_status2,book_number2,rental_date2,return_date2,return_period2,point2_1);
		return rental;
		
		
	}
	
	
	 private void setViewMyPage(MemberVo member,RentalVo rental) {
		 
		 String id = member.getId();
		 String pw = member.getPw();
		 String name = member.getName();
		 String gender = member.getGender();
		 String email = member.getEmail();
		 String tel = member.getTel();
		 String birth = member.getBirth();
		 String job = member.getJob();
		 
		 String rental_status = rental.getRental_date();
		 String rental_book = rental.getBook_number();
		 String rental_date = rental.getRental_date();
		 String return_date = rental.getReturn_date();
		 String return_period = rental.getReturn_period();
		 int point = rental.getPoint();
		 
		 this.ID_textField.setText(id);
		 this.PW_textField.setText(pw);
		 this.NAME_textField.setText(name);
		 this.GENDER_textField.setText(gender);
		 this.EMAIL_textField.setText(email);
		 this.TEL_textField.setText(tel);
		 this.BIRTH_textField.setText(birth);
		 this.JOB_textField.setText(job);
		 this.STATUS_textField.setText(rental_status);
		 this.RENTAL_BOOK_textField.setText(rental_book);
		 this.RENTAL_DATE_textField.setText(rental_date);
		 this.RETURN_DATE_textField.setText(return_date);
		 this.RETURN_PERIOD_textField.setText(return_period);
		 this.POINT_textField.setText(Integer.toString(point));
	 }
}
