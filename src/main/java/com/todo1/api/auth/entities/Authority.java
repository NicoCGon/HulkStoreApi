package com.todo1.api.auth.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Authority")
public class Authority  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id")
    private Integer id;
    @Column(name = "authority")
    private String authority;
    @ManyToMany(mappedBy = "authorities")
    private List<User> user;

    public Authority(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

}
