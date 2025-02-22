package kg.nurtelecom.benchmark.payload.request;

import java.util.Arrays;

public record PersonRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        byte[] photo,
        byte[] passportFace,
        byte[] passportBack
) {
    @Override
    public String toString() {
        return "PersonRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
