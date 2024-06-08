package dev.purav.productservice09april.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {

  //private Long id;// --now its already come from basemodel
  //  private String name;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    @ManyToOne(cascade = CascadeType.PERSIST) //the above is going to add a FK
    @JsonIgnore
    private Category category;

    public Product(String title, double price){
      this.title = title;
      this.price = price;
    }
}
