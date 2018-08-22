package org.lanqiao.oqaf.domain;

import java.util.Objects;

/**
 * 回答表
 */
public class Replay {
    private int problemId;
    private int replayUserId;
    private int zanCount;
    private String replayContent;
    private String replayDate;
    private int  remarkCount;

    public Replay() {
    }

    public Replay(int problemId, int replayUserId, int zanCount, String replayContent, String replayDate, int remarkCount) {
        this.problemId = problemId;
        this.replayUserId = replayUserId;
        this.zanCount = zanCount;
        this.replayContent = replayContent;
        this.replayDate = replayDate;
        this.remarkCount = remarkCount;
    }

    public String getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(String replayDate) {
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

    public int getZanCount() {
        return zanCount;
    }

    public void setZanCount(int zanCount) {
        this.zanCount = zanCount;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public int  getRemarkCount() {
        return remarkCount;
    }

    public void setRemarkCount(int remarkCount) {
        this.remarkCount = remarkCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replay replay = (Replay) o;
        return problemId == replay.problemId &&
                replayUserId == replay.replayUserId &&
                zanCount == replay.zanCount &&
                Objects.equals(replayContent, replay.replayContent) &&
                Objects.equals(replayDate, replay.replayDate) &&
                Objects.equals(remarkCount, replay.remarkCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, replayUserId, zanCount, replayContent, replayDate, remarkCount);
    }

    @Override
    public String toString() {
        return "Replay{" +
                "problemId=" + problemId +
                ", replayUserId=" + replayUserId +
                ", zanCount=" + zanCount +
                ", replayContent='" + replayContent + '\'' +
                ", replayDate='" + replayDate + '\'' +
                ", remarkCount='" + remarkCount + '\'' +
                '}';
    }
}
