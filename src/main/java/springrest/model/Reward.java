package springrest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "reward")
public class Reward implements Serializable {


    @Id
    @GeneratedValue
    private Long reward_id;

    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String provider;
    
    @Column(nullable = false)
    private Date start_date;
    
    @Column(nullable = false)
    private Date end_date;
  
    @Enumerated(EnumType.STRING)
	private Status status;
    
    
    private Integer reward_criteria;
    
    @ManyToMany
    @JoinTable(name = "use_tags",
        joinColumns = @JoinColumn(name = "reward_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tags> tags;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch=FetchType.LAZY)
    @JoinTable(name = "eventsToReward", joinColumns = { @JoinColumn(name = "reward_id") }, inverseJoinColumns = { @JoinColumn(name = "event_id") })
    Set<Event> events;
    

    public Reward() {
    	
    }
    public Reward(Long reward_id, String description)
    {
    	this.reward_id = reward_id;
		this.description = description;
    }


	public Long getId() {
		return reward_id;
	}
	public enum Status{SUBMMITED,POSTED,REJECTED }

	public void setId(Long reward_id) {
		this.reward_id = reward_id;
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



	public Integer getReward_criteria() {
		return reward_criteria;
	}


	public void setReward_criteria(Integer reward_criteria) {
		this.reward_criteria = reward_criteria;
	}


}