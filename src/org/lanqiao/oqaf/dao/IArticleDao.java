package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.Article;

import java.sql.SQLException;

/**
 * 写文章dao接口
 */
public interface IArticleDao {
    //插入数据
    public void insertArticle(Article article) throws SQLException;
}
