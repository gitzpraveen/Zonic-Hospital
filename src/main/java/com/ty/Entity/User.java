package com.ty.Entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user-register")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String username;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	@NaturalId
	private String email;
	private String phno;
	private  String  password;
	private String role;
	
	@OneToMany
	 private List<Appointment> appointments;
	
	
}
