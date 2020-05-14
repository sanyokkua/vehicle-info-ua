CREATE SCHEMA IF NOT EXISTS ua_vehicle_info;

CREATE TABLE IF NOT EXISTS ua_vehicle_info.admin_unit
       (
       unit_number VARCHAR(255) NOT NULL,
       level1_code VARCHAR(255),
       level2_code VARCHAR(255),
       level3_code VARCHAR(255),
       level4_code VARCHAR(255),
       category VARCHAR(255),
       unit_name VARCHAR(255),
       PRIMARY KEY (unit_number));

CREATE INDEX admin_unit_index ON ua_vehicle_info.admin_unit (unit_number, unit_name);

CREATE TABLE IF NOT EXISTS ua_vehicle_info.service_center
       (center_number BIGINT NOT NULL, address VARCHAR(255), email VARCHAR(255), PRIMARY KEY (center_number));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.department
       (code INT NOT NULL, department_name VARCHAR(255), PRIMARY KEY (code));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.purpose
       (purpose VARCHAR(255) NOT NULL, PRIMARY KEY (purpose));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.operation
       (code INT NOT NULL, description VARCHAR(255), PRIMARY KEY (code));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.brand
       (brand_name VARCHAR(255) NOT NULL, PRIMARY KEY (brand_name));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.model
       (model_name VARCHAR(255) NOT NULL, PRIMARY KEY (model_name));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.kind
       (kind VARCHAR(255) NOT NULL, PRIMARY KEY (kind));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.body_type
       (body_name VARCHAR(255) NOT NULL, PRIMARY KEY (body_name));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.fuel_type
       (fuel_name VARCHAR(255) NOT NULL, PRIMARY KEY (fuel_name));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.color
       (color_name VARCHAR(255) NOT NULL, PRIMARY KEY (color_name));

CREATE TABLE IF NOT EXISTS ua_vehicle_info.vehicle
       (
       vehicle_id SERIAL NOT NULL,
       brand VARCHAR(255) NOT NULL,
       model VARCHAR(255),
       body VARCHAR(255),
       kind VARCHAR(255),
       fuel VARCHAR(255),
       color VARCHAR(255),
       engine_capacity INT,
       make_year INT,
       own_weight INT,
       total_weight INT,
       PRIMARY KEY (vehicle_id),
       CONSTRAINT fk_brand FOREIGN KEY (brand) REFERENCES ua_vehicle_info.brand (brand_name),
       CONSTRAINT fk_model FOREIGN KEY (model) REFERENCES ua_vehicle_info.model (model_name),
       CONSTRAINT fk_body FOREIGN KEY (body) REFERENCES ua_vehicle_info.body_type (body_name),
       CONSTRAINT fk_color FOREIGN KEY (color) REFERENCES ua_vehicle_info.color (color_name),
       CONSTRAINT fk_fuel FOREIGN KEY (fuel) REFERENCES ua_vehicle_info.fuel_type (fuel_name),
       CONSTRAINT fk_kind FOREIGN KEY (kind) REFERENCES ua_vehicle_info.kind (kind));

CREATE UNIQUE INDEX vehicle_unique_index ON ua_vehicle_info.vehicle (brand, model, body, kind, fuel, color, make_year, engine_capacity) WHERE
                                                                                                                                        brand is null or model is null or body is null or kind is null or fuel is null or color is null or make_year is null or engine_capacity is null ;

CREATE TABLE IF NOT EXISTS ua_vehicle_info.registration
       (
       reg_id SERIAL NOT NULL,
       purpose VARCHAR(255),
       dep_code INT,
       admin_unit VARCHAR(255),
       oper_code INT NOT NULL,
       vehicle_id INT NOT NULL,
       reg_date DATE,
       person_type VARCHAR(2),
       reg_number VARCHAR(8),
       PRIMARY KEY (reg_id),
       CONSTRAINT fk_purpose FOREIGN KEY (purpose) REFERENCES ua_vehicle_info.purpose (purpose),
       CONSTRAINT fk_dep_code FOREIGN KEY (dep_code) REFERENCES ua_vehicle_info.department (code),
       CONSTRAINT fk_admin_unit FOREIGN KEY (admin_unit) REFERENCES ua_vehicle_info.admin_unit (unit_number),
       CONSTRAINT fk_oper_code FOREIGN KEY (oper_code) REFERENCES ua_vehicle_info.operation (code),
       CONSTRAINT fk_vehicle_id FOREIGN KEY (vehicle_id) REFERENCES ua_vehicle_info.vehicle (vehicle_id));
