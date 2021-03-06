package poke.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import poke.model.*;
import poke.view.PokeFrame;

public class PokeController
{
	private ArrayList<Pokemon> pokemonList;
	private PokeFrame appFrame;
	private String datafile;
	
	public void start()
	{
		loadData();
	}
	
	public PokeController()
	{
		//Make at least 10 Pokemon
		
		pokemonList = new ArrayList<Pokemon>();
		createPokedex();
		datafile = "save.pokemon";
		appFrame = new PokeFrame(this);
	}
	private void createPokedex()
	{
		pokemonList.add(new Darkrai(491, "I can't see"));
		pokemonList.add(new Houndoom(229, "Bork"));
		pokemonList.add(new Mew(151, "Only Annoying in Pokemon Snap"));
		pokemonList.add(new Entei(244, "Atsui!!!"));
		pokemonList.add(new Blastoise(9, "Turtle that annihilates people with water"));
	}
	
	public String [] getPokemon()
	{
		String [] pokemonNames = new String [pokemonList.size()];
		
		for (int index = 0; index < pokemonList.size(); index++)
		{
			pokemonNames[index] = (index + 1) + ": " + pokemonList.get(index).getClass().getSimpleName();
		}
		return pokemonNames;
	}
	
	public void updateCurrentPokemon(String name, int index, int health, boolean evolve)
	{
		Pokemon current = pokemonList.get(index);
		current.setName(name);
		current.setCanEvolve(evolve);
		current.setHealth(health);
	}
	
	public String [] getDisplayData(int index)
	{
		String [] data = new String [4];
		data[0] = pokemonList.get(index).getName();
		data[1] = pokemonList.get(index).getHealth() + "";
		data[2] = pokemonList.get(index).isCanEvolve() + "";
		
		String types = "";
		for (String type : pokemonList.get(index).getTypes())
		{
			types += type + " ";
		}
		
		data[3] = types;
		return data;
	}
	
	public boolean validateInt(String text) // integer validation
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(text);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(appFrame, "Type in a number!");
		}
		
		return isValid;
	}
	
	public void saveData()
	{
		
	}
	
	public void loadData()
	{
		try (FileInputStream loadStream = new FileInputStream(datafile);
			ObjectInputStream input = new ObjectInputStream(loadStream))
		{
			ArrayList<Pokemon> loadedPokemon = new ArrayList<Pokemon>();
			loadedPokemon = (ArrayList<Pokemon>) input.readObject();
			pokemonList = loadedPokemon;
		}
		
		catch (IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Read Error", JOptionPane.ERROR_MESSAGE);
		}
		
		catch (ClassNotFoundException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "Class Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
