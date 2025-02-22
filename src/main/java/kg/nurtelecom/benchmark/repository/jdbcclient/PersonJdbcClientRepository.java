package kg.nurtelecom.benchmark.repository.jdbcclient;

import java.util.UUID;
import kg.nurtelecom.benchmark.payload.request.PersonRequest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcClientRepository {
    private final JdbcClient jdbcClient;

    public PersonJdbcClientRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public boolean save(PersonRequest request) {
        String sql = "INSERT INTO person (person_id, first_name, last_name, email, phone, photo, passport_face, passport_back) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return 0 < jdbcClient.sql(sql)
                .param(UUID.randomUUID())
                .param(request.firstName())
                .param(request.lastName())
                .param(request.email())
                .param(request.phone())
                .param(request.photo())
                .param(request.passportFace())
                .param(request.passportBack())
                .update();
    }

    public int deleteAll() {
       return jdbcClient.sql("DELETE FROM person").update();
    }
}
