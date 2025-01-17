# Project Structure

```mermaid
classDiagram
    class Publication {
        <<abstract>>
        -String title
        -String author
        -int publicationYear
    }

    class Book {
        -String genre
    }

    class Magazine {
        -Periodicity periodicity
    }

    class Archive {
        -Set<Publication> publications
    }

    class Main {
        +main(String[] args)
    }

    Publication <|-- Book
    Publication <|-- Magazine
    Archive "1" *-- "0..*" Publication
    Main --> Archive
```

There is an abstract class `Publication` that
represents all types of publications (`Book`
and `Article` in this case).
Each publication has a title, author,
and year of publication.

