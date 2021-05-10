insert into user_$t (id, username, password, activation_code, active)
    values (10000, 'rogov', 'qwer', 'null', true);

insert into userrole_$t (user_id, roles)
    values (10000, 'USER'), (10000, 'ADMIN');