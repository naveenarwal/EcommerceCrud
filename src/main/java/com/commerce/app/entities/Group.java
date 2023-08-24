package com.commerce.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "`group`")
public class Group {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer gId;
	
	private String groupName;
	
	private Date createdDate;
	
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
 @JsonIgnoreProperties(value = {"group"})
	 @JoinColumn(name="group_id")
	private List<GroupVarient> groupVarient;
}
