package com.rog.teach.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import static com.rog.teach.utils.DateUtils.getStrDate;


@Data
@Entity
@NoArgsConstructor
@Table(name = "Message_$T")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Заполните поле")
    @Length(max = 2048, message = "Сообщение слишком большое (больше 2кб)")
    private String text;
    @Length(max = 255, message = "Тэг слишком большой (более 255 байт)")
    private String tag;
    private LocalDateTime dateMessage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @Column(length = 65535)
    private String file;

    public Message(String text, String tag, LocalDateTime date, User user) {
        this.text = text;
        this.tag = tag;
        this.dateMessage = date;
        this.author = user;
    }

    public String getAuthorName() {
        return (author != null && author.getUsername() != null) ? author.getUsername() : "<none user>";
    }

    public String getStrDateMessage() {
        return dateMessage != null ? getStrDate(dateMessage) : "<none date>";
    }

}
