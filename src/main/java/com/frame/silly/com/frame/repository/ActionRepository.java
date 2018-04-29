package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.Action;
import com.frame.silly.com.frame.entity.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.security.PublicKey;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "action", path = "action")
public interface ActionRepository extends PagingAndSortingRepository<Action, Long>{

    public List<Action> findAllByOrderByName();
    public List<Action> findAllByNameContaining(String name);

}
