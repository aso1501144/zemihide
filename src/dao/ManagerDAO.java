package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Manager;
import model.UserBean;

public class ManagerDAO {

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

		/*public String getLogin(int m_id,String pass) {

			//ログインユーザー情報を格納
			String loginm_id = null;
			try{
				//DB接続
				connection();
				//SQL文設定の準備・SQL文の実行
				String sql = "SELECT * FROM manager WHERE m_id=? AND pass=?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, m_id);
				stmt.setString(2, pass);
				//stmt.setInt(4, c_id);
				rs = stmt.executeQuery();

				//1件目のデータをカーソルに合わせる
				//データがない場合はcatchに飛ぶ
				rs.next();
				loginm_id = rs.getString("s_id");

			}catch (Exception e){
				//認証失敗
				//user = null;
			}finally{
				try{
					close();
				} catch (Exception e){

				}
			}
			return loginm_id;
		}*/

	public String getLogin(int m_id, String pass) {
		// TODO 自動生成されたメソッド・スタブ
		//ログインユーザー情報を格納
		String loginm_id = null;
		try{
			//DB接続
			connection();
			//SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM manager WHERE m_id=? AND pass=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, m_id);
			stmt.setString(2, pass);
			//stmt.setInt(4, c_id);
			rs = stmt.executeQuery();

			//1件目のデータをカーソルに合わせる
			//データがない場合はcatchに飛ぶ
			rs.next();
			loginm_id = rs.getString("s_id");

		}catch (Exception e){
			//認証失敗
			//user = null;
		}finally{
			try{
				close();
			} catch (Exception e){

			}
		}
		return loginm_id;
	}
}

