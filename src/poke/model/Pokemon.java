package poke.model;

public abstract class Pokemon
{
	private int pokedexNumber;
	private int health;
	private boolean canEvolve;
	private String name;
	
	public Pokemon(int pokedexNumber, String name)
	{
		this.pokedexNumber = pokedexNumber;
		this.health = 100;
		this.canEvolve = false;
		this.name = name;
	}

	public int getPokedexNumber()
	{
		return pokedexNumber;
	}

	public void setPokedexNumber(int pokedexNumber)
	{
		this.pokedexNumber = pokedexNumber;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public boolean isCanEvolve()
	{
		return canEvolve;
	}

	public void setCanEvolve(boolean canEvolve)
	{
		this.canEvolve = canEvolve;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
