package controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Workspace;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.WorkspaceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workspace")
@Tag(name = "Workspace", description = "Workspace management APIs")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    @Operation(summary = "Get all Workspaces", description = "Get all workspaces in the system")
    public List<Workspace> getAllWorkspaces(){
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a single workspace", description = "Get a single workspace in the system")
    public Optional<Workspace> getWorkspaceById(@PathVariable Long id){
        return workspaceService.getWorkspaceById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new workspace", description = "Create a new workspace in the system")
    public Workspace createWorkspace(@RequestBody Workspace workspace){
        return workspaceService.createWorkspace(workspace);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Workspace", description = "Update a workspace in the system")
    public Workspace updateWorkspace(@PathVariable Long id, @RequestBody Workspace workspaceDetails){
        return workspaceService.updateWorkspace(id, workspaceDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a workspace", description = "Delete a workspace in the system")
    public Optional<Workspace> deleteWorkspace(@PathVariable Long id){
        return workspaceService.deleteWorkspace(id);
    }
}
