package frame.main;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import db.PostDAO;
import db.PostVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HomePanel extends JPanel {
	PostDAO postDao = new PostDAO();
	static PostVO bag = new PostVO();
	ArrayList<PostVO> imgList;
	static String userPost;
	static String sk = "";
	static JButton home_pic_btn;
//	static String homeImg;
	static JPanel homeImgPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		HomePanel hopn = new HomePanel();
//		JFrame frame = new JFrame();
//		frame.setSize(600,900);
//		frame.add(hopn);
//		frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//		frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}
	public HomePanel() {
//		ArrayList<PostVO> list = new ArrayList<PostVO>();

		setBounds(51, 10, 492, 745);
		setLayout(null);
		// 스크롤패널 생성
		JScrollPane 스크롤패널 = new JScrollPane();
		스크롤패널.setBounds(5, 40, 390, 470);
		// 수평 스크롤 안쓰게함
		스크롤패널.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// 처음에 안보였다가 사진수가 늘어나면 스크롤 보이게 설정
		스크롤패널.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(스크롤패널);
		// 스크롤 패널에 담기위한 패널 생성
		JPanel 보더레이아웃패널 = new JPanel();
		// 스크롤패널에 패널 넣기
		스크롤패널.setViewportView(보더레이아웃패널);
		보더레이아웃패널.setLayout(new BorderLayout(1, 1));

		JPanel 컬럼패널 = new JPanel();
		보더레이아웃패널.add(컬럼패널, BorderLayout.CENTER);
		컬럼패널.setLayout(new GridLayout(3, 0, 20, 20));// 3, 0, 10, 10

		JTextField search_textField = new JTextField();
		search_textField.setBounds(72, 10, 182, 21);
		add(search_textField);
		search_textField.setColumns(10);

		// 해쉬태그 검색 버튼 기능
		JButton search_btn = new JButton("검색");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hashTag = search_textField.getText();
				homeImgPanel.setVisible(false);
				home_pic_btn.setVisible(false);

				try {
					bag = postDao.searchHash(hashTag);
					String getSearchText = bag.getImg_post();
					String searchImg = getSearchText;
					컬럼패널.setLayout(new GridLayout(0, 3));// 9, 0, 15, 15
					JPanel searchImgPanel = new JPanel();
					searchImgPanel.setPreferredSize(new Dimension(100, 115));
					컬럼패널.add(searchImgPanel);
					FlowLayout flow = new FlowLayout();
					searchImgPanel.setLayout(flow);

					JButton search_pic_btn = new JButton();
					// home_pic_btn.setBounds(10, 10, 105, 115);
					searchImgPanel.add(search_pic_btn);
					ImageIcon img1 = new ImageIcon(searchImg);
					Image pic = img1.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
					Image picCh = pic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
					ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성

					// 버튼 사이즈 설정
					// home_pic_btn.setPreferredSize(new Dimension(115, 115));
					// 버튼 테두리 없애기
					search_pic_btn.setBorderPainted(false);
					// 버튼 글자 테두리 없애기
					// home_pic_btn.setFocusPainted(false);
					// 버튼 배경색 없애기
					search_pic_btn.setContentAreaFilled(false);

					search_pic_btn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RootFrame.homePn.setVisible(false);
							RootFrame.lookPn.setVisible(true);
							// 버튼에 적용된 주소값을 가져오기 위한 uerPost메서드
//							userPost = postDao.userPost(searchImg);
//							// 콘솔에서 값 확인
//							System.out.println("--------------look패널에 주소값 적용 성공: "+ userPost);
//							// lookPanel 버튼에 값 넣기
//							LookPanel.look_mainPicLabel.setText(userPost);
//							LookPanel.ck = LookPanel.look_mainPicLabel.getText();
//							System.out.println("--------------look패널에 적용된 주소값 가져오기 성공: "+LookPanel.ck);
//							sk = LookPanel.ck;
//							System.out.println("--------------look패널에 적용된 주소값 가져오기 성공2: "+sk);
						}
					});
					search_pic_btn.setIcon(iconCh);
					// 스크롤패널 버튼적용
					searchImgPanel.add(search_pic_btn);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		search_btn.setBounds(266, 9, 97, 23);
		add(search_btn);

		// 다른 사용자의 이미지 불러와서 보여주기
		try {
			postDao = new PostDAO();
			imgList = postDao.all();

			System.out.println("-------------------------Home 이미지 개수:" + imgList.size() + "개");

			for (int img = 0; img < imgList.size(); img++) {// 1번째 for
				bag = imgList.get(img);
				String homeImg = bag.getImg_post();

//				for (int i = 0; i < imgList.size(); i++) {
				컬럼패널.setLayout(new GridLayout(0, 3));// 9, 0, 15, 15
				homeImgPanel = new JPanel();
				homeImgPanel.setPreferredSize(new Dimension(100, 115));
				컬럼패널.add(homeImgPanel);
				FlowLayout flow = new FlowLayout();
				homeImgPanel.setLayout(flow);

				home_pic_btn = new JButton();
				// home_pic_btn.setBounds(10, 10, 105, 115);
				homeImgPanel.add(home_pic_btn);
				ImageIcon img1 = new ImageIcon(homeImg);
				Image pic = img1.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
				Image picCh = pic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
				ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성

				// 버튼 사이즈 설정
				// home_pic_btn.setPreferredSize(new Dimension(115, 115));
				// 버튼 테두리 없애기
				home_pic_btn.setBorderPainted(false);
				// 버튼 글자 테두리 없애기
				// home_pic_btn.setFocusPainted(false);
				// 버튼 배경색 없애기
				home_pic_btn.setContentAreaFilled(false);

				home_pic_btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RootFrame.homePn.setVisible(false);
						RootFrame.lookPn.setVisible(true);
						// 버튼에 적용된 주소값을 가져오기 위한 uerPost메서드
						userPost = postDao.userPost(homeImg);
						// 콘솔에서 값 확인
						System.out.println("--------------look패널에 주소값 적용 성공: " + userPost);
						// lookPanel 버튼에 값 넣기
						LookPanel.look_mainPicLabel.setText(userPost);
						LookPanel.ck = LookPanel.look_mainPicLabel.getText();
						System.out.println("--------------look패널에 적용된 주소값 가져오기 성공: " + LookPanel.ck);
						sk = LookPanel.ck;
						System.out.println("--------------look패널에 적용된 주소값 가져오기 성공2: " + sk);
					}
				});
				home_pic_btn.setIcon(iconCh);
				// 스크롤패널 버튼적용
				homeImgPanel.add(home_pic_btn);
//				}
			} // 1번재 for
				// --------------------
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 해쉬태그 파일로 저장
		// 잠시 주석
//		try {
//			dao.allHash();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}

		setVisible(true);

	}
}
