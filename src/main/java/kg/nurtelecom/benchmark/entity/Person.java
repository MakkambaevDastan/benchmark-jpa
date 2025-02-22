package kg.nurtelecom.benchmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(schema = "public", name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    private UUID personId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "photo", columnDefinition = "BYTEA")
    private byte[] photo;

    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "passport_face", columnDefinition = "BYTEA")
    private byte[] passportFace;

    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "passport_back", columnDefinition = "BYTEA")
    private byte[] passportBack;

    public Person() {
    }

    public Person(UUID personId, String firstName, String lastName, String email, String phone, byte[] photo, byte[] passportFace, byte[] passportBack) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.passportFace = passportFace;
        this.passportBack = passportBack;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPassportFace() {
        return passportFace;
    }

    public void setPassportFace(byte[] passportFace) {
        this.passportFace = passportFace;
    }

    public byte[] getPassportBack() {
        return passportBack;
    }

    public void setPassportBack(byte[] passportBack) {
        this.passportBack = passportBack;
    }
}
