package db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//test
public class UserTb {

	private final static String url = "jdbc:mysql://localhost:3306/instabook";
	private final static String user = "java";
	private final static String password = "1234";
	private static Connection con;

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

	public static boolean signUp(String id, String pw, String nickName, String profileImg, String gender,
			String birth) {
		boolean result = false;

		try {
			setDb_user();
			// 3. sql문
			String sql = "insert into user_insta values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// 인덱스 1부터시작!!!!
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, nickName);
			ps.setString(4, profileImg);
			ps.setString(5, gender);
			ps.setString(6, birth);

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
				System.out.println("결과검색중...");
			}

			con.close();
			ps.close();

		} catch (Exception e) {
			System.out.println("connection failed");
		}

		return pw;

	}

	public static boolean updateProfile(String userId, String filePath) {
		boolean result = false;
		try {

			setDb_user();
			String sql = "update user_insta set img_user = \'" + filePath + "\' where id_user = \'" + userId + "\';";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");
			System.out.println("프로필 이미지 갱신중...");

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

	public static String getProfile(String userId) {
		String url = "";
		try {

			setDb_user();
			String sql = "select img_user from user_insta where id_user = " + "\'" + userId + "\'";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("3. sql문 생성 성공!");
			System.out.println("프로필 이미지 갱신중...");

			// 4.sql문 실행
			ResultSet rs = ps.executeQuery();
			System.out.println("4. 네트워크로 전송 성공!");

			while (rs.next()) {
				url = rs.getString("img_user");
				System.out.println("프로필 이미지 얻어오는중...");
			}

			con.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	public static boolean idcheck(String id) {

		String dbId = "";
		boolean result = false;

		try {

			setDb_user();
			// 3. sql문
			String sql = "select id_user from user_insta where id_user = " + "\'" + id + "\'";
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
		}

		return result;

	}

}
