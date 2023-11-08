package repository.impl;

import model.config.RepositoryConfig;
import model.entity.Cart;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.CartRepository;


public class CartRepositoryImpl extends RepositoryConfig implements CartRepository {
    @Override
    public void updateProductToCart(Cart cart) {

        try {
            getEntityTransaction().begin();
            getEntityManager().merge(cart);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_UPDATED_EXCEPTION);
        }
    }

    @Override
    public void buyProductsInCart(Cart cart) {

        try {
            getEntityTransaction().begin();
            getEntityManager().merge(cart);
            getEntityTransaction().commit();
        }catch (Exception e){
            throw new ApplicationException(ExceptionEnums.COULD_NOT_BE_UPDATED_EXCEPTION);
        }
    }
}
