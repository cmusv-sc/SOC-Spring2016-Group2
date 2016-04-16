# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table person (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  due_date                      datetime(6),
  constraint pk_person primary key (id)
);

create table publication (
  id                            bigint auto_increment not null,
  pubkey                        varchar(255),
  title                         varchar(255),
  editor                        varchar(255),
  year                          varchar(255),
  isbn                          varchar(255),
  url                           varchar(255),
  volume                        varchar(255),
  pages                         varchar(255),
  mdate                         varchar(255),
  series                        varchar(255),
  publisher                     varchar(255),
  booktitle                     varchar(255),
  crossref                      varchar(255),
  ee                            varchar(255),
  constraint pk_publication primary key (id)
);

create table publication_author (
  id                            bigint auto_increment not null,
  publication_id                bigint,
  author_id                     bigint,
  constraint pk_publication_author primary key (id)
);

create table search (
  id                            bigint auto_increment not null,
  keywords                      varchar(255),
  search_type                   varchar(255),
  constraint pk_search primary key (id)
);


# --- !Downs

drop table if exists author;

drop table if exists person;

drop table if exists publication;

drop table if exists publication_author;

drop table if exists search;

