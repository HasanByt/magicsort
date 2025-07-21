# MagicSort

**MagicSort** ist eine Java-Bibliothek zur Demonstration und Nutzung verschiedener Sortieralgorithmen. Das Projekt ist modular aufgebaut, gut testbar und lässt sich als `.jar`-Datei in andere Projekte integrieren – zum Beispiel für algorithmische Visualisierungen oder den Schulunterricht.

## ✨ Features

- Implementierte Algorithmen:
  - Bubble Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Shaker Sort
  - Gnome Sort
  - Slow Sort
  - Binary Tree Sort
  - Tim Sort (eigene Implementierung)
- Gemeinsames Interface `ISort`
- Dynamischer Zugriff über `SortFactory`
- Umfangreiche Tests pro Algorithmus
- Maven-Projektstruktur

## 📦 Installation

Falls du die Bibliothek über GitHub Packages einbinden willst, ergänze Folgendes in deiner `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/HasanByt/magicsort</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.HasanByt</groupId>
    <artifactId>magicsort</artifactId>
    <version>1.0.3</version>
  </dependency>
</dependencies>
```
## 🚀 Build (lokal)

### 🔧 Klonen

```bash
git clone https://github.com/HasanByt/magicsort.git
cd magicsort
```
# Bauen mit Maven
```bash
mvn clean package
```
Die fertige .jar-Datei findest du unter target/magicsort-<version>.jar.

## 🧪 Tests

Alle Algorithmen sind mit JUnit-Tests abgesichert. Um die Tests auszuführen:
```bash
mvn test
```

## 📁 Projektstruktur
```text
src/
  main/java/ch/wiss/magicsort/algorithms/
    ISort.java
    SortAlgorithm.java
    SortFactory.java
    ...
  test/java/ch/wiss/magicsort/algorithms/
    BubbleSortTest.java
    MergeSortTest.java
    ...
```
## ✅ Checkstyle

Es wird eine zentrale checkstyle.xml genutzt, um Codequalität sicherzustellen.
```bash
mvn checkstyle:check
```

## 📄 Lizenz

Dieses Projekt steht unter der MIT-Lizenz. Siehe LICENSE.

    Entwickelt mit ❤️ von Hasan Bytyqi – für das Schulprojekt im Modul M295.