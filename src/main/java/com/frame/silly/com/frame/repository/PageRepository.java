package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "page", path = "page")
public interface PageRepository extends PagingAndSortingRepository<Page, Long>{

    public List<Page> findAllByOrderByIdDesc();
    public List<Page> findAllByNameContaining(String name);

}
