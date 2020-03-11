package poke.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import poke.controller.PokeController;

@SuppressWarnings("serial")
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
	
	private ImageIcon pokemonIcon;
	
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
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, typesLabel, 497, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexNumberLabel, -57, SpringLayout.NORTH, typesLabel);
		appLayout.putConstraint(SpringLayout.NORTH, typesField, -5, SpringLayout.NORTH, typesLabel);
		appLayout.putConstraint(SpringLayout.WEST, typesLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexNumberLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 6, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -213, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 574, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveLabel, -131, SpringLayout.NORTH, updateButton);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 23, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 389, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableBox, 574, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolvableBox, -191, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, pokemonDropdown, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokemonDropdown, -11, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, updateButton, 556, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, updateButton, -6, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, updateButton, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 763, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, -224, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -8, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexNumberLabel, 424, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -440, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 59, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 339, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -106, SpringLayout.NORTH, pokedexLabel);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexLabel, 263, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokedexLabel, 154, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -10, SpringLayout.EAST, this);
		
	}

	private void setupDropdown()
	{
		DefaultComboBoxModel<String> pokedexModel = new DefaultComboBoxModel<String>(controller.getPokemon());
		pokemonDropdown.setModel(pokedexModel);
		pokedexLabel.setVerticalTextPosition(JLabel.BOTTOM);
		pokedexLabel.setHorizontalTextPosition(JLabel.CENTER);
		updateDisplay("");
		
	}
	
	private void updatePokemon(int index)
	{
		int health = 0;
		String name;
		boolean evolve;
		
		if (controller.validateInt(healthField.getText()))
		{
			health = Integer.parseInt(healthField.getText());
		}
		
		name = nameField.getText();
		evolve = evolvableBox.isSelected();
		controller.updateCurrentPokemon(name, index, health, evolve);
	}

	private void updateDisplay(String name)
	{
		String path = "/poke/view/images/";
		String defaultName = "GreatBall";
		String extension = ".png";
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		pokedexLabel.setIcon(pokemonIcon);
		repaint();
	}

	private void setupListeners()
	{
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				updatePokemon(pokemonDropdown.getSelectedIndex());
			}
		});
		
		pokemonDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selected)
			{
				String currentPokemon = pokemonDropdown.getSelectedItem().toString();
				updateDisplay(currentPokemon);
				String [] data = controller.getDisplayData(pokemonDropdown.getSelectedIndex());
				nameField.setText(data[0]);
				healthField.setText(data[1]);
				evolvableBox.setSelected(Boolean.parseBoolean(data[2]));
				typesField.setText(data[3]);
			}
		});
		
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
	
	public boolean validateInt(String intInput) // integer validation
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(intInput);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, error.getMessage());
			JOptionPane.showMessageDialog(null, "That is not an int. Try again!");
		}
		
		return isValid;
	}
}
