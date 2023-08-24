package com.commerce.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.Service.IGroupService;
import com.commerce.app.entities.Group;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private IGroupService groupService;
	
	// add group 
	@PostMapping("/")
	public ResponseEntity<Group> addGroup(@RequestBody Group group){
		ResponseEntity<Group> response = new ResponseEntity<Group>(this.groupService.addGroup(group),HttpStatus.CREATED);
				return response;
	}
	
	// get all groups 
	@GetMapping("/")
	public ResponseEntity<List<Group>> getAllGroup(){
		ResponseEntity<List<Group>> response = new ResponseEntity<List<Group>>(this.groupService.getAllGroups(),HttpStatus.OK);
				return response;
	}
	
	//get group by id
	@GetMapping("/{id}")
	public ResponseEntity<Group> addGroup(@PathVariable Integer id){
		ResponseEntity<Group> response = new ResponseEntity<Group>(this.groupService.getGroup(id),HttpStatus.OK);
				return response;
	}
	
	@PutMapping("/")
	public ResponseEntity<Group> updateGroup(@RequestBody Group group){
		ResponseEntity<Group> response = new ResponseEntity<Group>(this.groupService.updateGroup(group),HttpStatus.CREATED);
				return response;
	}
	
}
