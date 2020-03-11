package poke.model;

import java.util.ArrayList;

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
	
	 public String[] getTypes()
	 {
		 String [] types = null;
		 ArrayList<String> implementedTypes = new ArrayList<String>();
		 Class<?> currentClass = this.getClass();
		 
		 while (currentClass.getSuperclass() != null)
		 {
			 Class<?> [] pokemonTypes = currentClass.getInterfaces();
			 types = new String[pokemonTypes.length];
			 for(int index = 0; index < types.length; index++)
			 {
				 String currentInterface = pokemonTypes[index].getCanonicalName();
				 currentInterface = currentInterface.replace(this.getClass().getPackage().getName() + ".", "");
				 
				 if (!implementedTypes.contains(currentInterface))
				 {
					 implementedTypes.add(currentInterface);
				 }
			 }
			 currentClass = currentClass.getSuperclass();
		 }
		 types = new String [implementedTypes.size()];
		 for(int index = 0; index < implementedTypes.size(); index++)
		 {
			 types[index] = implementedTypes.get(index);
		 }
		 return types;
	 } 

	public void setName(String name)
	{
		this.name = name;
	}

}
