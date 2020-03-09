package poke.view;

import java.awt.Color;

import javax.swing.*;
import poke.controller.PokeController;

public class PokePanel extends JPanel
{
	private PokeController controller;
	private SpringLayout appLayout;
	
	private JButton updateButton;
	private JButton saveButton;
	private JComboBox<String> pokemonDropdown; //new
	
	private JCheckBox evolvableBox; //new
	private JLabel evolveLabel;
	
	private JTextField nameField;
	private JLabel nameLabel;
	
	private JLabel pokedexLabel;
	
	private JTextField healthField;
	private JLabel healthLabel;
	
	private JLabel pokedexNumberLabel;
	private String pokedexString;
	
	public PokePanel(PokeController controller)
	{
		super();
		this.controller = controller;
		
		this.appLayout = new SpringLayout();
		
		this.saveButton = new JButton("Save the Changes");
		this.updateButton = new JButton("Update the current Pokemon");
		this.pokemonDropdown = new JComboBox<String>();
		
		this.evolvableBox = new JCheckBox();
		this.evolveLabel = new JLabel("Is this Pokemon evolvable?");
		this.nameField = new JTextField("name");
		
		this.nameLabel = new JLabel("This Pokemon's name is:");
		this.pokedexLabel = new JLabel("Pokedex");
		
		this.healthField = new JTextField("health");
		this.healthLabel = new JLabel("This Pokemon has a health of:");
		
		this.pokedexString = "The number for this Pokemon is: ";
		this.pokedexNumberLabel = new JLabel(pokedexString);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupListeners()
	{
		
		
	}

	private void setupLayout()
	{
		
		
	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.MAGENTA);
		
		this.add(evolvableBox);
		this.add(evolveLabel);
		
		this.add(pokedexLabel);
		
		this.add(nameField);
		this.add(nameLabel);
		
		this.add(healthField);
		this.add(healthLabel);
		
		this.add(pokedexNumberLabel);
		
		this.add(saveButton);
		this.add(updateButton);
		this.add(pokemonDropdown);
	}
}
