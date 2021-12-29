package africa.semicolon.BlogApplication.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Enumerated
    private Gender gender;
    private String password;
    @Column(unique = true)
    @Email
    private  String email;
    private  LocalDate dob;
    @OneToMany(mappedBy = "owner")
    private List<Post> posts;

    public User() {

    }
}
