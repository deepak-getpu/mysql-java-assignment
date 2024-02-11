package projects.services;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbExceptionn;

public class ProjectService {
	
	ProjectDao projectDao = new ProjectDao();

	public Project addProject(Project project) {
		
		return projectDao.insertProject(project);
		
	}

	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}
	
	
//	Optional<Project> op = projectDao.fetchProjectById(projectId);
	
	public Project fetchProjectById(Integer projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
				"Project with project ID=" + projectId + "does not exist."));
	}

	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbExceptionn("Project with ID=" + project.getProjectId() + " does not exist.");
		}	
	}

	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			throw new DbExceptionn("Project with ID=" + projectId + " does not exist.");
		}	
	}
	

}
