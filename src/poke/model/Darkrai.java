package poke.model;

public class Darkrai extends Pokemon implements Dark
{
	public Darkrai()
	{
		super(491, "Darkrai");
		customStats();
	}
	
	public Darkrai(String customName)
	{
		super(491, customName);
		customStats();
	}
	
	public Darkrai(int number, String name)
	{
		super(number, name);
		customStats();
	}
	
	private void customStats()
	{
		this.setCanEvolve(false);
		this.setHealth(310);
	}

	public void darkPulse()
	{
		
	}

	public void payback()
	{

	}

	public void feintAttack()
	{
		
	}

	public void bite()
	{
		
	}

}
