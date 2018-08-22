package org.lanqiao.oqaf.domain;

import java.util.Objects;
/**
收藏表
 */
public class Collection {
    //收藏问题id
    private int problemId;
    //收藏用户id
    private int collectionUserId;
    //回答用户id
    private int replayUserId;
    //回答内容
    private String replayContent;

    public Collection() {
    }

    public Collection(int collectionUserId, int replayUserId, String replayContent) {
        this.collectionUserId = collectionUserId;
        this.replayUserId = replayUserId;
        this.replayContent = replayContent;
    }

    public Collection(int problemId, int collectionUserId, int replayUserId, String replayContent) {
        this.problemId = problemId;
        this.collectionUserId = collectionUserId;
        this.replayUserId = replayUserId;
        this.replayContent = replayContent;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(int collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    public int getReplayUserId() {
        return replayUserId;
    }

    public void setReplayUserId(int replayUserId) {
        this.replayUserId = replayUserId;
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
        Collection that = (Collection) o;
        return problemId == that.problemId &&
                collectionUserId == that.collectionUserId &&
                replayUserId == that.replayUserId &&
                Objects.equals(replayContent, that.replayContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, collectionUserId, replayUserId, replayContent);
    }

    @Override
    public String toString() {
        return "Collection{" +
                "problemId=" + problemId +
                ", collectionUserId=" + collectionUserId +
                ", replayUserId=" + replayUserId +
                ", replayContent='" + replayContent + '\'' +
                '}';
    }
}
