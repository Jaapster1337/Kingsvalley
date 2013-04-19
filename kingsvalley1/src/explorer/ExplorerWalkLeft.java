package explorer;
import com.badlogic.gdx.math.Vector2;
import animatedsprite.AnimatedSprite;

public class ExplorerWalkLeft extends AnimatedSprite{
	
	//Fields
	private Explorer explorer;
	
	//Constructor
	public ExplorerWalkLeft(Explorer explorer)
	{
		super(explorer);
		this.explorer = explorer;
		this.flipX = true;
	}
	
	public void Update(float delta)
	{
		this.explorer.setPosition(this.explorer.getPosition().
				add(new Vector2(-this.explorer.getSpeed(), 0f)));
		super.Update(delta);
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
