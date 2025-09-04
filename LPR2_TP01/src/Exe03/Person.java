/*
  DUPLA:
   - Kauã Felipe Da Silva Jenior
   - Fabio Vinicius Santos De Freitas
 
 3)Implemente o sistema representado pelo diagrama abaixo.
Obrigatório implementar uma classe de testes para todos os métodos das classes Staff e
Student.

 * */
package Exe03;

class Person {
	protected String name;
	protected String adress;
	
	public Person(String name, String adress) 
	{
		
		this.name = name;
		this.adress = adress;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAdress() 
	{
		return adress;
	}
	
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	
	public String toString()
	{
		return String.format("Person[name = ?, adress = ?]");
	}
}
