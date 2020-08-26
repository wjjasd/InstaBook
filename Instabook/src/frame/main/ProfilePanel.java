package frame.main;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.parser.entryPoint
	 */
	
	//디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		ProfilePanel profile = new ProfilePanel();
//		frame.add(profile);
//		frame.getContentPane().setBackground(Color.GRAY);
//		frame.setSize(600, 900);
//		frame.getContentPane().setLayout(null);
//		frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//		frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}
	
	public ProfilePanel() {

		setLayout(null);
		setSize(500, 600);
		setVisible(true);
		setBounds(100, 100, 400, 510);

		JButton profile_mainPic_btn = new JButton("사진");
		profile_mainPic_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RootFrame.profilePn.setVisible(false);
				RootFrame.postFixPn.setVisible(true);
				
			}
		});
		profile_mainPic_btn.setBounds(43, 92, 304, 344);
		add(profile_mainPic_btn);

		// frame에서 패널 위치 설정 및 레이아웃 크기
		setBounds(100, 100, 400, 510);
		setLayout(null);

		JLabel profile_nickname_Label = new JLabel("nick name");
		profile_nickname_Label.setBounds(245, 42, 102, 23);
		add(profile_nickname_Label);

		JLabel profile_headPic_Label = new JLabel("프로필 이미지");
		profile_headPic_Label.setBounds(54, 32, 82, 42);
		add(profile_headPic_Label);

	}
}
