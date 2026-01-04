# Parking Lot Management System

The Parking Lot Management System project is built in Java. This project simulates the daily operations of a parking facility, serving as a practical demonstration of clean architecture and strict adherence to SOLID principles.

## Overview

The application manages the end-to-end flow of vehicles entering and exiting a parking lot with a fixed capacity of 20 spots. It handles:

1. Entry: Validation of available space, ticket issuance, and timestamping.
2. Storage: Management of active tickets using an in-memory database structure.
3. Exit & Billing: Calculation of fees based on the specific vehicle type and the exact duration of the stay.

## Key Features

- Multi-Vehicle Support: Distinct handling for Cars, Trucks, and Motorcycles, each with specific attributes.
- Dynamic Pricing Strategies: Implementation of the strategy pattern to apply unique billing formulas like specific hourly rates and free-hour rules for different vehicle types.
- Capacity Management: Automatic tracking of occupied spots to prevent overfilling the lot.
- Real-Time Billing: Utilization of LocalDateTime and Duration to calculate fees based on actual elapsed time rather than fixed integers.

## Architecture & SOLID Principles

This project was engineered to demonstrate how SOLID principles create maintainable and scalable software:

- Single Responsibility Principle: Each class focuses on a single task. The TicketRepository handles data access, ParkingFeeStrategy handles math, and ParkingService orchestrates the workflow.
- Open/Closed Principle: The system is designed for extension. New vehicle types or pricing rules can be introduced by creating new strategy classes without modifying the existing service code.
- Liskov Substitution Principle: All vehicle subclasses (Car, Truck, Motorcycle) can be used interchangeably wherever the parent Vehicle class is expected without breaking application logic.
- Interface Segregation Principle: Interfaces are kept focused. The TicketRepository exposes only necessary methods (save, findById, delete), preventing the service layer from depending on unused functionality.
- Dependency Inversion Principle: High-level modules depend on abstractions rather than concrete implementations. The ParkingService relies on the TicketRepository interface, allowing the underlying data storage (currently in-memory) to be swapped for a real database without code changes.

## Design Decisions: Usage of Enums

The project utilizes a VehicleType Enum (CAR, TRUCK, MOTORCYCLE) rather than standard strings or class checks. This decision was driven by three factors:

1. Type Safety: It eliminates runtime errors caused by typos, ensuring only valid vehicle types are processed.
2. Replacement of instanceof: The Enum serves as a discriminator key, allowing the system to match vehicles to strategies without using brittle instanceof checks or hardcoded if-else chains.
3. Scalability: Centralizing types in an Enum makes it easier to manage the codebase as new vehicle categories are added.

## How to Run

```bash
# 1. Compile the source code
javac src/*.java

# 2. Run the application
java -cp src ParkingLotApplication

# Note: The application runs a pre-configured test scenario to demonstrate 
# the system is functioning correctly (simulating entry, time passing, and exit).
# This test driver program is AI-generated to verify the core system logic.
   
