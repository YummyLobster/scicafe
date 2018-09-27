package springrest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "reward")
public class Reward implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String provider;
    
    @Column(nullable = false)
    private Date start_date;
    
    @Column(nullable = false)
    private Date end_date;
  
    @Column(nullable = true)
    private String status;
    
    @Column(nullable = true)
    private String qualified_events;
    
    @Column(nullable = true)
    private String reward_criteria;

    
    public Reward()
    {
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getQualified_events() {
		return qualified_events;
	}


	public void setQualified_events(String qualified_events) {
		this.qualified_events = qualified_events;
	}


	public String getReward_criteria() {
		return reward_criteria;
	}


	public void setReward_criteria(String reward_criteria) {
		this.reward_criteria = reward_criteria;
	}


}