package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.Locator;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "by", path = "by")
public interface LocatorRepository extends PagingAndSortingRepository<Locator, Long>{

    public List<Locator> findAllByOrderByIdDesc();

}
