package frame.main.profile;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class PostFix extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.parser.entryPoint
	 */

	// 디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		PostFix hopn = new PostFix();
//		JFrame frame = new JFrame();
//		frame.setSize(600, 900);
//		frame.add(hopn);
//		frame.setLocationRelativeTo(null); // 프레임 가운데에서 띄우기
//		frame.setResizable(false); // 프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}

	public PostFix() {
		//setLayout과 setSize, setBounds에 따라 패널이  가운데 고정하는 크기에 영향이 생김.
		setLayout(null);
		setSize(500, 600);
		setBounds(100, 100, 400, 510);

		JLabel postFix_mainPic_Label = new JLabel("사진");
		postFix_mainPic_Label.setBounds(56, 56, 254, 272);
		add(postFix_mainPic_Label);

		JTextPane postFix_hash_input = new JTextPane();
		postFix_hash_input.setBounds(79, 356, 244, 35);
		add(postFix_hash_input);

		JButton postFix_btn = new JButton("수정완료");
		postFix_btn.setBounds(97, 420, 191, 44);
		add(postFix_btn);
		
		setVisible(true);

	}
}
