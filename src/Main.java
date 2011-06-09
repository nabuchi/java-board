import dao.ResDAO;
import dm.ConnectionManager;
import java.sql.*;
import bean.Res;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
        con = ConnectionManager.getConnection();
        ResDAO rdao = new ResDAO(con);
        Res res = new Res("著者", "コメント");
        System.out.println();
        rdao.insert(res);
        ArrayList<Res> rlist = rdao.selectAll();
        Iterator<Res> iter = rlist.iterator();
        while(iter.hasNext()) {
            res = iter.next();
            System.out.printf("%s %s %s %s\n",res.getId(), res.getTime(), res.getAuthor(), res.getContent());
        }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(con!=null) { con.close(); }
            }catch(Exception e){}
        }
    }
}
