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
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Entity
@Setter @Getter @EqualsAndHashCode
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username",nullable = false)
    private String username;
	@Column(name = "password",nullable = false)
    private String password;
	@Column(name = "name",nullable = false)
    private String name;
	@Column(name = "surname",nullable = false)
    private String surname;
	@Column(name = "email",nullable = false)
    private String email;
	@Column(name = "address",nullable = false)
    private String address;
	@Column(name = "age",nullable = false)
    private Integer age;
	@Column(name = "termsAccepted",nullable = false)
    private boolean termsAccepted;
}
