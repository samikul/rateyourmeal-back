package hh.swd20.RateYourMeal.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MainCourseRepository extends CrudRepository<MainCourse, Long> {
	List<MainCourse> findByMeal(String meal);
}
