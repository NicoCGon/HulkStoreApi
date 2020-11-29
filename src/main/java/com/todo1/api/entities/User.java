package com.todo1.api.entities;

import java.util.Set;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author Nicolas Gonzalez 
* 
*/ 

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor 
@Entity
@Table(name = "User")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
	private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
	private String password;
    @Column(name = "enabled")
    private boolean enabled;
	
    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "FK_User", nullable = false, referencedColumnName = "user_id"), 
    									inverseJoinColumns = @JoinColumn(name="FK_Authority", nullable = false, referencedColumnName = "authority_id"))
    private Set<Authority> authorities;
   
    
}
