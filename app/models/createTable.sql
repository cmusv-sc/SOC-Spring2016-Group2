drop database if exists ssnetwork;

create database ssnetwork;

use ssnetwork;

create table author (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (id)
);

create table person (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  due_date                      datetime,
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

create table comment (
  id                        bigint auto_increment not null,
  commentId                 bigint not null,
  comment_at                datetime,
  authorId                  bigint,
  content                   varchar(255),
  is_answer                 tinyint(1) default 0,
  constraint pk_comment primary key (id)
);

create table post (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   varchar(255),
  authorId                  bigint,
  is_queustion              tinyint(1) default 0,
  post_at                   datetime,
  constraint pk_post primary key (id)
);

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  constraint pk_user primary key (id)
);

commit;
