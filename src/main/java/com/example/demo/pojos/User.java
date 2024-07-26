package com.example.demo.pojos;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2668596648780138002L;
	
	@Id
	@UuidGenerator(style = Style.AUTO)
	private String userId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String username;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authoritues", joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "authorityId"))
	@Column(nullable = false)
	private Set<Authority> authorities;
	
	@Column(nullable = false)
	private Boolean isAccountExpired;
	
	private Boolean isAccountLocked;
	
	private Boolean isEnabeled;
	
	private Boolean isCredentialsExpired;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities
				.stream()
				.map(auth -> auth.getRole())
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	public String getUserId() {
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !this.isAccountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.isAccountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !this.isCredentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabeled;
	}
}
