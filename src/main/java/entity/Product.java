package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private String description;
    private String price;
    private String image;
    private String category;

    public Product(int id, String name, String description, String price, String image, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }
}
