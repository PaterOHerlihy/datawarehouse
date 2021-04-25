package de.pater.datawarehouse.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	@JsonProperty("user_id")
	@JsonAlias("id")
	@Id
	@Column(name="user_id")
	private long id;
	
	@JsonProperty("username")
	@JsonAlias("name")
	private String name;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnore
	public List<Tweet> tweets = new ArrayList<Tweet>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
