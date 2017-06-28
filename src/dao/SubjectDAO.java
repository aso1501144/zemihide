package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Subject;
import model.UserBean;;

public class SubjectDAO {
	// データソース
	DataSource ds = null; // データベース接続情報
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	// ▼▼データベース接続▼▼
	public Connection connection() throws Exception { // メッセージ出力のため
		// データソースがなければ、context.xmlから読み込んで設定する
		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = ds.getConnection();

		return con;
	}

	// ▼▼データベース切断▼▼
	public void close() throws Exception {
		if (rs != null) {
			rs.close();
		}
		// データベース接続されていれば、切断する
		if (con != null) {
			con.close();
		}
		if (stmt != null) {
			stmt.close();
		}
	}

	public ArrayList<Subject> getData() {
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
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
				Subject st = new Subject();
				st.setSub_id(rs.getInt("sub_id"));
				st.setSub_name(rs.getString("sub_name"));
				st.setSc_id(rs.getInt("sc_id"));
				list.add(st);
			}
		} catch (Exception e) {
			// 例外発生の場合は、例外メッセージを格納

		} finally {
			try {
				close();
			} catch (Exception e) {
				// // 例外発生の場合は、例外メッセージを格納

			}
		}
		// データが入ったlistをサーブレットに渡す
		return list;
	}

	public String subname(String id) {
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		String name = null;
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM subject WHERE sub_id = ?";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setString(1, id);
			rs = stmt.executeQuery(); // sql文を実行

			rs.next();
			name = rs.getString("sub_name");
		} catch (Exception e) {
			// 例外発生の場合は、例外メッセージを格納

		} finally {
			try {
				close();
			} catch (Exception e) {
				// // 例外発生の場合は、例外メッセージを格納

			}
		}
		// データが入ったlistをサーブレットに渡す
		return name;
	}

	/*
	 * public void subentry(String s_id, String sub_id) { try { // DB接続
	 * connection(); // INSERT文の設定・実行 // INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
	 * String sql = "INSERT INTO app VALUES(?,?,null,29);"; stmt =
	 * con.prepareStatement(sql); stmt.setString(1, s_id); stmt.setString(2,
	 * sub_id); stmt.executeUpdate(); } catch (Exception e) { } finally { try {
	 * close(); } catch (Exception e) { } } }
	 */
	public void subentry(String s_id, String sub_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
			String sql = "UPDATE app SET sub_id = ? WHERE s_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sub_id);
			stmt.setString(2, s_id);
			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
	}

	public void subentry2(String s_id, String sub_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
			String sql = "UPDATE app SET sub_id2 = ? WHERE s_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sub_id);
			stmt.setString(2, s_id);
			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
	}

	public void subentrynull(String s_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
			String sql = "INSERT INTO app (s_id,year) VALUES(?,29)";
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
		// 全員分のデータが入ったlistをサーブレットに渡す
	}

	// 科目別申し込み学生リスト表示
	// 引数idは科目ID
	// 戻り値はユーザービーンにs_idとs_nameだけ入れて返す
	public ArrayList<UserBean> entrylist(String id) {
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT app.s_id,s_name FROM app LEFT OUTER JOIN student ON app.s_id = student.s_id WHERE sub_id = ? OR sub_id2 = ?";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setString(1, id);
			stmt.setString(2, id);
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

		} finally {
			try {
				close();
			} catch (Exception e) {
				// // 例外発生の場合は、例外メッセージを格納

			}
		}
		// データが入ったlistをサーブレットに渡す
		return list;
	}

	public ArrayList<Subject> genresearch(String genre) {
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		ArrayList<Subject> list = new ArrayList<Subject>();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT sub_id,sub_name FROM sc,subject WHERE sc.sc_id=subject.sc_id AND sc_name = ?";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setString(1, genre);
			rs = stmt.executeQuery(); // sql文を実行
			while (rs.next()) {
				// 1つ分のデータをBeanに格納し、それをListに入れてjspに渡す
				// (Listには全員分のデータが入っている)
				Subject st = new Subject();
				st.setSub_id(rs.getInt("sub_id"));
				st.setSub_name(rs.getString("sub_name"));
				//st.setSc_id(rs.getInt("sc_id"));
				list.add(st);
			}
		} catch (Exception e) {
			// 例外発生の場合は、例外メッセージを格納

		} finally {
			try {
				close();
			} catch (Exception e) {
				// // 例外発生の場合は、例外メッセージを格納

			}
		}
		// データが入ったlistをサーブレットに渡す
		return list;
	}

	public void insertSub(String subName, int genre) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
			String sql = "INSERT INTO subject VALUES(null,?,?)";
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, null);
			stmt.setString(1, subName);
			stmt.setInt(2, genre);
			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
	}

	public void updataSub(String subName, int genre, int sub_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
			String sql = "UPDATE subject SET sub_Name = ?,sc_id = ? WHERE sub_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subName);
			stmt.setInt(2, genre);
			stmt.setInt(3, sub_id);
			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
	}

	public void deleteSub(String sub_id) {
		try { // DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！
			String sql = "DELETE FROM subject WHERE sub_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sub_id);
			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
	}
}
