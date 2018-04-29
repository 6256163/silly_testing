package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.ActionStep;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "actionStep", path = "actionStep")
public interface ActionStepRepository extends PagingAndSortingRepository<ActionStep, Long>{

//    public List<Step> findByAction_IdOrderBySort(Long actionId);

}
