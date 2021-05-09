insert into user_$t (id, username, password, active)
    values (1, 'rogov', 'qwer', true);

insert into userrole_$t (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');