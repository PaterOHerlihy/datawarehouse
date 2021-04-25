package de.pater.datawarehouse.data;


import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.Type;
import org.hibernate.type.TimeZoneType;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Tweet {

	@Id
	@Column(name="t_id")
	@JsonProperty("id")
	@JsonAlias("id")
	private long id;
	
	@JsonProperty("date")
	@JsonAlias("date")
	private Date date;
	
	@JsonProperty("time")
	@JsonAlias("time")
	private Time time;
	
	@JsonProperty("timezone")
	@JsonAlias("timezone")
	private String timezone;
	
	@JsonProperty("place")
	@JsonAlias("place")
	private String place;
	
	@Type(type="text")
	@JsonProperty("tweet")
	@JsonAlias("message")
	private String msg;
	
	@JsonProperty("likes_count")
	@JsonAlias("likes")
	private int likes;
	
	@JsonProperty("retweets_count")
	@JsonAlias("retweets_count")
	private int retweets;
	
	@JsonProperty("replies_count")
	@JsonAlias("replies")
	private int replies;
	
	@ElementCollection
	@OrderColumn(name = "hashtag")
	@JsonProperty("hashtags")
	@JsonAlias("hashtags")
	private String[] hashtags;

	@ManyToOne
	@JoinColumn(name="fk_user")
	private User author;
	
	public int getRetweets() {
		return retweets;
	}

	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}

	public int getReplies() {
		return replies;
	}

	public void setReplies(int replies) {
		this.replies = replies;
	}

	public String[] getHashtags() {
		return hashtags;
	}

	public void setHashtags(String[] hashtags) {
		this.hashtags = hashtags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
	
}
