package workflow.example.workflow.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workflow.example.workflow.converter.CongeConverter;
import workflow.example.workflow.dto.CongeDto;
import workflow.example.workflow.entity.Conge;
import workflow.example.workflow.service.CongeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Conge")
@Tag(name = "Conge", description = "CRUD Conge")
@CrossOrigin(origins = "http://localhost:4200")
public class CongeController {

    private final CongeService congeService;
    private final CongeConverter congeConverter;

    @GetMapping("/getAllConge/")
    @Operation(
            summary = "Find all Conge",
            description = "Find all Conge.",
            tags = { "Conge" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CongeDto.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<CongeDto> findAll() {
        return congeConverter.entityToDto(congeService.getAllConge());
    }

    @PostMapping("/addConge")
    @Operation(
            summary = "add Conge",
            description = "add Conge.",
            tags = { "Conge" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Conge.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Object> addConge(@RequestBody Conge conge) {
     return congeService.addConge(conge);
    }

    @GetMapping("/findCongeByWorkflowId/{workflowId}")
    @Operation(
            summary = "find conge by workflow",
            description = "find conge by workflowId.",
            tags = { "Conge" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CongeDto.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<CongeDto> findCongeByworkflowId(@PathVariable String workflowId){
        return congeConverter.entityToDto(congeService.findCongeByWorkflowId(workflowId));
    }

}