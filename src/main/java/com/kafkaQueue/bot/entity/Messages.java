package com.kafkaQueue.bot.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "messages",uniqueConstraints = {@UniqueConstraint(columnNames = {"message_id"})})
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

	@Column(name = "message_id")
	@NotNull
    protected Long messageId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "message")
    private String message;
    
    public Messages() {


	}

	public Messages(Long id, Long messageId, User user, String message) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.user = user;
		this.message = message;
	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
