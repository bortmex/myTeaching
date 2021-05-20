create extension pgcrypto;

update user_$t set password = crypt(password, gen_salt('bf', 8));