create table delivery (
	id bigint not null auto_increment,
    customer_id bigint not null,
    tax decimal(10,2) not null,
    status varchar(20) not null,
    request_date dateTime not null,
    finish_date dateTime,
    
    receiver_name varchar(60) not null,
	receiver_address varchar(255) not null,
	receiver_number varchar(30) not null,
	receiver_address2 varchar(60) not null,
	receiver_district varchar(30) not null,
    
    primary key (id)
);

alter table delivery add constraint fk_delivery_customer
foreign key (customer_id) references customer (id);