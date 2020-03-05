package poke.model;

public class Blastoise extends Pokemon
{
	public Blastoise()
	{
		super(9, "Blastoise");
		customStats();
	}
	
	public Blastoise(String customName)
	{
		super(9, customName);
		customStats();
	}
	
	public Blastoise(int number, String name)
	{
		super(number, name);
		customStats();
	}
	
	private void customStats()
	{
		this.setCanEvolve(false);
		this.setHealth(290);
	}

}
