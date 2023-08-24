package com.commerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.Group;
import com.commerce.app.entities.Stock;

public interface IGroupRepository extends JpaRepository<Group, Integer>{

}
