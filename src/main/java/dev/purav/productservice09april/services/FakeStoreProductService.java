package dev.purav.productservice09april.services;

import dev.purav.productservice09april.dtos.FakeStoreProductdto;
import dev.purav.productservice09april.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.ArrayList;
import java.util.List;

@Service("fakestore")
public abstract class FakeStoreProductService implements ProductService{

    private final ResourceUrlProvider mvcResourceUrlProvider;
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, ResourceUrlProvider mvcResourceUrlProvider) {
        this.restTemplate = restTemplate;
        this.mvcResourceUrlProvider = mvcResourceUrlProvider;
    }
//   @Override
//   public Optional<Product> getSingleProduct(Long productId) {
//      if(productId == 0){
//            throw new IllegalArgumentException("Inavalid ProductId, please try out some other ProductId");
//        }
//
//        ResponseEntity<FakeStoreProductdto> fakeStoreProductResponse = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products/1" + productId, FakeStoreProductdto.class);
//
//           return Optional.ofNullable(fakeStoreProductResponse.getBody().toProduct());
//
//
//    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreProductdto[] fakeStoreProductdtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductdto[].class);
        for(FakeStoreProductdto fakeStoreProductdto : fakeStoreProductdtos) {
               products.add(fakeStoreProductdto.toProduct());
        }
        return products;
    }


    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String category,
                                 String image) {
      FakeStoreProductdto fakeStoreProductdto = new FakeStoreProductdto();
      fakeStoreProductdto.setTitle(title);
      fakeStoreProductdto.setDescription(description);
      fakeStoreProductdto.setPrice(price);
      fakeStoreProductdto.setCategory(category);
      fakeStoreProductdto.setImage(image);
      FakeStoreProductdto fakeStoreProductdto1 = restTemplate.postForObject("https://fakestoreapi.com/products",
              fakeStoreProductdto,
         FakeStoreProductdto.class);
        return fakeStoreProductdto1.toProduct();
    }

    @Override
    public boolean generateProducts() {
        return false;
    }
    @Override
    public Page<Product> getPaginatedProducts(Integer pageNumber, Integer pageSize, Object o) {
        return null;
    }
}
// rest template allows you to send http req to external apis and get respond