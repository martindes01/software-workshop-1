# software-workshop-1

## About

These are my exercises and assignment submissions for the Software Workshop 1 (Object-Oriented Programming) module of the MSc Computer Science postgraduate course at the University of Birmingham during the 2020&ndash;2021 session.

## Getting Started

### Prerequisites

An installation of the [Java Development Kit version 11](https://adoptopenjdk.net/?variant=openjdk11) is required to compile these projects.
It is assumed that the `JAVA_HOME` and `PATH` environment variables are correctly set.

### Installation

Simply clone the source from this repository.

```shell
git clone https://github.com/martindes01/software-workshop-1.git
cd software-workshop-1
```

### Exercises

Each unit is named after a chapter of *Java Programming, Ninth Edition* by Joyce Farrell and the week of the module in which its contents was covered.
For example, the exercises attempted for chapter 11 in week 8 can be found in the directory `w08-ch11`.
The exercises are split into `exercises`, `labs` and `challenges`, and are named after the end-of-chapter exercises on which they are based.

Chapter | Title
---: | ---
1 | Creating Java programs
2 | Using Data
3 | Using Methods, Classes and Objects
4 | More Object Concepts
5 | Making Decisions
6 | Looping
7 | Characters, Strings and the `StringBuilder`
8 | Arrays
9 | Advanced Array Concepts
10 | Introduction to Inheritance
11 | Advanced Inheritance Concepts
12 | Exception Handling
13 | File Input and Output

### Assignment 1

- Instructions: [instructions.pdf](assignment-1/instructions.pdf)
- Last commit before submission: [c5fcea9](https://github.com/martindes01/software-workshop-1/commit/c5fcea9b5156a84bb43f96ca0dbb7096825947ae)

### Assignment 2

- Instructions: [instructions.pdf](assignment-2/instructions.pdf)
- Last commit before submission: [7c61dfe](https://github.com/martindes01/software-workshop-1/commit/7c61dfe90a4bbe4516e9e4af4f1355e45767b371)

### Assignment 3

- Instructions: [instructions.pdf](assignment-3/instructions.pdf)
- Last commit before submission: [d65d2d8](https://github.com/martindes01/software-workshop-1/commit/d65d2d87f9edef54c4ea26e3cec9844032936daa)

### Assignment 4

- Instructions: [instructions.pdf](assignment-4/instructions.pdf)
- Last commit before submission: [6d837a5](https://github.com/martindes01/software-workshop-1/commit/6d837a5a2e6583de7f0c383970a322495a5408da)

## Usage

### Assignment 1

To compile the project, run the Java compiler `javac` in the `assignment-1` directory, specifying the source path `src`, class path `bin`, source files to be compiled and destination directory `bin`.

```shell
cd assignment-1
javac --source-path src --class-path bin src/com/bham/pij/assignments/rps/*.java -d bin
```

To run each compiled program, run the Java interpreter `java`, specifying the class path `bin` and the main class to run.

```shell
java --class-path bin com.bham.pij.assignments.rps.RockPaperScissors
java --class-path bin com.bham.pij.assignments.rps.Hangman
java --class-path bin com.bham.pij.assignments.rps.FalloutTerminal
```

### Assignment 2

To compile the project, run the Java compiler `javac` in the `assignment-2` directory, specifying the source path `src`, class path `bin`, source file to be compiled and destination directory `bin`.

```shell
cd assignment-2
javac --source-path src --class-path bin src/com/bham/pij/assignments/calculator/Calculator.java -d bin
```

To run the compiled program, run the Java interpreter `java`, specifying the class path `bin` and the main class to run.

```shell
java --class-path bin com.bham.pij.assignments.calculator.Calculator
```

### Assignment 3

To compile the project, run the Java compiler `javac` in the `assignment-3` directory, specifying the source path `src`, class path `bin`, source files to be compiled and destination directory `bin`.

```shell
cd assignment-3
javac --source-path src --class-path bin src/com/bham/pij/assignments/pontoon/*.java -d bin
```

### Assignment 4

To compile the project, run the Java compiler `javac` in the `assignment-4` directory, specifying the source path `src`, class path `bin`, source files to be compiled and destination directory `bin`.

```shell
cd assignment-4
javac --source-path src --class-path bin src/com/bham/pij/assignments/candidates/*.java -d bin
```

To run the compiled program, run the Java interpreter `java`, specifying the class path `bin` and the main class to run.

```shell
java --class-path bin com.bham.pij.assignments.candidates.JobCandidatesMain
```

## License

This project is distributed under the terms of version 3 of the GNU General Public License as published by the Free Software Foundation.
See [COPYING](COPYING) for more information.
