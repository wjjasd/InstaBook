package frame.intro;

import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import frame.main.RootFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

// 로그인화면
public class LogInFrame {

	public static JFrame frame;
	// signUpPanel에서 접근 가능하게 하기 위해 public static으로 선언

	// 여기서 먼저 로그인 패널을 끼워 놓기 때문에
	// 회원가입 버튼 누를 때 새로운 SignUpPanel생성해서 끼우고 거기서(signUp클래스) back버튼 누를때는 그냥
	// visibility만 조정해줌

	public static JPanel logInPanel;

	// 프로그램 시작점
	public static void main(String[] args) {

		showLogInFrame();

	}

	public static void showLogInFrame() {

		// 프레임 사이즈
		final int WIDTH = 600;
		final int HEIGHT = 900;

		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setLayout(null);

		// 로그인패널 객체
		logInPanel = new JPanel();

		// id라벨
		JLabel idLabel_login = new JLabel("ID");
		idLabel_login.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel_login.setBounds(103, 259, 80, 42);

		// id 입력
		JTextField IdtextField_logIn;
		IdtextField_logIn = new JTextField();
		IdtextField_logIn.setBounds(226, 259, 232, 42);
		IdtextField_logIn.setColumns(10);

		// 패스워드 라벨
		JLabel pwLabel_login = new JLabel("PASSW");
		pwLabel_login.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel_login.setBounds(103, 318, 80, 42);

		// 패스워드 입력
		JPasswordField pwtextField_logIn;
		pwtextField_logIn = new JPasswordField();
		pwtextField_logIn.setColumns(10);
		pwtextField_logIn.setBounds(226, 318, 232, 42);

		// 회원가입 버튼
		JButton signUp_logIn = new JButton("SIGN UP");
		signUp_logIn.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		signUp_logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 프레임에 패널 처음 끼울때 새 객체 생성해야함
				SignUpPanel signUpPanel = new SignUpPanel();
				JPanel signUp = signUpPanel.showSignUpPanel();
				signUp.setVisible(true);
				frame.getContentPane().add(signUp);
				logInPanel.setVisible(false);
			}
		});
		signUp_logIn.setBounds(103, 382, 355, 42);
		signUp_logIn.setBorderPainted(false);


		// 종료 버튼
		JButton exitBtn_logIn = new JButton("EXIT");
		exitBtn_logIn.setBackground(Color.LIGHT_GRAY);
		exitBtn_logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn_logIn.setBounds(103, 674, 173, 42);

		// 로그인 버튼
		JButton logInBtn_logIn = new JButton("LOG IN");
		logInBtn_logIn.setBackground(Color.LIGHT_GRAY);
		logInBtn_logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RootFrame root = new RootFrame();
				root.setVisible(true);
				frame.setVisible(false);
			}
		});
		logInBtn_logIn.setBounds(279, 674, 179, 42);

		// 타이틀 라벨
		JLabel title_logIn = new JLabel("InstaBook");
		title_logIn.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 40));
		title_logIn.setHorizontalAlignment(SwingConstants.CENTER);
		title_logIn.setBounds(94, 74, 364, 85);

		// 로그인 패널

		logInPanel.setBounds(12, 10, 560, 841);
		logInPanel.add(idLabel_login);
		logInPanel.add(IdtextField_logIn);
		logInPanel.add(pwLabel_login);
		logInPanel.add(pwtextField_logIn);
		logInPanel.add(signUp_logIn);
		logInPanel.add(exitBtn_logIn);
		logInPanel.add(logInBtn_logIn);
		logInPanel.add(title_logIn);
		frame.getContentPane().add(logInPanel);
		logInPanel.setLayout(null);

		frame.setLocationRelativeTo(null); // 프레임 가운데에서 띄우기
		frame.setResizable(false); // 프레임 사이즈 변경 안되게 고정
		frame.setVisible(true);
	}

}
