package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IArticleDao;
import org.lanqiao.oqaf.domain.Article;

import java.sql.SQLException;

public class ArticleDaoImpl implements IArticleDao {
    //创建queryrunner对象(传入数据源对象)
    QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public void insertArticle(Article article) throws SQLException {
        //sql语句
        String sql = "insert into article(articleContent,zanNum,authorId,articleTitle,articleType,articleDate)" +
                " value(?,?,?,?,?,?)";
        //执行
        qur.update(sql,article.getArticleContent(),article.getZanNum(),article.getAuthorId(),article.getArticleTitle(),article.getArticleType(),article.getArticleDate());

    }
}
