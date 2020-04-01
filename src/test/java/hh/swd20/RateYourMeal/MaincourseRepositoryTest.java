package hh.swd20.RateYourMeal;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.RateYourMeal.domain.MainCourse;
import hh.swd20.RateYourMeal.domain.MainCourseRepository;
import hh.swd20.RateYourMeal.domain.Rating;
import hh.swd20.RateYourMeal.domain.SideDish;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MaincourseRepositoryTest {

	@Autowired
	private MainCourseRepository mcrepository;
	
	@Test
	public void findByMealShouldReturnAMeal() {
		List<MainCourse> maincourses = mcrepository.findByMeal("Juustoista savupalvikastiketta");
		assertThat(maincourses).hasSize(1);
		assertThat(maincourses.get(0).getComment()).isEqualTo("Juuh elikkäs aika hyvää.");
	}
	
	@Test
	public void createNewMaincourseShouldCreateANewMaincourseWithSidedishAndRating() {
		MainCourse maincourse = new MainCourse("Hernekeitto", LocalDate.of(2020, 03, 18), 1.77, 1, "Sinappia ja sipulia.", new SideDish("Ei lisuketta"), new Rating("5/5"));
		mcrepository.save(maincourse);
		assertThat(maincourse.getMaincourseid()).isNotNull();
	}
	
	@Test
	public void deleteByIdSholdDeleteMaincourseWithId14() {
		mcrepository.deleteById((long) 14); 
	}
}
