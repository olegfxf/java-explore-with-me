package ru.practicum.mainmicroservice.controller.priv;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainmicroservice.dto.CommentDto;
import ru.practicum.mainmicroservice.messages.LogMessages;
import ru.practicum.mainmicroservice.service.priv.PrivateUserCommentService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/users/{userId}/comments")
@Validated
@RequiredArgsConstructor
public class PrivateUserCommentController {

    private final PrivateUserCommentService privateUserCommentService;


    @PostMapping("/{eventId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto saveComment(@PositiveOrZero @PathVariable Long userId,
                                  @PositiveOrZero @PathVariable Long eventId,
                                  @Valid @RequestBody CommentDto commentDto) {

        log.debug(String.valueOf(LogMessages.TRY_ADD), "КОММЕНТАРИЙ");
        return privateUserCommentService.saveComment(userId, eventId, commentDto);
    }


    @GetMapping("/events/{eventId}")
    public List<CommentDto> getAllCommentsByUser(@Positive @PathVariable Long userId,
                                                 @RequestParam(defaultValue = "0") int from,
                                                 @RequestParam(defaultValue = "10") int size) {

        log.debug(String.valueOf(LogMessages.TRY_GET_ALL), "КОММЕНТАРИИ ПОЛЬЗОВАТЕЛЯ");
        return privateUserCommentService.getAllCommentsByUser(userId, from, size);
    }


    @PatchMapping("/{commentId}")
    public CommentDto updateComment(@PositiveOrZero @PathVariable Long commentId,
                                    @PositiveOrZero @PathVariable Long userId,
                                    @Valid @RequestBody CommentDto commentDto) {

        log.debug(String.valueOf(LogMessages.TRY_UPDATE), "КОММЕНТАРИЙ");
        return privateUserCommentService.updateComment(commentId, userId, commentDto);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PositiveOrZero @PathVariable Long userId,
                              @PositiveOrZero @PathVariable Long commentId) {

        log.debug(String.valueOf(LogMessages.TRY_REMOVE_OBJECT), "КОММЕНТАРИЙ");
        privateUserCommentService.deleteComment(commentId, userId);
    }


}
