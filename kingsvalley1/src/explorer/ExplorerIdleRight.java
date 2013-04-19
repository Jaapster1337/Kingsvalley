package explorer;

import animatedsprite.AnimatedSprite;

public class ExplorerIdleRight extends AnimatedSprite
{
	//Field
	private Explorer explorer;
	
	
	//Constructor
	public ExplorerIdleRight(Explorer explorer)
	{
		super(explorer);
		this.explorer = explorer;
		this.i = 7;
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
