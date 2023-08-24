package com.commerce.app.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IGroupRepository;
import com.commerce.app.Service.IGroupService;
import com.commerce.app.entities.Group;
import com.commerce.app.entities.GroupVarient;
import com.commerce.app.exception.GroupNotFoundException;

@Service
public class GroupServiceImpl implements IGroupService {
	@Autowired
	  private IGroupRepository groupRepo;

	@Override
	public Group addGroup(Group group) {
		// TODO Auto-generated method stub
		group.setCreatedDate(new Date());
		return this.groupRepo.save(group); 
	}

	@Override
	public Group updateGroup(Group group) {
		// TODO Auto-generated method stub
		Optional<Group> findById = this.groupRepo.findById(group.getGId());
		Group group2 = findById.get();
		List<GroupVarient> groupVarient = group.getGroupVarient();
		groupVarient.addAll(group2.getGroupVarient());
		 group.setGroupVarient(groupVarient);
		
		if(this.groupRepo.existsById(group.getGId())) {
			return this.groupRepo.save(group);
		}else
		throw new GroupNotFoundException("Group Not found "+group.getGId());	
		
		
	}

	@Override
	public boolean deleteGroup(Integer id) {
		// TODO Auto-generated method stub
		if(this.groupRepo.existsById(id)) {
			 this.groupRepo.deleteById(id);
			 return true;
		}
		throw new GroupNotFoundException("Group Not exits");
		
	}

	@Override
	public Group getGroup(Integer id) {
		// TODO Auto-generated method stub
		Optional<Group> group = this.groupRepo.findById(id);
		if(group.isPresent())
			return group.get();
		throw new GroupNotFoundException("Group Not Found");
	}

	@Override
	public List<Group> getAllGroups() {
		// TODO Auto-generated method stub
		return this.groupRepo.findAll();
	}

	
}
