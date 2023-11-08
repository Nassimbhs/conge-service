package workflow.example.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workflow.example.workflow.entity.Conge;

import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<Conge,Long> {
    List<Conge> findByWorkflow(String workflowId);
}