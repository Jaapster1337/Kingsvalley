package gesturelistener;

import level.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import explorer.Explorer;


public class ExplorerGestureListener implements GestureListener
{
	//Fields
	private Explorer explorer;
	private Vector2 flingVector;
	
	
	//Constructor
	public ExplorerGestureListener(Level level)
	{
		this.explorer = level.getExplorer();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button)
	{
		if ( this.explorer.getState().equals(this.explorer.getWalkRight()))
		{
			this.explorer.setState(this.explorer.getIdleRight());
		}
		else if ( this.explorer.getState().equals(this.explorer.getWalkLeft()))
		{
			this.explorer.setState(this.explorer.getIdleLeft());
		}
		return false;
	}

	@Override
	public boolean longPress(float x, float y)
	{
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) 
	{
		this.flingVector = new Vector2(velocityX, velocityY);
		Gdx.app.log("flingAngle", Float.toString(this.flingVector.angle()));
		
		if (velocityX > 0)
		{
			if ( this.flingVector.angle() >= 0 && this.flingVector.angle() < 30 ||
				 this.flingVector.angle() > 330 && this.flingVector.angle() <= 360)
			{
				this.explorer.setState(this.explorer.getWalkRight());
			}
			else if (this.flingVector.angle() >= 300 && this.flingVector.angle() <= 330)
			{
				this.explorer.getJumpRight().Initialize();
				this.explorer.setState(this.explorer.getJumpRight());
			}
			else if (this.flingVector.angle() > 270 && this.flingVector.angle() < 300)
			{
				this.explorer.getIdleJumpRight().Initialize();
				this.explorer.setState(this.explorer.getIdleJumpRight());
			}
		}
		else if ( velocityX < 0)
		{
			if ( this.flingVector.angle() >= 150 && this.flingVector.angle() < 210)
			{
				this.explorer.setState(this.explorer.getWalkLeft());
			}
			else if (this.flingVector.angle() >= 210 && this.flingVector.angle() <= 240)
			{
				this.explorer.getJumpLeft().Initialize();
				this.explorer.setState(this.explorer.getJumpLeft());
			}
			else if (this.flingVector.angle() >= 240 && this.flingVector.angle() < 270)
			{
				this.explorer.getIdleJumpLeft().Initialize();
				this.explorer.setState(this.explorer.getIdleJumpLeft());				
			}
		}
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) 
	{
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) 
	{
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) 
	{
		return false;
	}	
}