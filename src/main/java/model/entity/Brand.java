package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "_brand")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Builder.Default
    private boolean status = true;
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", products=" +
                '}';
    }
}
