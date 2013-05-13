package bricks;

import java.util.ArrayList;

import stairsRight.StepRight;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import nl.am1a.kingsvalley1.KingsValley;

public class StairsRight 
{
	//Fields
	private KingsValley game;
	private Vector2 position;
	private int amountOfSteps;
	private ArrayList<StepRight> stairs;
	
	
	
	public StairsRight(KingsValley game, Vector2 position, int amountOfSteps,
					   TextureRegion trapRight01, TextureRegion trapRight02,
					   TextureRegion trapTopRight02)
	{
		this.game = game;
		this.position = position;
		this.amountOfSteps = amountOfSteps;
		this.stairs = new ArrayList<StepRight>();
		
	}
	
	private void LoadContent(TextureRegion trapRight01, TextureRegion trapRight02,
							 TextureRegion trapTopRight02)
	{
		for (int i = 0; i < this.amountOfSteps; i++)
		{
			this.stairs.add(new StepRight(this.game,
										  new Vector2(this.position.x + i * 16, this.position.y - i * 16),
										  trapRight01, '^'));
		}
	}

}
