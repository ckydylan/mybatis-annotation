drop table if exists message;
create table message(
msg_id int not null auto_increment,
msg_text VARCHAR(32) not null,
msg_summary VARCHAR(32) default null,
PRIMARY KEY(msg_id)
)engine=INNODB auto_increment=1 DEFAULT charset=utf8