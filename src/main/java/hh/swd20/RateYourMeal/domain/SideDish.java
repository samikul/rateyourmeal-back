package hh.swd20.RateYourMeal.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "sidedish")
public class SideDish {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long sidedishid;
	
	@NotEmpty
	private String sidedish;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sidedish")
	private List<MainCourse> maincourses;


	public SideDish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SideDish(String sidedish) {
		super();
		this.sidedish = sidedish;
	}

	public long getSidedishid() {
		return sidedishid;
	}

	public void setSidedishid(long sidedishid) {
		this.sidedishid = sidedishid;
	}

	public String getSidedish() {
		return sidedish;
	}

	public void setSidedish(String sidedish) {
		this.sidedish = sidedish;
	}

	public List<MainCourse> getMaincourses() {
		return maincourses;
	}

	public void setMaincourses(List<MainCourse> maincourses) {
		this.maincourses = maincourses;
	}

		
}
