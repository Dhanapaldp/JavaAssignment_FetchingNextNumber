package in.yabelo.repo;

import org.springframework.data.repository.CrudRepository;

import in.yabelo.entity.Category;

public interface IFetchNumberRepo extends CrudRepository<Category, Integer> {

}
