import java.sql.*;
import java.util.*;
import dao.*;
import bean.*;
public class MCTopic {
    private Topic topic;
    private ArrayList<Res> reslist;

    MCTopic(Topic topic, ArrayList<Res> reslist) {
        this.topic = topic;
        this.reslist = reslist;
    }
    int getId() {
        return this.topic.getId();
    }
    String getTitle() {
        return this.topic.getTitle();
    }
    String getCreatedDate() {
        return this.topic.getCreatedDate();
    }
    ArrayList<Res> getResList() {
        return this.reslist;
    }
}
