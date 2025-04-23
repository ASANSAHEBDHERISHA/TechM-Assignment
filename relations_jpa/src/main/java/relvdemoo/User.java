package relvdemoo;
import jakarta.persistence.*;
@Entity
@NamedQuery(name="User.findAsif",query="select u from User u where u.email=:email")
@NamedNativeQuery(name="User.findArif",query="select * from user where status=?",resultClass=User.class)
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String status;
	public User() {}
	public User(String name, String email, String status) {
		super();
		this.name = name;
		this.email = email;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
