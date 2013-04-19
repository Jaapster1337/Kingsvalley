package level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bricks.Brick;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import nl.am1a.kingsvalley1.KingsValley;

public class Level
{
	//Field
	private KingsValley game;
	private String levelPath;
	private ArrayList<String> lines;
	private int height, width;
	private Texture spriteSheet;
	private Map<String, TextureRegion> region;
	private Brick bricks[][];
	
	//Constructor
	public Level(KingsValley game, int levelIndex)
	{
		this.game = game;

		this.levelPath = String.format("data/%s.txt", levelIndex);
		try {
			this.LoadAssets();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void LoadAssets() throws IOException
	{
		this.spriteSheet = new Texture("data/spriteSheet.png");
		this.region = new HashMap<String, TextureRegion>();
		this.region.put("brick", new TextureRegion(this.spriteSheet, 0,0,16,16));
		this.region.put("fundament", new TextureRegion(this.spriteSheet, 32, 0, 16, 16));
		this.region.put("brick_transparent", new TextureRegion(this.spriteSheet, 0, 16, 16, 16));
		
		Set<Entry<String, TextureRegion>> t = this.region.entrySet();
		Iterator<Entry<String, TextureRegion>> it = t.iterator();
		while (it.hasNext())
		{
			Entry<String, TextureRegion> e = it.next();
			TextureRegion value = (TextureRegion)e.getValue();
			value.flip(false, true);
		}
		
		
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(handle.read()));
		String line = reader.readLine();
		Gdx.app.log("line", line);
		this.width = line.length();
		while ( line != null)
		{
			lines.add(line);
			line = reader.readLine();
			Gdx.app.log("line", line);	
		}
		this.height = this.lines.size();
		
		this.bricks = new Brick[this.width][this.height];
		
		//doorlopen van de regels
		for (int i=0; i<this.height;i++)
		{
			//doorplopen van tekens in een regel
			for (int j=0;j<this.width;j++)
			{
				char brickElement = this.lines.get(i).charAt(j);
				this.bricks[j][i] = this.LoadAssets(brickElement, j*16, i*16);
			}
		}
				
	}
	
	private Brick LoadAssets(char brickElement, int i, int j)
	{
		switch (brickElement)
		{
		case '1':
			return new Brick(this.game, new Vector2(i,j), this.region.get("brick"), '1');
		case '2':
			return new Brick(this.game, new Vector2(i,j), this.region.get("fundament"), '2');
		case '.':
			return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '.');
		default:
			return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '.');
		}
		
	}
	
	public void Draw(float delta)
	{
		for (int i=0; i<this.height;i++)
		{
			for (int j=0;j<this.width;j++)
			{
				this.bricks[j][i].Draw(delta);
			}
		}
 }
}
