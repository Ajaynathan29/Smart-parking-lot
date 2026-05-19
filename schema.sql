-- ==========================================
-- Smart Parking Lot Database Schema (SQLite)
-- ==========================================

-- 1. Vehicles Table
CREATE TABLE Vehicles (
    license_plate VARCHAR(20) PRIMARY KEY,
    vehicle_type VARCHAR(15) CHECK(vehicle_type IN ('MOTORCYCLE', 'CAR', 'BUS')) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 2. Parking Spots Table
CREATE TABLE Parking_Spots (
    spot_id VARCHAR(10) PRIMARY KEY, 
    floor_number INT NOT NULL,
    spot_type VARCHAR(15) CHECK(spot_type IN ('COMPACT', 'REGULAR', 'LARGE')) NOT NULL,
    is_available BOOLEAN DEFAULT 1, -- 1 represents TRUE in SQLite
    version INT DEFAULT 0 
);

-- 3. Parking Tickets (Transactions) Table
CREATE TABLE Parking_Tickets (
    ticket_id VARCHAR(36) PRIMARY KEY, -- 36 characters to hold a standard UUID
    license_plate VARCHAR(20) NOT NULL,
    spot_id VARCHAR(10) NOT NULL,
    
    entry_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    exit_time DATETIME, 
    
    status VARCHAR(10) CHECK(status IN ('ACTIVE', 'PAID')) DEFAULT 'ACTIVE',
    total_fee DECIMAL(10, 2), 
    
    FOREIGN KEY (license_plate) REFERENCES Vehicles(license_plate),
    FOREIGN KEY (spot_id) REFERENCES Parking_Spots(spot_id)
);

-- ==========================================
-- Optional: Insert some dummy parking spots to test with later
-- ==========================================
INSERT INTO Parking_Spots (spot_id, floor_number, spot_type) VALUES 
('1A', 1, 'COMPACT'),
('1B', 1, 'REGULAR'),
('1C', 1, 'LARGE');