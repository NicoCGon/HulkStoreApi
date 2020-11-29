package com.todo1.api.auth.entities;

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

import com.sun.istack.NotNull;

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
    @NotNull
    @Column(name = "user_email")
    private String email;
    @NotNull
    @Column(name = "user_password")
	private String password;
    @Column(name = "user_enabled")
    private boolean enabled;
    @NotNull
    @Column(name = "user_dni")
    private Integer dni;
    @NotNull
    @Column(name = "user_name")
    private String name;
    @NotNull
    @Column(name = "user_last_name")
    private String lastName;
    @NotNull
    @Column(name = "user_age")
    private Integer age;
	
    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities;
    
}
