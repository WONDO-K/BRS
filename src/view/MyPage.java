package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MemberDao;
import model.MemberVo;
import model.RentalDao;
import model.RentalVo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPage extends JFrame{

	JFrame frame;
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
	private MemberDao memDao = new MemberDao();
	private MemberVo memVo = new MemberVo();
	private RentalDao rentalDao = new RentalDao();
	private String memberId;
	
	//ArrayList list1 = memDao.MemberInfoView();
	//ArrayList list2 = rentalDao.RentalInfoView();


	/**
	 * Create the application.
	 */
	public MyPage(String id) {
		memberId=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setTitle("내 정보");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 590);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_2 = new JButton("수정하기");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnNewButton_2) {
					// ID_textField.setEnabled(false);
					PW_textField.setEditable(true);
					NAME_textField.setEditable(true);
					EMAIL_textField.setEditable(true);
					TEL_textField.setEditable(true);
					/*
					 * GENDER_textField.setEnabled(false); BIRTH_textField.setEnabled(false);
					 * JOB_textField.setEnabled(false); STATUS_textField.setEnabled(false);
					 * RENTAL_BOOK_textField.setEnabled(false);
					 * RENTAL_DATE_textField.setEnabled(false);
					 * RETURN_DATE_textField.setEnabled(false);
					 * RETURN_PERIOD_textField.setEnabled(false); POINT_textField.setEnabled(false);
					 */
				}
			}
		});

		btnNewButton_2.setBounds(161, 24, 97, 23);
		panel.add(btnNewButton_2);

		ID_textField = new JTextField();
		ID_textField.setBounds(98, 70, 160, 20);
		panel.add(ID_textField);
		ID_textField.setColumns(10);
		ID_textField.setEditable(false);
		ArrayList list1 = new ArrayList();

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(29, 73, 57, 15);
		panel.add(lblNewLabel);

		PW_textField = new JTextField();
		PW_textField.setColumns(10);
		PW_textField.setBounds(98, 100, 160, 20);
		PW_textField.setEditable(false);
		panel.add(PW_textField);

		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(29, 103, 57, 15);
		panel.add(lblPw);

		NAME_textField = new JTextField();
		NAME_textField.setColumns(10);
		NAME_textField.setBounds(98, 131, 160, 20);
		NAME_textField.setEditable(false);
		panel.add(NAME_textField);

		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(29, 134, 57, 15);
		panel.add(lblNewLabel_2);

		GENDER_textField = new JTextField();
		GENDER_textField.setColumns(10);
		GENDER_textField.setBounds(98, 160, 160, 20);
		GENDER_textField.setEditable(false);
		panel.add(GENDER_textField);

		JLabel lblNewLabel_3 = new JLabel("성별");
		lblNewLabel_3.setBounds(29, 163, 57, 15);
		panel.add(lblNewLabel_3);

		EMAIL_textField = new JTextField();
		EMAIL_textField.setColumns(10);
		EMAIL_textField.setBounds(98, 191, 160, 20);
		EMAIL_textField.setEditable(false);
		panel.add(EMAIL_textField);

		JLabel lblNewLabel_4 = new JLabel("이메일");
		lblNewLabel_4.setBounds(29, 194, 57, 15);
		panel.add(lblNewLabel_4);

		BIRTH_textField = new JTextField();
		BIRTH_textField.setColumns(10);
		BIRTH_textField.setBounds(98, 253, 160, 20);
		BIRTH_textField.setEditable(false);
		panel.add(BIRTH_textField);

		JLabel lblNewLabel_5 = new JLabel("생년월일");
		lblNewLabel_5.setBounds(29, 256, 57, 15);
		panel.add(lblNewLabel_5);

		STATUS_textField = new JTextField();
		STATUS_textField.setColumns(10);
		STATUS_textField.setBounds(98, 325, 160, 20);
		STATUS_textField.setEditable(false);
		panel.add(STATUS_textField);

		JLabel lblNewLabel_6 = new JLabel("대여현황");
		lblNewLabel_6.setBounds(29, 328, 57, 15);
		panel.add(lblNewLabel_6);

		RENTAL_BOOK_textField = new JTextField();
		RENTAL_BOOK_textField.setColumns(10);
		RENTAL_BOOK_textField.setBounds(98, 356, 160, 20);
		RENTAL_BOOK_textField.setEditable(false);
		panel.add(RENTAL_BOOK_textField);

		JLabel lblNewLabel_7 = new JLabel("대여한 책");
		lblNewLabel_7.setBounds(29, 359, 57, 15);
		panel.add(lblNewLabel_7);

		RETURN_DATE_textField = new JTextField();
		RETURN_DATE_textField.setColumns(10);
		RETURN_DATE_textField.setBounds(98, 418, 160, 20);
		RETURN_DATE_textField.setEditable(false);
		panel.add(RETURN_DATE_textField);

		JLabel lblNewLabel_8 = new JLabel("반납일자");
		lblNewLabel_8.setBounds(29, 421, 57, 15);

		panel.add(lblNewLabel_8);

		JButton btnNewButton = new JButton("취소");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
		});
		btnNewButton.setBounds(29, 506, 97, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("완료");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                String id = ID_textField.getText();
                String pw = PW_textField.getText();
                String name = NAME_textField.getText();
                String email = EMAIL_textField.getText();
                String tel = TEL_textField.getText();

                memVo = new MemberVo(id,pw,name,email,tel);
                memDao.updateMember(memVo);

                JOptionPane success = new JOptionPane();
                success.showMessageDialog(null, "완료되었습니다.");
                frame.dispose();
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
		TEL_textField.setEditable(false);
		panel.add(TEL_textField);

		JLabel lblNewLabel_8_1 = new JLabel("반납기간");
		lblNewLabel_8_1.setBounds(29, 451, 57, 15);
		panel.add(lblNewLabel_8_1);

		RETURN_PERIOD_textField = new JTextField();
		RETURN_PERIOD_textField.setColumns(10);
		RETURN_PERIOD_textField.setBounds(98, 448, 160, 20);
		RETURN_PERIOD_textField.setEditable(false);
		panel.add(RETURN_PERIOD_textField);

		JLabel lblNewLabel_8_1_1 = new JLabel("포인트");
		lblNewLabel_8_1_1.setBounds(29, 479, 57, 15);
		panel.add(lblNewLabel_8_1_1);

		POINT_textField = new JTextField();
		POINT_textField.setColumns(10);
		POINT_textField.setBounds(98, 476, 160, 20);
		POINT_textField.setEditable(false);
		panel.add(POINT_textField);

		JLabel lblNewLabel_7_1 = new JLabel("반출일자");
		lblNewLabel_7_1.setBounds(29, 389, 64, 15);
		panel.add(lblNewLabel_7_1);

		RENTAL_DATE_textField = new JTextField();
		RENTAL_DATE_textField.setColumns(10);
		RENTAL_DATE_textField.setBounds(98, 386, 160, 20);
		RENTAL_DATE_textField.setEditable(false);
		panel.add(RENTAL_DATE_textField);

		JLabel lblNewLabel_5_1 = new JLabel("직업");
		lblNewLabel_5_1.setBounds(29, 286, 57, 15);
		panel.add(lblNewLabel_5_1);

		JOB_textField = new JTextField();
		JOB_textField.setColumns(10);
		JOB_textField.setBounds(98, 283, 160, 20);
		JOB_textField.setEditable(false);
		panel.add(JOB_textField);

		setViewMyPage();
		
	}

	private void setMemberInfo(MemberVo memvo) {
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

	public void setViewMyPage() {

		MemberDao memDao = new MemberDao();
		
		ArrayList list1 = memDao.MemberInfoView(memberId);
		ArrayList list2 = rentalDao.RentalInfoView(memberId);
		
		String id = String.valueOf(list1.get(0));
		String pw = String.valueOf(list1.get(1));
		String name = String.valueOf(list1.get(2));
		String gender = String.valueOf(list1.get(3));
		String email = String.valueOf(list1.get(4));
		String tel = String.valueOf(list1.get(5));
		String birth = String.valueOf(list1.get(6));
		String job = String.valueOf(list1.get(7));

		String rental_status;
		String rental_book;
		String rental_date;
		String return_date;
		String return_period;
		String point;
		String[] period;
		String[] r_period = null;
		
		int size = list2.size();
		
		if(size > 0)
		{
			rental_status = String.valueOf(list2.get(0));
			rental_book = String.valueOf(list2.get(1));
			rental_date = String.valueOf(list2.get(2));
			return_date = String.valueOf(list2.get(3));
			return_period = String.valueOf(list2.get(4));
			point = String.valueOf(list2.get(5));
			period = return_period.split("-");
			r_period = period[2].split(" ");
		}
		else
		{
			rental_status = "null";
			rental_book = "null";
			rental_date = "null";
			return_date = "null";
			return_period = "null";
			point = "null";
		}
//		String rental_status = String.valueOf(list2.get(0));
//		String rental_book = String.valueOf(list2.get(1));
//		String rental_date = String.valueOf(list2.get(2));
//		String return_date = String.valueOf(list2.get(3));
//		String return_period = String.valueOf(list2.get(4));
//		String point = String.valueOf(list2.get(5));

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
		this.POINT_textField.setText(point);
		if(r_period != null) {
			this.RETURN_PERIOD_textField.setText(r_period[0]);
		}
		else
		{
			this.RETURN_PERIOD_textField.setText(return_period);
		}
	}
}
