# Shipping Company Management System

A comprehensive database management system for a shipping company built with MongoDB and Java, designed to handle various aspects of shipping operations including customer management, shipment tracking, warehouse management, and employee administration.

## 💖 Support my Open-Source Journey

I am a software engineer and student dedicated to building tools that give users back their digital agency. If my work has saved you time, solved a technical headache, or improved your workflow, consider supporting my independent development!

☕ **[Support my work on Patreon (Buy Me a Coffee)](https://patreon.com/HussainRazaKhan)** or 
    **NayaPay ID:** `HusineRzaKhan@nayapay`

## 📋 Project Overview

This system provides an end-to-end solution for managing a shipping company's operations, including:
- Customer Management
- Shipment Tracking
- Employee Management (Managers, Supervisors, Drivers, Shippers)
- Warehouse Operations
- Container Management
- Financial Tracking
- Product Management

## 🏗️ Architecture

The system follows a modular architecture with the following key components:

### Database Collections
- Container
- Customer
- Department
- Driver
- Employee
- Supervisor
- Product
- Shipper
- WareHouse
- Shipment
- AccountingDepartment
- ShippingDepartment

### Class Hierarchy
- Person (Super Class)
  - Employee
    - Manager
    - Driver
    - Shipper
    - Supervisor
  - Customer

## 🔑 Key Features

1. **User Management**
   - Role-based access control
   - Secure manager-level operations

2. **Customer Operations**
   - Customer profile management
   - Shipment history tracking
   - Multiple contact information

3. **Shipment Management**
   - Real-time tracking
   - Weight and charges calculation
   - Delivery status updates

4. **Warehouse Operations**
   - Inventory tracking
   - Opening/Closing time management
   - Shipment allocation

5. **Employee Management**
   - Different employee roles
   - Salary management
   - Performance tracking

6. **Financial Management**
   - Profit tracking
   - Cost management
   - Payment processing

## 📦 Project Structure

- `src/`: Source code files
  - Java classes for each entity
  - GUI implementation
  - Database connection handlers
- `lib/`: Dependencies
- `bin/`: Compiled output
- `JSON Files/`: MongoDB collection schemas and sample data

## 🚀 Setup Instructions

1. Install MongoDB
2. Clone the repository
3. Import the Java project in VS Code
4. Ensure MongoDB Java drivers are in the `lib` folder
5. Run `Main.java` to start the application

## 💡 Potential Improvements

1. Add authentication and authorization
2. Implement real-time tracking features
3. Add reporting and analytics dashboard
4. Implement API endpoints for external integration
5. Add data validation and error handling
6. Implement logging system

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
