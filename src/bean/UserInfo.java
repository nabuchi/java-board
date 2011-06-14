package bean;

import java.io.*;

public class UserInfo implements Serializable {
    private int id;
    private String name;
    private String password;
    private String secretQuestion;
    private String secretQuestionAnswer;

    public UserInfo() {}

    public UserInfo(
            String name,
            String password,
            String secretQuestion,
            String secretQuestionAnswer) {
        this.name = name;
        this.password = password;
        this.secretQuestion = secretQuestion;
        this.secretQuestionAnswer = secretQuestionAnswer;
        this.id = -1;
    }

    public UserInfo(
            int id,
            String name,
            String password,
            String securetQuestion,
            String secretQuestionAnswer) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.secretQuestion = secretQuestion;
        this.secretQuestionAnswer = secretQuestionAnswer;
    }


	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getSecretQuestion() { return secretQuestion; }
	public void setSecretQuestion(String secretQuestion) { this.secretQuestion = secretQuestion; }
	public String getSecretQuestionAnswer() { return secretQuestionAnswer; }
	public void setSecretQuestionAnswer(String secretQuestionAnswer) { this.secretQuestionAnswer = secretQuestionAnswer; }

    public boolean checkPassword(String password) {
        return password != null && password.equals(this.password);
    }
}
