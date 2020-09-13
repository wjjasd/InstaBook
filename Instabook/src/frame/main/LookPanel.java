package frame.main;

import javax.swing.JPanel;

import db.PostDAO;
import db.PostVO;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LookPanel extends JPanel {
	static PostVO postVo = new PostVO();
	PostDAO postDao = new PostDAO();
	static JLabel look_mainPicLabel = new JLabel();
	static String ck;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.parser.entryPoint
	 * 
	 */

	// 디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		LookPanel lp = new LookPanel();
//		lp.setLayout(null);
//		
//		
//		frame.getContentPane().add(lp);
//		
//		frame.getContentPane().setBackground(Color.GRAY);
//		frame.setSize(600, 900);
//		frame.getContentPane().setLayout(null);
//		frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//		frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}
//	static String ck ="C:\\Users\\aej93\\Desktop\\img\\11.jpg";

	public LookPanel() {
		
		String ssk = HomePanel.sk;
		System.out.println("---------------------룩패널에 값 : "+ssk);

		setLayout(null);
		setSize(500, 600);
		setBounds(51, 10, 492, 745);

		JLabel look_NickName_Label = new JLabel("닉네임");
		look_NickName_Label.setBounds(300, 32, 102, 34);
		add(look_NickName_Label);

		JLabel look_headPic_Label = new JLabel("프로필 사진");
		look_headPic_Label.setBounds(71, 14, 111, 70);
		add(look_headPic_Label);

		JLabel look_day_Label = new JLabel();
		look_day_Label.setBounds(90, 469, 183, 27);
		add(look_day_Label);

		JLabel look_hash_Label = new JLabel();
		look_hash_Label.setBounds(60, 506, 218, 60);
		add(look_hash_Label);

		JLabel look_like_Label = new JLabel();
		look_like_Label.setBounds(260, 473, 57, 15);
		add(look_like_Label);
		
		JLabel look_mainPicLabel = new JLabel();
//		String ck = look_mainPicLabel.getText();

		try {
			// 누른 다른 사용자의 이미지(게시물) 기준으로 같은 이미지 출력
//				// DB에 저장되어 있는 이미지 경로 불러와서 사진 보여주기
//			postVo = postDao.lookRead(ck);
//			String imgPath = postVo.getImg_post();
			ImageIcon look_img = new ImageIcon(ck);
//			ImageIcon look_img = new ImageIcon(imgPath);
			Image look_pic = look_img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
			Image look_picCh = look_pic.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
			ImageIcon look_iconCh = new ImageIcon(look_picCh); // Image로 ImageIcon 생성

			look_mainPicLabel.setIcon(look_iconCh);
			// 스크롤패널 버튼적용
			look_mainPicLabel.setBounds(60, 80, 377, 368);
			add(look_mainPicLabel);

			look_day_Label.setText(postVo.getDate_post());
			look_hash_Label.setText(postVo.getHash_post());
			// int설정
			int likeInt = postVo.getLike_post();
			String textLike = Integer.toString(likeInt);
			look_like_Label.setText(textLike);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		setVisible(true);
	}
}
