package dev.purav.productservice09april.services;

import dev.purav.productservice09april.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

  //  Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product createProduct(String title,
                  String description,
                  double price,
                  String category,
                  String imageURL);


    Product getSingleProduct(Long id);

    boolean generateProducts();
  Page<Product> getPaginatedProducts(Integer pageNumber, Integer pageSize, Object o);

  Page<Product> getPaginatedProducts(Integer pageNo, Integer pageSize, String sort);
}
