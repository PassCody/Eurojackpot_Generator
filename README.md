# 🎰 Eurojackpot Generator

A Java-based tool for generating and statistically analyzing Eurojackpot numbers.
It uses parallel processing to simulate a large number of tips and identify the most frequently drawn numbers.

---

## 📦 Project Structure

```
Eurojackpot_Generator/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── github/
                    └── PassCody/
                        └── Eurojackpot_Generator/
                            ├── Main.java
                            ├── Numbers/
                            │   └── EuroJackpotNumbers.java
                            └── PossibilitiesCalculator/
                                └── PCCalc.java
```

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Apache Maven

### Build & Run
```
# Clone the repository
git clone https://github.com/PassCody/Eurojackpot_Generator.git
cd Eurojackpot_Generator

# Build the project
mvn clean install

# Run the application
mvn exec:java -Dexec.mainClass="com.github.PassCody.Eurojackpot_Generator.Main"
```

---

## 🧠 How It Works

- Simulates **140 million** Eurojackpot tips.
- Uses **two threads** for parallel processing.
- The `EuroJackpotNumbers` class generates random draws.
- The `PCCalc` class calculates frequency statistics.
- At the end, the **top 5 main numbers** and **top 2 Euro numbers** are printed based on frequency.

### Example Output

```
Numbers => [7, 12, 19, 34, 45]
Euro numbers => [3, 8]
```

---

## ⚙️ Technologies

- Java
- Multithreading (ExecutorService)
- Maven

---

## 👨‍💻 Author

[PassCody](https://github.com/PassCody)

---
