create schema if not exists jobs;
create schema if not exists categories;

create table if not exists jobs.job
(
    id                            bigserial,
    company                       bigint         not null,
    name                          varchar(255)   not null,
    description                   text           not null,
    min_price                     decimal(19, 2) not null,
    min_price_in_default_currency decimal(19, 2) not null,
    max_price                     decimal(19, 2) not null,
    max_price_in_default_currency decimal(19, 2) not null,
    currency                      varchar(3)     not null,
    price_type                    int            not null,
--     job_type                      int[]          not null,
    city                          int            not null,
    region                        int,
    country                       int            not null,
--     industries                    int[]          not null,
--     specializations               int[]          not null,
    date_created                  timestamp(3)   not null,
    date_updated                  timestamp(3),
    primary key (id)

);

create table if not exists jobs.job_type
(
    id   serial       not null,
    name varchar(255) not null unique,
    primary key (id)
);

create table if not exists jobs.price_type
(
    id   serial       not null,
    name varchar(255) not null unique,
    primary key (id)
);

create table if not exists jobs.job_job_type
(
    job_id      bigint not null,
    job_type_id bigint not null,
    primary key (job_id, job_type_id),
    foreign key (job_id) references jobs.job (id),
    foreign key (job_type_id) references jobs.job_type (id)
);

create table if not exists categories.industry_category
(
    id   serial unique not null,
    name varchar(255)  not null unique,
    primary key (id)
);

create table if not exists categories.industry_subcategory
(
    id       serial unique not null,
    name     varchar(255)  not null,
    category int           not null,
    primary key (id)
);

create table if not exists jobs.job_industry_subcategory
(
    job_id         bigint not null,
    subcategory_id int    not null,
    primary key (job_id, subcategory_id)
);

create table if not exists categories.specialization_category
(
    id   serial unique not null,
    name varchar(255)  not null unique,
    primary key (id)
);

create table if not exists categories.specialization_subcategory
(
    id       serial unique not null,
    name     varchar(255)  not null,
    category int           not null,
    primary key (id)
);

create table if not exists jobs.job_specialization_subcategory
(
    job_id         bigint not null,
    subcategory_id int    not null,
    primary key (job_id, subcategory_id)
);

alter table jobs.job
    add constraint job__price_type__fk
        foreign key (price_type) references jobs.price_type (id);

alter table jobs.job_job_type
    add constraint job_job_type__job__fk
        foreign key (job_id) references jobs.job (id);

alter table jobs.job_job_type
    add constraint job_job_type__job_type__fk
        foreign key (job_type_id) references jobs.job_type (id);

alter table categories.industry_subcategory
    add constraint industry_subcategory__industry_category__fk
        foreign key (category) references categories.industry_category (id);

alter table categories.specialization_subcategory
    add constraint specialization_subcategory__specialization_category__fk
        foreign key (category) references categories.specialization_category (id);

alter table jobs.job_industry_subcategory
    add constraint job_industry_subcategory__job__fk
        foreign key (job_id) references jobs.job (id);

alter table jobs.job_industry_subcategory
    add constraint job_industry_subcategory__industry_subcategory__fk
        foreign key (subcategory_id) references categories.industry_subcategory (id);

alter table jobs.job_specialization_subcategory
    add constraint job_specialization_subcategory__job__fk
        foreign key (job_id) references jobs.job (id);

alter table jobs.job_specialization_subcategory
    add constraint job_specialization_subcategory__specialization_subcategory_fk
        foreign key (subcategory_id) references categories.specialization_subcategory (id);

-- alter table jobs.job
--     add constraint job__industry_subcategory__fk
--         foreign key (industries) references categories.industry_subcategory (id);
--
-- alter table jobs.job
--     add constraint job__specialization_subcategory__fk
--         foreign key (specializations) references categories.specialization_subcategory (id);

delete
from jobs.job_type;
insert into jobs.job_type(name)
values ('OFFICE');
insert into jobs.job_type(name)
values ('REMOTE');
insert into jobs.job_type(name)
values ('HYBRID');

delete
from jobs.price_type;
insert into jobs.price_type(name)
values ('BEFORE_TAXES');
insert into jobs.price_type(name)
values ('AFTER_TAX');
