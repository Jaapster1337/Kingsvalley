package explorer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import animatedsprite.AnimatedSprite;

public class ExplorerWalkRight extends AnimatedSprite{
	
	//Fields
	private Explorer explorer;
	
	//Constructor
	public ExplorerWalkRight(Explorer explorer)
	{
		super(explorer);
		this.explorer = explorer;
	}
	
	public void Update(float delta)
	{
		this.explorer.setPosition(this.explorer.getPosition().
				add(new Vector2(this.explorer.getSpeed(), 0f)));
		//Gdx.app.log("yrichting:", Float.toString(this.explorer.getPosition().y));
		super.Update(delta);
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
