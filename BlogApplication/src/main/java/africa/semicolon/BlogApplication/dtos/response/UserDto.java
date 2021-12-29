package africa.semicolon.BlogApplication.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
public class UserDto {
    private String email;
    private LocalDate dob;
    private Long id;
}
