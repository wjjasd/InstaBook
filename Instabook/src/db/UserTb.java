package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTb {

	final String url = "jdbc:mysql://localhost:3366/instabook";
	final String user = "java";
	final String password = "1234";
	private Connection con;

	public void setDb_user() throws SQLException {

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

	public boolean insert(String id, String pw, String nickName, String profileImg, String gender, String birth) {
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
		} catch (Exception e) {
			System.out.println("connection failed");
		}
		return result;
	}

}
