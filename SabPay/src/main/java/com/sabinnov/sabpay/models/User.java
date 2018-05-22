package com.sabinnov.sabpay.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @Column(name = "telephone")
    @ApiModelProperty(notes = "User telephone", required = true)
    private String telephone;

    @Column(name = "lastname")
    @ApiModelProperty(notes = "User last name", required = true)
    private String lastname;

    @Column(name = "name")
    @ApiModelProperty(notes = "User last name", required = true)
    private String name;

    @Column(name = "password")
    @ApiModelProperty(notes = "User last password", required = true, dataType = "password")
    private String password;
    
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

        public Date getCreatedAt() {
            return createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
        
        

        
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", active='" + active + '\'' +
                ", telephone='" + telephone + '\'' +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}