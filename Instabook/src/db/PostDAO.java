package db;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PostDAO {
	// post하기 위한 메서드
	public void createTb(PostVO postSet) throws Exception {

		String id_user = postSet.getId_user();
		String date_post = postSet.getDate_post();
		String hash_post = postSet.getHash_post();
		String img_post = postSet.getImg_post();
		int like_post = postSet.getLike_post();

//		System.out.println("DB에 저장 처리 함.");
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. post connector 설정 성공");
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("2. post post_insta연결 성공!!");
		String sql = "insert into post_insta values (null,?,?,?,?,?)";// 어떤 값을 받을지 아직 모른다.
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id_user);
		ps.setString(2, date_post);
		ps.setString(3, hash_post);
		ps.setString(4, img_post);
		ps.setInt(5, like_post);
//		System.out.println("3. post에 createTb로 SQL문 생성 성공!!");

		ps.executeUpdate();
//		System.out.println("4. post에 createTb로 SQL문을 mySQL로 네트워크 전송 성공!!");
	}

	// 데이터 가져오는 메서드 //String date_post, String hash_post, String img_post, int
	// like_post
	public int readTb(String id_user) throws Exception {

		// 데이터베이스 Connection
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. read connector 설정 성공");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instabook", "java", "1234");
		// select 쿼리
//		System.out.println("연결 성공.");
		// 테이블 불러오기
		String sql = "select * from user_insta where id_user =?";
//		System.out.println("3. read SQL문 생성 성공!!");
		// java statement 생성
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id_user);
		// 쿼리 execute , 객체형성
		ResultSet rs = ps.executeQuery();
//		System.out.println("4. readTb sql문 전송 성공.!!");
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

		} else {
			System.out.println("readTb 검색결과가 없어요.");
		}
		return result;
		// 0이 넘어가면, 검색결과가 없음.
		// 1이 넘어가면, 검색결과가 있음.

	}

	// PostFix에서 id기준으로 DB의 값 불러오는 메서드
	public PostVO detailRead(String id_user) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. connector 연결 성공.!!");

		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("2. db 연결 성공.!!");

		String sql = "select * from post_insta where id_user = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id_user);
//		System.out.println("3. sql 생성 성공.!!");

		ResultSet rs = ps.executeQuery();
//		System.out.println("4. sql문 전송 성공.!!");
		PostVO bag = new PostVO();// 3.묶음 값을 꺼내주기 위해 객체 생성.
		if (rs.next() == true) {
//			System.out.println("detailRead 검색결과가 있어요.");
			// 4.쿼리를 통해 DB에서 받은 값을
			String date_post = rs.getString("date_post");
			String hash_post = rs.getString("hash_post");
			String img_post = rs.getString("img_post");
			int like_post = rs.getInt("like_post");
			// 5. PostVO 클래스를 통해 가방에 넣기
			bag.setDate_post(date_post);
			bag.setHash_post(hash_post);
			bag.setImg_post(img_post);
			bag.setLike_post(like_post);
		} else {
			System.out.println("detailRead 검색결과가 없어요.");
		}
		// 6.bag은 참조형 변수에 넣은 값, 주소를 전달!
		return bag;// 7.detail에 전달.
	}

	public PostVO lookRead(String homeImg) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. lookRead connector 연결 성공.!!");

		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("2. db 연결 성공.!!");

		String sql = "select * from post_insta where img_post = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, homeImg);
//		System.out.println("3. lookRead sql 생성 성공.!!");

		ResultSet rs = ps.executeQuery();
//		System.out.println("4. lookRead sql문 전송 성공.!!");
		PostVO bag = new PostVO();// 3.묶음 값을 꺼내주기 위해 객체 생성.
		if (rs.next() == true) {
			System.out.println("lookRead 검색결과가 있어요.");
			// 4.쿼리를 통해 DB에서 받은 값을
			String date_post = rs.getString("date_post");
			String hash_post = rs.getString("hash_post");
			String img_post = rs.getString("img_post");
			int like_post = rs.getInt("like_post");
			// 5. PostVO 클래스를 통해 가방에 넣기
			bag.setDate_post(date_post);
			bag.setHash_post(hash_post);
			bag.setImg_post(img_post);
			bag.setLike_post(like_post);
		} else {
			System.out.println("lookRead 검색결과가 없어요.");
		}
		// 6.bag은 참조형 변수에 넣은 값, 주소를 전달!
		return bag;// 7.detail에 전달.
	}

	public void PostFixUpdate(PostVO postSet) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. connector 연결 성공.!!");

		// 2. db연결 - ip, user name과 pw가 필요하다.
//				String url = "연결하는 방법://ip/port/db명";
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("2. db 연결 성공.!!");

		// 3. sql문을 만둔다.
		String sql = "update post_insta set img_post = ?, hash_post = ?, date_post = ? where id_user = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, postSet.getImg_post());
		ps.setString(2, postSet.getHash_post());
		ps.setString(3, postSet.getDate_post());
		ps.setString(4, postSet.getId_user());
//		System.out.println("3. sql 생성 성공.!!");

		// 4. sql문은 전송
		ps.executeUpdate();
//		System.out.println("4.PostFixUpdate로 sql문 전송 성공.!!");
	}

	// 모든 게시물의 해쉬 파일 저장
	public void allHash() throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨!
		// <>안에는 컨테이너에 무엇을 넣을지 지정! 꺾세는 형변환 필요없이 넣고 꺼낼 수 있다.
		ArrayList<PostVO> list = new ArrayList<PostVO>();
//      DB프로그램 절차에 맞추어서 코딩
//      1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
//           String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("2. db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select * from post_insta";
		// PreparedStatement: 데이터베이스에 매개변수화된 SQL 문을 전송하기 위한 PreparedStatement 객체 생성
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// ResultSet: 데이터베이스의 데이터 집합을 나타내는 데이터 표로, 데이터베이스에 쿼리문을 실행하여 생성된다.
		// 복수의 데이터를 가져올때 사용
		ResultSet rs = ps.executeQuery();
//		System.out.println("4. SQL문 전송 성공.!!");
		while (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			// 가방을 여러개 만들어야 해서 while문 안에 넣는다.
			PostVO bag = new PostVO();// 가방만들어서,
			System.out.println("#해쉬태그 검색결과가 있어요.");
			String date_post = rs.getString("date_post");
			String hash_post = rs.getString("hash_post");
			bag.setDate_post(date_post);
			bag.setHash_post(hash_post);
			// 컨테이너에 넣는다.
			list.add(bag);
		} // while

		for (int i = 0; i < list.size(); i++) {
			// 컨테이너역할인 list에서 하나씩 꺼내는 부분
			PostVO hash = list.get(i);
			// 파일로 저장할 예정 ->
			try {
				// 파일을 만들어서 저장하는 부품써야함.
				FileWriter w = new FileWriter(hash.date_post + ".txt");// 저장될 파일의 이름
				w.write(hash.date_post + "\n");
				w.write(hash.hash_post + "\n");
				w.close();// 파일에다가 다 썼음.
				System.out.println("#해쉬태그 파일 저장 완료");
				// 파일을 닫아 주어야 내용이 저장된다.
			} catch (Exception e) {
				// try내에 있는 코드에서 에러가 발생했을 때, 대응처리 내용을 써줌.
				System.out.println("파일로 저장하다가 에러가 발생함!~");
			}
		} // for
	}

	public ArrayList<PostVO> all() throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨!
		// <>안에는 컨테이너에 무엇을 넣을지 지정! 꺾세는 형변환 필요없이 넣고 꺼낼 수 있다.
		ArrayList<PostVO> list = new ArrayList<PostVO>();
//      DB프로그램 절차에 맞추어서 코딩
//      1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1. 홈 이미지 connector연결 성공.!!");

		// 2. db연결
//           String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println("2. 홈 이미지 db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select * from post_insta";
		// PreparedStatement: 데이터베이스에 매개변수화된 SQL 문을 전송하기 위한 PreparedStatement 객체 생성
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// ResultSet: 데이터베이스의 데이터 집합을 나타내는 데이터 표로, 데이터베이스에 쿼리문을 실행하여 생성된다.
		// 복수의 데이터를 가져올때 사용
		ResultSet rs = ps.executeQuery();
		System.out.println("4. 홈 이미지 SQL문 전송 성공.!!");
		while (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			// 가방을 여러개 만들어야 해서 while문 안에 넣는다.
			PostVO bag = new PostVO();// 가방만들어서,
			String img_post = rs.getString("img_post");
			bag.setImg_post(img_post);
			// 컨테이너에 넣는다.
			list.add(bag);
		} // while
		return list;
		// bag은 참조형 변수, 주소를 전달!
	}

	// db에서 삭제 처리 전담 메서드
	public void detailDelete(String id_user) throws Exception {
		// 디비 사용을 위해 driver class를 불러온다.
		// swing --- connector설정(driver) ---- mySQL
		Class.forName("com.mysql.jdbc.Driver");
		// 연결 확인용 출력
//			System.out.println("1. delete connector 연결 성공.!!");
		// db연결
		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		// 연결 확인용 출력
//			System.out.println("2.delete db 연결 성공.!!");
		// db에 있는 데이터를 삭제하기 위한 sql 명령문
		String sql = "delete from post_insta where id_user = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		// UI에서 받은 파라미터값을 받기 위한 설정.
		ps.setString(1, id_user);
		// sql생성 확인용 출력
//			System.out.println("3. delete sql 생성 성공.!!");
		// sql문 전송
		ps.executeUpdate();
		// sql문 전송 확인용 출력
//			System.out.println("4. delete sql문 전송 성공.!!");

	}

	// 해쉬태그 전용 검색 메서드
	public PostVO searchHash(String hashTag) throws Exception {
		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.searchHash connector 연결 성공.!!");

		String url = "jdbc:mysql://localhost:3306/instabook";
		String user = "java";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.searchHash db 연결 성공.!!");

		String sql = "select * from post_insta where hash_post =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, hashTag);
		System.out.println("3.searchHash sql 생성 성공.!!");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. sql문 전송 성공.!!");
		PostVO bag = new PostVO();// 3.묶음 값을 꺼내주기 위해 객체 생성.
		if (rs.next() == true) {
			System.out.println("searchHash 검색결과가 있어요.");
			// 4.쿼리를 통해 DB에서 받은 값을
			String img_post = rs.getString("img_post");
			// 5. MemberVO 클래스를 통해 가방에 넣기
			bag.setImg_post(img_post);
		} else {
			System.out.println("searchHash 검색결과가 없어요.");
		}
		// 6.bag은 참조형 변수에 넣은 값, 주소를 전달!
		return bag;// 7.회원CURDUI에 전달.

	}

	// home 버튼에 등록된 이미지값 String으로 돌려주는 메서드
	public String userPost(String homeImg) {
		return homeImg;
	}

}// class