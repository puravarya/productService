package dev.purav.productservice09april.controllers;

import dev.purav.productservice09april.dtos.RequestBodyProductDto;
import dev.purav.productservice09april.models.Product;
import dev.purav.productservice09april.services.FakeStoreProductService;
import dev.purav.productservice09april.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    /*
    post/products/ -->request body
    {id;
    title;
    etc
     */
    ProductService productService;
    public ProductController(@Qualifier("selfproductservice")ProductService productService) {
        this.productService = productService;
        //qualifier is used to inject the dependency to be injected here
    }
    //ProductService productService = new FakeStoreProductService();
    @PostMapping("/products")
    public Product createProduct(@RequestBody RequestBodyProductDto request ){
        return productService.createProduct(request.getTitle(),
                                request.getDescription(),
                                      request.getPrice(),
                                   request.getCategory(),
                                     request.getImage());
    }
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){

        return productService.getSingleProduct(id);
    }
//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        throw new RuntimeException();
//    //     List<Product>  products = productService.getAllProducts();
//      //   return new ResponseEntity<>(products, HttpStatus.CONFLICT);
//    }
     @GetMapping("/products")
     public List<Product> getAllProducts(){
        return productService.getAllProducts();
     }

//    @GetMapping("/paginationProducts/{pageNo}/{pageSize}")
//    public Page<Product> getProductsByPage(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
//        return productService.getPaginatedProducts(pageNo, pageSize, null);
//    }
//
//    @GetMapping("/paginationProductsByPrice/{pageNo}/{pageSize}")
//    public Page<Product> getProductsByPrice(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
//        return productService.getPaginatedProducts(pageNo, pageSize, "price");
//    }
@GetMapping("/paginationProducts/{pageNo}/{pageSize}")
public Page<Product> getProductsPaginated(@PathVariable("pageNo") int pageNo, @PathVariable("PageSize") int pageSize){
        return productService.getPaginatedProducts(pageNo, pageSize, null);
}
//    @GetMapping("/paginationProductsByPrice/{pageNo}/{pageSize}")
//    public Page<Product> getProductsByPrice(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
//        return productService.getPaginatedProducts(pageNo, pageSize, "price");
//    }

    public void updateProduct(){

    }

    @GetMapping("/generate")
    public boolean generateProducts(){
        return productService.generateProducts();
    }

}
// every api call at the end of the day is the method called inside the controller