package inputprocessor;


import screens.PlayScreen;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class ExplorerInputProcessor implements InputProcessor
{
	//Fields
	private PlayScreen screen;	
	
	//Constructor
	public ExplorerInputProcessor(PlayScreen screen)
	{
		this.screen = screen;
	}

	@Override
	public boolean keyDown(int keycode) 
	{
		switch(keycode)
		{
			case Keys.RIGHT:
				Gdx.app.log("links", this.screen.getExplorer().getState().toString());
				Gdx.app.log("rechts", this.screen.getExplorer().getIdleLeft().toString());
				Gdx.app.log("gelijk", "" + this.screen.getExplorer().getState().equals(this.screen.getExplorer().getIdleLeft()));
				if (this.screen.getExplorer().getState().equals(this.screen.getExplorer().getIdleRight()) ||
					this.screen.getExplorer().getState().equals(this.screen.getExplorer().getIdleLeft()) ||
					this.screen.getExplorer().getState().equals(this.screen.getExplorer().getWalkLeft()))
				{
					this.screen.getExplorer().setState(this.screen.getExplorer().getWalkRight());
				}
				break;	
			case Keys.LEFT:
				if (this.screen.getExplorer().getState().equals(this.screen.getExplorer().getIdleLeft()) ||
					this.screen.getExplorer().getState().equals(this.screen.getExplorer().getIdleRight())||
					this.screen.getExplorer().getState().equals(this.screen.getExplorer().getWalkRight()))
				{
					this.screen.getExplorer().setState(this.screen.getExplorer().getWalkLeft());
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
				if (this.screen.getExplorer().getState().equals(this.screen.getExplorer().getWalkRight()))
				{
					this.screen.getExplorer().setState(this.screen.getExplorer().getIdleRight());
				}
				break;
			case Keys.LEFT:
				if (this.screen.getExplorer().getState().equals(this.screen.getExplorer().getWalkLeft()))
				{
					this.screen.getExplorer().setState(this.screen.getExplorer().getIdleLeft());
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
			this.screen.getExplorer().setState(this.screen.getExplorer().getWalkRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.screen.getExplorer().setState(this.screen.getExplorer().getWalkLeft());
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
			this.screen.getExplorer().setState(this.screen.getExplorer().getIdleRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.screen.getExplorer().setState(this.screen.getExplorer().getIdleLeft());
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
			this.screen.getExplorer().setState(this.screen.getExplorer().getIdleRight());
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
