package hh.swd20.RateYourMeal;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.RateYourMeal.domain.MainCourse;
import hh.swd20.RateYourMeal.domain.MainCourseRepository;
import hh.swd20.RateYourMeal.domain.Rating;
import hh.swd20.RateYourMeal.domain.RatingRepository;
import hh.swd20.RateYourMeal.domain.SideDish;
import hh.swd20.RateYourMeal.domain.SideDishRepository;
import hh.swd20.RateYourMeal.domain.User;
import hh.swd20.RateYourMeal.domain.UserRepository;

@SpringBootApplication
public class RateYourMealApplication {
	private static final Logger log = LoggerFactory.getLogger(RateYourMealApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RateYourMealApplication.class, args);
	}

	@Bean
	public CommandLineRunner mealDemo(MainCourseRepository mcrepository, SideDishRepository sdrepository, UserRepository urepository, RatingRepository rrepository) {
		return (args) -> {

			log.info("tallennetaan käyttäjät, salasanat ja roolit");
			urepository.save(new User("user", "$2a$04$FyZaKbvqT4/FtaSoAWd2pOyZikzJx7Iyd9wJ.hCgRyCrRRxVHFlgi", "USER", "user@email.com"));
			urepository.save(new User("admin", "$2a$04$FyZaKbvqT4/FtaSoAWd2pOyZikzJx7Iyd9wJ.hCgRyCrRRxVHFlgi", "ADMIN", "admin@email.com"));

			log.info("tallennetaan testilisukkeet");
			sdrepository.save(new SideDish("Keitettyjä perunoita"));
			sdrepository.save(new SideDish("Täysjyvävehnä"));
			sdrepository.save(new SideDish("Höyrytettyä tummaa riisiä"));
			sdrepository.save(new SideDish("Luomutäysjyväpennepastaa"));
			sdrepository.save(new SideDish("Perunasosetta"));
			sdrepository.save(new SideDish("Ei lisuketta"));

			log.info("tallennetaan arvosteluasteikot");		
			rrepository.save(new Rating("0/5"));
			rrepository.save(new Rating("1/5"));
			rrepository.save(new Rating("2/5"));
			rrepository.save(new Rating("3/5"));
			rrepository.save(new Rating("4/5"));
			rrepository.save(new Rating("5/5"));

			log.info("tallennetaan testiruuat");
			mcrepository.save(new MainCourse("Punajuurikroketteja", LocalDate.of(2020, 03, 30), 1.77, 0, "Tarjolla oli myös tillikermaviilikastiketta.", sdrepository.findBySidedish("Keitettyjä perunoita").get(0), rrepository.findByRating("2/5").get(0)));		
			mcrepository.save(new MainCourse("Jauhelihakastiketta", LocalDate.of(2020, 03, 30), 1.77, 0, "Hapankorppujen päälle levitin valkosipulilevitettä.", sdrepository.findBySidedish("Keitettyjä perunoita").get(0), rrepository.findByRating("3/5").get(0)));		
			mcrepository.save(new MainCourse("Chili con vege", LocalDate.of(2020, 03, 30), 1.77, 2, "Oli ihan okei eli ei siitä sen enempää.", sdrepository.findBySidedish("Höyrytettyä tummaa riisiä").get(0), rrepository.findByRating("4/5").get(0)));		
			mcrepository.save(new MainCourse("Lihapyöryköitä ja pippurikastiketta", LocalDate.of(2020, 03, 30), 1.77, 1, "Jäliruokana oli mangorahkaa kerroksittain.", sdrepository.findBySidedish("Perunasosetta").get(0), rrepository.findByRating("4/5").get(0)));		
			mcrepository.save(new MainCourse("Juurespyttipannua", LocalDate.of(2020, 03, 30), 1.77, 0, "Tarjolla oli myös maukasta sinappimajoneesia.", sdrepository.findBySidedish("Ei lisuketta").get(0), rrepository.findByRating("5/5").get(0)));		
			mcrepository.save(new MainCourse("Juustoista savupalvikastiketta", LocalDate.of(2020, 03, 30), 1.77, 1, "Juuh elikkäs aika hyvää.", sdrepository.findBySidedish("Luomutäysjyväpennepastaa").get(0), rrepository.findByRating("4/5").get(0)));		

			log.info("haetaan kaikki lisukkeet, ruuat ja arvosanat");
			for (SideDish sidedish : sdrepository.findAll()) {
				log.info(sidedish.toString());
			}
			for (MainCourse maincourse : mcrepository.findAll()) {
				log.info(maincourse.toString());
			}
			for (Rating rating : rrepository.findAll()) {
				log.info(rating.toString());
			}			
		};
	}
}