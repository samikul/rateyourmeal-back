package hh.swd20.RateYourMeal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.RateYourMeal.domain.Rating;
import hh.swd20.RateYourMeal.domain.RatingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RatingRepositoryTest {

	@Autowired
	private RatingRepository rrepository;
	
	@Test
	public void findByRatingShouldReturnARating() {
		List<Rating> ratings = rrepository.findByRating("5/5");
		assertThat(ratings).hasSize(1);
		assertThat(ratings.get(0).getRatingid()).isEqualTo(12);
	}
	
	@Test
	public void createANewRatingShouldCreateANewRating() {
		Rating rating = new Rating("kuusi/5");
		rrepository.save(rating);
		assertThat(rating.getRatingid()).isNotNull();
	}
	
	@Test
	public void deleteByIdSholdDeleteRatingWithId10() {
		rrepository.deleteById((long) 10); 
	}
}