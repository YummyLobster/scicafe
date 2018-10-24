package springrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization implements Serializable {

	@Id
	@GeneratedValue
	private Long organization_id;
	
	@Column(nullable = false)
	private String name;
	
	
	public Long getId() {
		return organization_id;
	}
	
	public void setId(Long organization_id) {
		this.organization_id = organization_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}