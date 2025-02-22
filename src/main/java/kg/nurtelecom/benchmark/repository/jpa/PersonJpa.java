package kg.nurtelecom.benchmark.repository.jpa;

import java.util.UUID;
import kg.nurtelecom.benchmark.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpa extends JpaRepository<Person, UUID> {
}
