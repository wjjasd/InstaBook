package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDAO {
	//post하기 위한 메서드
	public void createTb(PostVO postSet) throws Exception {
		
		String id_user = postSet.getId_user();
		String date_post = postSet.getDate_post();
		String hash_post = postSet.getHash_post();
		String img_post = postSet.getImg_post();
		int like_post = postSet.getLike_post();
		
		
		System.out.println("DB에 저장 처리 함.");
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. post connector 설정 성공");
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. post post_insta연결 성공!!");
		String sql = "insert into post_insta values (null,?,?,?,?,?)";//어떤 값을 받을지 아직 모른다.
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id_user);
		ps.setString(2, date_post);
		ps.setString(3, hash_post);
		ps.setString(4, img_post);
		ps.setInt(5, like_post);
		System.out.println("3. post에 createTb로 SQL문 생성 성공!!");

		ps.executeUpdate();
		System.out.println("4. post에 createTb로 SQL문을 mySQL로 네트워크 전송 성공!!");
	}
	
	
	//데이터 가져오는 메서드    //String date_post, String hash_post, String img_post, int like_post
		public int readTb(String id_user) throws Exception {
			
				// 데이터베이스 Connection
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1. read connector 설정 성공");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instabook", "root", "1234");
				// select 쿼리
				System.out.println("연결 성공.");
				// 테이블 불러오기
				String sql = "select * from user_insta where id_user =?";
				System.out.println("3. read SQL문 생성 성공!!");
				// java statement 생성
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id_user);
				// 쿼리 execute , 객체형성
				ResultSet rs = ps.executeQuery();
				System.out.println("4. readTb sql문 전송 성공.!!");
				int result = 0;// 결과가 없음.
				if (rs.next() == true) {
					result = 1;// 결과가 있음.
					String idUser = rs.getString("id_user");
					String datePost = rs.getString("date_post");
					String hash = rs.getString("hash_post");
					String day = rs.getString("img_post");
					int like = rs.getInt("like_post");
					System.out.println("검색결과 id_user:" + idUser);
					System.out.println("검색결과 date_post:" + datePost);
					System.out.println("검색결과 hash_post:" + hash);
					System.out.println("검색결과 img_post:" + day);
					System.out.println("검색결과 like_post:" + like);
					
				}else {
					System.out.println("readTb 검색결과가 없어요.");
				}
				return result;
				// 0이 넘어가면, 검색결과가 없음.
				// 1이 넘어가면, 검색결과가 있음.

		}
		
	
	//PostFix에서 id기준으로 DB의 값 불러오는 메서드
	public PostVO detailRead(String id_user) throws Exception{
		// 1. connector설정
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1. connector 연결 성공.!!");

				String url = "jdbc:mysql://localhost:3306/instabook";
				String user = "java";
				String password = "1234";
				Connection con = DriverManager.getConnection(url, user, password);
				System.out.println("2. db 연결 성공.!!");

				String sql = "select * from post_insta where id_user = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id_user);
				System.out.println("3. sql 생성 성공.!!");

				ResultSet rs = ps.executeQuery();
				System.out.println("4. sql문 전송 성공.!!");
				PostVO bag = new PostVO();//3.묶음 값을 꺼내주기 위해 객체 생성.
				if (rs.next() == true) {
					System.out.println("detailRead 검색결과가 있어요.");
					//4.쿼리를 통해 DB에서 받은 값을   
					String date_post = rs.getString("date_post");
					String hash_post = rs.getString("hash_post");
					String img_post = rs.getString("img_post");
					int like_post = rs.getInt("like_post");
					//5. PostVO 클래스를 통해 가방에 넣기
					bag.setDate_post(date_post);
					bag.setHash_post(hash_post);
					bag.setImg_post(img_post);
					bag.setLike_post(like_post);
				} else {
					System.out.println("detailRead 검색결과가 없어요.");
				}
				//6.bag은 참조형 변수에 넣은 값, 주소를 전달!
				return bag;//7.detail에 전달.
	}
	
	public void PostFixUpdate(PostVO postSet) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공.!!");

		// 2. db연결 - ip, user name과 pw가 필요하다.
//				String url = "연결하는 방법://ip/port/db명";
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공.!!");

		// 3. sql문을 만둔다.
		String sql = "update post_insta set img_post = ?, hash_post = ?, date_post = ? where id_user = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, postSet.getImg_post());
		ps.setString(2, postSet.getHash_post());
		ps.setString(3, postSet.getDate_post());
		ps.setString(4, postSet.getId_user());
		System.out.println("3. sql 생성 성공.!!");

		// 4. sql문은 전송
		ps.executeUpdate();
		System.out.println("4.PostFixUpdate로 sql문 전송 성공.!!");
	}
	
	
}
