public class Library {
    public static void main(String[] args) {
        book book1 = new book ("The Alchamiest", "Paulo Coelho", 208);
        book book2 = new book ( "Simple Path", "Lucinda Vardey", 101);
        Textbook Textbook1 = new Textbook("Java Programming", "John smith", 201,"Computer Science", 3);
        book1.borrowBook();
        book1.returnBook();
        System.out.println("All Book Information:");
        book1.displayInfo();
        book2.displayInfo();
        Textbook1.displayInfo();

    }
}
