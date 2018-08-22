package org.lanqiao.oqaf.domain;

import java.util.Objects;

public class UserQuestion {
    private int problemId;
    private int problemUserId;
    private String title;
    private String content;
    private String problemDate;

    public UserQuestion() {
    }

    public UserQuestion(int problemId, int problemUserId, String title, String content, String problemDate) {
        this.problemId = problemId;
        this.problemUserId = problemUserId;
        this.title = title;
        this.content = content;
        this.problemDate = problemDate;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getProblemUserId() {
        return problemUserId;
    }

    public void setProblemUserId(int problemUserId) {
        this.problemUserId = problemUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProblemDate() {
        return problemDate;
    }

    public void setProblemDate(String problemDate) {
        this.problemDate = problemDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserQuestion that = (UserQuestion) o;
        return problemId == that.problemId &&
                problemUserId == that.problemUserId &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(problemDate, that.problemDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, problemUserId, title, content, problemDate);
    }

    @Override
    public String toString() {
        return "UserQuestion{" +
                "problemId=" + problemId +
                ", problemUserId=" + problemUserId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", problemDate='" + problemDate + '\'' +
                '}';
    }
}
