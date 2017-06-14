package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.EntryBean;

public class EntryDAO {
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
		public ArrayList<EntryBean> getData(String id) {
			//▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
				ArrayList<EntryBean> list = new ArrayList<EntryBean>();
				try {
					// DB接続
					connection();
					// SQL文設定の準備・SQL文の実行
					String sql = "SELECT * FROM student これ以上わかりません";
					stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
					rs = stmt.executeQuery(); // sql文を実行
					while (rs.next()) {
						// 1つ分のデータをBeanに格納し、それをListに入れてjspに渡す
						// (Listには全員分のデータが入っている)
						EntryBean st = new EntryBean();
						st.setSub_id(rs.getInt("sub_id"));
						st.setSub_name(rs.getString("sub_name"));
						st.setSc_id(rs.getInt("sc_id"));

						list.add(st);
						//kikik
					}
				} catch (Exception e) {
					// 例外発生の場合は、例外メッセージを格納
//					CategoryBean st = new CategoryBean();
//					st.setMessage("例外発生：" + e.getStackTrace());
//					list.add(st);
				} finally {
					try {
						close();
					} catch (Exception e) {
//						// 例外発生の場合は、例外メッセージを格納
//						CategoryBean st = new CategoryBean();
//						st.setMessage("例外発生：" + e.getStackTrace());
//						list.add(st);
					}
				}
				// データが入ったlistをサーブレットに渡す
				return list;
			}
}
