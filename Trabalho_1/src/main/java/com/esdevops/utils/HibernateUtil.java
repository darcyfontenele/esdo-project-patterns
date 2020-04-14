package com.esdevops.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private final EntityManagerFactory entityManagerFactory;

    public HibernateUtil() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("Trabalho1");
        } catch (Exception e) {
            throw new RuntimeException("Unable to configure Hibernate connection: " + e.getMessage());
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}