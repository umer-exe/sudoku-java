# 🧩 Sudoku Java Game

A fully functional **console-based Sudoku game** developed in Java using core OOP concepts and discrete mathematics for a university project.

Created by:

- **Muhammad Umer Malik**
- **Mustafa Murtaza Ali**  
  Course: *Discrete Mathematical Structures*

---

## 🚀 Features

- ✅ Dynamic Puzzle Generation (random each time)
- 🧠 Multiple Difficulty Levels (Beginner to Hard)
- ↩️ Undo Functionality
- ⚠️ Real-time Error Detection & Validation
- ⌨️ Command-Line UI
- 🧱 Efficient use of Stacks, Queues, and Arrays
- 📉 Clean modular design — easy to understand and expand

---

## 🧠 Discrete Math Concepts Used

- **Logic & Propositional Statements** – Sudoku rules implemented with quantified logic
- **Set Theory** – Used for validating grid uniqueness
- **Graph Theory** – Sudoku grid treated as a graph (nodes & constraints)
- **Combinatorics** – Random puzzle generation and cell removal
- **Recursion & Backtracking** – Used in puzzle generation (`Generate.java`)

---

## 🧪 How to Run

```bash
javac -d bin src/*.java
java -cp bin Main
