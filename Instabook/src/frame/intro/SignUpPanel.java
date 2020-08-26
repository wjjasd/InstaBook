package frame.intro;

import java.awt.Font;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

//회원가입화면
public class SignUpPanel {

	public static JPanel signUpPanel = new JPanel();

	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel showSignUpPanel() {

		// id 라벨
		JLabel idLabel_signUp = new JLabel("ID");
		idLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel_signUp.setBounds(137, 196, 31, 24);

		// id 텍스트 입력
		JTextField idTextField_signUp;
		idTextField_signUp = new JTextField();
		idTextField_signUp.setBounds(137, 224, 266, 34);
		idTextField_signUp.setColumns(10);

		// 회원가입 라벨
		JLabel pwLabel_signUp = new JLabel("PASSW");
		pwLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel_signUp.setBounds(137, 287, 85, 24);

		//패스워드 필드
		JPasswordField pwField_signUp;
		pwField_signUp = new JPasswordField();
		pwField_signUp.setColumns(10);
		pwField_signUp.setBounds(137, 315, 266, 34);

		// 회원가입 버튼
		JButton signInBtn_signUp = new JButton("SIGN UP");
		signInBtn_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//회원가입 테이블 쓰기
			}
		});
		signInBtn_signUp.setBounds(265, 632, 126, 50);

		// 뒤로가기 버튼
		JButton backBtn_signUp = new JButton("BACK");
		backBtn_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpPanel.setVisible(false);
				LogInFrame.logInPanel.setVisible(true);
			}
		});
		backBtn_signUp.setBounds(137, 632, 126, 50);

		// 비밀번호 확인 입력
		JPasswordField confPwField_signUp;
		confPwField_signUp = new JPasswordField();
		confPwField_signUp.setColumns(10);
		confPwField_signUp.setBounds(137, 397, 266, 33);

		// 성별 라벨
		JLabel sexLabel_signUp = new JLabel("SEX");
		sexLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		sexLabel_signUp.setBounds(137, 454, 54, 24);

		// 비밀번호 확인 라벨
		JLabel confPLabel_signUp = new JLabel("Confirm Pasw");
		confPLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		confPLabel_signUp.setBounds(137, 370, 168, 24);

		// 생년월일 입력
		JTextField birthTextField_signUp;
		birthTextField_signUp = new JTextField();
		birthTextField_signUp.setColumns(10);
		birthTextField_signUp.setBounds(137, 539, 266, 34);

		// 생년월일 라벨
		JLabel birthLabel_signUp = new JLabel("Date of birth");
		birthLabel_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		birthLabel_signUp.setBounds(137, 500, 134, 34);

		// 체크박스 남
		JCheckBox chckbxMale_signUp = new JCheckBox("Male");
		chckbxMale_signUp.setFont(new Font("굴림", Font.PLAIN, 15));
		chckbxMale_signUp.setBounds(214, 451, 57, 27);

		// 체크박스 여
		JCheckBox chckbxFemale_signUp = new JCheckBox("Female");
		chckbxFemale_signUp.setFont(new Font("굴림", Font.PLAIN, 15));
		chckbxFemale_signUp.setBounds(305, 451, 71, 27);
		
		//체크박스 그룹
		ButtonGroup checkBoxGroup = new ButtonGroup();
		checkBoxGroup.add(chckbxMale_signUp);
		checkBoxGroup.add(chckbxFemale_signUp);

		// 타이틀 라벨
		JLabel titleLabel_signUp = new JLabel("SIGN UP");
		titleLabel_signUp.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_signUp.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 40));
		titleLabel_signUp.setBounds(184, 40, 194, 67);

		signUpPanel.setBounds(12, 10, 560, 841);
		signUpPanel.setLayout(null);
		signUpPanel.add(idLabel_signUp);
		signUpPanel.add(idTextField_signUp);
		signUpPanel.add(pwLabel_signUp);
		signUpPanel.add(pwField_signUp);
		signUpPanel.add(signInBtn_signUp);
		signUpPanel.add(backBtn_signUp);
		signUpPanel.add(confPwField_signUp);
		signUpPanel.add(sexLabel_signUp);
		signUpPanel.add(confPLabel_signUp);
		signUpPanel.add(birthTextField_signUp);
		signUpPanel.add(birthLabel_signUp);
		signUpPanel.add(chckbxMale_signUp);
		signUpPanel.add(chckbxFemale_signUp);
		signUpPanel.add(titleLabel_signUp);

		return signUpPanel;

	}
}
