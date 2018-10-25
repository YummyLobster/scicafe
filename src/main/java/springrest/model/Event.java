package springrest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "events")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String location;
    
    @Column(nullable = false)
    private Date start_date;
    
    @Column(nullable = false)
    private Date end_date;
  
    @Enumerated(EnumType.STRING)
	private Status status;

    
    @OneToMany
    @JoinTable(name = "events_attendance",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "events_id"))
    Set<User> events_attendance;
    
    @ManyToMany
    @JoinTable(name = "use_tags",
        joinColumns = @JoinColumn(name = "events_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tags> tags;
    
    
    public Event()
    {
    	tags = new HashSet<Tags>();
    }
    public Event(Long id, String title, String description, String location, Date start_date, Date end_date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
	}

    public enum Status{SUBMITTED,POSTED,REJECTED }
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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


	

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Set<User> getEvents_attendance() {
		return events_attendance;
	}

	public void setEvents_attendance(Set<User> events_attendance) {
		this.events_attendance = events_attendance;
	}


	public Set<Tags> getTags() {
		return tags;
	}


	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}


}