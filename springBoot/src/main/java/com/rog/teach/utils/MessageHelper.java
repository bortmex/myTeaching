package com.rog.teach.utils;

import com.rog.teach.domain.User;

import java.time.LocalDateTime;

import static com.rog.teach.utils.DateUtils.getStrDate;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return (author != null && author.getUsername() != null) ? author.getUsername() : "<none user>";
    }

    public static String getStrDateMessage(LocalDateTime localDateTime) {
        return localDateTime != null ? getStrDate(localDateTime) : "<none date>";
    }
}
