package com.husain.ppmapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.husain.ppmapi.domain.Project;

@Repository
public interface ProjectRepository  extends CrudRepository<Project, Long>{

}
