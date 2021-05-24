package com.rog.teach.domain.dto;

import com.rog.teach.domain.Message;
import com.rog.teach.domain.User;
import com.rog.teach.utils.MessageHelper;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(of = {"id", "author", "likes", "meLiked"})
public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String file;
    private Long likes;
    private Boolean meLiked;
    private LocalDateTime dateMessage;

    public MessageDto(Message message, Long likes, Boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.dateMessage = message.getDateMessage();
        this.file = message.getFile();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }

    public String getStrDateMessage() {
        return MessageHelper.getStrDateMessage(dateMessage);
    }
}
