package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Cart {
    private int id;
    private String productId;
    private String quantity;
 private String name;
 private String price;
 private String image;

}
