INSERT INTO users (username, password, role) VALUES
('admin', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'ADMIN'),
('manager', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'MANAGER'),
('user', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'USER');

INSERT INTO manufacturer (name, country) VALUES
('Toyota', 'Japan'),
('Honda', 'Japan'),
('Ford', 'USA'),
('BMW', 'Germany');

INSERT INTO customer (first_name, last_name, email) VALUES
('Razvan', 'Joita', 'razvan@example.com'),
('Maria', 'Popescu', 'maria@example.com'),
('Andrei', 'Ionescu', 'andrei@example.com');

INSERT INTO dealership (name, location) VALUES
('AutoHub Central', 'Bucharest'),
('DrivePoint West', 'Cluj-Napoca');

INSERT INTO employee (name, role, email, phone, dealership_id) VALUES
('John Mechanic', 'MECHANIC', 'john@auto.com', '0711111111', 1),
('Ana Service', 'SERVICE_ADVISOR', 'ana@auto.com', '0722222222', 1),
('Victor Tech', 'TECHNICIAN', 'victor@auto.com', '0733333333', 2);

INSERT INTO vehicle (vin, license_plate, make, model, year, fuel_type, status, manufacturer_id) VALUES
('1HGCM82633A123456', 'B-123-ABC', 'Toyota', 'Camry', 2023, 'Gasoline', 'ACTIVE', 1),
('2HGCM82633A123457', 'CJ-456-DEF', 'Honda', 'Civic', 2024, 'Gasoline', 'ACTIVE', 2),
('3HGCM82633A123458', 'TM-789-GHI', 'BMW', '320d', 2022, 'Diesel', 'ACTIVE', 4);

INSERT INTO part (name, part_number, description, price, quantity) VALUES
('Oil Filter', 'OF-001', 'Engine oil filter', 49.99, 20),
('Brake Pad Set', 'BP-002', 'Front brake pads', 199.99, 10),
('Air Filter', 'AF-003', 'Cabin air filter', 89.99, 15);

INSERT INTO service_record (description, date, vehicle_id, mechanic_id) VALUES
('Oil change service', '2026-03-20', 1, 1),
('Brake inspection', '2026-03-21', 2, 1),
('Air filter replacement', '2026-03-22', 3, 3);

INSERT INTO service_record_parts (service_record_id, part_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO warranty (start_date, end_date, vehicle_id) VALUES
('2026-01-01', '2028-01-01', 1),
('2026-02-01', '2029-02-01', 2),
('2026-03-01', '2028-03-01', 3);

INSERT INTO appointment (date, vehicle_id) VALUES
('2026-04-01', 1),
('2026-04-05', 2),
('2026-04-10', 3);

INSERT INTO invoice (amount, service_record_id) VALUES
(249.99, 1),
(399.99, 2),
(179.99, 3);