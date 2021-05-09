insert into user_$t (id, username, password, activation_code, active)
    values (1, 'rogov', 'qwer', 'activation', true);

insert into userrole_$t (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');