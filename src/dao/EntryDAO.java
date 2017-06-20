package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.EntryBean;
import model.Subject;

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
		public ArrayList<EntryBean> getData(int id) {
			//▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
				ArrayList<EntryBean> list = new ArrayList<EntryBean>();
				try {
					// DB接続
					connection();
					// SQL文設定の準備・SQL文の実行
					String sql = "SELECT sub1.sub_id,sub2.sub_id AS sub_id2,sub1.sub_name,sub2.sub_name AS sub_name2 FROM app a LEFT OUTER JOIN subject sub1 ON a.sub_id = sub1.sub_id LEFT OUTER JOIN subject sub2 ON a.sub_id2 = sub2.sub_id WHERE a.s_id = ?";
					stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
					stmt.setInt(1, id);
					rs = stmt.executeQuery(); // sql文を実行
					while (rs.next()) {
						// 1つ分のデータをBeanに格納し、それをListに入れてjspに渡す
						// (Listには全員分のデータが入っている)
						EntryBean st = new EntryBean();
						//st.setS_id(rs.getInt("s_id"));
						st.setSub_name(rs.getString("sub_name"));
						st.setSub_name2(rs.getString("sub_name2"));
						st.setSub_id(rs.getString("sub_id"));
						st.setSub_id2(rs.getString("sub_id2"));

						list.add(st);
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

	/*	public ArrayList<EntryBean> getData() {
			//▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
				ArrayList<Subject> list = new ArrayList<Subject>();
				try {
					// DB接続
					connection();
					// SQL文設定の準備・SQL文の実行
					String sql = "SELECT * FROM subject";
					stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
					rs = stmt.executeQuery(); // sql文を実行
					while (rs.next()) {
						// 1つ分のデータをBeanに格納し、それをListに入れてjspに渡す
						// (Listには全員分のデータが入っている)
						Subject sj = new Subject();
						//st.setS_id(rs.getInt("s_id"));
						sj.setSub_id(rs.getInt("sub_id"));
						sj.setSub_name(rs.getString("sub_name"));
						sj.setSc_id(rs.getInt("sc_id"));

						list.add(sj);
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
				return list;*/

}
