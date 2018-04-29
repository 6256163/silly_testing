package com.frame.silly.com.frame.repository;

import com.frame.silly.com.frame.entity.Element;
import com.frame.silly.com.frame.entity.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "element", path = "element")
public interface ElementRepository extends PagingAndSortingRepository<Element, Long> {

    List<Element> findAllByPageOrderByIdDesc(Page page);

    List<Element> findAllByPageId(long pageId);

    List<Element> findAllByOrderByPage();



}
