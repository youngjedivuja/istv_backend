
create table person
(
	person_id int auto_increment
		primary key,
	NAME varchar(128) not null,
	surname varchar(128) not null,
	unid varchar(13) not null,
	pin varchar(6) not null,
	birth_date date null,
	gender varchar(128) null,
	created_date date null,
	last_modified_date date null,
	last_modified_by varchar(128) null,
	record_status int default 1 null
);

create table product
(
	product_id int auto_increment
		primary key,
	product_code varchar(13) not null,
	full_name varchar(128) not null,
	country_of_origin varchar(128) not null,
	storage_quantity int not null,
	created_date date null,
	last_modified_by varchar(128) null,
	last_modified_date date null,
	record_status int default 1 null,
	price int null
);

create table role
(
	role_id int auto_increment
		primary key,
	role_name varchar(32) not null,
	created_date date null,
	last_modified_date date null,
	last_modified_by varchar(128) null,
	record_status int default 1 null
);

create table spring_session
(
	PRIMARY_ID char(36) not null
		primary key,
	SESSION_ID char(36) not null,
	CREATION_TIME bigint not null,
	LAST_ACCESS_TIME bigint not null,
	MAX_INACTIVE_INTERVAL int not null,
	EXPIRY_TIME bigint not null,
	PRINCIPAL_NAME varchar(100) null,
	constraint SPRING_SESSION_IX1
		unique (SESSION_ID)
);

create index SPRING_SESSION_IX2
	on spring_session (EXPIRY_TIME);

create index SPRING_SESSION_IX3
	on spring_session (PRINCIPAL_NAME);

create table spring_session_attributes
(
	SESSION_PRIMARY_ID char(36) not null,
	ATTRIBUTE_NAME varchar(200) not null,
	ATTRIBUTE_BYTES blob not null,
	primary key (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	constraint SPRING_SESSION_ATTRIBUTES_FK
		foreign key (SESSION_PRIMARY_ID) references spring_session (PRIMARY_ID)
			on delete cascade
);

create table user
(
	user_id int auto_increment
		primary key,
	person_id int null,
	username varchar(128) not null,
	PASSWORD varchar(128) null,
	created_date date null,
	email varchar(128) not null,
	last_modified_date date null,
	last_modified_by varchar(128) null,
	record_status int null,
	constraint fk_user_person
		foreign key (person_id) references person (person_id)
);

create table buyer
(
	buyer_id int auto_increment
		primary key,
	user_id int not null,
	company_name varchar(128) not null,
	city varchar(128) not null,
	created_date date null,
	last_modified_date date null,
	last_modified_by varchar(128) null,
	record_status int default 1 null,
	constraint fk_buyer_user
		foreign key (user_id) references user (user_id)
);

create table employee
(
	employee_id int auto_increment
		primary key,
	user_id int not null,
	POSITION varchar(128) not null,
	bank varchar(128) not null,
	employmend_start_date date null,
	employmend_end_date date null,
	created_date date null,
	last_modified_date date null,
	last_modified_by varchar(128) null,
	record_status int null,
	constraint fk_employee_user
		foreign key (user_id) references user (user_id)
);

create table `order`
(
	order_id int auto_increment
		primary key,
	buyer_id int not null,
	delivery_address varchar(128) not null,
	order_status varchar(128) not null,
	created_date date null,
	last_modified_date date null,
	record_status int default 1 null,
	last_modified_by varchar(128) null,
	constraint fk_order_buyer
		foreign key (buyer_id) references buyer (buyer_id)
);

create table order_product
(
	product_id int not null,
	quantity int null,
	created_date date null,
	last_modified_date date null,
	last_modified_by varchar(128) null,
	record_status int default 1 null,
	order_id int not null,
	order_product_id int auto_increment
		primary key,
	constraint fk_order_product
		foreign key (order_id) references `order` (order_id),
	constraint fk_product_order
		foreign key (product_id) references product (product_id)
);

create table user_role
(
	user_id int not null,
	role_id int not null,
	constraint fk_role_user
		foreign key (user_id) references user (user_id),
	constraint fk_user_role
		foreign key (role_id) references role (role_id)
);

