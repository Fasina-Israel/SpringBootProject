package africa.semicolon.BlogApplication.data.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @ManyToOne
    private User owner;
    private LocalDateTime creationTime;
    @Column(length = 1000)
    private String text;
    @Lob
    private List<Comment> comments;
    @Lob
    private List<Likes> likes;
}
