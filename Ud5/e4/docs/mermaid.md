```mermaid

classDiagram
    class Book {
        -String isbn
        -String title
        -boolean available
        +getIsbn() String
        +getTitle() String
        +isAvailable() boolean
        +borrow() void
        +giveBack() void
    }

    class User {
        -String id
        -String name
        -List~Loan~ loans
        +getId() String
        +getName() String
        +getLoans() List
        +addLoan(Loan loan) void
        +removeLoan(Loan loan) void
    }

    class Loan {
        -Book book
        -User user
        -LocalDate startDate
        -boolean active
        +getBook() Book
        +getUser() User
        +getStartDate() LocalDate
        +isActive() boolean
        +closeLoan() void
    }

    class LibraryService {
        -Map books
        -Map users
        +addBook(Book book) void
        +addUser(User user) void
        +borrowBook(String isbn, String userId) Loan
        +returnBook(Loan loan) void
    }

    %% Relaciones
    LibraryService "1" -- "*" Book : gestiona
    LibraryService "1" -- "*" User : gestiona
    User "1" o-- "0..3" Loan : tiene
    Loan "*" -- "1" Book : referencia
    Loan "*" -- "1" User : pertenece

    ```