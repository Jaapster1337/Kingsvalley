package screens;
import level.Level;
import gesturelistener.ExplorerGestureListener;
import inputprocessor.ExplorerInputProcessor;
import nl.am1a.kingsvalley1.KingsValley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;

public class PlayScreen implements Screen{

	//Fields
	private KingsValley game;
	private OrthographicCamera camera;
	private float ratio, zoom = 480f;
	private Level level;
	
	//Properties
	
	//Constructor
	public PlayScreen(KingsValley game)
	{
		this.game = game;
		camera = new OrthographicCamera();
		this.ratio = (float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
		camera.setToOrtho(true, this.ratio * this.zoom, this.zoom);
		camera.position.set(544f/2f, 480f/2f, 0f);
		camera.update();
	}
	
	@Override
	public void render(float delta) 
	{
		this.level.Update(delta);
		this.game.getBatch().setProjectionMatrix(camera.combined);
		this.game.getBatch().begin();
			this.level.Draw(delta);
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{		
	}

	@Override
	public void show() 
	{		
		this.level = new Level(this.game, 0);
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {		
	}

}
