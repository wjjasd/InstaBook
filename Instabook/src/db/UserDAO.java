package db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//test
public class UserDAO {

	private final static String url = "jdbc:mysql://localhost:3306/instabook";
	private final static String user = "java";
	private final static String password = "1234";
	private static Connection con;

	//DB커넥터 초기화
	private static void setDb_user() throws SQLException {

		// 1. connector 설정
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. connector 설정 성공");
			// 2. db연결
			// 1)ip+port+db명
			// 2)username : root
			// 3)password : 1234
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. instabook 연결성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 네트워크 연결 파일연결 cpu연결 등 에러 발생이 다분한 상황에서는 반드시 에러처리 해야함.

	}

	//회원가입
	public static boolean signUp(UserVO userDataSet) {
		boolean result = false;
		
		String id = userDataSet.getId_user();			//회원아이디
		String pw = userDataSet.getPw_user();			//패스워드
		String nickName = userDataSet.getId_user();		//닉네임
		String gender = userDataSet.getGender_user();	//성별
		String birth = userDataSet.getBirth_user();		//출생일

		try {
			setDb_user();
			// 3. sql문
			String sql = "insert into user_insta values (?,?,?,null,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// 인덱스 1부터시작!!!!
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nickName);
			ps.setString(4, gender);
			ps.setString(5, birth);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ps.executeLargeUpdate();
			System.out.println("4. 네트워크로 전송 성공!");
			result = true;

			con.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("connection failed");
		}
		return result;
	}

	//로그인
	public static String logIn(String id) {
		String pw = "";

		try {

			setDb_user();
			// 3. sql문
			String sql = "select pw_user from user_insta where id_user = " + "\'" + id + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			while (rs.next()) {
				pw = rs.getString("pw_user");
				System.out.println("PW 검색중...");
			}

			con.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("connection failed");
		}

		return pw;

	}

	//프로필 사진 업데이트
	public static boolean updateProfile(String userId, String filePath) {
		boolean result = false;
		try {

			setDb_user();
			System.out.println("프로필 이미지 갱신중...");
			filePath = filePath.replaceAll("\\\\", "\\\\\\\\");
			System.out.println("파일경로 역슬래쉬 처리 : " + filePath);
			String sql = "update user_insta set img_user = \'" + filePath + "\' where id_user = \'" + userId + "\';";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ps.executeLargeUpdate();
			System.out.println("4. 네트워크로 전송 성공!");
			result = true;

			con.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	//프로필 사진 로드
	public static String getProfile(String userId) {
		String url = "";
		try {

			setDb_user();
			System.out.println("프로필 이미지 갱신중...");
			String sql = "select img_user from user_insta where id_user = " + "\'" + userId + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			while (rs.next()) {
				url = rs.getString("img_user");
				System.out.println("img 검색중...");

			}

			con.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	//아이디 확인
	public static boolean idcheck(String userId) {

		String dbId = "";
		boolean result = false;

		try {

			setDb_user();
			// 3. sql문
			String sql = "select id_user from user_insta where id_user = " + "\'" + userId + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			while (rs.next()) {
				dbId = rs.getString("id_user");
				System.out.println("ID 검색중...");

			}

			con.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("connection failed");
			result = false;
		}

		if (dbId != "") {
			result = true;
			System.out.println("ID 유효");
		}

		return result;

	}
	
	//성별 가져오기
	public static String getGender(String userId) {
		String gender = null;
		
		try {

			setDb_user();
			System.out.println("gender 가져오는중...");
			String sql = "select gender_user from user_insta where id_user = " + "\'" + userId + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			int size = 0;
			while (rs.next()) {
				gender = rs.getString("gender_user");
				System.out.println("gender 검색중...");
				size++;
			}
			
			if(size > 0) {
				System.out.println("사용자 성별 : " + gender);
			}else {
				gender = null;
			}

			con.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return gender;
	}
	
	//출생일 가져오기
	public static String getBirth(String userId) {
		String birth = null;
		
		try {

			setDb_user();
			System.out.println("birth 가져오는중...");
			String sql = "select birth_user from user_insta where id_user = " + "\'" + userId + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			int size = 0;
			while (rs.next()) {
				birth = rs.getString("birth_user");
				System.out.println("birth 검색중...");
				size++;
			}
			
			if(size > 0) {
				System.out.println("사용자 출생일 : " + birth);
			}else {
				birth = null;
			}

			con.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return birth;
	}
	
	//닉네임 가져오기
	public static String getNickname(String userId) {
		String nickname = null;
		
		try {

			setDb_user();
			System.out.println("nickname 가져오는중...");
			String sql = "select nickname_user from user_insta where id_user = " + "\'" + userId + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			int size = 0;
			while (rs.next()) {
				nickname = rs.getString("nickname_user");
				System.out.println("nickname 검색중...");
				size++;
			}
			
			if(size > 0) {
				System.out.println("사용자 별명 : " + nickname);
			}else {
				nickname = null;
			}

			con.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nickname;
	}
	
	//회원정보 수정
	public static boolean updateUserInfo(UserVO userDataSet) {
		boolean result = false;
		
		//수정가능 항목: 패스워드, 닉네임, 성별, 출생일
		String id = userDataSet.getId_user();
		String pw = userDataSet.getPw_user();
		String nickName = userDataSet.getId_user();
		String gender = userDataSet.getGender_user();
		String birth = userDataSet.getBirth_user();

		try {
			setDb_user();
			// 3. sql문
			String sql = "update user_insta set "
					+ "pw_user = '"+pw+"', "
					+ "nickname_user = '"+nickName+"', "
					+ "gender_user = '"+gender+"', "
					+ "birth_user = '"+birth+"' "
					+ "where id_user = '"+id+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			// 인덱스 1부터시작!!!!
			
			System.out.println("3. sql문 생성 성공!");

			// 4.sql문 실행
			ps.executeLargeUpdate();
			System.out.println("4. 네트워크로 전송 성공!");
			result = true;

			con.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("회원정보 수정실패");
			System.out.println(e.toString());
		}
		return result;
	}

}
