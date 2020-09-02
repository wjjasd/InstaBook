package frame.main;

import javax.swing.JFrame;

import frame.main.profile.Detail;
import frame.main.profile.PostFix;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RootFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static HomePanel homePn = new HomePanel();
	public static LookPanel lookPn = new LookPanel();
	public static PostPanel postPn = new PostPanel();
	public static ProfilePanel profilePn = new ProfilePanel();
	public static PostFix postFixPn = new PostFix();
	public static Detail detailPn = new Detail();

	/**
	 * @return
	 * @wbp.parser.entryPoint
	 */
	
	//디자인에 사용하는 임시 main
	public static void main(String[] args) {
		RootFrame root = new RootFrame();
		root.setVisible(true);
	}
	
	public RootFrame() {

		setSize(600, 900);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.GRAY);
		getContentPane().add(homePn);
		getContentPane().add(lookPn);
		getContentPane().add(postPn);
		getContentPane().add(profilePn);
		getContentPane().add(postFixPn);
		getContentPane().add(detailPn);

		homePn.setVisible(true);
		lookPn.setVisible(false);
		postPn.setVisible(false);
		profilePn.setVisible(false);
		postFixPn.setVisible(false);
		detailPn.setVisible(false);

		// 홈 버튼
		JButton root_home_btn = new JButton("Home");
		root_home_btn.setBounds(60, 692, 145, 42);
		root_home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				homePn.setVisible(true);
				lookPn.setVisible(false);
				postPn.setVisible(false);
				profilePn.setVisible(false);
				postFixPn.setVisible(false);
				detailPn.setVisible(false);
				
			}
		});
		getContentPane().add(root_home_btn);

		// 포스트 버튼
		JButton root_post_btn = new JButton("게시물");
		root_post_btn.setBounds(213, 692, 145, 42);
		root_post_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				homePn.setVisible(false);
				lookPn.setVisible(false);
				postPn.setVisible(true);
				profilePn.setVisible(false);
				postFixPn.setVisible(false);
				detailPn.setVisible(false);
				
			}
		});
		getContentPane().add(root_post_btn);

		// 프로필 버튼
		JButton root_profile_btn = new JButton("My Profile");
		root_profile_btn.setBounds(367, 692, 145, 42);
		root_profile_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				homePn.setVisible(false);
				lookPn.setVisible(false);
				postPn.setVisible(false);
				profilePn.setVisible(true);
				postFixPn.setVisible(false);
				detailPn.setVisible(false);
				
			}
		});
		getContentPane().add(root_profile_btn);

		// 프레임 초기 위치 가운데
		setLocationRelativeTo(null);
		
		//프레임 사이즈 변경 안되게 고정
		setResizable(false); 
		
		setVisible(true);

	}

}
