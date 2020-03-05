package poke.model;

public class Mew extends Pokemon
{
	public Mew()
	{
		super(151, "Mew");
		customStats();
	}
	
	public Mew(String customName)
	{
		super(151, customName);
		customStats();
	}
	
	public Mew(int number, String name)
	{
		super(number, name);
		customStats();
	}
	
	private void customStats()
	{
		this.setCanEvolve(false);
		this.setHealth(365);
	}

}
