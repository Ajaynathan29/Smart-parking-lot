# 🚗 Smart Parking Lot - Backend Architecture

A low-level backend architecture and simulation for a multi-floor smart parking lot, written in **Java**. 

This system manages vehicle entry and exit, automatically allocates the nearest available parking spots based on vehicle size, and calculates dynamic parking fees upon checkout.

## 🌟 Features
* **Smart Spot Allocation:** Uses an optimized $O(\log N)$ algorithm (Priority Queues / Min-Heaps) to instantly assign vehicles to the lowest available floor.
* **Size-Based Routing:** Enforces logic where Motorcycles can park anywhere, Cars in Regular/Large spots, and Buses only in Large spots.
* **Dynamic Fee Calculation:** Calculates total amount due upon exit based on vehicle type and duration of stay.
* **Object-Oriented Design:** Clean separation of concerns between Data Models, Business Logic (Services), and Application State.

## 🛠️ Tech Stack
* **Language:** Java (JDK 8+)
* **Architecture:** Service-Oriented Architecture (Models, Services, API placeholders)
* **Data Structures:** `PriorityQueue` (Min-Heap implementation for fast retrieval)
* **Database Design:** SQL schema provided in `/database` for persistence mapping.

## 📁 Project Structure
```text
Smart-parking-lot/
├── database/               
│   └── schema.sql          # Relational database schema for persistence
├── src/                    
│   ├── models/             # Entities: ParkingSpot, VehicleType, SpotType
│   ├── services/           # Business logic: ParkingLotService
│   ├── api/                # Placeholder for future REST Controllers
│   └── Main.java           # Terminal simulation entry point
└── README.md