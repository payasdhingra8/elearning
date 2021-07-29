package com.amdocs.training.model;

public class Feedback {


	private Long userId;
	private String username;
	private String email;
	private Long feedbackId;
	private String feedback;
	
	public Feedback( Long userId, String username, String email, Long feedbackId, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.feedback = feedback;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", userId=" + userId + ", username=" + username + ", email="
				+ email + ", feedback=" + feedback + "]";
	}

	
	
	
	
	
}
