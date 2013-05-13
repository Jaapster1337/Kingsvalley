package inputprocessor;


import level.Level;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import explorer.Explorer;

public class ExplorerInputProcessor implements InputProcessor
{
	//Fields
	private Explorer explorer;
	
	//Constructor
	public ExplorerInputProcessor(Level level)
	{
		this.explorer = level.getExplorer();
	}

	@Override
	public boolean keyDown(int keycode) 
	{
		switch(keycode)
		{
			case Keys.RIGHT:
				Gdx.app.log("links", this.explorer.getState().toString());
				Gdx.app.log("rechts", this.explorer.getIdleLeft().toString());
				Gdx.app.log("gelijk", "" + this.explorer.getState().equals(this.explorer.getIdleLeft()));
				if (this.explorer.getState().equals(this.explorer.getIdleRight()) ||
					this.explorer.getState().equals(this.explorer.getIdleLeft()) ||
					this.explorer.getState().equals(this.explorer.getWalkLeft()))
				{
					this.explorer.setState(this.explorer.getWalkRight());
				}
				break;	
			case Keys.LEFT:
				if (this.explorer.getState().equals(this.explorer.getIdleLeft()) ||
					this.explorer.getState().equals(this.explorer.getIdleRight())||
					this.explorer.getState().equals(this.explorer.getWalkRight()))
				{
					this.explorer.setState(this.explorer.getWalkLeft());
				}
				break;	
		}	
		return false;
	}

	@Override
	public boolean keyUp(int keycode) 
	{	
		switch(keycode)
		{
			case Keys.RIGHT:
				if (this.explorer.getState().equals(this.explorer.getWalkRight()))
				{
					this.explorer.setState(this.explorer.getIdleRight());
				}
				break;
			case Keys.LEFT:
				if (this.explorer.getState().equals(this.explorer.getWalkLeft()))
				{
					this.explorer.setState(this.explorer.getIdleLeft());
				}
				break;
		}	
		return false;
	}

	@Override
	public boolean keyTyped(char character) 
	{
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		int x_right = 1200;
		int x_left = 0;
		int y = 600;
		if ( screenX > x_right  && screenX < x_right + 100  && screenY > y && screenY < y + 100)
		{
			this.explorer.setState(this.explorer.getWalkRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.explorer.setState(this.explorer.getWalkLeft());
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		int x_right = 1200;
		int x_left = 0;
		int y = 600;
		if ( screenX > x_right  && screenX < x_right + 100  && screenY > y && screenY < y + 100)
		{
			this.explorer.setState(this.explorer.getIdleRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.explorer.setState(this.explorer.getIdleLeft());
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) 
	{
		int x = 1200;
		int y = 600;
		if ( screenX > x  && screenX < x + 10  && screenY > y && screenY < y + 100)
		{
			this.explorer.setState(this.explorer.getIdleRight());
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
			
		return false;
	}

	@Override
	public boolean scrolled(int amount) 
	{
		return false;
	}
}
