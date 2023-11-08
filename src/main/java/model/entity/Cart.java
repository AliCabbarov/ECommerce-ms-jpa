package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "_cart")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int count;
    private BigDecimal totalAmount;
    @ManyToMany
    private List<Product> products;


    public void addProducts(Product product) {
        this.products.add(product);
    }

    public void deleteProducts(Product product) {
        this.products.remove(product);
    }

    public BigDecimal sumProductPrice(final List<Product> products) {
        BigDecimal sum = new BigDecimal(0);

        System.out.println(products.size());
        for (Product product: products) {
            sum = sum.add(product.getAmount());
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", count=" + count +
                ", totalAmount=" + totalAmount +
                ", products=" +
                '}';
    }
}