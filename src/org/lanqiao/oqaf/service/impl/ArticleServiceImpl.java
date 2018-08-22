package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IArticleDao;
import org.lanqiao.oqaf.dao.impl.ArticleDaoImpl;
import org.lanqiao.oqaf.domain.Article;
import org.lanqiao.oqaf.service.IArticleService;

import java.sql.SQLException;

public class ArticleServiceImpl implements IArticleService {
    private IArticleDao dao = new ArticleDaoImpl();
    @Override
    public void insertArticle(Article article) {
        try {
            dao.insertArticle(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
