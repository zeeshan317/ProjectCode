package com.cg.ems.service;

import java.sql.Date;
import java.util.List;

import com.cg.ems.dto.Project;
import com.cg.ems.exception.WrongIDException;
/**
 * 
 * @author zeeshan
 *
 */
public interface ProjectService {

	Project addProject(Project project);
	
	
	List<Project> fetchAll();
	
	Project searchById(int projectCode) throws WrongIDException;
	
	Boolean deleteProject(int projectCode) throws WrongIDException;

	int modifyProject(int projectCode, String projectDescription, Date startDate, Date endDate, String businessUnit,
			String status) throws WrongIDException;


}
