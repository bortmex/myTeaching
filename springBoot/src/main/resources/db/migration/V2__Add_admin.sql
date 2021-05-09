insert into user_$t (id, username, password, active)
    values (10000, 'rogov', 'qwer', true);

insert into userrole_$t (user_id, roles)
    values (10000, 'USER'), (10000, 'ADMIN');