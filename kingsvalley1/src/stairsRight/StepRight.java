package stairsRight;

import nl.am1a.kingsvalley1.KingsValley;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import image.Image;

public class StepRight extends Image
{
	//Fields
	private char character;
	
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}

	public StepRight(KingsValley game, Vector2 position, TextureRegion region, char character) 
	{
		super(game, position, region);
		this.setCharacter(character);
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
