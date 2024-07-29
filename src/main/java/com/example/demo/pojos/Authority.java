package com.example.demo.pojos;

import java.util.Set;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2949470903323002321L;

	@Id
	@UuidGenerator(style = Style.AUTO)
	private String authorityId;
	
	private String role;
	
	@ManyToMany(mappedBy = "authorities")
	private Set<User> users;
}
