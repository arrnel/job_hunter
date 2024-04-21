create schema if not exists geo;

create table if not exists geo.country
(
    id   serial unique not null,
    name varchar(255)  not null unique,
    primary key (id, name)
);

create table if not exists geo.region
(
    id         serial unique not null,
    country_id serial        not null,
    name       varchar(255)  not null,
    primary key (id, name)
);

create table if not exists geo.city
(
    id         serial unique not null,
    country_id serial        not null,
    region_id  serial,
    name       varchar(255)  not null,
    city_type  varchar,
    population bigint
);

alter table geo.region
    add constraint region__country__fk
        foreign key (country_id) references geo.country (id);

alter table geo.city
    add constraint city__country__fk
        foreign key (country_id) references geo.country (id);

alter table geo.city
    add constraint city__region__fk
        foreign key (region_id) references geo.region (id);