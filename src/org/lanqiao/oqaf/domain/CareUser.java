package org.lanqiao.oqaf.domain;

import java.util.Objects;

/**
 * 关注表
 */
public class CareUser {
    //关注用户id
    private int careUserId;
    //关注用户姓名
    private String careUsername;
    //关注用户个人介绍
    private String careUserDetails;
    //关注用户头像
    private String careUserImg;
    //被关注
    private String fansUsername;
    private int fansId;
    private String fansDetails;
    private String fansImg;


    public CareUser() {
    }

    public CareUser(int careUserId, int fansId) {
        this.careUserId = careUserId;
        this.fansId = fansId;
    }

    public CareUser(int careUserId, String careUsername, String careUserDetails, String careUserImg, String fansUsername, int fansId, String fansDetails, String fansImg) {
        this.careUserId = careUserId;
        this.careUsername = careUsername;
        this.careUserDetails = careUserDetails;
        this.careUserImg = careUserImg;
        this.fansUsername = fansUsername;
        this.fansId = fansId;
        this.fansDetails = fansDetails;
        this.fansImg = fansImg;
    }

    public CareUser(String careUsername, String careUserDetails, String careUserImg, String fansUsername, int fansId, String fansDetails, String fansImg) {
        this.careUsername = careUsername;
        this.careUserDetails = careUserDetails;
        this.careUserImg = careUserImg;
        this.fansUsername = fansUsername;
        this.fansId = fansId;
        this.fansDetails = fansDetails;
        this.fansImg = fansImg;
    }

    public int getCareUserId() {
        return careUserId;
    }

    public void setCareUserId(int careUserId) {
        this.careUserId = careUserId;
    }

    public String getCareUsername() {
        return careUsername;
    }

    public void setCareUsername(String careUsername) {
        this.careUsername = careUsername;
    }

    public String getCareUserDetails() {
        return careUserDetails;
    }

    public void setCareUserDetails(String careUserDetails) {
        this.careUserDetails = careUserDetails;
    }

    public String getCareUserImg() {
        return careUserImg;
    }

    public void setCareUserImg(String careUserImg) {
        this.careUserImg = careUserImg;
    }

    public String getFansUsername() {
        return fansUsername;
    }

    public void setFansUsername(String fansUsername) {
        this.fansUsername = fansUsername;
    }

    public int getFansId() {
        return fansId;
    }

    public void setFansId(int fansId) {
        this.fansId = fansId;
    }

    public String getFansDetails() {
        return fansDetails;
    }

    public void setFansDetails(String fansDetails) {
        this.fansDetails = fansDetails;
    }

    public String getFansImg() {
        return fansImg;
    }

    public void setFansImg(String fansImg) {
        this.fansImg = fansImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareUser careUser = (CareUser) o;
        return careUserId == careUser.careUserId &&
                fansId == careUser.fansId &&
                Objects.equals(careUsername, careUser.careUsername) &&
                Objects.equals(careUserDetails, careUser.careUserDetails) &&
                Objects.equals(careUserImg, careUser.careUserImg) &&
                Objects.equals(fansUsername, careUser.fansUsername) &&
                Objects.equals(fansDetails, careUser.fansDetails) &&
                Objects.equals(fansImg, careUser.fansImg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(careUserId, careUsername, careUserDetails, careUserImg, fansUsername, fansId, fansDetails, fansImg);
    }

    @Override
    public String toString() {
        return "CareUser{" +
                "careUserId=" + careUserId +
                ", careUsername='" + careUsername + '\'' +
                ", careUserDetails='" + careUserDetails + '\'' +
                ", careUserImg='" + careUserImg + '\'' +
                ", fansUsername='" + fansUsername + '\'' +
                ", fansId=" + fansId +
                ", fansDetails='" + fansDetails + '\'' +
                ", fansImg='" + fansImg + '\'' +
                '}';
    }
}
