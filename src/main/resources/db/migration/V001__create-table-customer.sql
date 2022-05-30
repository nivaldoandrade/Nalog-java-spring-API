create table customer (
	id bigint not null auto_increment,
    name varchar(255) not null,
    email varchar(255) not null,
    telephone varchar(25),
    created_at datetime not null default current_timestamp,
    updated_at datetime null default current_timestamp on update current_timestamp,
    
    primary key (id)
);