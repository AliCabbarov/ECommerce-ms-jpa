import controller.Management;
import controller.impl.ManagementImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Order;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.impl.OrderRepositoryImpl;
import repository.impl.ProductRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new ManagementImpl().manage();
    }





}
