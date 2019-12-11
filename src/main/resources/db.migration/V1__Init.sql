create sequence hibernate_sequence
;

create table users
(
  id bigint not null
    constraint users_pkey
    primary key,
  name varchar(255),
  phone varchar(255),
  email varchar(255),
  password varchar(255),
  role_dto varchar(255)
)
;