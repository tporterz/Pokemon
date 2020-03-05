package poke.model;

public class Mew extends Pokemon implements Psychic
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

	public void psychic()
	{
		
	}

	public void futureSight()
	{
		
	}

	public void zenHeadbutt()
	{
		
	}

	public void imprison()
	{
		
	}

}
