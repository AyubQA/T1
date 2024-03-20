package api.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Data
@NoArgsConstructor

public class Product {
    private String category;
    private int discount;
    private long id;
    private String name;
    private double price;

    public Product(String category, int discount, long id, String name, double price) {
        this.category = category;
        this.discount = discount;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Todo попытка сделать невалидный JSON
    public Product(int category, int discount, int id, int i, double price) {
    }
}


