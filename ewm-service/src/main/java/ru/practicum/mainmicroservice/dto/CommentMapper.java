package ru.practicum.mainmicroservice.dto;

import lombok.experimental.UtilityClass;
import ru.practicum.mainmicroservice.model.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class CommentMapper {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public CommentDto toCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .authorName(comment.getUser().getName())
                .created(comment.getCreated().format(dateTimeFormatter))
                .build();
    }

    public Comment toComment(CommentDto commentDto) {
        return Comment.builder()
                .text(commentDto.getText())
                .created(LocalDateTime.now())
                .build();
    }

}
