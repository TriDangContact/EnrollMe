# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table address (
  id                            integer auto_increment not null,
  street                        varchar(255),
  city                          varchar(255),
  state                         varchar(255),
  country                       varchar(255),
  zip                           integer not null,
  constraint pk_address primary key (id)
);

create table user (
  id                            integer auto_increment not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  email                         varchar(255),
  phone                         varchar(255),
  password                      varchar(255),
  address_id                    integer,
  constraint pk_user primary key (id)
);

create index ix_user_address_id on user (address_id);
alter table user add constraint fk_user_address_id foreign key (address_id) references address (id) on delete restrict on update restrict;


# --- !Downs

alter table user drop foreign key fk_user_address_id;
drop index ix_user_address_id on user;

drop table if exists address;

drop table if exists user;

