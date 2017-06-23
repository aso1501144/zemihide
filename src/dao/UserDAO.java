package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.UserBean;

public class UserDAO {
	// データソース
	DataSource ds = null; // データベース接続情報
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	//▼▼データベース接続▼▼
	public Connection connection() throws Exception { // メッセージ出力のため
		// データソースがなければ、context.xmlから読み込んで設定する
		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = ds.getConnection();

		return con;
	}

	//▼▼データベース切断▼▼
	public void close() throws Exception {
		if(rs != null){
			rs.close();
		}
		// データベース接続されていれば、切断する
		if (con != null) {
			con.close();
		}
		if(stmt != null){
			stmt.close();
		}
	}
	public ArrayList<UserBean> getData() {
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM student";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			rs = stmt.executeQuery(); // sql文を実行
			while (rs.next()) {
				// 1つ分のデータをBeanに格納し、それをListに入れてjspに渡す
				// (Listには全員分のデータが入っている)
				UserBean st = new UserBean();
				st.setS_id(rs.getInt("s_id"));
				st.setS_name(rs.getString("s_name"));
				st.setPass(rs.getString("pass"));
				st.setC_id(rs.getInt("c_id"));
				list.add(st);
			}
		} catch (Exception e) {
			// 例外発生の場合は、例外メッセージを格納
//			CategoryBean st = new CategoryBean();
//			st.setMessage("例外発生：" + e.getStackTrace());
//			list.add(st);
		} finally {
			try {
				close();
			} catch (Exception e) {
//				// 例外発生の場合は、例外メッセージを格納
//				CategoryBean st = new CategoryBean();
//				st.setMessage("例外発生：" + e.getStackTrace());
//				list.add(st);
			}
		}
		// データが入ったlistをサーブレットに渡す
		return list;
	}

	//▼▼ログインユーザー確認▼▼
	public UserBean getData(int s_id,String pass) {

		//ログインユーザー情報を格納
		UserBean user = new UserBean();

		try{
			//DB接続
			connection();
			//SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM student WHERE s_id=? AND pass=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, s_id);
			stmt.setString(2, pass);
			//stmt.setInt(4, c_id);
			rs = stmt.executeQuery();

			//1件目のデータをカーソルに合わせる
			//データがない場合はcatchに飛ぶ
			rs.next();


			//DBから取得したデータをusオブジェクトに格納
			user.setS_id(rs.getInt("s_id"));
			user.setS_name(rs.getString("s_name"));
			user.setPass(rs.getString("pass"));
			user.setC_id(rs.getInt("c_id"));

		}catch (Exception e){
			//認証失敗
			user = null;
		}finally{
			try{
				close();
			} catch (Exception e){

			}
		}
		return user;
	}

	public String getLogin(int s_id,String pass) {

		//ログインユーザー情報を格納
		//UserBean user = new UserBean();
		String logins_id = null;
		try{
			//DB接続
			connection();
			//SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM student WHERE s_id=? AND pass=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, s_id);
			stmt.setString(2, pass);
			//stmt.setInt(4, c_id);
			rs = stmt.executeQuery();

			//1件目のデータをカーソルに合わせる
			//データがない場合はcatchに飛ぶ
			rs.next();
			logins_id = rs.getString("s_id");

		}catch (Exception e){
			//認証失敗
			//user = null;
		}finally{
			try{
				close();
			} catch (Exception e){

			}
		}
		return logins_id;
	}

	public Boolean subdel(String s_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
				String sql = "UPDATE app SET sub_id = null WHERE s_id = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, s_id);
				stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		return true;
	}

	public Boolean subdel2(String s_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
				String sql = "UPDATE app SET sub_id2 = null WHERE s_id = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, s_id);
				stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		return true;
	}
}
