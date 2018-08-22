package org.lanqiao.oqaf.domain;

import java.util.Objects;

/**
评论表
 */
public class Remarks {
    private int problemId;
    private int replayUserId;
    //评论者ID
    private int remarkNumId;
    //评论内容
    private String remarkContent;
    private String remarkDate;
    private String user_Name;
    public Remarks() {
    }

    public Remarks(int problemId, int replayUserId, int remarkNumId, String remarkContent, String remarkDate, String user_Name) {
        this.problemId = problemId;
        this.replayUserId = replayUserId;
        this.remarkNumId = remarkNumId;
        this.remarkContent = remarkContent;
        this.remarkDate = remarkDate;
        this.user_Name = user_Name;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getReplayUserId() {
        return replayUserId;
    }

    public void setReplayUserId(int replayUserId) {
        this.replayUserId = replayUserId;
    }

    public int getRemarkNumId() {
        return remarkNumId;
    }

    public void setRemarkNumId(int remarkNumId) {
        this.remarkNumId = remarkNumId;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public String getRemarkDate() {
        return remarkDate;
    }

    public void setRemarkDate(String remarkDate) {
        this.remarkDate = remarkDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remarks remarks = (Remarks) o;
        return problemId == remarks.problemId &&
                replayUserId == remarks.replayUserId &&
                remarkNumId == remarks.remarkNumId &&
                Objects.equals(remarkContent, remarks.remarkContent) &&
                Objects.equals(remarkDate, remarks.remarkDate) &&
                Objects.equals(user_Name, remarks.user_Name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, replayUserId, remarkNumId, remarkContent, remarkDate, user_Name);
    }

    @Override
    public String toString() {
        return "Remark{" +
                "problemId=" + problemId +
                ", replayUserId=" + replayUserId +
                ", remarkNumId=" + remarkNumId +
                ", remarkContent='" + remarkContent + '\'' +
                ", remarkDate='" + remarkDate + '\'' +
                ", user_Name='" + user_Name + '\'' +
                '}';
    }
}