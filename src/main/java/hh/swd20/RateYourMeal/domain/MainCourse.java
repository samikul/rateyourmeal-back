package hh.swd20.RateYourMeal.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "maincourses")
public class MainCourse {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long maincourseid;

	@NotEmpty
	private String meal;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@Min(1)
	private Double price;

	@Max(3)
	private Long numberOfRedGlasses;

	@NotEmpty
	private String comment;

	@ManyToOne
	@JoinColumn(name = "sidedishid")
	private SideDish sidedish;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ratingid")
	private Rating rating;

	public MainCourse() {
	}

	public MainCourse(String meal, LocalDate date, Double price, long numberOfRedGlasses, String comment,
			SideDish sidedish, Rating rating) {
		super();
		this.meal = meal;
		this.date = date;
		this.price = price;
		this.numberOfRedGlasses = numberOfRedGlasses;
		this.comment = comment;
		this.sidedish = sidedish;
		this.rating = rating;
	}

	public Long getMaincourseid() {
		return maincourseid;
	}

	public void setMaincourseid(Long maincourseid) {
		this.maincourseid = maincourseid;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getNumberOfRedGlasses() {
		return numberOfRedGlasses;
	}

	public void setNumberOfRedGlasses(Long numberOfRedGlasses) {
		this.numberOfRedGlasses = numberOfRedGlasses;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public SideDish getSidedish() {
		return sidedish;
	}

	public void setSidedish(SideDish sidedish) {
		this.sidedish = sidedish;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MainCourse [maincourseid=" + maincourseid + ", meal=" + meal + ", date=" + date + ", price=" + price
				+ ", numberOfRedGlasses=" + numberOfRedGlasses + ", comment=" + comment + ", sidedish=" + sidedish
				+ ", rating=" + rating + "]";
	}	
}
