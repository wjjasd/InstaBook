package frame.main.profile;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import db.UserDAO;
import db.UserVO;
import frame.intro.LogInFrame;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;

public class UserInfoDialog extends JDialog {
	private JPasswordField oldPw_updateInfo;
	private JPasswordField newPw_updateInfo;
	private JTextField name_updateInfo;
	private JTextField birth_updateInfo;
	private String mGender;

	// 입력란 힌트주기위한 폰트

	public UserInfoDialog(String id, String name, String gender, String birth) {


		setSize(400, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.out.println("cancelBtn");
			}
		});
		cancelBtn.setBounds(12, 501, 174, 50);
		getContentPane().add(cancelBtn);

		JLabel idLabel_updateInfo = new JLabel("ID");
		idLabel_updateInfo.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel_updateInfo.setBounds(57, 55, 31, 24);
		getContentPane().add(idLabel_updateInfo);

		JLabel oldpwLabel_updateInfo = new JLabel("Existing Password");
		oldpwLabel_updateInfo.setFont(new Font("굴림", Font.BOLD, 20));
		oldpwLabel_updateInfo.setBounds(57, 104, 181, 24);
		getContentPane().add(oldpwLabel_updateInfo);

		oldPw_updateInfo = new JPasswordField();
		oldPw_updateInfo.setColumns(10);
		oldPw_updateInfo.setBounds(57, 132, 266, 34);
		getContentPane().add(oldPw_updateInfo);

		JLabel newpwLabel_updateInfo = new JLabel("New Password");
		newpwLabel_updateInfo.setFont(new Font("굴림", Font.BOLD, 20));
		newpwLabel_updateInfo.setBounds(57, 176, 168, 24);
		getContentPane().add(newpwLabel_updateInfo);

		newPw_updateInfo = new JPasswordField();
		newPw_updateInfo.setColumns(10);
		newPw_updateInfo.setBounds(57, 203, 266, 33);
		getContentPane().add(newPw_updateInfo);

		JLabel nameLb_signUp = new JLabel("Name");
		nameLb_signUp.setFont(new Font("굴림", Font.BOLD, 20));
		nameLb_signUp.setBounds(57, 246, 54, 24);
		getContentPane().add(nameLb_signUp);

		
		name_updateInfo = new JTextField();
		name_updateInfo.setText(name);
		name_updateInfo.setColumns(10);
		name_updateInfo.setBounds(57, 274, 266, 34);
		getContentPane().add(name_updateInfo);

		JLabel genderLabel_updateInfo = new JLabel("Gender");
		genderLabel_updateInfo.setFont(new Font("굴림", Font.BOLD, 20));
		genderLabel_updateInfo.setBounds(57, 318, 103, 24);
		getContentPane().add(genderLabel_updateInfo);

		JCheckBox chckbxMale_updateInfo = new JCheckBox("Male");
		chckbxMale_updateInfo.setFont(new Font("굴림", Font.PLAIN, 15));
		chckbxMale_updateInfo.setBounds(149, 318, 57, 27);
		chckbxMale_updateInfo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 체크박스 '남' 선택시 전역변수 mGender에 m대입
				// 그룹으로 묶이면 무조건 하나 선택 하기때문에 여성은 코딩안해도됨
				if (e.getStateChange() == 1) {
					mGender = "m";
//					System.out.println("남");
				} else {
					mGender = "f";
//					System.out.println("여");
				}
				
			}
		});
		getContentPane().add(chckbxMale_updateInfo);

		
		JCheckBox chckbxFemale_updateInfo = new JCheckBox("Female");
		chckbxFemale_updateInfo.setFont(new Font("굴림", Font.PLAIN, 15));
		chckbxFemale_updateInfo.setBounds(210, 319, 71, 27);
		getContentPane().add(chckbxFemale_updateInfo);
		
		
		if(gender == "m") {
			mGender = "m";
			chckbxMale_updateInfo.setSelected(true);
		}else {
			mGender = "f";
			chckbxFemale_updateInfo.setSelected(true);
		}

		// 체크박스 그룹
		ButtonGroup checkBoxGroup = new ButtonGroup();
		checkBoxGroup.add(chckbxMale_updateInfo);
		checkBoxGroup.add(chckbxFemale_updateInfo);

		JLabel birthLabel_updateInfo = new JLabel("Date of birth");
		birthLabel_updateInfo.setFont(new Font("굴림", Font.BOLD, 20));
		birthLabel_updateInfo.setBounds(57, 368, 134, 34);
		getContentPane().add(birthLabel_updateInfo);

		birth_updateInfo = new JTextField();
		birth_updateInfo.setText(birth);
		birth_updateInfo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		birth_updateInfo.setColumns(8);
		birth_updateInfo.setBounds(57, 403, 266, 34);
		getContentPane().add(birth_updateInfo);

		JLabel idLb = new JLabel(id);
		idLb.setForeground(Color.DARK_GRAY);
		idLb.setFont(new Font("굴림", Font.PLAIN, 15));
		idLb.setBounds(82, 48, 236, 43);
		getContentPane().add(idLb);

		JButton okBtn = new JButton("save");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] pw = newPw_updateInfo.getPassword();
				String pwStr = "";
				for (int i = 0; i < pw.length; i++) {
					pwStr += pw[i];
				}
				String name = name_updateInfo.getText().toString();
				String birth = birth_updateInfo.getText().toString();

				UserVO userDataSet = new UserVO();
				userDataSet.setId_user(id);
				userDataSet.setPw_user(pwStr);
				userDataSet.setNickname_user(name);
				userDataSet.setGender_user(mGender);
				userDataSet.setBirth_user(birth);

				// 회원정보 수정
				boolean result = UserDAO.updateUserInfo(userDataSet);
				if (result) {
					JOptionPane.showMessageDialog(null, "회원정보 수정 성공!");
					setVisible(false);
					LogInFrame.logInPanel.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "회원정보 수정 실패!");
				}

				System.out.println("saveBtn");
			}
		});
		okBtn.setBounds(198, 501, 174, 50);
		getContentPane().add(okBtn);
		
		JLabel lblNewLabel = new JLabel("회원정보 수정");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(137, 10, 116, 24);
		getContentPane().add(lblNewLabel);

	}
}
