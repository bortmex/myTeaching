delete from message_$t;

insert into message_$t(id, text, tag, user_id) values
(10000, 'first', 'my-tag', 10000),
(10001, 'second', 'more', 10000),
(10002, 'third', 'my-tag', 10000),
(10003, 'fourth', 'another', 10000);

alter sequence hibernate_sequence restart with 10004;
