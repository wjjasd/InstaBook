package frame.main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class LookPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	
	//디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		LookPanel lp = new LookPanel();
//		frame.getContentPane().add(lp);
//		
//		frame.getContentPane().setBackground(Color.GRAY);
//		frame.setSize(600, 900);
//		frame.getContentPane().setLayout(null);
//		frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//		frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}

	public LookPanel() {

		setLayout(null);
		setSize(500, 600);
		setBounds(100, 100, 400, 510);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(134, 179, 115, 23);
		add(chckbxNewCheckBox);

		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setBounds(300, 32, 102, 34);
	
		add(lblNewLabel);

		JLabel look_headPic_Label = new JLabel("프로필 사진");
		look_headPic_Label.setBounds(71, 14, 111, 70);
		add(look_headPic_Label);

		JLabel look_day_Label = new JLabel("2020.08.20");
		look_day_Label.setBounds(90, 469, 183, 27);
		add(look_day_Label);

		JLabel look_hash_Label = new JLabel("#해쉬 #태그 #sns");
		look_hash_Label.setBounds(60, 506, 218, 60);
		add(look_hash_Label);

		JLabel look_like_Label = new JLabel("좋아요");
		look_like_Label.setBounds(340, 492, 77, 60);
		add(look_like_Label);

		JLabel look_mainPicLabel = new JLabel("이미지");
		look_mainPicLabel.setBounds(60, 80, 377, 368);
		add(look_mainPicLabel);
		
		setVisible(true);

	}
}
