package frame.main.profile;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


public class Detail extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 * @wbp.parser.entryPoint
	 */
	//디자인에 사용하는 임시 main
		public static void main(String[] args) {
			Detail hopn = new Detail();
			JFrame frame = new JFrame();
			frame.setSize(600,900);
			frame.add(hopn);
			frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
			frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
			frame.setVisible(true);
		}
	
	public Detail() {


		setBounds(100, 100, 400, 510);
		setSize(500, 600);
		setLayout(null);

		JLabel detail_mainPic_Label = new JLabel("이미지");
		detail_mainPic_Label.setBounds(42, 96, 318, 254);
		add(detail_mainPic_Label);

		JLabel detail_header_pic_Label = new JLabel("프로필");
		detail_header_pic_Label.setBounds(26, 20, 93, 44);
		add(detail_header_pic_Label);

		JLabel detail_nickname_Label = new JLabel("닉네임");
		detail_nickname_Label.setBounds(230, 20, 101, 30);
		add(detail_nickname_Label);

		JTextPane detail_hash_input = new JTextPane();
		detail_hash_input.setBounds(49, 399, 167, 30);
		add(detail_hash_input);

		JLabel detail_like_Label = new JLabel("좋아요");
		detail_like_Label.setBounds(274, 396, 67, 33);
		add(detail_like_Label);

		JButton detail_del_btn = new JButton("삭제");
		detail_del_btn.setBounds(74, 454, 97, 23);
		add(detail_del_btn);

		JButton detail_Fix_btn = new JButton("수정");
		detail_Fix_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		detail_Fix_btn.setBounds(230, 454, 97, 23);
		add(detail_Fix_btn);

		JLabel detail_day_Label = new JLabel("게시일:2020.08.28");
		detail_day_Label.setBounds(49, 361, 122, 15);
		add(detail_day_Label);
		setVisible(true);

	}
}
