package frame.main.profile;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.MonthDay;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import db.PostDAO;
import db.PostVO;
import db.UserDAO;
import frame.intro.LogInFrame;
import frame.main.RootFrame;

public class PostFix extends JPanel {
	private static PostVO postVo = new PostVO();
	public static File postFix_img_path;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.parser.entryPoint
	 */

	// 디자인에 사용하는 임시 main
//	public static void main(String[] args) {
//		PostFix hopn = new PostFix();
//		JFrame frame = new JFrame();
//		frame.setSize(600, 900);
//		frame.add(hopn);
//		frame.setLocationRelativeTo(null); // 프레임 가운데에서 띄우기
//		frame.setResizable(false); // 프레임 사이즈 변경 안되게 고정
//		frame.setVisible(true);
//	}

	public PostFix() {
		// 로그인 된 아이디 값 확인.
		String id_user = LogInFrame.userId;

		// setLayout과 setSize, setBounds에 따라 패널이 가운데 고정하는 크기에 영향이 생김.
		setLayout(null);
		setSize(500, 600);
		setBounds(100, 100, 400, 510);

		// 이미지를 파일로 불러오기 위한 버튼
		JButton postFix_mainPic_Label = new JButton();
		postFix_mainPic_Label.setBounds(56, 56, 254, 272);
		add(postFix_mainPic_Label);

		// 이미지 등록을 위한 버튼
		JTextArea postFix_hash_input = new JTextArea();
		postFix_hash_input.setBounds(79, 356, 244, 35);
		add(postFix_hash_input);
		// 이미지 수정을 위한 파일 버튼
		postFix_mainPic_Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser postFix_img_file = new JFileChooser();
				int img_file = postFix_img_file.showOpenDialog(postFix_mainPic_Label);
				if (img_file == JFileChooser.APPROVE_OPTION) {
					// 선택한 파일의 경로 반환
					postFix_img_path = postFix_img_file.getSelectedFile();
					// 경로 출력
					System.out.println(postFix_img_path);

					ImageIcon img = new ImageIcon(postFix_img_path.getPath());
					Image pic = img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
					Image picCh = pic.getScaledInstance(450, 500, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
					ImageIcon iconCh = new ImageIcon(picCh); // Image로 ImageIcon 생성

					postFix_mainPic_Label.setIcon(iconCh);
					add(postFix_mainPic_Label);
				}

			}
		});

		// 수정완료 버튼
		JButton postFix_btn = new JButton("수정완료");
		postFix_btn.setBounds(97, 420, 191, 44);
		add(postFix_btn);

		postFix_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// postFix 값 가져오기
					// 파일로 선택한 이미지 경로 img 변수에 저장.
					String img = postFix_img_path.getPath();
					String hash = postFix_hash_input.getText();
					PostDAO PostTb = new PostDAO();
					PostVO postSet = new PostVO();
					// userDAO의 id_user값 기준으로 임의값 입력
					postSet.setId_user(id_user);
					//오늘 날짜 계산 부품
					SimpleDateFormat sdf = new SimpleDateFormat("yy" +"."+"MM"+"."+"dd");
					Calendar c1 = Calendar.getInstance();
					String strToday = sdf.format(c1.getTime());
					postSet.setDate_post(strToday);
					postSet.setImg_post(img);
					postSet.setHash_post(hash);

					PostTb.PostFixUpdate(postSet);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				// 이전(Detail) 화면으로 이동
				RootFrame.postFixPn.setVisible(false);
				RootFrame.detailPn.setVisible(true);
			}
		});

		// 이미지 적용하기
		PostDAO postDao = new PostDAO();
		try {
			postVo = postDao.detailRead(id_user);
			postFix_mainPic_Label.setText(postVo.getDate_post());
			// DB에 저장되어 있는 이미지 경로 불러와서 사진 보여주기
			String imgPath = postVo.getImg_post();
			ImageIcon detail_img = new ImageIcon(imgPath);
			Image detail_pic = detail_img.getImage(); // ImageIcon을 Image로 변환.(객체를 돌려준다.)
			Image detail_picCh = detail_pic.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);// 이미지 사이즈 조정
			ImageIcon detail_iconCh = new ImageIcon(detail_picCh); // Image로 ImageIcon 생성

			postFix_mainPic_Label.setIcon(detail_iconCh);
			// 버튼에 이미지 적용
			add(postFix_mainPic_Label);

			postFix_hash_input.setText(postVo.getHash_post());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		setVisible(true);
	}
}
