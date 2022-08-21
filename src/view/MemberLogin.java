package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.BookDao;
import model.MemberDao;
import model.MemberVo;

public class MemberLogin extends JPanel implements ActionListener {
	private JTextField id_textField;
	private JButton btn_join;
	private JButton btn_login;
	private CardLayout card;
	private JPasswordField pw_textField;
	private static MemberDao memDao = new MemberDao();
	private static BookDao bookDao = null;
	private static Main main;
	private static MemberVo memVo = null;

	/**
	 * Create the panel.
	 */
	public MemberLogin(CardLayout card, Main main) {
		this.main = main;

		// memDao = new MemDao();

		// 카드 레이아웃 설정(화면 넘겨야됨)
		this.card = card;
		setLayout(new GridLayout(3, 1, 0, 0));

		// 아이디 핸들링 할 패널
		JPanel id_panel = new JPanel();
		add(id_panel);
		id_panel.setLayout(null);

		// 아이디 라벨, 아이디 텍스트 필드
		JLabel id_label = new JLabel("아이디");
		id_label.setFont(new Font("굴림", Font.PLAIN, 15));
		id_label.setBounds(47, 42, 42, 15);
		id_panel.add(id_label);

		id_textField = new JTextField();
		id_textField.setBounds(111, 39, 116, 21);
		id_panel.add(id_textField);
		id_textField.setColumns(10);

		// 패스워드 핸들링 할 패널
		JPanel pwd_panel = new JPanel();
		add(pwd_panel);
		pwd_panel.setLayout(null);

		// 패스워드 라벨, 패스워드 패스워드 필드
		JLabel pw_label = new JLabel("패스워드");
		pw_label.setFont(new Font("굴림", Font.PLAIN, 15));
		pw_label.setBounds(47, 42, 57, 18);
		pwd_panel.add(pw_label);

		pw_textField = new JPasswordField();
		pw_textField.setColumns(10);
		pw_textField.setBounds(111, 41, 116, 21);
		pwd_panel.add(pw_textField);

		// 버튼 핸들링 할 패널
		JPanel btn_panel = new JPanel();
		add(btn_panel);
		btn_panel.setLayout(null);

		// 회원가입 버튼
		btn_join = new JButton("회원가입");
		btn_join.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_join.setBounds(31, 40, 97, 23);
		btn_panel.add(btn_join);
		btn_join.addActionListener(this);

		// 로그인 버튼
		btn_login = new JButton("로그인");
		btn_login.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_login.setBounds(160, 40, 97, 23);
		btn_panel.add(btn_login);
		btn_login.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 회원 가입 버튼 클릭
		if (e.getSource() == btn_join) {
			// Main Frame에서 카드레이아웃으로 회원가입 패널로 전환
			card.show(getParent(), "join");
		}

		else if (e.getSource() == btn_login) {
			// 유효성 검사
			// id pwd 가져오기
			String id = "";
			String pw = "";
			id = id_textField.getText();
			pw = new String(pw_textField.getPassword());
			try {
				if (!id.equals("")) {
					if (memDao.login(id, pw)) {
						new BookMenu(id);
						main.dispose();
					} else {
						JOptionPane.showMessageDialog(MemberLogin.this, "아이디 혹은 비밀번호가 다릅니다. 다시 시도 부탁드립니다.");
					}
				} else {
					JOptionPane.showMessageDialog(MemberLogin.this, "아이디 혹은 비밀번호가 입력되지 않았습니다. 다시 시도 부탁드립니다.");
				}
				
			} catch (NullPointerException | HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
