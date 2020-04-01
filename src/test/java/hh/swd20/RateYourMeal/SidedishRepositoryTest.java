package hh.swd20.RateYourMeal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.RateYourMeal.domain.SideDish;
import hh.swd20.RateYourMeal.domain.SideDishRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SidedishRepositoryTest {

	@Autowired
	private SideDishRepository sdrepository;
	
	@Test
	public void findBySidedishShouldReturnASidedish() {
		List<SideDish> sidedishes = sdrepository.findBySidedish("Höyrytettyä tummaa riisiä");
		assertThat(sidedishes).hasSize(1);
		assertThat(sidedishes.get(0).getSidedishid()).isEqualTo(3);
	}
	
	@Test
	public void createNewSidedishShouldCreateANewSidedish() {
		SideDish sidedish = new SideDish("Ranskalaiset");
		sdrepository.save(sidedish);
		assertThat(sidedish.getSidedishid()).isNotNull();
	}
	
	@Test
	public void deleteByIdSholdDeleteSidedishWithId6() {
		sdrepository.deleteById((long) 6); 
	}
}