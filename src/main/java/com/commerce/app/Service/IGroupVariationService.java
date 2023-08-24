package com.commerce.app.Service;

import java.util.List;


import com.commerce.app.entities.GroupVarient;

public interface IGroupVariationService {
	public GroupVarient addGroupVariation(GroupVarient groupVariation);
    
    public GroupVarient updateGroupVariation(GroupVarient groupVariation);
    
    public boolean deleteGroupVariation(Integer id);
    
    public GroupVarient getGroupVariation(Integer id);
    
    public List<GroupVarient> getGroupVariations();
}
