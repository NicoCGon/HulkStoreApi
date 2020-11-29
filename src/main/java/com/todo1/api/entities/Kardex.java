package com.todo1.api.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Kardex")
public class Kardex {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kardex_id")
	private Integer id;
    @NotNull
    @Column(name = "kardex_counter")
    private BigInteger counter;
    
}
