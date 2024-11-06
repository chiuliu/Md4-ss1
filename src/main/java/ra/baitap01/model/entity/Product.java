package ra.baitap01.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
@Table(name = "Product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Pattern(regexp = "^\\w+$",message = "Khong chua ki tu dac biet")
    @Column(name = "name")
    private String name;

    private Integer stock;

    private Double price;

    @NotBlank(message = "Khong duoc de trong")
    private String description;
    public String getPriceFormat(){
        return NumberFormat.getCurrencyInstance().format(price);
    }


}
