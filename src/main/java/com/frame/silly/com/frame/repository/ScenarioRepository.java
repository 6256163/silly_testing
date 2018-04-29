package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.Feature;
import com.frame.silly.com.frame.entity.Scenario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "scenario", path = "scenario")
public interface ScenarioRepository extends PagingAndSortingRepository<Scenario, Long>{

    public List<Scenario> findAllByOrderByCodeAsc();
    public List<Scenario> findAllByNameContaining(String name);
    public List<Scenario> findAllByFeatureId(Long featureId);



}
