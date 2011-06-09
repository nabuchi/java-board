package bean;

import java.io.*;

public class Res implements Serializable {
    private int id;
    private String author;
    private String content;
    private String time;

    public Res() {}

    public Res(String author, String content) {
        this.author = author;
        this.content = content;
        this.id = -1;
        this.time = null;
    }

    public Res(int id, String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.id = id;
        this.time = time;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getTime() { return time; }
    public void setTime() { this.time = time; }
}
