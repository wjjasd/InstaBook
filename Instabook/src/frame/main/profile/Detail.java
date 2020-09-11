package frame.main.profile;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

import db.PostDAO;
import db.PostVO;
import db.UserDAO;
import db.UserVO;
import frame.intro.LogInFrame;
import frame.main.RootFrame;


public class Detail extends JPanel {
	private static PostVO postVo = new PostVO();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return
	 * @wbp.parser.entryPoint
	 */
	//디자인에 사용하는 임시 main
//		public static void main(String[] args) {
//			Detail hopn = new Detail();
//			JFrame frame = new JFrame();
//			frame.setSize(355,523);
//			frame.getContentPane().add(hopn);
//			
//			
//			frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//			frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//			frame.setVisible(true);
//		}
	
	public Detail() {
		//로그인 된 아이디 값 확인.
		String id_user = LogInFrame.userId;
		
		//setLayout과 setSize, setBounds에 따라 패널이  가운데 고정하는 크기에 영향이 생김.
		setLayout(null);
		setSize(500, 600);
		setBounds(100, 100, 400, 510);
		
		JButton detail_header_pic_btn  = new JButton();
		ImageIcon img = new ImageIcon("..\\TheJoEnProject1\\Instabook\\src\\images\\myProfileImg.png");
		Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
		Image picCh = pic.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
		ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성
		
		// 버튼 테두리 없애기
		detail_header_pic_btn.setBorderPainted(false);
		// 버튼 글자 테두리 없애기
		detail_header_pic_btn.setFocusPainted(false);
		// 버튼 배경색 없애기
		detail_header_pic_btn.setContentAreaFilled(false);

		detail_header_pic_btn.setBounds(24, 21, 97, 58);
//		detail_header_pic_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog( detail_header_pic_btn,"난 이미지에요.");
//			}
//		});
		detail_header_pic_btn.setIcon(iconCh);
		add(detail_header_pic_btn);
		
		//아이디를 기준으로 닉네임 테이더베이스에서 불러오기
		String nickName = UserDAO.getNickname(id_user);
		JLabel detail_nickname_Label = new JLabel("닉네임");
		detail_nickname_Label.setBounds(230, 20, 101, 30);
		detail_nickname_Label.setText(nickName);
		add(detail_nickname_Label);
		
		JLabel detail_mainPic_Label = new JLabel();
		detail_mainPic_Label.setBounds(75, 96, 318, 254);

		JLabel detail_day_Label = new JLabel("게시일");
		detail_day_Label.setBounds(49, 361, 122, 15);
		add(detail_day_Label);

		JLabel detail_hash_input = new JLabel();
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
				RootFrame.detailPn.setVisible(false);
				RootFrame.postFixPn.setVisible(true);
			}
		});
		detail_Fix_btn.setBounds(230, 454, 97, 23);
		add(detail_Fix_btn);

		PostDAO postDao = new PostDAO();
		try {
			postVo = postDao.detailRead(id_user);
			detail_day_Label.setText(postVo.getDate_post());
			//DB에 저장되어 있는 이미지 경로 불러와서 사진 보여주기
			String imgPath = postVo.getImg_post();
			ImageIcon detail_img = new ImageIcon(imgPath);
			Image detail_pic = detail_img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
			Image detail_picCh = detail_pic.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
			ImageIcon detail_iconCh = new ImageIcon(detail_picCh); // Image로 ImageIcon 생성
			
			
			detail_mainPic_Label.setIcon(detail_iconCh);
			//스크롤패널 버튼적용
			add(detail_mainPic_Label);
			
			detail_hash_input.setText(postVo.getHash_post());
			//int설정
			int likeInt = postVo.getLike_post();
			String textLike = Integer.toString(likeInt);
			detail_like_Label.setText(textLike);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		
		setVisible(true);

	}
}
