package com.sabinnov.sabpay.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer id;

    @Column(length = 255, nullable = false, columnDefinition = "ROLE_USER")
    @ApiModelProperty(hidden = true, readOnly = true)
    private Integer active;

    @Column(name = "email")
    @ApiModelProperty(notes = "User email", required = true, dataType = "email")
    private String email;

    @Column(name = "lastname")
    @ApiModelProperty(notes = "User last name", required = true)
    private String lastname;

    @Column(name = "name")
    @ApiModelProperty(notes = "User last name", required = true)
    private String name;

    @Column(name = "password")
    @ApiModelProperty(notes = "User last password", required = true, dataType = "password")
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


        public Integer getActive() {
            return active;
        }


        public void setActive(Integer active) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", active='" + active + '\'' +
                ", email='" + email + '\'' +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}