package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Entity(name = "_product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal amount;
    @ElementCollection
    private List<String> comment;
    private int likes;
    private byte star;
    private int remainCount;
    @Embedded
    private ProductDetails productDetails;
    @Builder.Default
    private boolean status = true;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
    @ManyToOne
    private Category category;

    public void addComment(String comment) {
        this.comment.add(comment);
    }

    public void setStar(byte star) {
        if(star > 5){
            this.star = (byte) ((byte) (this.star + 5) / 2);
        }else {
            this.star = (byte) ((byte) (this.star + star) / 2);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", comment=" + comment +
                ", likes=" + likes +
                ", star=" + star +
                ", remainCount=" + remainCount +
                ", productDetails=" + productDetails +
                ", status=" + status +
                '}';
    }

    public void decreaseRemainCount(){
        --remainCount;
    }
}
