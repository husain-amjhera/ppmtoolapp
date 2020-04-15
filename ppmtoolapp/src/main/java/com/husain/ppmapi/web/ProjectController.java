package com.husain.ppmapi.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husain.ppmapi.domain.Project;
import com.husain.ppmapi.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
		if(result.hasErrors()) {
			
			Map<String, String> errorMap= new HashMap<>();
			for(FieldError fieldError : result.getFieldErrors()) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<String>("Project Object has Error", HttpStatus.BAD_REQUEST);
		}
		Project proj =projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(proj, HttpStatus.CREATED);
	}
	

}
