package org.seven.telecom.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter @Getter @EqualsAndHashCode
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username",nullable = false)
	private String username;
	@Column(name = "password",nullable = false)
	private String password;

	private User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
