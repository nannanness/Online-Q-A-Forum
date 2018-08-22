package org.lanqiao.oqaf.domain;

import java.util.Date;
import java.util.Objects;

/**
 * 问题表
 */
public class Problem {
    private int problemId;
    private int problemUserId;
    private String title;
    private String content;
    private String problemType;
    private String problemDate;

    public Problem() {
    }

    public Problem(int problemUserId,int problemId, String title, String content, String problemType, String problemDate) {
        this.problemUserId = problemUserId;
        this.problemId = problemId;
        this.title = title;
        this.content = content;
        this.problemType = problemType;
        this.problemDate = problemDate;
    }

    public Problem(int problemUserId,String title, String content, String problemType, String problemDate) {
        this.problemUserId = problemUserId;
        this.title = title;
        this.content = content;
        this.problemType = problemType;
        this.problemDate = problemDate;
    }
    public int getProblemUserId(){return problemUserId;}
    public void setProblemUserId(int problemUserId){this.problemUserId = problemUserId;};
    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
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

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
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
        Problem problem = (Problem) o;
        return problemId == problem.problemId &&
                Objects.equals(title, problem.title) &&
                Objects.equals(content, problem.content) &&
                Objects.equals(problemType, problem.problemType) &&
                Objects.equals(problemDate, problem.problemDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, title, content, problemType, problemDate);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemUserId="+problemUserId+
                "problemId=" + problemId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", problemType='" + problemType + '\'' +
                ", problemDate=" + problemDate +
                '}';
    }
}
