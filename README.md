# ⏰ Java Multithreaded CLI Alarm Clock

A clean, multithreaded Command Line Interface (CLI) Alarm Clock application built using Core Java. It features a real-time digital clock display in the console, custom WAV audio playback, robust input validation, and past-time prevention logic.

---

## 🔥 Key Features

- **Live Terminal Digital Clock:** Updates seconds in real-time on the same line using `\r` (carriage return).
- **Multithreaded Architecture:** Background execution via Java `Thread` and `Runnable` interface so the alarm doesn't freeze the main process.
- **Audio Playback:** Plays custom `.wav` audio files using Java's `javax.sound.sampled` API.
- **Robust Validation:** Validates `HH:mm:ss` time formatting and handles invalid user inputs without crashing (`DateTimeParseException`).
- **Past Time Protection:** Ensures the user cannot set an alarm for a time that has already passed today.

---

## 🛠️ Java Concepts Demonstrated

- **Multithreading:** `Thread`, `Runnable`, `Thread.sleep()`
- **Java Time API:** `LocalTime`, `DateTimeFormatter`
- **Java Sound API:** `Clip`, `AudioInputStream`, `AudioSystem`
- **Exception Handling:** `try-catch`, `try-with-resources`
- **Object-Oriented Programming:** Encapsulation, Constructor Injection, Interface Implementation

---

## 📁 Project Structure

```text
├── Audio/
│   └── No One Here Gets In Alive - National Sweetheart.wav
├── src/
│   ├── Main.java
│   └── AlarmClock.java
└── README.md
```

---

## 🚀 How to Run

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/java-alarm-clock.git](https://github.com/your-username/java-alarm-clock.git)
   cd java-alarm-clock
   ```

2. **Ensure your audio file is placed inside the `Audio/` folder** as `.wav` format.

3. **Compile and Run via CLI or IntelliJ IDEA:**
   ```bash
   javac src/*.java
   java -cp src Main
   ```

4. **Set the alarm:** Enter time in `HH:mm:ss` format (e.g., `18:30:00`). When the alarm triggers, press **ENTER** to stop audio.
