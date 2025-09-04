package Exe01_Exe02;

public class TesteBook {
	public static void main(String[] args) {
        Author a1 = new Author("Autor 01", "autor01@somewhere.com.br", 'm');
        Author a2 = new Author("Autor 02", "autor02@nowhere.com.br", 'm');
        Author[] authors = {a1, a2};

        Book book = new Book("Java for Dummies", authors, 19.99, 99);

        System.out.println(book);
        System.out.println("Autores: " + book.getAuthorNames());
    }
}
