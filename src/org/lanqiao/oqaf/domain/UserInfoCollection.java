package org.lanqiao.oqaf.domain;

import java.util.Objects;

public class UserInfoCollection {
    private int problemId ;
    private int replayUserId;
    private int collectionUserId;
    private String user_Name;
    private String replayDate;
    private String replayContent;

    public UserInfoCollection() {
    }

    public UserInfoCollection(int problemId, int replayUserId, int collectionUserId, String user_Name, String replayDate, String replayContent) {
        this.problemId = problemId;
        this.replayUserId = replayUserId;
        this.collectionUserId = collectionUserId;
        this.user_Name = user_Name;
        this.replayDate = replayDate;
        this.replayContent = replayContent;
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

    public int getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(int collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(String replayDate) {
        this.replayDate = replayDate;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoCollection that = (UserInfoCollection) o;
        return problemId == that.problemId &&
                replayUserId == that.replayUserId &&
                collectionUserId == that.collectionUserId &&
                Objects.equals(user_Name, that.user_Name) &&
                Objects.equals(replayDate, that.replayDate) &&
                Objects.equals(replayContent, that.replayContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, replayUserId, collectionUserId, user_Name, replayDate, replayContent);
    }

    @Override
    public String toString() {
        return "UserInfoCollection{" +
                "problemId=" + problemId +
                ", replayUserId=" + replayUserId +
                ", collectionUserId=" + collectionUserId +
                ", user_Name='" + user_Name + '\'' +
                ", replayDate='" + replayDate + '\'' +
                ", replayContent='" + replayContent + '\'' +
                '}';
    }
}
