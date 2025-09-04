/*
  DUPLA:
   - Kauã Felipe Da Silva Jenior
   - Fabio Vinicius Santos De Freitas
 
 2) Um livro pode ser escrito por um ou muitos autores, por esta razão a classe Book deve
ter um array de autores, conforme o modelo abaixo:

 - O construtor deve receber um array de autores
- Uma vez que o livro é instanciado o seu autor não pode ser adicionado ou removido.
- O método toString() deve retornar a seguinte resposta:
"Book[name=?,authors={Author[name=?,email=?,gender=?],......},price=?,qty=?]".
Você deve:
- Escrever um código para a classe Book, você deve reutilizar o código do Author
escrito no exercício 1
- Escrever uma classe de teste, chamada TestBook, para testar a classe Book.
Dicas:
// Crie e aloque o array de autores.
Author[] authors = new Author[2];
authors[0] = new Author("Autor 01", "autor01@somewhere.com.br", 'm');
authors[1] = new Author("Autor 02", "autor02@nowhere.com.br", 'm');
// Declarar e alocar a instância de um book.
Book testeBook = new Book("Java for Dummy", authors, 19.99, 99);
System.out.println(testeBook); // toString()
 
 * */
package Exe01_Exe02;

public class Book {
	
	private String name;
	private Author[] authors;
	private double price;
	private int qty = 0;

	 public String GetName() {
		 return name;
	 }
	 
	 public Book(String name, Author[] authors, double price, int qty) {
	        this.name = name;
	        this.authors = authors;
	        this.price = price;
	        this.qty = qty;
	    }
	 
	 public Author[] getAuthors() {
	
		 return authors;
	 }
	 
	 public double getPrice() {
		 return price;
	 }
	 
	 public void setPrice(double price) {
		 this.price = price;
	 }
	 
	 public int getQty(){
		 return qty;
	 }
	 
	 public void setQty(int qty) {
		 this.qty = qty;
	 }
	 
	 @Override
	 public String toString() {
		 StringBuilder authorsStr = new StringBuilder();
		    for (int i = 0; i < authors.length; i++) {
		        authorsStr.append(authors[i].toString());
		        if (i < authors.length - 1) {
		            authorsStr.append(", ");
		        }
		    }

		    return String.format("Book[name=%s, authors={%s}, price=%.2f, qty=%d]",
		                         name, authorsStr.toString(), price, qty);
	}
	
	 public String getAuthorNames() {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < authors.length; i++) {
	            sb.append(authors[i].GetName());
	            if (i < authors.length - 1) {
	                sb.append(", ");
	            }
	        }
	        return sb.toString();
	    }
	 }

