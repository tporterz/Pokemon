package poke.model;

public class Blastoise extends Pokemon implements Water
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

	public void rainDance()
	{
		
	}

	public void hydroPump()
	{
		
	}

	public void surf()
	{
		
	}

	public void waterPulse()
	{
		
	}

}
