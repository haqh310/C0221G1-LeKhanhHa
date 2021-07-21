package com.codegym.model.service.impl;

import com.codegym.model.entity.Comment;
import com.codegym.model.service.ICommentService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Comment> findAll() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateNow = formatter.format(date);
        String queryStr = "select c from Comment as c where  c.date= :date_now";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("date_now", dateNow);
        return query.getResultList();
    }

    @Override
    public Comment findOne(int id) {
        String queryStr = "SELECT c FROM Comment AS c WHERE c.id = :id";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Comment save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            comment.setDate(formatter.format(date));
            session.saveOrUpdate(comment);
            transaction.commit();
            return comment;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void like(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment comment = findOne(id);
            comment.setLikes(comment.getLikes()+1);
            session.saveOrUpdate(comment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
