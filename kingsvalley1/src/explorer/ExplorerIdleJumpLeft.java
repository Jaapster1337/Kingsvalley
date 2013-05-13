package explorer;

import com.badlogic.gdx.math.Vector2;

import animatedsprite.AnimatedSprite;

public class ExplorerIdleJumpLeft extends AnimatedSprite
{
	//Fields
	private Explorer explorer;
	private float startX, startY, a, x;
	private int h, k, startH, startK;
	
	//Constructor
	//h is de afstand in pixels tot de symmetrie-as. k is de hoogte in pixels van de sprong
	public ExplorerIdleJumpLeft(Explorer explorer, int h, int k)
	{
		super(explorer);
		this.explorer = explorer;
		this.startH = h;
		this.startK = k;
		this.flipX = true;
		this.Initialize();
	}
	
	public void Initialize()
	{
		this.startX = explorer.getPosition().x;
		this.startY = explorer.getPosition().y;
		this.h = (int)this.startX + this.startH;
		this.k = (int)this.startY - this.startK;
		this.a = (this.startY - this.k)/ (float)Math.pow((double)(this.startX - h), 2);
		this.x = this.startX;
	}
	
	//Update method
	public void Update(float delta)
	{
		this.x = this.x - this.explorer.getSpeed();
		float y = this.a * (float)Math.pow((double)(this.x - this.h), 2) + this.k;
		float x = this.startX;
		
		this.explorer.setPosition(new Vector2(x, y));
		if ( this.explorer.getPosition().y > this.startY)
		{
			this.explorer.setPosition(new Vector2(this.startX, this.startY));
			this.explorer.setState(this.explorer.getIdleLeft());
		}
	}
	
	//Draw method
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
