package bricks;

import nl.am1a.kingsvalley1.KingsValley;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import image.Image;


public class Brick extends Image
{
	//Field
	private char character;
	
	//Properties
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}

	//Constructor
	public Brick(KingsValley game, Vector2 position, TextureRegion region, char character)
	{
	super(game, position, region);
	this.setCharacter(character);
	}
	
	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}