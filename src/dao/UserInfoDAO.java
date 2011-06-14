package dao;

import java.sql.*;
import java.util.*;
import bean.UserInfo;

public class UserInfoDAO {
	private Connection con;

	public UserInfoDAO(Connection con) {
		this.con = con;
	}

    public UserInfo insert(UserInfo u) throws SQLException {
		String sql = "insert into userinfo ("
                        + "name, password, birthday ) values('"
                    + u.getName() + "','"
                    + u.getPassword() + "','"
                    + u.getBirthday() + "')";
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql);
		if (cnt != 0) {
			return u;
		} else {
			return null;
		}
    }

	public ArrayList<UserInfo> selectAll() throws SQLException {
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		String sql = "select id, name, password, birthday from userinfo";
        Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			UserInfo u = new UserInfo(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			list.add(u);
		}
		return list;
	}

    public UserInfo selectByNamePass(String userId, String passwd) throws SQLException {
        UserInfo user = null;
        String sql = "select name, password, birthday from userinfo where name = ? and password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,userId);
        ps.setString(2,passwd);
        ResultSet rset = ps.executeQuery();
        if( rset.next() ) {
            user = new UserInfo(rset.getString(1), rset.getString(2), rset.getString(3) );
        } else {
            user = null;
        }
        return user;
    }

}
