package service;

import model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.WorkspaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {


    private WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public List<Workspace> getAllWorkspaces(){
        return workspaceRepository.findAll();
    }

    public Optional<Workspace> getWorkspaceById(Long id){
        return workspaceRepository.findById(id);
    }

    public Workspace createWorkspace(Workspace workspace){
        return workspaceRepository.save(workspace);
    }

    public Workspace updateWorkspace(Long id, Workspace workspaceDetails){
        Workspace workspace = workspaceRepository.findById(id).orElseThrow(() -> new RuntimeException("Workspace not found"));
        workspace.setLocation(workspaceDetails.getLocation());
        workspace.setAvailability(workspaceDetails.isAvailability());
        return workspaceRepository.save(workspace);
    }

    public Optional<Workspace> deleteWorkspace(Long id){
        Optional<Workspace> workspace = workspaceRepository.findById(id);
        if(workspace.isPresent()){
            workspaceRepository.deleteById(id);
        }
        return workspace;
    }

}
