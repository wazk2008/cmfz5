package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import io.goeasy.GoEasy;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Map<String, Object> selectAllArticle(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Article article = new Article();
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Article> articles = articleDao.selectByRowBounds(article, rowBounds);
        int count = articleDao.selectCount(article);
        map.put("page",page);
        map.put("rows",articles);
        map.put("total",count%rows==0?count/rows:count/rows+1);
        map.put("records",count);
        return map;
    }

    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setCreateDate(new Date());
        int i = articleDao.insertSelective(article);
        if(i == 0){
            throw new RuntimeException("添加文章失败");
        }else{
            //第一个参数：REST Host       第二个参数：appks
            GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io","BC-268c25f44f5841ff93a8f4e6aa24193a");
//        第一个参数：channel的名称      第二个参数：发送的内容
            goEasy.publish("cmfz-article", article.getContent());
        }
    }

    @Override
    public void edit(Article article) {
        int i = articleDao.updateByPrimaryKeySelective(article);
        if(i == 0){
            throw new RuntimeException("修改文章失败");
        }
    }

    @Override
    public void del(Article article) {
        int i = articleDao.deleteByPrimaryKey(article.getId());
        if(i == 0){
            throw new RuntimeException("文章删除失败");
        }
    }

    @Override
    public List<Article> selectArticleByGuruId(String id) {
        Article article = new Article();
        article.setAuthor(id);
        List<Article> list = articleDao.select(article);
        return list;
    }

    @Override
    public List<Article> selectAll() {
        return articleDao.selectAll();
    }
}
