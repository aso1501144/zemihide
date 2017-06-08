package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.naming.InitialContext;

import com.mysql.jdbc.Connection;

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

		//▼▼データ登録▼▼
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
					list.add(st);
				}
			} catch (Exception e) {
				// 例外発生の場合は、例外メッセージを格納
//				CategoryBean st = new CategoryBean();
//				st.setMessage("例外発生：" + e.getStackTrace());
//				list.add(st);
			} finally {
				try {
					close();
				} catch (Exception e) {
//					// 例外発生の場合は、例外メッセージを格納
//					CategoryBean st = new CategoryBean();
//					st.setMessage("例外発生：" + e.getStackTrace());
//					list.add(st);
				}
			}
			// データが入ったlistをサーブレットに渡す
			return list;
		}

		//▼▼ログインユーザー確認▼▼
		public UserBean getMember(int userid, String password) {

			//ログインユーザー情報を格納
			UserBean member = new UserBean();

			try{
				//DB接続
				connection();
				//SQL文設定の準備・SQL文の実行
				String sql = "SELECT * FROM hide_user WHERE userid=? AND password=?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, userid);
				stmt.setString(2, password);
				rs = stmt.executeQuery();

				//1件目のデータをカーソルに合わせる
				//データがない場合はcatchに飛ぶ
				rs.next();


				//DBから取得したデータをusオブジェクトに格納
				member.setUserid(rs.getInt("userid"));
				member.setPassword(rs.getString("password"));

			}catch (Exception e){
				//認証失敗
				member = null;
			}finally{
				try{
					close();
				} catch (Exception e){

				}
			}
			return member;
		}
}


