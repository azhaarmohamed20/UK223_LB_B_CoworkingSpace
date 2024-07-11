package controller;

import model.Workspace;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.WorkspaceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public List<Workspace> getAllWorkspaces(){
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public Optional<Workspace> getWorkspaceById(@PathVariable Long id){
        return workspaceService.getWorkspaceById(id);
    }

    @PostMapping
    public Workspace createWorkspace(@RequestBody Workspace workspace){
        return workspaceService.createWorkspace(workspace);
    }

    @PutMapping("/{id}")
    public Workspace updateWorkspace(@PathVariable Long id, @RequestBody Workspace workspaceDetails){
        return workspaceService.updateWorkspace(id, workspaceDetails);
    }

    @DeleteMapping("/{id}")
    public Optional<Workspace> deleteWorkspace(@PathVariable Long id){
        return workspaceService.deleteWorkspace(id);
    }
}
