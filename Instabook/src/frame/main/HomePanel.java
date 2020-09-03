package frame.main;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class HomePanel extends JPanel {
	
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

		setBounds(100, 100, 400, 510);
		setLayout(null);
		//스크롤패널 생성
		JScrollPane 스크롤패널 = new JScrollPane();
		스크롤패널.setBounds(5, 5, 390, 500);
		// 수평 스크롤 안쓰게함
		스크롤패널.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//처음에 안보였다가 사진수가 늘어나면 스크롤 보이게 설정
		스크롤패널.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(스크롤패널);
		//스크롤 패널에 담기위한 패널 생성
		JPanel 보더레이아웃패널 = new JPanel();
		//스크롤패널에 패널 넣기
		스크롤패널.setViewportView(보더레이아웃패널);
		보더레이아웃패널.setLayout(new BorderLayout(1, 1));

		JPanel 컬럼패널 = new JPanel();
		보더레이아웃패널.add(컬럼패널, BorderLayout.CENTER);
		컬럼패널.setLayout(new GridLayout(3, 0, 10, 10));//3, 0, 10, 10

		for (int i = 0; i < 20; i++) {
			컬럼패널.setLayout(new GridLayout(9, 0, 15, 15));//9, 0, 15, 15
			JPanel rowPanel = new JPanel();
			rowPanel.setPreferredSize(new Dimension(100, 115));
			컬럼패널.add(rowPanel);
			FlowLayout flow = new FlowLayout();
			rowPanel.setLayout(flow);

			
			JButton home_pic_btn = new JButton();
//			home_pic_btn.setBounds(10, 10, 105, 115);
			rowPanel.add(home_pic_btn);

			ImageIcon img = new ImageIcon("..\\Instabook\\src\\images\\" + i +".jpg");
			Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
			Image picCh = pic.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
			ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성

			// 버튼 사이즈 설정
//			home_pic_btn.setPreferredSize(new Dimension(115, 115));
			// 버튼 테두리 없애기
			home_pic_btn.setBorderPainted(false);
//			 버튼 글자 테두리 없애기
//			home_pic_btn.setFocusPainted(false);
			// 버튼 배경색 없애기
			home_pic_btn.setContentAreaFilled(false);

			home_pic_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RootFrame.homePn.setVisible(false);
					RootFrame.lookPn.setVisible(true);
				}
			});

			home_pic_btn.setIcon(iconCh);
			//스크롤패널 버튼적용
			rowPanel.add(home_pic_btn);
		}

		setVisible(true);

	}

}
