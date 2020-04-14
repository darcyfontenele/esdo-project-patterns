package com.esdevops.services;

import com.esdevops.entities.Book;
import com.esdevops.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private EntityManager entityManager;

    public BookService() {
        entityManager = new HibernateUtil().getEntityManagerFactory().createEntityManager();
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        if(entityManager != null && entityManager.isOpen()){
            books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        }
        return books;
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void save(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(book);
            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error message: "+ e.getMessage());
        }
    }

    public void update(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(book);
            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error message: "+ e.getMessage());
        }
    }

    public void delete(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(book);
            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error message: "+ e.getMessage());
        }
    }

}
