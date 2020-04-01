package hh.swd20.RateYourMeal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.RateYourMeal.webcontroller.MainCourseController;
import hh.swd20.RateYourMeal.webcontroller.SideDishController;

@RunWith(SpringRunner.class)
@SpringBootTest
class RateYourMealApplicationTests {

	@Autowired
	private MainCourseController MainCourseController;

	@Autowired
	private SideDishController SideDishController;

	@Test
	void contextLoads() throws Exception {
		assertThat(MainCourseController).isNotNull();
		assertThat(SideDishController).isNotNull();
	}

}
