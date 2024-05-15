create extension if not exists "uuid-ossp";

create schema if not exists auth;

create table if not exists auth.users
(
    id                      UUID unique        not null default uuid_generate_v1(),
    username                varchar(50) unique not null,
    password                varchar(255)       not null,
    enabled                 boolean            not null,
    account_non_expired     boolean            not null,
    account_non_locked      boolean            not null,
    credentials_non_expired boolean            not null,
    primary key (id, username)
);

create table if not exists auth.authorities
(
    id        UUID unique not null default uuid_generate_v1() primary key,
    user_id   UUID        not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (user_id) references auth.users (id)
);

create unique index if not exists ix_auth_username on auth.authorities (user_id, authority);