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
	
	private JTextField typesField;
	private JLabel typesLabel;
	
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
		
		this.typesLabel = new JLabel("This Pokemon has the following types:");
		this.typesField = new JTextField("type");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupListeners()
	{
		
		
	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 4, SpringLayout.SOUTH, updateButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -10, SpringLayout.EAST, updateButton);
		appLayout.putConstraint(SpringLayout.NORTH, pokemonDropdown, 241, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokemonDropdown, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 17, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexLabel, 10, SpringLayout.WEST, pokemonDropdown);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexLabel, -19, SpringLayout.NORTH, pokemonDropdown);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 56, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 182, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -105, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 6, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 83, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, -191, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokedexNumberLabel, 0, SpringLayout.WEST, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 182, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, updateButton);
		appLayout.putConstraint(SpringLayout.SOUTH, updateButton, -43, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, updateButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, -138, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 146, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveLabel, -138, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, updateButton, 144, SpringLayout.EAST, pokedexLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -71, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 1, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexNumberLabel, 9, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexNumberLabel, -166, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, typesLabel, 174, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, typesLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, typesField, 6, SpringLayout.SOUTH, typesLabel);
		appLayout.putConstraint(SpringLayout.WEST, typesField, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, typesField, 0, SpringLayout.EAST, healthField);
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
		
		this.add(typesLabel);
		this.add(typesField);
		
		this.add(saveButton);
		this.add(updateButton);
		this.add(pokemonDropdown);
	}
}
