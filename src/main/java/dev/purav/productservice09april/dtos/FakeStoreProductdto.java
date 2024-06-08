package dev.purav.productservice09april.dtos;

import dev.purav.productservice09april.models.Category;
import dev.purav.productservice09april.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductdto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;
public Product toProduct(){
    Product product = new Product();
    product.setId(id);
    product.setTitle(title);
    product.setPrice(price);
    product.setDescription(description);
    product.setImageURL(image);

    Category category1 = new Category();
    category1.setTitle(category);
    product.setCategory(category1);
    return product;
}
}
