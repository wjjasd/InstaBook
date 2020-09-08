package frame.main;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import db.PostDAO;
import db.PostVO;
import frame.main.profile.Detail;
import frame.main.profile.PostFix;

public class PostPanel extends JPanel {
	
	public static HomePanel homePn = new HomePanel();
	public static PostPanel postPn = new PostPanel();
	public static File post_img_path;
	
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

		JButton post_mainPic_btn = new JButton("이미지 추가");
		post_mainPic_btn.setBounds(68, 45, 260, 238);
		// 버튼 테두리 없애기
//		post_mainPic_btn.setBorderPainted(false);
		// 버튼 글자 테두리 없애기
		post_mainPic_btn.setFocusPainted(false);
		// 버튼 배경색 없애기
		post_mainPic_btn.setContentAreaFilled(false);
		add(post_mainPic_btn);
		
		post_mainPic_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser post_img_file = new JFileChooser();
				int img_file = post_img_file.showOpenDialog(post_mainPic_btn);
				if (img_file == JFileChooser.APPROVE_OPTION) { 
					//선택한 파일의 경로 반환 
					post_img_path = post_img_file.getSelectedFile();
					//경로 출력 
					System.out.println(post_img_path);
					
					ImageIcon img = new ImageIcon(post_img_path.getPath());
					Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
					Image picCh = pic.getScaledInstance(450, 500, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
					ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성
					
					post_mainPic_btn.setIcon(iconCh);
					add(post_mainPic_btn);
				}

			}
		});

		JTextArea post_hash_input = new JTextArea();
		post_hash_input.setBounds(68, 309, 260, 42);
		add(post_hash_input);

		JButton post_put_btn = new JButton("입력완료");
		post_put_btn.setBounds(123, 403, 142, 52);
		add(post_put_btn);
		
		
		post_put_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//게시물 값 가져오기
				PostDAO PostTb = new PostDAO();
				//파일로 선택한 이미지 경로 img 변수에 저장.
				String img = post_img_path.getPath();
				String hash = post_hash_input.getText();
				try {
					//값이 들어가는 것을 확인하기 user_Tb의 id_user값 기준으로 임의값 입력
					
					PostVO postSet = new PostVO();
					postSet.setId_user("d");
					postSet.setDate_post("20.09.02");
					postSet.setHash_post(hash);
					postSet.setImg_post(img);
					postSet.setLike_post2(0);
					
					PostTb.createTb(postSet);
					
					
//					PostTb.createTb("d", "20.09.02", hash, img, 0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				postPn.revalidate();
				postPn.repaint();
				RootFrame.postPn.setVisible(false);
				RootFrame.homePn.setVisible(true);
			}
		});
		setVisible(true);

	}
}
