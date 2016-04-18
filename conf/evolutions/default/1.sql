# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_author primary key (id))
;

create table person (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  due_date                  datetime(6),
  constraint pk_person primary key (id))
;

create table comment (
  id                        bigint auto_increment not null,
  commentId                 bigint not null,
  comment_at                datetime(6),
  authorId                  bigint,
  content                   varchar(255),
  is_answer                 tinyint(1) default 0,
  constraint pk_comment primary key (id))
;

create table post (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   varchar(255),
  authorId                  bigint,
  is_queustion              tinyint(1) default 0,
  post_at                   datetime(6),
  constraint pk_post primary key (id))
;

create table publication (
  id                        bigint auto_increment not null,
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
  id                        bigint auto_increment not null,
  publication_id            bigint,
  author_id                 bigint,
  constraint pk_publication_author primary key (id))
;

create table search (
  id                        bigint auto_increment not null,
  keywords                  varchar(255),
  search_type               varchar(255),
  constraint pk_search primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  constraint pk_user primary key (id))
;

alter table comment add constraint fk_comment_post_1 foreign key (commentId) references post (id) on delete restrict on update restrict;
create index ix_comment_post_1 on comment (commentId);
alter table comment add constraint fk_comment_author_2 foreign key (authorId) references user (id) on delete restrict on update restrict;
create index ix_comment_author_2 on comment (authorId);
alter table post add constraint fk_post_author_3 foreign key (authorId) references user (id) on delete restrict on update restrict;
create index ix_post_author_3 on post (authorId);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table author;

drop table person;

drop table comment;

drop table post;

drop table publication;

drop table publication_author;

drop table search;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

