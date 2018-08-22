package org.lanqiao.oqaf.domain;

import java.util.Objects;
/**
 评论表
 */
public class Remark {
    private int problemId;
    private int replayUserId;
    //评论数量
    private int remarkNumId;
    //评论内容
    private String remarkContent;
    //    评论时间
    private String remarkDate;

    public Remark() {
    }

    public Remark(int problemId, int replayUserId, int remarkNumId, String remarkContent, String remarkDate) {
        this.problemId = problemId;
        this.replayUserId = replayUserId;
        this.remarkNumId = remarkNumId;
        this.remarkContent = remarkContent;
        this.remarkDate = remarkDate;
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
        Remark remark = (Remark) o;
        return problemId == remark.problemId &&
                replayUserId == remark.replayUserId &&
                remarkNumId == remark.remarkNumId &&
                Objects.equals(remarkContent, remark.remarkContent) &&
                Objects.equals(remarkDate, remark.remarkDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, replayUserId, remarkNumId, remarkContent, remarkDate);
    }

    @Override
    public String toString() {
        return "Remark{" +
                "problemId=" + problemId +
                ", replayUserId=" + replayUserId +
                ", remarkNumId=" + remarkNumId +
                ", remarkContent='" + remarkContent + '\'' +
                ", remarkDate='" + remarkDate + '\'' +
                '}';
    }
}
