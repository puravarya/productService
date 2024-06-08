package dev.purav.productservice09april.repositories;

import dev.purav.productservice09april.models.Category;
import dev.purav.productservice09april.models.Product;
import dev.purav.productservice09april.repositories.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
        @Query("select p from Product p where p.title = :title")
        List<Product>findAllProductsWithAParticularName(@Param("title") String title);

        @Query("select p.title, p.category.title, p.description from Product p where p.category.title = :categoryName and p.price> :price")
        List<ProductProjection>findAllProductsByCategoryNameAndProductPrice(@Param("categoryName") String categoryName,
                                                                            @Param("price") long price);


        @Query(value = "select * from products p where p.category.title = :categoryName and p.price = :price", nativeQuery = true)
        List<Product> findAllProductsByCategoryNameAndProductPrice2(@Param("categoryName") String categoryName,
                                                                    @Param("price") long price);
// here spring will automatically run a query on db for the corresponding methodcall
Product save(Product product);
Product findByIdIs(long id);

        @Override
        List<Product> findAll();

        List<Product> findAllByTitle(String title);

        List<Product> findAllByCategory(Category category);

        List<Product> findAllByCategory_Title(String title);

        List<Product> findAllByCategory_Id(long id);

        List<Product> findByTitleStartingWithAndIdGreaterThanAndCategory_IdEquals(String title, long GreaterThan, long Category_Id);

}