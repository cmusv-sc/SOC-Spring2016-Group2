# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_author primary key (id))
;

create table person (
  id                        bigint not null,
  name                      varchar(255),
  due_date                  timestamp,
  constraint pk_person primary key (id))
;

create table comment (
  id                        bigint not null,
  comment_at                timestamp,
  authorId                  bigint,
  content                   varchar(255),
  is_answer                 boolean,
  post_id                   bigint,
  constraint pk_comment primary key (id))
;

create table post (
  id                        bigint not null,
  title                     varchar(255),
  content                   varchar(255),
  authorId                  bigint,
  is_queustion              boolean,
  post_at                   timestamp,
  constraint pk_post primary key (id))
;

create table publication (
  id                        bigint not null,
  pubkey                    varchar(255),
  title                     varchar(255),
  editor                    varchar(255),
  year                      varchar(255),
  isbn                      varchar(255),
  url                       varchar(255),
  volume                    varchar(255),
  pages                     varchar(255),
  mdate                     varchar(255),
  series                    varchar(255),
  publisher                 varchar(255),
  booktitle                 varchar(255),
  crossref                  varchar(255),
  ee                        varchar(255),
  constraint pk_publication primary key (id))
;

create table publication_author (
  id                        bigint not null,
  publication_id            bigint,
  author_id                 bigint,
  constraint pk_publication_author primary key (id))
;

create table search (
  id                        bigint not null,
  keywords                  varchar(255),
  search_type               varchar(255),
  constraint pk_search primary key (id))
;

create table user (
  id                        bigint not null,
  username                  varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  constraint pk_user primary key (id))
;

create sequence author_seq;

create sequence person_seq;

create sequence comment_seq;

create sequence post_seq;

create sequence publication_seq;

create sequence publication_author_seq;

create sequence search_seq;

create sequence user_seq;

alter table comment add constraint fk_comment_author_1 foreign key (authorId) references user (id) on delete restrict on update restrict;
create index ix_comment_author_1 on comment (authorId);
alter table comment add constraint fk_comment_owner_2 foreign key (post_id) references post (id) on delete restrict on update restrict;
create index ix_comment_owner_2 on comment (post_id);
alter table post add constraint fk_post_author_3 foreign key (authorId) references user (id) on delete restrict on update restrict;
create index ix_post_author_3 on post (authorId);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists author;

drop table if exists person;

drop table if exists comment;

drop table if exists post;

drop table if exists publication;

drop table if exists publication_author;

drop table if exists search;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists author_seq;

drop sequence if exists person_seq;

drop sequence if exists comment_seq;

drop sequence if exists post_seq;

drop sequence if exists publication_seq;

drop sequence if exists publication_author_seq;

drop sequence if exists search_seq;

drop sequence if exists user_seq;

