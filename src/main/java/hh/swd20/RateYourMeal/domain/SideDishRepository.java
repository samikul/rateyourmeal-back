package hh.swd20.RateYourMeal.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SideDishRepository extends CrudRepository<SideDish, Long> {
	List<SideDish> findBySidedish(String sidedish);
}
