<p align="center">
  <img src=".github/runecraft-academy.svg" alt="Runecraft Academy Logo" width="150">
</p>

# Runecraft Academy - Backend Grimoire

Welcome, aspiring Runecrafter, to the **Backend Grimoire** of the Runecraft Academy! This repository holds the arcane secrets and powerful enchantments that fuel our mystical learning realm. Here, knowledge is forged, and mastery is rewarded.

## The Academy's Vision

Runecraft Academy transcends mere study; it is a quest for enlightenment. We empower you to delve into ancient lore, master forgotten spells (concepts), and ascend through the ranks of true knowledge-seekers.

### Arcane Features:

*   **Flashcard Forging:** Craft, organize, and imbue your flashcards with potent knowledge, guided by an intelligent spaced repetition system that hones your recall.
*   **Enchanted Marketplace (The Nexus):** Discover and acquire powerful "Ensembles" (curated sets of flashcards) from fellow Runecrafters, or forge your own unique collections to share with the Academy.
*   **Gamified Ascension:** Earn experience, unlock mystical achievements, and ascend through the hallowed ranks as you master subjects and contribute to the Academy's ever-growing tome of wisdom.
*   **Pomodoro Rituals:** Utilize ancient Pomodoro timers to focus your mind and amplify your productivity during your study rituals.

## Initiating the Backend Grimoire

This is the heart of the Runecraft Academy's magic. To awaken its power, follow these sacred steps:

### Prerequisites for the Ritual:

*   **Java Development Kit (JDK) 17 or higher:** The essence of our enchantments.
*   **Maven:** The tool for weaving our code into powerful artifacts.
*   **A PostgreSQL database:** The ancient vault where our knowledge is stored (or configure for another database as per `application.properties`).

### The Awakening Ritual:

1.  **Clone the Ancient Scrolls:**
    ```bash
    git clone https://github.com/mrpunkdasilva/runecraft-academy-backend.git
    cd runecraft-academy-backend
    ```

2.  **Database Attunement:**
    *   Create a database named `runecraft_academy_db` (or as configured in `src/main/resources/application.properties`).
    *   Execute the sacred SQL script located at `src/main/java/org/punkdomus/runecraftacademy/database/runecraft_academy_db.sql` to prepare the knowledge vaults.
    *   Update `src/main/resources/application.properties` with your database connection runes (username, password, URL).

3.  **Forge the Artifacts:**
    ```bash
    mvn clean install
    ```

4.  **Invoke the Server Spirit:**
    ```bash
    mvn spring-boot:run
    ```

The Backend Grimoire's spirit should now be active, typically at `http://localhost:8080`.

## API Scrolls

The ancient API scrolls are documented using OpenAPI (Swagger). Once the spirit is invoked, you can decipher these scrolls at `http://localhost:8080/swagger-ui.html` (or similar path depending on your configuration).

## Contributing to the Lore

We welcome all who wish to contribute to the Academy's lore! Please consult our `CONTRIBUTING.md` (if available) for guidelines on how to add your wisdom to this project.

## Sacred Oaths (License)

This project is bound by the MIT License - see the `LICENSE` file for the full sacred oath.