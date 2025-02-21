# ***`Flashcard App V2`***

[Overview](#overview) | [Features](#features) | [Usage](#usage) | [Project Structure](#project-structure) | [Installation](#installation) | [Contributing](#contribution-guidelines) | [License](#license)

> [!IMPORTANT]
> Flashcard App V2 is an interactive learning app that helps users study effectively using customizable flashcards.

## Overview

Flashcard App V2 is an Android application built using **Kotlin** and **Jetpack Compose**. It enables users to practice questions with a deck-based system, track progress, and manage different types of flashcards.

## Features

- **Interactive Flashcards**: Flip between questions and answers.
- **Deck Management**: Different flashcard decks for various topics.
- **Progress Tracking**: Track the number of attempts and correct answers.
- **Smooth UI**: Built with Jetpack Compose for a seamless experience.

## Usage

### Basic Usage

1. Open the app and choose a deck.
2. Tap a flashcard to reveal the answer.
3. Mark whether your answer was correct or incorrect.
4. Proceed to the next card.
5. Restart the deck when finished.

### Example Decks

- **Perfect Squares**: Practice square numbers.
- **Custom Decks**: Add your own flashcards (coming soon!).

## Project Structure

```plaintext
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/flashcardappv2/
│   │   │   ├── MainActivity.kt (Main UI Logic)
│   │   │   ├── p2.kt (Deck Logic)
│   │   │   ├── ui/theme/ (Theming files)
│   │   ├── res/
│   │   │   ├── drawable/ (Icons and images)
│   │   │   ├── values/ (Colors, Strings, Themes)
├── build.gradle.kts
├── settings.gradle.kts
```

## Installation

### Prerequisites

- Android Studio **Giraffe or later**
- JDK **17 or higher**

### Steps

1. Clone the repository:
   ```sh
   git clone https://github.com/altR3GAL/Flashcard-App-V2.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle dependencies.
4. Run the app on an emulator or a physical device.

## Contribution Guidelines

We welcome contributions! Follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-name`).
3. Commit changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a **Pull Request**.

## License

This project is licensed under the **MIT License**. See the `LICENSE` file for details.

