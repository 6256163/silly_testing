package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.Testcase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "testcase", path = "testcase")
public interface TestcaseRepository extends PagingAndSortingRepository<Testcase, Long>{

    public List<Testcase> findAllByOrderByTcId();
    public List<Testcase> findAllByTcIdContaining(String name);
    public List<Testcase> findAllByScenarioId(long scenarioId);


}
