create extension if not exists "uuid-ossp";

create schema if not exists currencies;

create table if not exists currencies.currency
(
    id           serial unique not null default uuid_generate_v1(),
    name         varchar(3)  not null unique,
    rate         decimal     not null,
    is_default   boolean     not null,
    is_active    boolean     not null,
    date_updated boolean     not null,
    primary key (id, name)
);