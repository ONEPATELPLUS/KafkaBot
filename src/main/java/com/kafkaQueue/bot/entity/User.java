package com.kafkaQueue.bot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "USER",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_number"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
   

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "user_number", nullable = false)
    private Long userNumber;

    @Column(name = "creation_date")
    private Date date;
    
    public User(Long id, Long userNumber, Date date) {
		super();
		this.id = id;
		this.userNumber = userNumber;
		this.date = date;
	}


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
