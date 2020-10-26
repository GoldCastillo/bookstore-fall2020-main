package swd20.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	//attribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uId", nullable = false, updatable = false)
	private long uId;
	
	//Uniikki käyttäjänimi
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String passwordHash;
    
    @Column(name = "role", nullable = false)
    private String role;
    
    @Column(name = "email", nullable = false)
    private String email;


	public User(String username, String passwordHash, String role, String email) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
		this.email = email;
	}

	public User() {
		
	}

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
