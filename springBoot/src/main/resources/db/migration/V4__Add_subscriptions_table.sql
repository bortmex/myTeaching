create table if not exists user_subscriptions_$T (
    channel_id int8 not null references user_$t,
    subscriber_id int8 not null references user_$t,
    primary key (channel_id, subscriber_id)
)