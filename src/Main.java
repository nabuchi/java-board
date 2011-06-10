import dm.ConnectionManager;
import java.sql.*;
import bean.*;
import dao.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            //ResDAOテスト
            ResDAO rdao = new ResDAO(con);
            Res res = new Res("著者", "コメント");
            rdao.insert(res);
            ArrayList<Res> rlist = rdao.selectAll();
            Iterator<Res> iter = rlist.iterator();
            while(iter.hasNext()) {
                res = iter.next();
                System.out.printf("%s %s %s %s\n",res.getId(), res.getTime(), res.getAuthor(), res.getContent());
            }

            //TopicDAOテスト
            TopicDAO tdao = new TopicDAO(con);
            Topic topic = new Topic("たいとる", 1);
            tdao.insert(topic);
            ArrayList<Topic> tlist = tdao.selectAll();
            Iterator<Topic> iter2 = tlist.iterator();
            while(iter2.hasNext()) {
                topic = iter2.next();
                System.out.printf("%s %s %s %s\n",topic.getId(), topic.getTitle(), topic.getCreatedDate(), topic.getUserid());
            }

            //UserInfoDAOテスト
            UserInfoDAO udao = new UserInfoDAO(con);
            UserInfo user = new UserInfo("a"+Math.random(), "パスワード", "秘密の質問", "秘密の質問答え");
            udao.insert(user);
            ArrayList<UserInfo> ulist = udao.selectAll();
            Iterator<UserInfo> iter3 = ulist.iterator();
            while(iter3.hasNext()) {
                user = iter3.next();
                System.out.printf("%s %s %s %s\n",user.getId(), user.getName(), user.getSecretQuestion(), user.getSecretQuestionAnswer());
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
