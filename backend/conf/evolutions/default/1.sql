# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table access_comment (
  publication_id            bigint auto_increment not null,
  status                    tinyint(1) default 0,
  constraint pk_access_comment primary key (publication_id))
;

create table subscription (
  id                        bigint auto_increment not null,
  follower_id               bigint,
  followee_id               bigint,
  category                  varchar(255),
  timestamp                 datetime(6),
  constraint pk_subscription primary key (id))
;

create table tagpost (
  tagpost_id                bigint auto_increment not null,
  tag                       varchar(255),
  post_id                   bigint,
  constraint pk_tagpost primary key (tagpost_id))
;

create table tagpub (
  tagpub_id                 bigint auto_increment not null,
  tag                       varchar(255),
  pub_id                    bigint,
  constraint pk_tagpub primary key (tagpub_id))
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
  id                        integer auto_increment not null,
  parentid                  integer,
  authorid                  varchar(255),
  content                   varchar(255),
  time                      bigint,
  rootid                    integer,
  categoryid                integer,
  constraint pk_comment primary key (id))
;

create table comment_counts (
  id                        integer auto_increment not null,
  rootid                    integer,
  counts                    integer,
  constraint pk_comment_counts primary key (id))
;

create table group_member (
  id                        bigint auto_increment not null,
  member_id                 varchar(255),
  group_id                  bigint,
  constraint pk_group_member primary key (id))
;

create table group_message (
  id                        bigint auto_increment not null,
  member_id                 varchar(255),
  group_id                  bigint,
  title                     varchar(255),
  message                   varchar(255),
  constraint pk_group_message primary key (id))
;

create table group_notice (
  id                        bigint auto_increment not null,
  sender                    varchar(255),
  group_id                  bigint,
  groupname                 varchar(255),
  receiver                  varchar(255),
  constraint pk_group_notice primary key (id))
;

create table post (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   varchar(255),
  author_id                 bigint,
  is_question               tinyint(1) default 0,
  answer                    varchar(255),
  post_at                   varchar(255),
  constraint pk_post primary key (id))
;

create table post_comment (
  id                        bigint auto_increment not null,
  post_id                   bigint,
  comment_id                bigint,
  constraint pk_post_comment primary key (id))
;

create table publication_author (
  id                        bigint auto_increment not null,
  publication_id            bigint,
  author_id                 bigint,
  constraint pk_publication_author primary key (id))
;

create table publication (
  pub_id                    bigint auto_increment not null,
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
  constraint pk_publication primary key (pub_id))
;

create table thumb (
  id                        bigint auto_increment not null,
  thumb_type                tinyint(1) default 0,
  sender                    varchar(255),
  receiver                  integer,
  constraint pk_thumb primary key (id))
;

create table user_profile (
  id                        bigint auto_increment not null,
  user_name                 varchar(255),
  collaborator_numbers      integer,
  subscriber_numbers        integer,
  tags                      varchar(255),
  paper_titles              varchar(255),
  constraint pk_user_profile primary key (id))
;

create table user_group (
  id                        bigint auto_increment not null,
  groupname                 varchar(255),
  createrid                 varchar(255),
  intro                     varchar(255),
  type                      varchar(255),
  constraint pk_user_group primary key (id))
;

alter table tagpub add constraint fk_tagpub_publication_1 foreign key (pub_id) references publication (pub_id) on delete restrict on update restrict;
create index ix_tagpub_publication_1 on tagpub (pub_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table access_comment;

drop table subscription;

drop table tagpost;

drop table tagpub;

drop table user;

drop table author;

drop table comment;

drop table comment_counts;

drop table group_member;

drop table group_message;

drop table group_notice;

drop table post;

drop table post_comment;

drop table publication_author;

drop table publication;

drop table thumb;

drop table user_profile;

drop table user_group;

SET FOREIGN_KEY_CHECKS=1;

