package se.alex.lexicon.g51todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.alex.lexicon.g51todoapi.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
