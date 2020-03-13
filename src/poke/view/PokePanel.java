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
		
		this.nameLabel = new JLabel("This Pokemon's name is:");
		this.nameField = new JTextField("name");
		
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
		appLayout.putConstraint(SpringLayout.EAST, typesLabel, -6, SpringLayout.WEST, typesField);
		appLayout.putConstraint(SpringLayout.WEST, typesField, 670, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, typesField, 779, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, typesField, -5, SpringLayout.NORTH, typesLabel);
		appLayout.putConstraint(SpringLayout.NORTH, typesLabel, 18, SpringLayout.SOUTH, pokedexNumberLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolvableBox, 0, SpringLayout.EAST, pokedexNumberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexNumberLabel, 17, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, pokedexNumberLabel, -170, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveLabel, -23, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -618, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -190, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 4, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokemonDropdown, 0, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 161, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexLabel, 151, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokedexLabel, 56, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokemonDropdown, 1, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 6, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 374, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 14, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, 0, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, updateButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, updateButton, -13, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -10, SpringLayout.EAST, this);
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
				currentPokemon = currentPokemon.substring(currentPokemon.indexOf(": ") + 2);
				updateDisplay(currentPokemon);
				String [] data = controller.getDisplayData(pokemonDropdown.getSelectedIndex());
				updateFields(data);
			}
		});
		
	}
	
	private void updateFields(String [] data)
	{
		nameField.setText(data[0]);
		healthField.setText(data[1]);
		evolvableBox.setSelected(Boolean.parseBoolean(data[2]));
		typesField.setText(data[3]);
	}

	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setLayout(appLayout);
		
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
