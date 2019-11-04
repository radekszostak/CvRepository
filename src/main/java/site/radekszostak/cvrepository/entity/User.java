package site.radekszostak.cvrepository.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "birth_date")
	private String birthDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	
	public User() {
	}

	public User(String userName, String password, String email, String firstName, String lastName, String phone,
			String birthDate) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.birthDate = birthDate;
	}

	public User(String userName, String password, String email, String firstName, String lastName, String phone,
			String birthDate, Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.birthDate = birthDate;
		this.roles = roles;
	}

	public User(String userName, String password, Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", birthDate="
				+ birthDate + "]";
	}
	
	
}