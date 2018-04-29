package com.frame.silly.com.frame.repository;


import com.frame.silly.com.frame.entity.TestcaseStep;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "testcaseStep", path = "testcaseStep")
public interface TestcaseStepRepository extends PagingAndSortingRepository<TestcaseStep, Long>{

}
