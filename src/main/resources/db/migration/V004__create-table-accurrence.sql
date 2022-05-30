create table accurrence (
	id bigint not null auto_increment,
    delivery_id bigint not null,
    message varchar(255) not null,
    register_date datetime not null,
    
    primary key (id)
);

alter table accurrence add constraint fk_accurrence_delivery
foreign key (delivery_id) references delivery (id);