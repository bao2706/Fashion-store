package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class Category {
    private String cateName;
    private String cateID;

    public Category(String cateName, String cateID) {
        this.cateName = cateName;
        this.cateID = cateID;
    }
}
