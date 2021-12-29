package africa.semicolon.BlogApplication.data.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Comment {
    private Long id;
    private String owner;
    private LocalDateTime creationTime;
    private String text;
    private List<Likes> likes;
    private List<Comment> comments;
}
