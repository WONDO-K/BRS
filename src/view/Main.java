package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Main extends JFrame {

	private JFrame frame;
	private MemberLogin Login;
	private Join Join;
	private CardLayout card;
	
	// 프로그램 실행
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		
		this.setTitle("회원가입 / 로그인");

		card = new CardLayout();
		getContentPane().setLayout(card);

		Login = new MemberLogin(card, this);
		GridLayout gridLayout = (GridLayout) Login.getLayout();
		gridLayout.setVgap(1);
		gridLayout.setHgap(1);
		Join = new Join(card);
		GridLayout gridLayout_1 = (GridLayout) Join.getLayout();
		gridLayout_1.setVgap(1);
		gridLayout_1.setHgap(1);

		getContentPane().add(Login, "login");
		getContentPane().add(Join, "join");

		setSize(320, 350);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
