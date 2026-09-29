package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Cart {
    private int id;
    private String productId;
    private String quantity;
    private String name;
    private String price;
    private String image;

    public Cart(int id, String productId, String quantity, String name, String price, String image) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
