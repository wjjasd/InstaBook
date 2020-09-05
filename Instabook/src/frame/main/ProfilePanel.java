package frame.main;

import javax.swing.JPanel;

import db.UserTb;
import frame.intro.LogInFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import java.awt.Image;
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
//		frame.getContentPane().add(profile);
//		
//		JButton profileBtn_profilPn = new JButton();
//		profileBtn_profilPn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog( profile,"난 이미지에요.");
//			}
//		});
//		ImageIcon img = new ImageIcon("..\\TheJoEnProject1\\Instabook\\src\\images\\myProfileImg.png");
//		Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
//		Image picCh = pic.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
//		ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성
//		
//		// 버튼 테두리 없애기
//		profileBtn_profilPn.setBorderPainted(false);
//		// 버튼 글자 테두리 없애기
//		profileBtn_profilPn.setFocusPainted(false);
//		// 버튼 배경색 없애기
//		profileBtn_profilPn.setContentAreaFilled(false);
//		//아이콘설정
//		profileBtn_profilPn.setIcon(iconCh);
//		
//		profileBtn_profilPn.setBounds(46, 10, 70, 59);
//		profile.add(profileBtn_profilPn);
//		
//		frame.getContentPane().setBackground(Color.GRAY);
//		frame.setSize(600, 900);
//		frame.getContentPane().setLayout(null);
//		frame.setLocationRelativeTo(null); //프레임 가운데에서 띄우기
//		frame.setResizable(false); //프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}
	
	public ProfilePanel() {
		// frame에서 패널 위치 설정 및 레이아웃 크기
		setLayout(null);
		setSize(500, 600);
		setBounds(100, 100, 400, 510);

		JButton profile_mainPic_btn = new JButton("사진");
		profile_mainPic_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RootFrame.profilePn.setVisible(false);
				RootFrame.detailPn.setVisible(true);
				
			}
		});
		
		profile_mainPic_btn.setBounds(43, 92, 304, 344);
		add(profile_mainPic_btn);

		JLabel profile_nickname_Label = new JLabel("nick name");
		profile_nickname_Label.setBounds(245, 42, 102, 23);
		add(profile_nickname_Label);
		
		JButton profileBtn_profilPn = new JButton();
		profileBtn_profilPn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser profile = new JFileChooser();
				int dialogOption = profile.showOpenDialog(profileBtn_profilPn);
				if(dialogOption == JFileChooser.APPROVE_OPTION) {
					File imgFile = profile.getSelectedFile();
					System.out.println(imgFile);
					String filePath = imgFile.getPath();
					System.out.println("DB저장전 URL : " + filePath);
					//선택한 파일 경로 디비 저장
					String id = LogInFrame.userId;
					System.out.println("로그인된 아이디 : " + id );
					boolean result = UserTb.updateProfile(id, filePath);
					
					if(result) {
						//방금 저장한 이미지 경로 읽고 적용 되는지 테스트
//						1. 바로 적용
						ImageIcon img = new ImageIcon(filePath);
						Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
						Image picCh = pic.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
						ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성
						profileBtn_profilPn.setIcon(iconCh);
						//적용됨
						
// 						2. DB에서 불러온 경로 적용안됨
//						String url = UserTb.getProfile(id);
//						System.out.println(url);
//						ImageIcon img = new ImageIcon(url);
//						Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
//						Image picSI = pic.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
//						ImageIcon resizedIc = new ImageIcon(picSI);
//						profileBtn_profilPn.setIcon(resizedIc);
					}
				}
			}
		});
		
		String id = LogInFrame.userId;
		System.out.println("로그인된 아이디 : " + id );
		String imgUrl = UserTb.getProfile(id);
		System.out.println("현재 설정된 프로필 이미지의 경로 : " + imgUrl);
		ImageIcon img = new ImageIcon(imgUrl); 
		Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
		Image picCh = pic.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
		ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성
		
		// 버튼 테두리 없애기
		profileBtn_profilPn.setBorderPainted(false);
		// 버튼 글자 테두리 없애기
		profileBtn_profilPn.setFocusPainted(false);
		// 버튼 배경색 없애기
		profileBtn_profilPn.setContentAreaFilled(false);
		//아이콘설정
		profileBtn_profilPn.setIcon(iconCh);
		
		profileBtn_profilPn.setBounds(46, 10, 70, 59);
		add(profileBtn_profilPn);

		
		setVisible(true);

	}
}
