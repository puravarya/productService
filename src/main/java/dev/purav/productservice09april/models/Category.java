package dev.purav.productservice09april.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel {
    private String title;
   // private int categoryLocation;
    // Category:Product
   @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
   @JsonIgnore
    private List<Product> products;
    //private String description;

}
