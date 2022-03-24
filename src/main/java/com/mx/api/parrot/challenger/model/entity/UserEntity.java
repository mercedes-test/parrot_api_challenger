package com.mx.api.parrot.challenger.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "users")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9062478886440092052L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;

	
}
