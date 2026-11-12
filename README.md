# OceanFleet
# OceanFleet Analytics

## Project Overview
OceanFleet Analytics is a Java-based vessel performance management system developed for a marine research organization. It helps store vessel performance records, retrieve vessel information using unique vessel IDs, and identify high-performing vessels based on their average speed.

## Objectives
- Store vessel performance details efficiently.
- Retrieve vessel records using vessel IDs.
- Identify vessels with the highest average speed.
- Display vessel information through a console-based interface.
- Apply Object-Oriented Programming (OOP) principles for modular development.

## Technologies Used
- **Programming Language:** Java
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5
- **IDE:** IntelliJ IDEA
- **Version Control:** Git and GitHub

## Project Structure

```text
OceanFleet/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── oceanfleet/
│   │               ├── model/
│   │               │   └── Vessel.java
│   │               ├── util/
│   │               │   └── VesselUtil.java
│   │               └── ui/
│   │                   └── UserInterface.java
│   └── test/
│       └── java/
│           └── com/
│               └── oceanfleet/
│                   ├── model/
│                   │   └── VesselTest.java
│                   ├── util/
│                   │   └── VesselUtilTest.java
│                   └── ui/
│                       └── UserInterfaceTest.java
├── pom.xml
└── .gitignore
```

## Components

### 1. Vessel (Model)
- Represents a vessel's performance details.
- Stores vessel ID, vessel name, average speed, and vessel type.
- Uses private instance variables, constructors, getters, and setters.

### 2. VesselUtil (Utility)
- Maintains vessel records using `List<Vessel>`.
- Adds vessel performance records.
- Retrieves vessels using their unique IDs.
- Identifies all vessels having the maximum average speed, including ties.

### 3. UserInterface (UI)
- Accepts vessel details through console input.
- Converts colon-separated input into Vessel objects.
- Displays retrieved vessel details.
- Displays all high-performance vessels.

## Use Cases Implemented
1. **UC1 – Vessel Model:** Create the Vessel class with constructors, attributes, getters, and setters.
2. **UC2 – Store Vessel Records:** Store vessel performance records using a List.
3. **UC3 – Retrieve Vessel by ID:** Search for a vessel using its unique ID.
4. **UC4 – Identify High-Performance Vessels:** Find all vessels with the maximum average speed.
5. **UC5 – Console User Interface:** Accept input and display vessel information.
6. **UC6 – OOP Refactoring:** Organize the application into Model, Utility, and UI layers.

## Sample Input

```text
3
V001:Sea King:25.5:Cargo
V002:Ocean Star:18.0:Tanker
V003:Wave Rider:25.5:Cruise
V001
```

## Sample Output

```text
V001 | Sea King | Cargo | 25.5 knots
High performance vessels are
V001 | Sea King | Cargo | 25.5 knots
V003 | Wave Rider | Cruise | 25.5 knots
```

## How to Run

**Prerequisites:** Java JDK 21 and Maven.

1. Clone the repository:
   ```bash
   git clone https://github.com/Deepanwitha06/OceanFleet.git
   ```

2. Navigate to the project directory:
   ```bash
   cd OceanFleet
   ```

3. Run the JUnit tests:
   ```bash
   mvn clean test
   ```

4. Run the application using IntelliJ IDEA by opening `UserInterface.java` and executing its `main()` method.

## Testing
JUnit 5 is used to verify:
- Vessel constructors and getters/setters.
- Adding vessel records.
- Retrieving vessels by ID.
- Handling vessels that are not found.
- Identifying maximum-speed vessels, including tied records.
- Parsing and formatting console input/output.

## OOP Principles Applied
- **Encapsulation:** Private fields with public getters and setters.
- **Abstraction:** Vessel operations are handled through the utility class.
- **Modularity:** Separate packages for model, utility, and UI.
- **Reusability:** Utility methods can be reused across application components.
- **Separation of Concerns:** Each class has a clearly defined responsibility.

## Author
**Deepanwitha Chennamsetti**

## License
This project is developed for academic and learning purposes.
