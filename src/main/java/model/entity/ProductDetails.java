package model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductDetails {
    private String color;
    private String weight;

    @Override
    public String toString() {
        return "ProductDetails{" +
                "color='" + color + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
