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
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -20, SpringLayout.EAST, this);
		this.updateButton = new JButton("Update the current Pokemon");
		appLayout.putConstraint(SpringLayout.EAST, updateButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 4, SpringLayout.SOUTH, updateButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, updateButton);
		this.pokemonDropdown = new JComboBox<String>();
		appLayout.putConstraint(SpringLayout.WEST, updateButton, 105, SpringLayout.EAST, pokemonDropdown);
		appLayout.putConstraint(SpringLayout.SOUTH, pokemonDropdown, -26, SpringLayout.SOUTH, this);
		
		this.evolvableBox = new JCheckBox();
		this.evolveLabel = new JLabel("Is this Pokemon evolvable?");
		appLayout.putConstraint(SpringLayout.WEST, pokemonDropdown, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveLabel, -616, SpringLayout.SOUTH, this);
		
		this.nameField = new JTextField("name");
		this.nameLabel = new JLabel("This Pokemon's name is:");
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, 0, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 56, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 389, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -242, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 6, SpringLayout.EAST, nameLabel);
		
		this.pokedexLabel = new JLabel("Pokedex");
		appLayout.putConstraint(SpringLayout.NORTH, pokedexLabel, 206, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexLabel, 365, SpringLayout.WEST, this);
		
		this.healthField = new JTextField("health");
		appLayout.putConstraint(SpringLayout.NORTH, evolvableBox, 6, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 8, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, evolvableBox, -14, SpringLayout.EAST, healthField);
		this.healthLabel = new JLabel("This Pokemon has a health of:");
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 10, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 389, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -213, SpringLayout.EAST, this);
		
		this.pokedexString = "The number for this Pokemon is: ";
		this.pokedexNumberLabel = new JLabel(pokedexString);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexNumberLabel, 8, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.WEST, pokedexNumberLabel, 0, SpringLayout.WEST, nameLabel);
		
		this.typesLabel = new JLabel("This Pokemon has the following types:");
		appLayout.putConstraint(SpringLayout.NORTH, typesLabel, 6, SpringLayout.SOUTH, evolvableBox);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 6, SpringLayout.SOUTH, typesLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexNumberLabel, -11, SpringLayout.NORTH, typesLabel);
		appLayout.putConstraint(SpringLayout.WEST, typesLabel, 0, SpringLayout.WEST, nameLabel);
		this.typesField = new JTextField("type");
		appLayout.putConstraint(SpringLayout.NORTH, typesField, -5, SpringLayout.NORTH, typesLabel);
		appLayout.putConstraint(SpringLayout.WEST, typesField, 6, SpringLayout.EAST, typesLabel);
		appLayout.putConstraint(SpringLayout.EAST, typesField, -70, SpringLayout.EAST, this);
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
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

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.SOUTH, updateButton, -43, SpringLayout.SOUTH, this);
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
