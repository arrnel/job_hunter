create schema if not exists profiles;

create table if not exists profiles.user_profile_status
(
    id   serial,
    name varchar(255) not null unique,
    primary key (id)
);

create table if not exists profiles.user_profile
(
    id                    bigserial,
    user_id               bigint       not null,
    email                 varchar(255) not null,
    first_name            varchar(255) not null,
    last_name             varchar(255) not null,
    position              varchar(255) not null,
    description           text         not null,
    birth_date            date,
    is_birth_date_visible boolean,
    city_id               integer,
    avatar_id             bigint,
    status_id             serial       not null,
    date_created          timestamp(3) not null,
    date_updated          timestamp(3),
    primary key (id)
);

create table if not exists profiles.course
(
    id              bigserial,
    user_profile_id bigint,
    user_id         bigint       not null,
    company_id      bigint       not null,
    company_name    varchar(255) not null,
    position        varchar(255) not null,
    description     text         not null,
    date_from       date         not null,
    date_to         date         not null,
    date_created    timestamp(3) not null,
    date_updated    timestamp(3),
    primary key (id)
);

create table if not exists profiles.education
(
    id              bigserial,
    user_profile_id bigint,
    user_id         bigint       not null,
    company_id      bigint       not null,
    company_name    varchar(255) not null,
    position        varchar(255) not null,
    description     text         not null,
    date_from       date         not null,
    date_to         date         not null,
    date_created    timestamp(3) not null,
    date_updated    timestamp(3),
    primary key (id)
);

create table if not exists profiles.experience
(
    id              bigserial,
    user_profile_id bigint,
    user_id         bigint       not null,
    company_id      bigint,
    company_name    varchar(255) not null,
    position        varchar(255) not null,
    description     text         not null,
    date_from       date         not null,
    date_to         date         not null,
    date_created    timestamp(3) not null,
    date_updated    timestamp(3),
    primary key (id)
);

alter table profiles.user_profile
    add constraint user_profile__user_profile_status__fk
        foreign key (status_id) references profiles.user_profile_status (id);

alter table profiles.experience
    add constraint experience__user_profile__fk
        foreign key (user_profile_id) references profiles.user_profile (id);

alter table profiles.course
    add constraint course__user_profile__fk
        foreign key (user_profile_id) references profiles.user_profile (id);

alter table profiles.education
    add constraint education__user_profile__fk
        foreign key (user_profile_id) references profiles.user_profile (id);


delete
from profiles.user_profile_status;
insert into profiles.user_profile_status(name)
values ('PUBLIC');
insert into profiles.user_profile_status(name)
values ('PRIVATE');
