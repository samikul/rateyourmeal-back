package hh.swd20.RateYourMeal.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.RateYourMeal.domain.SideDish;
import hh.swd20.RateYourMeal.domain.SideDishRepository;

@Controller
public class SideDishController {

	@Autowired
	private SideDishRepository sdrepository;


	// Add new side dish
	@RequestMapping(value="/addsidedish")
	public String addMaincourse(Model model) {
		model.addAttribute("sidedish", new SideDish());
		return "sidedishform";
	}

	// show all side dishes
	@RequestMapping(value = "/sidedishlist", method = RequestMethod.GET)
	public String getAllSidedishes(Model model) {
		List<SideDish> sidedish = (List<SideDish>) sdrepository.findAll();
		model.addAttribute("sidedishes", sidedish);
		return "sidedishlist";
	}

	// save side dish
	@RequestMapping(value = "/savesidedish", method = RequestMethod.POST)
	public String saveSidedish(@ModelAttribute SideDish sidedish) {
		sdrepository.save(sidedish);
		return "redirect:/sidedishlist";
	}

	// delete side dish
	@RequestMapping(value = "/deletesidedish/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteSidedish(@PathVariable("id") Long sidedishid) {
		sdrepository.deleteById(sidedishid);
		return "redirect:/sidedishlist";
	}

	// edit side dish
	@RequestMapping(value = "/editsidedish/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editSidedish(@PathVariable("id") Long sidedishid, Model model) {
		model.addAttribute("sidedish", sdrepository.findById(sidedishid));
		return "sidedishedit";
	}

	// RESTful service to get all sidedishes
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/sidedishes", method = RequestMethod.GET)
	public @ResponseBody List<SideDish> sidedishListRest() {
		return ((List<SideDish>) sdrepository.findAll());
	}

	// RESTful service to get sidedish by id
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/sidedish/{sidedishid}", method = RequestMethod.GET)
	public @ResponseBody Optional<SideDish> findSidedishRest(@PathVariable("sidedishid") Long sidedishid) {
		return sdrepository.findById(sidedishid);
	}	
}
