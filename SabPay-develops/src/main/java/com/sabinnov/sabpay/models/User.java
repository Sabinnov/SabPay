package com.sabinnov.sabpay.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //exepmle de property qui sera controller par swagger avant validation de la requete
    @ApiModelProperty(notes = "The database generated user ID")
    private Integer id;
    
    private String active;

    @ApiModelProperty(notes = "The email of user", required = true)
    private String email;
    
    private String lastname;
    
    private String name;
    
    private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
        public String getActive() {
            return active;
        }


        public void setActive(String active) {
            this.active = active;
        }

        public String getLastname() {
            return lastname;
        }


        public void setLastname(String lastname) {
            this.lastname = lastname;
        }


        public String getPassword() {
            return password;
        }


        public void setPassword(String password) {
            this.password = password;
        }


}