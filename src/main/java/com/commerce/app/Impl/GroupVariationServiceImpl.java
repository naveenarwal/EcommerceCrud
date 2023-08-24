package com.commerce.app.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IGroupRepository;
import com.commerce.app.Repository.IGroupVarientsRepository;
import com.commerce.app.Service.IGroupService;
import com.commerce.app.Service.IGroupVariationService;
import com.commerce.app.entities.Group;
import com.commerce.app.entities.GroupVarient;
import com.commerce.app.exception.GroupNotFoundException;
import com.commerce.app.exception.GroupVariationNotFoundException;

@Service
public class GroupVariationServiceImpl  implements IGroupVariationService{
  @Autowired
  private IGroupVarientsRepository groupVaritationRepo;

@Override
public GroupVarient addGroupVariation(GroupVarient groupVariation) {
	// TODO Auto-generated method stub
	return this.groupVaritationRepo.save(groupVariation);
}

@Override
public GroupVarient updateGroupVariation(GroupVarient groupVariation) {
	// TODO Auto-generated method stub
	
	if(this.groupVaritationRepo.existsById(groupVariation.getGvId()))
		return this.groupVaritationRepo.save(groupVariation);
	 
	throw new GroupVariationNotFoundException("Group varition Not Found");
	
}

@Override
public boolean deleteGroupVariation(Integer id) {
	// TODO Auto-generated method stub
	if(this.groupVaritationRepo.existsById(id))
	{
		this.groupVaritationRepo.deleteById(id);
		return true;
	}
	throw new GroupVariationNotFoundException("Group Variation Not found ");
	
}

@Override
public GroupVarient getGroupVariation(Integer id) {
	// TODO Auto-generated method stub
	Optional<GroupVarient> groupVarient = this.groupVaritationRepo.findById(id);
	  if(groupVarient.isPresent())
		  return groupVarient.get();
	
	  throw new GroupVariationNotFoundException("Group Variation Not found ");
}

@Override
public List<GroupVarient> getGroupVariations() {
	// TODO Auto-generated method stub
	
	
	return this.groupVaritationRepo.findAll();
}

  
}
