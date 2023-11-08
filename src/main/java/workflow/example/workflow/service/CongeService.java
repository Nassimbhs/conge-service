package workflow.example.workflow.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import workflow.example.workflow.entity.Conge;
import workflow.example.workflow.repository.CongeRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CongeService {

    private final CongeRepository congeRepository;

    public List<Conge> getAllConge() {
        return congeRepository.findAll();
    }

    public ResponseEntity<Object> addConge(Conge conge) {
        congeRepository.save(conge);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("Conge", conge);
        responseBody.put("message", "Conge successfully created!");
        return ResponseEntity.ok().body(responseBody);
    }
    public List<Conge> findCongeByWorkflowId(String workflowId){
        return congeRepository.findByWorkflow(workflowId);
    }

}