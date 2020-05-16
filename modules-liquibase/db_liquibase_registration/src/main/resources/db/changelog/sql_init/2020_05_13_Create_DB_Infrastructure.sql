create schema if not exists ua_vehicle_info;

create table if not exists ua_vehicle_info.admin_unit (
       unit_number varchar(255) not null,
       category varchar(12),
       unit_name varchar(300),
       primary key (unit_number));

create index admin_unit_index on ua_vehicle_info.admin_unit (unit_number, unit_name);

create table if not exists ua_vehicle_info.service_center
       (center_number bigint not null, address varchar(400), email varchar(400), primary key (center_number));

create table if not exists ua_vehicle_info.department
       (code int not null, department_name varchar(255), primary key (code));

create table if not exists ua_vehicle_info.purpose
       (purpose varchar(255) not null, primary key (purpose));

create table if not exists ua_vehicle_info.operation
       (code int not null, description varchar(255), primary key (code));

create table if not exists ua_vehicle_info.brand
       (brand_name varchar(255) not null, primary key (brand_name));

create table if not exists ua_vehicle_info.model
       (model_name varchar(255) not null, primary key (model_name));

create table if not exists ua_vehicle_info.kind
       (kind varchar(255) not null, primary key (kind));

create table if not exists ua_vehicle_info.body_type
       (body_name varchar(255) not null, primary key (body_name));

create table if not exists ua_vehicle_info.fuel_type
       (fuel_name varchar(255) not null, primary key (fuel_name));

create table if not exists ua_vehicle_info.color
       (color_name varchar(255) not null, primary key (color_name));

create table if not exists ua_vehicle_info.vehicle
       (
       vehicle_id serial not null,
       brand varchar(255) not null,
       model varchar(255),
       body varchar(255),
       kind varchar(255),
       fuel varchar(255),
       color varchar(255),
       engine_capacity int,
       make_year int,
       own_weight int,
       total_weight int,
       primary key (vehicle_id),
       constraint fk_brand foreign key (brand) references ua_vehicle_info.brand (brand_name),
       constraint fk_model foreign key (model) references ua_vehicle_info.model (model_name),
       constraint fk_body foreign key (body) references ua_vehicle_info.body_type (body_name),
       constraint fk_color foreign key (color) references ua_vehicle_info.color (color_name),
       constraint fk_fuel foreign key (fuel) references ua_vehicle_info.fuel_type (fuel_name),
       constraint fk_kind foreign key (kind) references ua_vehicle_info.kind (kind));

create unique index vehicle_unique_index on ua_vehicle_info.vehicle (brand, model, body, kind, fuel, color, make_year, engine_capacity) where
                                                                                                                                        brand is null or model is null or body is null or kind is null or fuel is null or color is null or make_year is null or engine_capacity is null ;

create table if not exists ua_vehicle_info.registration (
       reg_id serial not null,
       purpose varchar(255),
       dep_code int,
       admin_unit varchar(255),
       oper_code int not null,
       vehicle_id int not null,
       reg_date date,
       person_type varchar(2),
       reg_number varchar(12),
       primary key (reg_id),
       constraint fk_purpose foreign key (purpose) references ua_vehicle_info.purpose (purpose),
       constraint fk_dep_code foreign key (dep_code) references ua_vehicle_info.department (code),
       constraint fk_oper_code foreign key (oper_code) references ua_vehicle_info.operation (code),
       constraint fk_vehicle_id foreign key (vehicle_id) references ua_vehicle_info.vehicle (vehicle_id));
