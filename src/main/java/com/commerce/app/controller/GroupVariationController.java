package com.commerce.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.Service.IGroupService;
import com.commerce.app.Service.IGroupVariationService;
import com.commerce.app.entities.Group;
import com.commerce.app.entities.GroupVarient;

@RestController
@RequestMapping("/groupVarient")
public class GroupVariationController {

	@Autowired
	private IGroupVariationService groupVariationService;
	
	@PostMapping("/")
	public ResponseEntity<GroupVarient> addGroup(@RequestBody GroupVarient groupVarient){
		ResponseEntity<GroupVarient> response = new ResponseEntity<GroupVarient>(this.groupVariationService.addGroupVariation(groupVarient),HttpStatus.CREATED);
				return response;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<GroupVarient>> getAllGroupVarient(){
		ResponseEntity<List<GroupVarient>> response = new ResponseEntity<List<GroupVarient>>(this.groupVariationService.getGroupVariations(),HttpStatus.OK);
				return response;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<GroupVarient> getGroupVarient(@PathVariable Integer id){
		ResponseEntity<GroupVarient> response = new ResponseEntity<GroupVarient>(this.groupVariationService.getGroupVariation(id),HttpStatus.OK);
				return response;
	}
	
	@PutMapping("/update/")
	public ResponseEntity<GroupVarient> updateGroupVarient(@RequestBody GroupVarient groupVarient){
		ResponseEntity<GroupVarient> response = new ResponseEntity<GroupVarient>(this.groupVariationService.updateGroupVariation(groupVarient),HttpStatus.OK);
				return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGroupVarient(@PathVariable Integer id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.groupVariationService.deleteGroupVariation(id)+"Group varient delete ID : "+id,HttpStatus.OK);
				return response;
	}
}
