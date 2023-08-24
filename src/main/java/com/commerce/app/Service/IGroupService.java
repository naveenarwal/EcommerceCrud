package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.Group;

public interface IGroupService {
public Group addGroup(Group group);
    
    public Group updateGroup(Group group);
    
    public boolean deleteGroup(Integer id);
    
    public Group getGroup(Integer id);
    
    public List<Group> getAllGroups();
}
