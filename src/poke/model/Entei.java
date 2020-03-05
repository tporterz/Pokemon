package poke.model;                                    

public class Entei extends Pokemon implements Fire
{
	public Entei()
	{
		super(244, "Entei");
		customStats();
	}
	
	public Entei(String customName)
	{
		super(244, customName);
		customStats();
	}
	
	public Entei(int number, String name)
	{
		super(number, name);
		customStats();
	}
	
	private void customStats()
	{
		this.setCanEvolve(false);
		this.setHealth(380);
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

}
