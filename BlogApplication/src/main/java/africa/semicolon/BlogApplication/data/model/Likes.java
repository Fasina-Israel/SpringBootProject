package africa.semicolon.BlogApplication.data.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Likes {
    private LocalDateTime creationTime;
    private  String emoji;
}
