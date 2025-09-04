package Exe03;

public class Student extends Person{

	private String program;
	private int year;
	private double fee;
	
	public String getProgram() 
	{
		return program;
	}
	
	public void setProgram(String program)
	{
		this.program = program;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public double getFee()
	{
		return fee;
	}
	
	public void setFee(double fee)
	{
		this.fee = fee;
	}
	
	public Student (String name, String adress, String program, int year, double fee)
	{
		super(name, adress);
		this.program = program;
		this.year = year;
		this.fee = fee;
	}
	
	public String toString()
	{
	 return String.format("Student[Person[name = %s, adress = %s], program = %s, year = %d, fee = %f]", name, adress, program, year, fee);
	}
}
