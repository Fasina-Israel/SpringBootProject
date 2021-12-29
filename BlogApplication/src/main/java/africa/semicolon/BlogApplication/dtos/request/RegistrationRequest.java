package africa.semicolon.BlogApplication.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class RegistrationRequest {
    private String email;
    private String password;
    private LocalDate dob;
}
