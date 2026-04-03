DROP TABLE IF EXISTS service_record_parts;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS warranty;
DROP TABLE IF EXISTS service_record;
DROP TABLE IF EXISTS part;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS dealership;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS customer;

CREATE TABLE manufacturer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(50)
);

CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE dealership (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(150)
);

CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    dealership_id BIGINT,
    CONSTRAINT fk_employee_dealership FOREIGN KEY (dealership_id) REFERENCES dealership(id)
);

CREATE TABLE vehicle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vin VARCHAR(17) UNIQUE NOT NULL,
    license_plate VARCHAR(20) UNIQUE NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    fuel_type VARCHAR(20),
    status VARCHAR(20),
    manufacturer_id BIGINT,
    CONSTRAINT fk_vehicle_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id)
);

CREATE TABLE part (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    part_number VARCHAR(50),
    description TEXT,
    price DECIMAL(10,2),
    quantity INT
);

CREATE TABLE service_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description TEXT,
    date DATE NOT NULL,
    vehicle_id BIGINT,
    mechanic_id BIGINT,
    CONSTRAINT fk_service_record_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
    CONSTRAINT fk_service_record_mechanic FOREIGN KEY (mechanic_id) REFERENCES employee(id)
);

CREATE TABLE service_record_parts (
    service_record_id BIGINT NOT NULL,
    part_id BIGINT NOT NULL,
    PRIMARY KEY (service_record_id, part_id),
    CONSTRAINT fk_srp_service_record FOREIGN KEY (service_record_id) REFERENCES service_record(id),
    CONSTRAINT fk_srp_part FOREIGN KEY (part_id) REFERENCES part(id)
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE warranty (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    vehicle_id BIGINT UNIQUE,
    CONSTRAINT fk_warranty_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);

CREATE TABLE appointment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    vehicle_id BIGINT,
    CONSTRAINT fk_appointment_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);

CREATE TABLE invoice (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    service_record_id BIGINT UNIQUE,
    CONSTRAINT fk_invoice_service_record FOREIGN KEY (service_record_id) REFERENCES service_record(id)
);