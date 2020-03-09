package poke.view;

import javax.swing.*;
import poke.controller.PokeController;

public class PokePanel extends JPanel
{
	private PokeController controller;
	private SpringLayout appLayout;
	
	private JButton updateButton;
	private JButton saveButton;
	private JComboBox<String> pokemonDropDown; //new
	
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
		this.pokemonDropDown = new JComboBox<String>();
		this.evolvableBox = new JCheckBox();
		this.evolveLabel = new JLabel("Is this Pokemon evolvable?");
		this.nameField = new JTextField("name");
		this.nameLabel = new JLabel("This Pokemon's name is:");
		this.pokedexLabel = new JLabel("Pokedex");
		this.healthField = new JTextField("health");
		this.healthLabel = new JLabel("This Pokemon has a health of:");
		this.pokedexNumberLabel = new JLabel();
		this.pokedexString = "The number for this Pokemon is: ";
		
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
		
		
	}
}
