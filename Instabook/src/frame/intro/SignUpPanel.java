package frame.intro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.UserTb;

//회원가입화면
public class SignUpPanel {

	public JPanel signUpPanel = new JPanel();
	private JLabel idLabel_signUp = new JLabel("ID");
	private JTextField idTextField_signUp;
	private JLabel pwLabel_signUp = new JLabel("Password");
	private JPasswordField pwField_signUp;
	private JTextField nameTextField_signUp;
	private String mGender;
	private JPasswordField confPwField_signUp;
	private JLabel sexLabel_signUp = new JLabel("Gender");
	private JLabel confPLabel_signUp = new JLabel("Repeat Password");
	private JTextField birthTextField_signUp;
	private JLabel birthLabel_signUp = new JLabel("Date of birth");
	private JCheckBox chckbxMale_signUp = new JCheckBox("Male");
	private JCheckBox chckbxFemale_signUp = new JCheckBox("Female");

	private JButton signUpBtn_signUp = new JButton("SIGN UP");
	private JButton backBtn_signUp = new JButton("BACK");
	private JTextField dummy; //아이디입력 텍스츠 필드에 포커스 안가게 만들어놓은것 (안보임)

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel showSignUpPanel() {
		// 입력란 힌트주기위한 폰트
		Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
		Font lostFont = new Font("Tahoma", Font.ITALIC, 11);
		String idHint = " example@exam.com";
		String birthHint = "ex) 20201125";

		// id 라벨
		idLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel_signUp.setBounds(137, 130, 31, 24);

		// id 텍스트 입력
		idTextField_signUp = new JTextField();
		idTextField_signUp.setColumns(10);
		idTextField_signUp.setBounds(137, 158, 266, 34);
		idTextField_signUp.setText(idHint);
		idTextField_signUp.setFont(lostFont);

		// 힌트표시 리스너 오버라이딩
		idTextField_signUp.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (idTextField_signUp.getText().equals(idHint) || idTextField_signUp.getText().length() == 0) {
					idTextField_signUp.setText(idHint);
					idTextField_signUp.setFont(lostFont);
					idTextField_signUp.setForeground(Color.GRAY);
				} else {
					idTextField_signUp.setText(idTextField_signUp.getText());
					idTextField_signUp.setFont(gainFont);
					idTextField_signUp.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (idTextField_signUp.getText().equals(idHint)) {
					idTextField_signUp.setText("");
					idTextField_signUp.setFont(gainFont);
				} else {
					idTextField_signUp.setText(idTextField_signUp.getText());
					idTextField_signUp.setFont(gainFont);
				}

			}
		});

		// 회원가입 라벨
		pwLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel_signUp.setBounds(137, 202, 126, 24);

		// 패스워드 필드
		pwField_signUp = new JPasswordField();
		pwField_signUp.setColumns(10);
		pwField_signUp.setBounds(137, 230, 266, 34);

		// 회원가입 버튼
		signUpBtn_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTextField_signUp.getText().toString();
				char[] pw = pwField_signUp.getPassword();
				String pwStr = "";
				for (int i = 0; i < pw.length; i++) {
					pwStr += pw[i];
				}
				String name = nameTextField_signUp.getText().toString();
				String img = null;
				String gender = mGender;
				String birth = birthTextField_signUp.getText().toString();
				// 회원가입 테이블 쓰기
				boolean result = UserTb.signUp(id, pwStr, name, img, gender, birth);
				if (result) {
					JOptionPane.showMessageDialog(signUpPanel, "회원가입 성공!");
					signUpPanel.setVisible(false);
					LogInFrame.logInPanel.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(signUpPanel, "회원가입 실패!");
				}
			}
		});
		signUpBtn_signUp.setBounds(265, 632, 126, 50);

		// 뒤로가기 버튼
		backBtn_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpPanel.setVisible(false);
				LogInFrame.logInPanel.setVisible(true);
			}
		});
		backBtn_signUp.setBounds(137, 632, 126, 50);

		// 비밀번호 확인 입력
		confPwField_signUp = new JPasswordField();
		confPwField_signUp.setColumns(10);
		confPwField_signUp.setBounds(137, 301, 266, 33);

		// 성별 라벨

		sexLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		sexLabel_signUp.setBounds(137, 431, 103, 24);

		// 비밀번호 확인 라벨

		confPLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		confPLabel_signUp.setBounds(137, 274, 168, 24);

		// 생년월일 입력

		birthTextField_signUp = new JTextField();
		birthTextField_signUp.setToolTipText("19921102");
		birthTextField_signUp.setColumns(8);
		birthTextField_signUp.setBounds(137, 520, 266, 34);
		birthTextField_signUp.setText(birthHint);
		birthTextField_signUp.setFont(lostFont);
		birthTextField_signUp.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {

				if (birthTextField_signUp.getText().equals(birthHint) || birthTextField_signUp.getText().length() == 0) {
					birthTextField_signUp.setText(birthHint);
					birthTextField_signUp.setFont(lostFont);
					birthTextField_signUp.setForeground(Color.GRAY);
				} else {
					birthTextField_signUp.setText(birthTextField_signUp.getText());
					birthTextField_signUp.setFont(gainFont);
					birthTextField_signUp.setForeground(Color.BLACK);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {

				if (birthTextField_signUp.getText().equals(birthHint)) {
					birthTextField_signUp.setText("");
					birthTextField_signUp.setFont(gainFont);
				} else {
					birthTextField_signUp.setText(birthTextField_signUp.getText());
					birthTextField_signUp.setFont(gainFont);
				}

				
			}
		});
		

		// 생년월일 라벨

		birthLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		birthLabel_signUp.setBounds(137, 481, 134, 34);

		// 체크박스 남

		chckbxMale_signUp.setFont(new Font("굴림", Font.PLAIN, 15));
		chckbxMale_signUp.setBounds(229, 431, 57, 27);
		chckbxMale_signUp.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == 1) {
					mGender = "m";
//					System.out.println("남");
				} else {
					mGender = "f";
//					System.out.println("여");
				}

			}
		});

		// 체크박스 여

		chckbxFemale_signUp.setFont(new Font("굴림", Font.PLAIN, 15));
		chckbxFemale_signUp.setBounds(290, 432, 71, 27);

		// 체크박스 그룹
		ButtonGroup checkBoxGroup = new ButtonGroup();
		checkBoxGroup.add(chckbxMale_signUp);
		checkBoxGroup.add(chckbxFemale_signUp);

		// 타이틀 라벨
		JLabel titleLabel_signUp = new JLabel("SIGN UP");
		titleLabel_signUp.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_signUp.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 40));
		titleLabel_signUp.setBounds(167, 54, 194, 67);

		signUpPanel.setBounds(12, 10, 560, 841);
		signUpPanel.setLayout(null);
		signUpPanel.add(idLabel_signUp);
		signUpPanel.add(idTextField_signUp);
		signUpPanel.add(pwLabel_signUp);
		signUpPanel.add(pwField_signUp);
		signUpPanel.add(signUpBtn_signUp);
		signUpPanel.add(backBtn_signUp);
		signUpPanel.add(confPwField_signUp);
		signUpPanel.add(sexLabel_signUp);
		signUpPanel.add(confPLabel_signUp);
		signUpPanel.add(birthTextField_signUp);
		signUpPanel.add(birthLabel_signUp);
		signUpPanel.add(chckbxMale_signUp);
		signUpPanel.add(chckbxFemale_signUp);
		signUpPanel.add(titleLabel_signUp);

		JLabel nameLb_signUp = new JLabel("Name");
		nameLb_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		nameLb_signUp.setBounds(137, 344, 54, 24);
		signUpPanel.add(nameLb_signUp);

		nameTextField_signUp = new JTextField();
		nameTextField_signUp.setColumns(10);
		nameTextField_signUp.setBounds(137, 372, 266, 34);
		signUpPanel.add(nameTextField_signUp);

		dummy = new JTextField();
		dummy.setBounds(0, 0, -1, 3);
		signUpPanel.add(dummy);
		dummy.setColumns(10);

		return signUpPanel;

	}
}
