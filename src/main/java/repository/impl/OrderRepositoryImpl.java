package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Order;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl extends RepositoryConfig implements OrderRepository {
    @Override
    public void createOrder(Order order) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(order);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> orderTypedQuery = getEntityManager().createQuery("select  o from _order o ", Order.class);

        return orderTypedQuery.getResultList();
    }
}
