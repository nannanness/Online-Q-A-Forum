package org.lanqiao.oqaf.domain;

import java.util.Date;
import java.util.Objects;

public class UserResponse {
    private int problemId;
    private int replayUserId;
    private String title;
    private String replayContent;
    private String replayDate;

    public UserResponse() {
    }

    public UserResponse(int problemId, int replayUserId, String title, String replayContent, String replayDate) {
        this.problemId = problemId;
        this.replayUserId = replayUserId;
        this.title = title;
        this.replayContent = replayContent;
        this.replayDate = replayDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public String getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(String replayDate) {
        this.replayDate = replayDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return problemId == that.problemId &&
                replayUserId == that.replayUserId &&
                Objects.equals(title, that.title) &&
                Objects.equals(replayContent, that.replayContent) &&
                Objects.equals(replayDate, that.replayDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, replayUserId, title, replayContent, replayDate);
    }

    @Override
    public String
    toString() {
        return "UserResponse{" +
                "problemId=" + problemId +
                ", replayUserId=" + replayUserId +
                ", title='" + title + '\'' +
                ", replayContent='" + replayContent + '\'' +
                ", replayDate='" + replayDate + '\'' +
                '}';
    }
}
