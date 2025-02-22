package kg.nurtelecom.benchmark.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.UUID;
import kg.nurtelecom.benchmark.entity.Person;
import kg.nurtelecom.benchmark.payload.request.PersonRequest;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
    private final PersonJpa personJpa;
    @PersistenceContext
    private final EntityManager entityManager;
    private int count;

    public PersonRepository(PersonJpa personJpa, EntityManager entityManager) {
        this.personJpa = personJpa;
        this.entityManager = entityManager;
    }
    @Transactional
    public Person save(PersonRequest request) {
        count++;
        Person person = new Person(
                UUID.randomUUID(),
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone(),
                request.photo(),
                request.passportFace(),
                request.passportBack());
        if (count == 10) {
            clear();
            count = 0;
        }
        return personJpa.save(person);
    }

    private void clear() {
        entityManager.flush();
        entityManager.clear();
        SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
        sessionFactory.getCache().evictEntityData(Person.class);
        sessionFactory.getCache().evictQueryRegions();
        sessionFactory.close();
    }
}
