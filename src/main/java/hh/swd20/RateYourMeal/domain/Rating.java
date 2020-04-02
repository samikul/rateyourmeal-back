package hh.swd20.RateYourMeal.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rating")
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ratingid;
	private String rating;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
	private List<MainCourse> maincourses;

	public Rating() {
	}

	public Rating(String rating) {
		this.rating = rating;
	}

	public Long getRatingid() {
		return ratingid;
	}

	public void setRatingid(Long ratingid) {
		this.ratingid = ratingid;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<MainCourse> getMaincourses() {
		return maincourses;
	}

	public void setMaincourses(List<MainCourse> maincourses) {
		this.maincourses = maincourses;
	}

}
