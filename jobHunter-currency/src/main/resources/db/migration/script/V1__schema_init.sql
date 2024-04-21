create schema if not exists currencies;

create table if not exists currencies.currency
(
    id           serial unique not null,
    name         varchar(3)    not null unique,
    rate         decimal       not null,
    is_default   boolean       not null,
    is_active    boolean       not null,
    date_updated timestamp(6)  not null,
    primary key (id, name)
);