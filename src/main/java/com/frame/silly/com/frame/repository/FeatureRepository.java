package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.Feature;
import com.frame.silly.com.frame.entity.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "feature", path = "feature")
public interface FeatureRepository extends PagingAndSortingRepository<Feature, Long>{

    public List<Feature> findAllByOrderByCodeAsc();
    public List<Feature> findAllByNameContaining(String name);

}
