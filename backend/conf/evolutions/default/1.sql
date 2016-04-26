# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table subscription (
  id                        bigint auto_increment not null,
  follower_id               bigint,
  followee_id               bigint,
  category                  varchar(255),
  timestamp                 datetime(6),
  constraint pk_subscription primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  constraint pk_user primary key (id))
;

create table author (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_author primary key (id))
;

create table comment (
  id                        bigint auto_increment not null,
  parentid                  bigint,
  authorid                  bigint,
  content                   varchar(255),
  time                      bigint,
  rootid                    bigint,
  categoryid                bigint,
  constraint pk_comment primary key (id))
;

create table group_member (
  id                        bigint auto_increment not null,
  member_id                 bigint,
  group_id                  bigint,
  constraint pk_group_member primary key (id))
;

create table post (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   varchar(255),
  author_id                 bigint,
  is_queustion              tinyint(1) default 0,
  answer_id                 bigint,
  post_at                   datetime,
  constraint pk_post primary key (id))
;

create table post_comment (
  id                        bigint auto_increment not null,
  publication_id            bigint,
  author_id                 bigint,
  constraint pk_post_comment primary key (id))
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

create table user_group (
  id                        bigint auto_increment not null,
  groupname                 varchar(255),
  createrid                 bigint,
  intro                     varchar(255),
  type                      varchar(255),
  constraint pk_user_group primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table subscription;

drop table user;

drop table author;

drop table comment;

drop table group_member;

drop table post;

drop table post_comment;

drop table publication;

drop table publication_author;

drop table user_group;

SET FOREIGN_KEY_CHECKS=1;

