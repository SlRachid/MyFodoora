

# MyFoodora Platform

## Project Overview

MyFoodora is an online food ordering application designed to connect customers with a variety of restaurants. The platform enables different types of users to interact with the system, including customers, couriers, restaurants, and managers, each having unique roles and functionalities. The primary goal of the project was to create a scalable, modular, and maintainable application that adheres to object-oriented design principles, while being easy to modify and extend.

## Table of Contents

1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
   - [Core Components](#core-components)
   - [User Management](#user-management)
   - [Order and Delivery Management](#order-and-delivery-management)
   - [Economic Management](#economic-management)
   - [Global Management](#global-management)
3. [Design Patterns Used](#design-patterns-used)
4. [Setup and Installation](#setup-and-installation)
5. [Usage](#usage)
6. [Command-Line Interface (CLI) Guide](#command-line-interface-cli-guide)
7. [Testing](#testing)
8. [Contributing](#contributing)
9. [License](#license)

## Introduction

The MyFoodora platform is designed to facilitate the online ordering and delivery of food. The system supports multiple user types, including customers, restaurants, couriers, and managers, each with distinct functionalities. The platform was developed with a focus on creating a robust and flexible architecture, making use of various design patterns to ensure ease of maintenance and scalability.

## Project Structure

The project is divided into several key components:

### Core Components

- **FoodItem Management**: The platform offers a variety of dishes (`Dish`) and meal combinations (`Meal`). These are managed by an abstract `FoodItem` class, which ensures that all food-related items share common properties such as price and order count.

- **Menu Management**: Each restaurant has a `Menu` that includes various dishes and meals. The `Menu` class also handles discount factors and special offers, which are propagated through the use of the Observer pattern.

### User Management

- **User Types**: The platform supports different user types: `Customer`, `Courier`, `Restaurant`, and `Manager`. Each user type is managed by an abstract `User` class, which defines common attributes like `uniqueID`, `userName`, `password`, `name`, and `surname`.

- **Access Control**: Each user type has specific permissions and access rights, managed through their respective classes.

### Order and Delivery Management

- **Order Processing**: Customers can place orders through the platform, which are then assigned to couriers based on various delivery policies. 

- **Delivery Management**: Couriers receive delivery requests via an Observer pattern implementation, ensuring they are promptly notified of new tasks.

### Economic Management

- **Profit Calculation**: The platform includes modules for calculating profits and other economic metrics, with the capability to apply different strategies to optimize future profits.

### Global Management

- **MyFoodora Core**: The `MyFoodora` class serves as the heart of the platform, integrating all the functionalities and ensuring smooth interaction between different modules.

## Design Patterns Used

The project employs several design patterns to enhance flexibility and maintainability:

- **Factory Pattern**: Used for creating instances of `FoodItem` and `User` classes, allowing for easy extension of new types.
- **Visitor Pattern**: Applied to `Meal` classes to calculate prices and manage dish additions.
- **Observer Pattern**: Implemented for updating menu prices and managing notifications for couriers and customers.
- **Strategy Pattern**: Utilized for defining and switching between different delivery and profit optimization strategies.

## Setup and Installation

To set up the project, follow these steps:

1. Clone the repository from GitLab:
   ```
   git clone [repository URL]
   ```
2. Import the project into your preferred Java IDE (e.g., Eclipse).
3. Build the project using the provided build configuration.

## Usage

Once the project is set up, you can run the application through the command-line interface.

## Command-Line Interface (CLI) Guide

The CLI allows users to interact with the MyFoodora platform. Below are the available commands:

### General Commands
- **`help`**: Displays the list of available commands.

### User Management
- **`login <username> <password>`**: Logs in a user with the specified username and password.
- **`registerCustomer <firstName> <lastName> <username> <password> <emailAddress>`**: Registers a new customer.
- **`logout`**: Logs out the current user.

### Customer-Specific Commands
- **`placeOrder <item1> <item2> ...`**: Places an order with the specified items.
- **`viewMenu`**: Displays the current menu of the restaurant.
- **`viewOrderHistory`**: Shows the order history of the logged-in customer.

### Courier-Specific Commands
- **`viewAssignedOrders`**: Lists the orders assigned to the logged-in courier.
- **`deliverOrder <orderId>`**: Marks an order as delivered.

### Manager-Specific Commands
- **`setTargetProfit <profitAmount>`**: Sets a new target profit.
- **`viewReports`**: Displays reports on various metrics like profit, orders, and deliveries.
- **`activateUser <username>`**: Activates a user account.

### Restaurant-Specific Commands
- **`addToMenu <item>`**: Adds a new item to the menu.
- **`removeFromMenu <item>`**: Removes an item from the menu.
- **`applyDiscount <percentage>`**: Applies a discount to the menu.

### System Commands
- **`close`**: Closes the application.

## Testing

Unit tests are provided to ensure the correctness of the application. To run the tests:

1. Navigate to the `src/test` directory.
2. Use JUnit to execute the tests.
3. Review the test results to ensure all components function as expected.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes. Ensure that your code follows the project's style guidelines and includes appropriate tests.

