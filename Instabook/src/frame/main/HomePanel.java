package frame.main;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//디자인에 사용하는 임시 main
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

		setLayout(null);
		setSize(500, 600);
		setBounds(100, 100, 400, 510);

//		ImageIcon img = new ImageIcon("img0.jpg");

		// 사진(버튼) 여러장 보이도록 출력
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		

		for (int i = 0; i < 12; i++) {

			JButton home_pic_btn = new JButton();
			ImageIcon img = new ImageIcon("..\\Instabook\\src\\images\\myProfileImg.png");
			Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
			Image picCh = pic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
			ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성

			// 버튼 사이즈 설정
			home_pic_btn.setPreferredSize(new Dimension(120, 120));
			// 버튼 테두리 없애기
			home_pic_btn.setBorderPainted(false);
			// 버튼 글자 테두리 없애기
			home_pic_btn.setFocusPainted(false);
			// 버튼 배경색 없애기
			home_pic_btn.setContentAreaFilled(false);

			home_pic_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RootFrame.homePn.setVisible(false);
					RootFrame.lookPn.setVisible(true);
				}
			});
			
			home_pic_btn.setIcon(iconCh);
			add(home_pic_btn);
		}
		
		
		setVisible(true);

	}

}
