package kg.nurtelecom.benchmark.repository;

import kg.nurtelecom.benchmark.payload.request.PersonRequest;
import kg.nurtelecom.benchmark.repository.jdbcclient.PersonJdbcClientRepository;
import kg.nurtelecom.benchmark.repository.jpa.PersonRepository;
import kg.nurtelecom.benchmark.service.BenchmarkService;
import org.springframework.stereotype.Service;

@Service
public class BenchmarkRepository implements BenchmarkService {

    private final PersonRepository jpaRepository;
    private final PersonJdbcClientRepository jdbcClientRepository;

    public BenchmarkRepository(PersonRepository jpaRepository, PersonJdbcClientRepository jdbcClientRepository) {
        this.jpaRepository = jpaRepository;
        this.jdbcClientRepository = jdbcClientRepository;
    }

    @Override
    public String benchmark(String repository, int size, int count) {
        PersonRequest request = getRequest(size);
        for (int i = 0; i < count; i++) {
            save(repository, request);
        }
        return "saved";
    }

    @Override
    public String benchmark(String repository, int size) {
        PersonRequest request = getRequest(size);
        save(repository, request);
        return "saved";
    }

    @Override
    public String clear() {
        if (jdbcClientRepository.deleteAll() > 0) return "deleted all records";
        throw new RuntimeException("Failed to delete all records");
    }

    private void save(String repository, PersonRequest request) {
        if (repository.equals("jpa")) {
            jpaRepository.save(request);
        } else if (repository.equals("jdbcClient")) {
            jdbcClientRepository.save(request);
        } else {
            throw new RuntimeException("Unknown repository: " + repository);
        }
    }

    private PersonRequest getRequest(int size) {
        byte[] image = new byte[(size / 3) * 1024 * 1024];
        return new PersonRequest(
                "Dastan",
                "Makkambaev",
                "makkambaevdastan@gmail.com",
                "+996777123456",
                image,
                image,
                image
        );
    }
}
