package bean;

import java.io.*;

public class Thread implements Serializable {
    private int id;
    private String title;
    private String createdDate;
    private int userid;

    public Thread() {}

    public Thread(String title, int userid) {
        this.title = title;
        this.userid = userid;
        this.id = -1;
        this.userid = -1;
    }
    public Thread(int id, String title, String createdDate, int userid) {
        this.id = id;
        this.title = title;
        this.createdDate = createdDate;
        this.userid = userid;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate() { this.createdDate = createdDate; }
    public int getUserId() { return userid; }
    public void setUserId() { this.userid = userid; }
}
