package model.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Getter;

@Getter
public class RepositoryConfig {
    protected final EntityManagerFactory entityManagerFactory;
    protected final EntityManager entityManager;
    protected final EntityTransaction entityTransaction;

    public RepositoryConfig() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }
}
