package org.lanqiao.oqaf.domain;

import java.util.Objects;

public class Problem_Replay {
    private int problemId;//问题的id
    private String title;//问题的标题
    private String content;//问题内容
    private String user_Img;//评论者的头像
    private String user_Name;//评论者的名字
    private String problemType;//问题的类型
    private String replayContent;//回答用户的内容
    private int replayUserId;//回答用户id
    private int remarkCount;//评论的个数

    public Problem_Replay() {
    }

    public Problem_Replay(int problemId, String title, String content, String user_Img, String user_Name, String problemType, String replayContent, int replayUserId, int remarkCount) {
        this.problemId = problemId;
        this.title = title;
        this.content = content;
        this.user_Img = user_Img;
        this.user_Name = user_Name;
        this.problemType = problemType;
        this.replayContent = replayContent;
        this.replayUserId = replayUserId;
        this.remarkCount = remarkCount;
    }

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

    public String getUser_Img() {
        return user_Img;
    }

    public void setUser_Img(String user_Img) {
        this.user_Img = user_Img;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public int getReplayUserId() {
        return replayUserId;
    }

    public void setReplayUserId(int replayUserId) {
        this.replayUserId = replayUserId;
    }

    public int getRemarkCount() {
        return remarkCount;
    }

    public void setRemarkCount(int remarkCount) {
        this.remarkCount = remarkCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem_Replay that = (Problem_Replay) o;
        return problemId == that.problemId &&
                replayUserId == that.replayUserId &&
                remarkCount == that.remarkCount &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(user_Img, that.user_Img) &&
                Objects.equals(user_Name, that.user_Name) &&
                Objects.equals(problemType, that.problemType) &&
                Objects.equals(replayContent, that.replayContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(problemId, title, content, user_Img, user_Name, problemType, replayContent, replayUserId, remarkCount);
    }

    @Override
    public String toString() {
        return "Problem_Replay{" +
                "problemId=" + problemId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user_Img='" + user_Img + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", problemType='" + problemType + '\'' +
                ", replayContent='" + replayContent + '\'' +
                ", replayUserId=" + replayUserId +
                ", remarkCount=" + remarkCount +
                '}';
    }
}
