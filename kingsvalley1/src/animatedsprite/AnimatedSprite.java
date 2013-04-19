package animatedsprite;
import explorer.Explorer;

public class AnimatedSprite {
	
	
	private Explorer explorer;
	private int[] xValue = { 0, 18, 36, 54, 72, 90, 108, 126 };
	protected int i = 0;
	private float timer = 0f;
	protected boolean flipX = false;

	//Constructor
	public AnimatedSprite(Explorer explorer)
	{
		this.explorer = explorer;
	}
	
	//Update
	public void Update(float delta)
	{
		this.timer += delta;
		if ( this.timer > 5f/60f)
		{
			this.timer = 0f;
			this.i++;
			if ( this.i > 7 )
			{
				this.i = 0;
			}
		}
	}
	
	public void Draw(float delta)
	{
		this.explorer.getGame().getBatch().draw(this.explorer.getTexture(),
				  this.explorer.getPosition().x,
				  this.explorer.getPosition().y,
				  this.explorer.getTexture().getWidth()/8,
				  this.explorer.getTexture().getHeight(),
				  this.xValue[this.i],
				  0,
				  18,
				  32,
				  this.flipX,
				  false);
	}

}
