package com.mapping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="st4_seq")
	@SequenceGenerator(name="st4_seq",sequenceName="review_seq",allocationSize=1,initialValue=1)
	private int id;
	@Column(name="comments")
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Review( String comments) {
		super();
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", comments=" + comments + "]";
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
