package dao;

import java.sql.*;
import java.util.*;
import bean.Topic;

public class TopicDAO {
	private Connection con;

	public TopicDAO(Connection con) {
		this.con = con;
	}

    public Topic insert(Topic t) throws SQLException {
		String sql = "insert into topic (title, userid) values('"
                    + t.getTitle() + "',"
                    + t.getUserid() + ")";
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql);
		if (cnt != 0) {
			return t;
		} else {
			return null;
		}
    }

	public ArrayList<Topic> selectAll() throws SQLException {
		ArrayList<Topic> list = new ArrayList<Topic>();
		String sql = "select topic.id, title, created_date, name from topic,userinfo where topic.userid = userinfo.id";
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			Topic r = new Topic(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			list.add(r);
		}
		return list;
	}
    public ArrayList<Integer> selectAllId() throws SQLException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select id from topic";
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
            Integer i = rset.getInt(1);
            list.add(i);
        }
        return list;
    }
}
