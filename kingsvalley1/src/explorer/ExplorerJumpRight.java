package explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import animatedsprite.AnimatedSprite;

public class ExplorerJumpRight extends AnimatedSprite
{
	//Fields
	private Explorer explorer;
	private float startX, startY, a;
	private int h, k, startH, startK;
	
	//Constructor
	//h is de afstand in pixels tot de symmetrie-as. k is de hoogte in pixels van de sprong
	public ExplorerJumpRight(Explorer explorer, int h, int k)
	{
		super(explorer);
		this.explorer = explorer;
		this.startH = h;
		this.startK = k;
		this.Initialize();
	}
	
	public void Initialize()
	{
		this.startX = explorer.getPosition().x;
		this.startY = explorer.getPosition().y;
		this.h = (int)this.startX + this.startH;
		this.k = (int)this.startY - this.startK;
		this.a = (this.startY - this.k)/ (float)Math.pow((double)(this.startX - h), 2);
	}
	
	//Update method
	public void Update(float delta)
	{
		float x = this.explorer.getPosition().x + this.explorer.getSpeed();
		float y = (float)(this.a * Math.pow((double)(x - this.h), 2) + this.k);
		
		this.explorer.setPosition(new Vector2(x, y));
		//Gdx.app.log("yrichting:", Float.toString(this.explorer.getPosition().y));
		if ( this.explorer.getPosition().y > this.startY)
		{
			this.explorer.setPosition(new Vector2(x, this.startY));
			this.explorer.setState(this.explorer.getWalkRight());
		}
	}
	
	//Draw method
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
