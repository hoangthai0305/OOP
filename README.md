# OOP - Accommodation Reservation System

## Overview

This repository contains a Java object-oriented programming project that simulates an accommodation reservation system. The application loads accommodation data from CSV files, builds an object model for different accommodation types, supports multiple search scenarios, and performs room reservations by appending new records to a reservation file.

This README describes the project as it currently exists in the repository, including its actual folder structure, implemented features, and runtime constraints.

## Implemented Features

The current codebase implements the following requirements:

1. Load accommodations, rooms, and room-accommodation mappings from CSV files.
2. Search accommodations by city and number of guests.
3. Search accommodations by price range, date range, city, guest count, and booking availability.
4. Perform advanced searches using optional filters such as:
   - room type
   - private pool
   - star rating
   - free breakfast
   - private bar
5. Perform a reservation and append the new booking to a CSV file.

`Main.java` and `Main_1.java` currently execute requirements `1` through `5`. The output file array also includes `Req6.txt`, but the current entry points do not implement a case for requirement 6.

## Object Model

The project is organized around these main classes:

- `Accommodation`: abstract base class for all accommodation types.
- `CommonAccommodation`: accommodation type with rooms (`Hotel`, `Homestay`, `Resort`).
- `LuxuryAccommodation`: high-end accommodation type (`Villa`, `CruiseShip`).
- `Room`: stores room information such as capacity, type, and nightly cost.
- `Reservation`: stores booking information.
- `ReservationSystem`: central business logic for loading data, searching, and reserving.

## Repository Structure

```text
.
|-- 523H0177_MaiHoangThai/
|   |-- Accommodation.java
|   |-- CommonAccommodation.java
|   |-- LuxuryAccommodation.java
|   |-- Hotel.java
|   |-- Homestay.java
|   |-- Resort.java
|   |-- Villa.java
|   |-- CruiseShip.java
|   |-- Room.java
|   `-- ReservationSystem.java
|-- SourceCode/
|   |-- Main.java
|   |-- Main_1.java
|   |-- Reservation.java
|   |-- Test.java
|   |-- data/
|   |-- data_1/
|   |-- expected_output/
|   |-- expected_output_1/
|   |-- output/
|   `-- output_1/
|-- AssignmentRequirements.pdf
`-- README.md
```

Notes:

- The source code is split across two locations: the domain and business logic classes are in `523H0177_MaiHoangThai/`, while the entry points, datasets, and generated outputs are in `SourceCode/`.
- The repository also includes compiled `.class` files, sample outputs, and submission archive files.

## Input Data

The main dataset is located in `SourceCode/data/`:

- `accommodation.csv`: accommodation records
- `room_type.csv`: room definitions
- `room_in_accommodation.csv`: room-to-accommodation mapping
- `reservation_3.csv`: reservation data used by the date-range search
- `reservation_5.csv`: reservation data used by the booking feature

An alternate dataset is located in `SourceCode/data_1/` and is used by `Main_1.java`.

## How to Build and Run

### Environment Requirements

- JDK 21
- Windows PowerShell or another terminal that can execute `javac` and `java`

Important note: in the current machine setup used to inspect this repository, `java` in `PATH` points to JRE 8 while the compiled `.class` files were built with Java 21. If you see `UnsupportedClassVersionError`, use a Java 21 runtime explicitly or update your `PATH` so that `java` and `javac` come from the same JDK.

### Compile from Source

Run this command from the repository root:

```powershell
& "C:\Program Files\Common Files\Oracle\Java\javapath\javac.exe" `
  -d SourceCode `
  523H0177_MaiHoangThai\*.java `
  SourceCode\Reservation.java `
  SourceCode\Main.java `
  SourceCode\Main_1.java `
  SourceCode\Test.java
```

### Run the Main Dataset

```powershell
Set-Location SourceCode
& "C:\Program Files\Common Files\Oracle\Java\javapath\java.exe" Main 1 2 3 4 5
```

This generates:

- `SourceCode/output/Req1.txt`
- `SourceCode/output/Req2_1.txt`
- `SourceCode/output/Req2_2.txt`
- `SourceCode/output/Req3_1.txt`
- `SourceCode/output/Req3_2.txt`
- `SourceCode/output/Req4_1.txt`
- `SourceCode/output/Req4_2.txt`
- `SourceCode/output/Req5.txt`

### Run the Alternate Dataset

```powershell
Set-Location SourceCode
& "C:\Program Files\Common Files\Oracle\Java\javapath\java.exe" Main_1 1 2 3 4
```

This generates output files in `SourceCode/output_1/`.

## Expected Output

The repository already contains reference outputs in:

- `SourceCode/expected_output/`
- `SourceCode/expected_output_1/`

Generated outputs can be compared against:

- `SourceCode/output/`
- `SourceCode/output_1/`

## Reservation Behavior

Requirement 5 performs the following steps:

1. Read existing reservations from file.
2. Check whether the requested room is available for the requested period.
3. Compute the total price based on the number of days and the room rate.
4. Add `8%` to the total price.
5. Append a new reservation record to the reservation CSV file.

Because of this behavior, running requirement 5 can modify `SourceCode/data/reservation_5.csv`.

## Current Project State

This is a plain Java project:

- no package structure
- no Maven or Gradle build system
- direct CSV and TXT file input/output

If the project is cleaned up in the future, a reasonable next step would be to consolidate the source files into one source tree, remove compiled `.class` files from version control, and add a dedicated build/run script. This README intentionally documents the repository as it currently works so that it can be cloned and executed with minimal guesswork.
