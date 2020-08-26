package frame.main;

import javax.swing.JPanel;


import javax.swing.JButton;
import javax.swing.JTextArea;

public class PostPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 * @wbp.parser.entryPoint
	 */
	
	//디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		PostPanel popn = new PostPanel();
//		frame.add(popn);
//		frame.getContentPane().setBackground(Color.GRAY);
//		frame.setSize(600, 900);
//		frame.getContentPane().setLayout(null);
//		frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//		frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}
	
	public PostPanel() {

		setLayout(null);
		setSize(500, 600);
		setVisible(true);
		setBounds(100, 100, 400, 510);

		// 이미지1
//		ImageIcon img = new ImageIcon("flower.jpg");

		setBounds(100, 100, 400, 510);
		setLayout(null);

		JButton post_mainPic_btn = new JButton("이미지");
		post_mainPic_btn.setBounds(68, 45, 260, 238);
		add(post_mainPic_btn);

		JTextArea post_hash_input = new JTextArea();
		post_hash_input.setBounds(68, 309, 260, 42);
		add(post_hash_input);

		JButton post_put_btn = new JButton("입력완료");
		post_put_btn.setBounds(123, 403, 142, 52);
		add(post_put_btn);
		setVisible(true);

	}
}
