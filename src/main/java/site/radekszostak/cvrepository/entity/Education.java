/*package site.radekszostak.cvrepository.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "educations")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@Column(name = "from_date")
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Column(name = "to_date")
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	@Column(name = "field")
	private String field;
	
	@Column(name = "school")
	private String school;
	
	@Column(name = "description")
	private String description;
	
	public Education() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", field=" + field
				+ ", school=" + school + ", description=" + description + "]";
	}
	
	
}*/
