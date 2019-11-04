package com.cg.ems.service;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dto.Project;
import com.cg.ems.exception.WrongIDException;
import com.cg.ems.repo.ProjectRepo;

/**
 * 
 * @author Zeeshan
 *
 */
@Service
@Transactional(rollbackOn = WrongIDException.class)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo repo;

	@Override
	public Project addProject(Project project) {
		return repo.save(project);
	}

	@Override
	public int modifyProject(int projectCode, String projectDescription,Date startDate,Date endDate,String businessUnit, String status) throws WrongIDException  {
		try {
		return repo.modifyProject(projectCode,projectDescription,startDate, endDate, businessUnit, status);
		} catch (Exception e) {
			throw new WrongIDException("Project wtih code "+projectCode+" not found");
		}
		}

	@Override
	public List<Project> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Project searchById(int projectCode) throws WrongIDException {
		try {
			return repo.findById(projectCode).get();
		} catch (Exception e) {
			throw new WrongIDException("No Expense with Project Code " + projectCode + " found");
		}
	}

	@Override
	public Boolean deleteProject(int projectCode) throws WrongIDException {
		try {
			repo.deleteById(projectCode);
			return true;
		} catch (Exception e) {
			throw new WrongIDException("No Project with Project Code " + projectCode + " found");
		}
	}
}
