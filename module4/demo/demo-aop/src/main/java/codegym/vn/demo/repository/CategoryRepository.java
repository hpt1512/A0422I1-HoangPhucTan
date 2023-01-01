package codegym.vn.demo.repository;

import codegym.vn.demo.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
