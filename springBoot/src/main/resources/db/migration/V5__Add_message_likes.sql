create table Message_likes_$T (
    user_id    bigint not null references user_$t,
    message_id bigint not null references message_$t,
    primary key (user_id, message_id)
)