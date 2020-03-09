package poke.view;

import javax.swing.*;

import poke.controller.PokeController;

public class PokeFrame extends JFrame
{
	private PokeController controller;
	private PokePanel panel;
	
	public PokeFrame(PokeController controller)
	{
		super();
		this.controller = controller;
		this.panel = new PokePanel(controller);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Pokemon (Pokedex)");
		this.setSize(800, 800);
		this.setResizable(false);
		this.setVisible(true);
	}
}
