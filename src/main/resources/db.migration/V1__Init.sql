create sequence hibernate_sequence
;

create table if not exists users
(
  id bigint not null
    constraint users_pkey
    primary key,
  company_name varchar(255),
  phone varchar(255),
  email varchar(255),
  password varchar(255),
  role_user varchar(255)
)
;