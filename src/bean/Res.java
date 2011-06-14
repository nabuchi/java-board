package bean;

import java.io.*;

public class Res implements Serializable {
    private int id;
    private String author;
    private String content;
    private String time;
    private int userid;
    private int topicid;

    public Res() {}

    public Res(String author, String content, int topicid) {
        this.author = author;
        this.content = content;
        this.topicid = topicid;
        this.id = -1;
        this.userid = -1;
        this.time = null;
    }

    public Res(int id, String author, String content, String time, int userid, int topicid) {
        this.author = author;
        this.content = content;
        this.id = id;
        this.time = time;
        this.userid = userid;
        this.topicid = topicid;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getTime() { return time; }
    public void setTime() { this.time = time; }
    public int getUserid() { return userid; }
    public void setUserid() { this.userid = userid; }
    public int getTopicid() { return topicid; }
    public void setTopicid() { this.topicid = topicid; }
}
