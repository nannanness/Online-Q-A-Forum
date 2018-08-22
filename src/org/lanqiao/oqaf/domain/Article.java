package org.lanqiao.oqaf.domain;

import java.util.Objects;

/**
 * 文章表
 */
public class Article {
    //文章标题
    private String articleTitle;
    // 文章内容
    private String articleContent;
    // 文章id
    private int articleId;
    // 文章作者
    private int authorId;
    // 文章点赞个数
    private int zanNum;
    //文章类别
    private String articleType;
    //文章显示日期
    private String articleDate;
    public Article() {
    }

    public Article(String articleTitle, String articleContent, int articleId, int authorId, int zanNum,String articleType, String articleDate) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleId = articleId;
        this.authorId = authorId;
        this.zanNum = zanNum;
        this.articleDate = articleDate;
    }

    public Article(String articleContent,int zanNum,int authorId,String articleTitle, String articleType,String articleDate) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.authorId = authorId;
        this.zanNum = zanNum;
        this.articleDate = articleDate;
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

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }
    public String getArticleType(){
        return articleType;
    }
    public void setArticleType(String articleType){
        this.articleType = articleType;
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
        Article article = (Article) o;
        return articleId == article.articleId &&
                authorId == article.authorId &&
                zanNum == article.zanNum &&
                Objects.equals(articleTitle, article.articleTitle) &&
                Objects.equals(articleContent, article.articleContent) &&
                Objects.equals(articleType, article.articleType) &&
                Objects.equals(articleDate, article.articleDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(articleTitle, articleContent, articleId, authorId, zanNum,articleType, articleDate);
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleId=" + articleId +
                ", authorId=" + authorId +
                ", zanNum=" + zanNum +
                ",articleType" + articleType+
                ", articleDate='" + articleDate + '\'' +
                '}';
    }
}
