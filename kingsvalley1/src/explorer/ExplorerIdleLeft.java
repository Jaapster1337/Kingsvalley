package explorer;

import animatedsprite.AnimatedSprite;

public class ExplorerIdleLeft extends AnimatedSprite
{
	//Field	
	
	//Constructor
	public ExplorerIdleLeft(Explorer explorer)
	{
		super(explorer);
		this.i = 7;
		this.flipX = true;
	}
	
	//Update
	public void Update(float delta)
	{
		
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);		
	}
}
