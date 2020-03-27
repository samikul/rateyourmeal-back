package hh.swd20.RateYourMeal.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
	List<Rating> findByRating(String rating);
}