package view;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.MemberDao;
import model.MemberVo;

public class Join extends JPanel implements ActionListener {
	private JTextField id_textField;
	private JTextField name_textField;
	private JTextField phone_textField;
	private JTextField mail_textField;
	private JTextField birth_textField;
	private JPasswordField pw_pwField;
	private CardLayout card;
	private JButton btn_cancel;
	private JButton btn_join;
	private JRadioButton male_button;
	private JRadioButton female_button;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static MemberDao memDao = null;
	private JPasswordField pw2__pwField;

	/**
	 * Create the panel.
	 */
	public Join(CardLayout card) {
		this.card = card;
		setLayout(new GridLayout(9, 1, 0, 0));

		// 회원가입 아이디 핸들링 패널
		JPanel id_panel = new JPanel();
		add(id_panel);
		id_panel.setLayout(null);

		JLabel id_label = new JLabel("아이디");
		id_label.setBounds(45, 11, 117, 15);
		id_panel.add(id_label);

		id_textField = new JTextField();
		id_textField.setBounds(132, 8, 138, 21);
		id_textField.setToolTipText("");
		id_panel.add(id_textField);
		id_textField.setColumns(12);

		// 회원가입 패스워드 핸들링 패널
		JPanel pw_panel = new JPanel();
		add(pw_panel);
		pw_panel.setLayout(null);

		JLabel pw_label = new JLabel("패스워드");
		pw_label.setBounds(45, 11, 117, 15);
		pw_panel.add(pw_label);

		pw_pwField = new JPasswordField();
		pw_pwField.setBounds(132, 8, 138, 21);
		pw_pwField.setColumns(10);
		pw_panel.add(pw_pwField);

		// 회원가입 패스워드 확인 핸들링 패널
		JPanel pw2_panel = new JPanel();
		add(pw2_panel);
		pw2_panel.setLayout(null);

		JLabel pw2_label = new JLabel("패스워드 확인");
		pw2_label.setBounds(45, 11, 117, 15);
		pw2_panel.add(pw2_label);
		
		pw2__pwField = new JPasswordField();
		pw2__pwField.setBounds(132, 8, 138, 21);
		pw2__pwField.setColumns(10);
		pw2_panel.add(pw2__pwField);

		// 회원가입 이름 핸들링 패널
		JPanel name_panel = new JPanel();
		add(name_panel);
		name_panel.setLayout(null);

		JLabel name_label = new JLabel("이름");
		name_label.setBounds(45, 11, 117, 15);
		name_panel.add(name_label);

		name_textField = new JTextField();
		name_textField.setBounds(132, 8, 138, 21);
		name_textField.setColumns(10);
		name_panel.add(name_textField);

		// 회원가입 휴대폰 번호 핸들링 패널
		JPanel phone_panel = new JPanel();
		add(phone_panel);
		phone_panel.setLayout(null);

		JLabel phone__label = new JLabel("전화번호");
		phone__label.setBounds(45, 11, 117, 15);
		phone_panel.add(phone__label);

		phone_textField = new JTextField();
		phone_textField.setBounds(132, 8, 138, 21);
		phone_textField.setColumns(10);
		phone_panel.add(phone_textField);

		// 회원가입 이메일 핸들링 패널
		JPanel mail_panel = new JPanel();
		add(mail_panel);
		mail_panel.setLayout(null);

		JLabel mail_label = new JLabel("이메일");
		mail_label.setBounds(45, 11, 117, 15);
		mail_panel.add(mail_label);

		mail_textField = new JTextField();
		mail_textField.setBounds(132, 8, 138, 21);
		mail_textField.setColumns(10);
		mail_panel.add(mail_textField);

		// 회원가입 생년월일 핸들링 패널
		JPanel birth_panel = new JPanel();
		add(birth_panel);
		birth_panel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("생년월일");
		lblNewLabel_6.setBounds(45, 11, 117, 15);
		birth_panel.add(lblNewLabel_6);

		birth_textField = new JTextField();
		birth_textField.setBounds(132, 8, 138, 21);
		birth_textField.setColumns(10);
		birth_panel.add(birth_textField);

		// 회원가입 성별 핸들링 패널
		JPanel gender_panel = new JPanel();
		add(gender_panel);
		gender_panel.setLayout(null);

		JLabel gender_label = new JLabel("성별");
		gender_label.setBounds(45, 11, 59, 15);
		gender_panel.add(gender_label);

		// 라디오버튼 성별, 그룹화 시켜서 1개만 눌리도록 설정
		male_button = new JRadioButton("남성");
		male_button.setBounds(147, 8, 59, 23);
		buttonGroup.add(male_button);
		gender_panel.add(male_button);

		female_button = new JRadioButton("여성");
		female_button.setBounds(210, 8, 68, 23);
		buttonGroup.add(female_button);
		gender_panel.add(female_button);

		// 회원가입 버튼 핸들링 패널
		JPanel btn_panel = new JPanel();
		add(btn_panel);

		btn_cancel = new JButton("취소");
		btn_panel.add(btn_cancel);
		btn_cancel.addActionListener(this);

		btn_join = new JButton("회원가입");
		btn_panel.add(btn_join);
		btn_join.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		MemberDao memDao = new MemberDao();
		MemberVo mv = new MemberVo();

		if (e.getSource() == btn_cancel) {
			// 휘소 버튼 눌렀을 때 처음 로그인 화면으로 전환
			card.show(getParent(), "login");
		} else if (e.getSource() == btn_join) {
			// 회원가입 유효성 검사

			String Id = id_textField.getText();

			String Pw = "";
			if (new String(pw_pwField.getPassword()).equals(new String(pw2__pwField.getPassword()))) {
				Pw = (new String(pw_pwField.getPassword()));
			}
			String Name = name_textField.getText();

			String Gender = "";
			if (male_button.isSelected()) {
				Gender = "male";
			} else if (female_button.isSelected()) {
				Gender = "female";
			}

			String Birth = birth_textField.getText();
			String Phone = phone_textField.getText();
			String Mail = mail_textField.getText();

			String pw1 = new String(pw_pwField.getPassword());
			String pw2 = new String(pw2__pwField.getPassword());
			String Job = "";

			try {
				if (!memDao.checkID(id_textField.getText())) {
					if (pw1.equals(pw2)) {
						JOptionPane.showMessageDialog(Join.this, "회원가입 완료");
						memDao.addmem(Id, Pw, Name, Birth, Phone, Mail, Gender, Job);
						card.show(getParent(), "login");
					}

					else {
						pw_pwField.setText("");
						pw2__pwField.setText("");
						JOptionPane.showMessageDialog(Join.this, "패스워드가 다릅니다. 패스워드를 다시 입력해주세요");
					}
				} else {
					JOptionPane.showMessageDialog(Join.this, "아이디가 중복됩니다. 다른 아이디를 사용해주세요.");
					id_textField.setText("");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}