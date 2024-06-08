package dev.purav.productservice09april.repositories;

import dev.purav.productservice09april.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByTitle(String title);

    Category save(Category category);
  //  Category findById(long id);
     Category findById(long id);

}
