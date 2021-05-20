delete from userrole_$t;
delete from user_$t;

insert into user_$t(id, active, password, activation_code, username) values
(10000, true, '$2a$08$e/rR2Hep1PrIWwqW4vm4OufDq9C52dwFHGTA/Zlks/8FklzEe73gi', 'null', 'rogov'),
(10001, true, '$2a$08$e/rR2Hep1PrIWwqW4vm4OufDq9C52dwFHGTA/Zlks/8FklzEe73gi', 'null', 'mike');

insert into userrole_$t(user_id, roles) values
(10000, 'USER'), (10000, 'ADMIN'),
(10001, 'USER');