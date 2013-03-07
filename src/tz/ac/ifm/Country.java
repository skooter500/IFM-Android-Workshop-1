package tz.ac.ifm;

public class Country 
{
	private int id;
	private String name;
	private int population;
	private String capital;
	private String currency;
	
	public Country(int id, String name, int pop, String capital, String currency)
	{
		this.id = id;
		this.name = name;
		this.population = pop;
		this.capital = capital;
		this.currency = currency;
	}
	
	public Country()
	{
		this(0, "", 0, "", "");
	}
	
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
