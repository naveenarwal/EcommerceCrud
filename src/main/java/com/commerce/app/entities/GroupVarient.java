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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupVarient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer gvId;
  
	private String vName;
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name="group_id")
	private Group group;
	
  
}
