package org.lanqiao.oqaf.domain;

import java.util.Objects;

public class UserArticle {
    private int articleId;
    private int authorId;
    private String articleTitle;
    private String articleContent;
    private String articleDate;

    public UserArticle() {
    }

    public UserArticle(int articleId, int authorId, String articleTitle, String articleContent, String articleDate) {
        this.articleId = articleId;
        this.authorId = authorId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserArticle that = (UserArticle) o;
        return articleId == that.articleId &&
                authorId == that.authorId &&
                Objects.equals(articleTitle, that.articleTitle) &&
                Objects.equals(articleContent, that.articleContent) &&
                Objects.equals(articleDate, that.articleDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(articleId, authorId, articleTitle, articleContent, articleDate);
    }

    @Override
    public String toString() {
        return "UserArticle{" +
                "articleId=" + articleId +
                ", authorId=" + authorId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate='" + articleDate + '\'' +
                '}';
    }
}
