# Hot and Cold Game

This is a Java program that plays the "Hot and Cold" game. The game involves guessing a 4-digit number based on hints provided by another player. The hints are given in the form of "Hots" and "Colds", which indicate how many digits in the guess match the hidden number in both digit and position, or in position only, respectively.

### Prerequisites

- Java 18
- Maven 3
- Git

## Quick Start

For a quick execution of the program, run the following command in the terminal:

- Linux

```bash
run.sh
```

- Windows

```batch
run.bat
```
## Build and Run

### Build

Run the next command:

```bash
mvn clean package
```

### Run

Run the next command:

```bash
java -jar target/hot-and-cold-1.0-SNAPSHOT.jar --help
```

### About the execution parameters

The program accepts the following parameters:

```bash
Hot and Cold Game - Command-Line Interface

Usage from CLI: 'java -jar Hot-and-Cold.jar [options]'

Options:
--demo				Run a demo of the Hot and Cold game.
--file <file-path>			Read input from a file.
--single <number1> <number2> <string>	Run a single test case.
--help				Print this help message.
````

## Running the tests (Demo)

The program includes a demo that runs a series of test cases. To run the demo, execute the following command:

```bash
java -jar target/hot-and-cold-1.0-SNAPSHOT.jar --demo
```

