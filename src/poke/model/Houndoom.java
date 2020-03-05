package poke.model;

public class Houndoom extends Pokemon implements Dark, Fire
{
	public Houndoom()
	{
		super(229, "Houndoom");
		customStats();
	}
	
	public Houndoom(String customName)
	{
		super(229, customName);
		customStats();
	}
	
	public Houndoom(int number, String name)
	{
		super(number, name);
		customStats();
	}
	
	private void customStats()
	{
		this.setCanEvolve(false);
		this.setHealth(325);
	}

	public void flamethrower()
	{
		
	}

	public void ember()
	{
		
	}

	public void eruption()
	{
		
	}

	public void fireFang()
	{
		
	}

	public void darkPulse()
	{
		
	}

	public void feintAttack()
	{
		
	}

	public void bite()
	{
		
	}

	public void payback()
	{
		
	}

}
