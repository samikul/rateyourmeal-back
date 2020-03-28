package hh.swd20.RateYourMeal.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.RateYourMeal.domain.MainCourse;
import hh.swd20.RateYourMeal.domain.MainCourseRepository;
import hh.swd20.RateYourMeal.domain.RatingRepository;
import hh.swd20.RateYourMeal.domain.SideDishRepository;

@Controller
public class MainCourseController {

	@Autowired
	private MainCourseRepository mcrepository;

	@Autowired
	private SideDishRepository sdrepository;

	@Autowired
	private RatingRepository rrepository;

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}

	// Add new meal
	@RequestMapping(value="/addmaincourse")
	public String addMaincourse(Model model) {
		model.addAttribute("maincourse", new MainCourse());
		model.addAttribute("sidedish", sdrepository.findAll()); 
		model.addAttribute("rating", rrepository.findAll()); 
		return "maincourseform";
	}

	// show all meals
	@RequestMapping(value = "/maincourselist", method = RequestMethod.GET)
	public String getAllMaincourses(Model model) {
		List<MainCourse> maincourse = (List<MainCourse>) mcrepository.findAll();
		model.addAttribute("maincourses", maincourse);
		return "maincourselist";
	}

	// save meal
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMeal(@ModelAttribute MainCourse maincourse) {
		mcrepository.save(maincourse);
		return "redirect:/maincourselist";
	}

	// delete meal
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMeal(@PathVariable("id") Long maincourseid) {
		mcrepository.deleteById(maincourseid);
		return "redirect:/maincourselist";
	}

	// edit meal
	@RequestMapping(value = "/editmeal/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editMeal(@PathVariable("id") Long maincourseid, Model model) {
		model.addAttribute("maincourse", mcrepository.findById(maincourseid));
		model.addAttribute("sidedish", sdrepository.findAll());
		model.addAttribute("rating", rrepository.findAll());
		return "maincourseedit";
	}

//		// RESTful service to get all meals
//		@RequestMapping(value = "/maincourses", method = RequestMethod.GET)
//		public @ResponseBody List<MainCourse> maincourseListRest() {
//			return (List<MainCourse> mcrepository.findAll());
//		}

	// RESTful service to get meal by id
	@RequestMapping(value="/maincourse/{maincourseid}", method = RequestMethod.GET)
	public @ResponseBody Optional<MainCourse> findMaincourseRest(@PathVariable("maincourseid") Long maincourseid) {
		return mcrepository.findById(maincourseid);
	}	

}
