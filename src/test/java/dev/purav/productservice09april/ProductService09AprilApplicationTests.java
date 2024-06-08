package dev.purav.productservice09april;

import dev.purav.productservice09april.models.Category;
import dev.purav.productservice09april.repositories.CategoryRepository;
import dev.purav.productservice09april.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductService09AprilApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void testQueries(){
    Category category = categoryRepository.findById(1L);
	System.out.println("Category is Fetched");
	category.getProducts();
	}


}
