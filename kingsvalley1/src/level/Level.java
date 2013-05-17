package level;

import inputprocessor.ExplorerInputProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;

import stairsLeft.StairsLeft;
import stairsRight.StairsRight;
//import java.util.Map.Entry;
//import java.util.Set;

import bricks.Brick;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import explorer.Explorer;
import gesturelistener.ExplorerGestureListener;


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
	private Explorer explorer;
	private ExplorerInputProcessor inputProcessor;
	private ExplorerGestureListener gestureListener;
	private InputMultiplexer multiplexer;
	private ArrayList<StairsRight> stairsRight;
	private ArrayList<StairsLeft> stairsLeft;
	
	//Properties
	public Explorer getExplorer() {
		return explorer;
	}
	public void setExplorer(Explorer explorer) {
		this.explorer = explorer;
	}
	
	//Constructor
	public Level(KingsValley game, int levelIndex)
	{
		this.game = game;

		this.levelPath = String.format("data/%s.txt", levelIndex);
		try {
			this.LoadAssets();
		} catch (IOException e) {
			e.getMessage();
		}
		
		//Stop alle rechtertrappen in een arraylist object
		this.stairsRight = new ArrayList<StairsRight>();
		
		this.DetectStairsRight();
		
		//Stop alle ltrappen in een arraylist object
		this.stairsLeft = new ArrayList<StairsLeft>();
		
		this.DetectStairsLeft();
		
		//Inputprocessor zorgt voor alle inputdetectie
		//-----------------------------------------------------
		this.inputProcessor = new ExplorerInputProcessor(this);
		//-----------------------------------------------------
		
		//Met een gestureListener kun je andere scherminput afvangen zoals de fling en de pinch
		//-----------------------------------------------------
		this.gestureListener = new ExplorerGestureListener(this);
		//----------------------------------------------------
		
		//Met een multiplexer kun je zowel de inputprocessor als de gesturelistener gebruiken
		this.multiplexer = new InputMultiplexer();
		this.multiplexer.addProcessor(this.inputProcessor);
		this.multiplexer.addProcessor(new GestureDetector(this.gestureListener));
		
		//Voeg de multiplexer toe aan setInputProcessor
		Gdx.input.setInputProcessor(this.multiplexer);
		
	}
	
	private void LoadAssets() throws IOException
	{
		this.spriteSheet = new Texture("data/SpriteSheet.png");
		this.region = new HashMap<String, TextureRegion>();
		this.region.put("brick", new TextureRegion(this.spriteSheet, 0, 0, 16, 16));
		this.region.put("fundament", new TextureRegion(this.spriteSheet, 32, 0, 16, 16));
		this.region.put("brick_transparent", new TextureRegion(this.spriteSheet, 0, 16, 16, 16));
		this.region.put("traptopright01", new TextureRegion(this.spriteSheet, 100, 16, 16, 16));
		this.region.put("traptopleft01", new TextureRegion(this.spriteSheet, 68, 16, 16, 16));
		this.region.put("trapRight01", new TextureRegion(this.spriteSheet, 100, 0, 16, 16));
		this.region.put("trapRight02", new TextureRegion(this.spriteSheet, 116, 0, 16,16));
		this.region.put("trapTopRight02", new TextureRegion(this.spriteSheet, 116, 16, 16, 16));
		this.region.put("trapLeft01", new TextureRegion(this.spriteSheet, 68, 0, 16, 16));
		this.region.put("trapLefto2", new TextureRegion(this.spriteSheet, 84, 0, 16, 16));
		this.region.put("traptopleft02", new TextureRegion(this.spriteSheet,84, 16, 16, 16));
		
		
		//Alle stenen omdraaien
		for (Map.Entry<String, TextureRegion> e : this.region.entrySet())
		{
			e.getValue().flip(false, true);
		}
		
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(handle.read()));
		String line = reader.readLine();
		this.width = line.length();
		//Gdx.app.log("line", line);
		
		while ( line != null)
		{
			lines.add(line);
			line = reader.readLine();
			//Gdx.app.log("line", line);	
		}
		this.height = this.lines.size();
		
		this.bricks = new Brick[this.width][this.height];
		
		//Doorlopen van de regels
		for (int i=0; i< this.height; i++)
		{
			//Doorlopen van alle tekens van een regel
			for (int j=0; j < this.width; j++)
			{
				//Nu weten we voor een i,j combinatie wat voor teken het is.
				char brickElement = this.lines.get(i).charAt(j);
				this.bricks[j][i] = this.LoadAssets(brickElement, j * 16, i * 16);
			}			
		}				
	}
	
	private Brick LoadAssets(char brickElement, int i, int j)
	{
		switch ( brickElement)
		{
			case '1':
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick"), '1');
			case '2':
				return new Brick(this.game, new Vector2(i,j), this.region.get("fundament"), '2');
			case '.':
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '.');
			case '+':
				this.explorer = new Explorer(this.game, new Vector2(i,j), 1f);
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '+');
			case 's':
				return new Brick(this.game, new Vector2(i,j), this.region.get("traptopright01"), 's');
			case 'x':
				return new Brick(this.game, new Vector2(i,j), this.region.get("traptopleft01"), 'x');
			default:
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '.');
			
		}
		
	}
	
	private void DetectStairsRight()
	{
		for (int i = 0; i < this.height; i++)
		{
			for (int j = 0; j < this.width; j++)
			{
				if (this.bricks[j][i].getCharacter() == 's')
				{
					int amountOfSteps = 0;
					int horizontal = j + 1;
					for (int k = (i+1); k < this.height; k++)
					{
						horizontal--;
						if (this.bricks[horizontal][k].getCharacter() == '1')
						{
							amountOfSteps = k - i - 1;
							break;
						}
					}
					this.stairsRight.add(new StairsRight(this.game,
														 new Vector2(j * 16, i * 16),
														 amountOfSteps,
														 this.region.get("trapRight01"),
														 this.region.get("trapRight02"),
														 this.region.get("trapTopRight02")));
				}
			}
		}
	}
		
		private void DetectStairsLeft()
		{
			for (int i = 0; i < this.height; i++)
			{
				for (int j = 0; j < this.width; j++)
				{
					if (this.bricks[j][i].getCharacter() == 'x')
					{
						int amountOfSteps = 0;
						int horizontal = j;
						for (int k = (i+1); k < this.height; k++)
						{
							horizontal++;
							if (this.bricks[horizontal][k].getCharacter() == '1')
							{
								amountOfSteps = k - i - 1;
								break;
							}
						}
						this.stairsLeft.add(new StairsLeft(this.game,
															 new Vector2(j * 16, i * 16),
															 amountOfSteps,
															 this.region.get("trapLeft01"),
															 this.region.get("trapLeft02"),
															 this.region.get("traptopleft02")));
					}
				}
			}
	}
	
	public void Update(float delta)
	{
		this.explorer.Update(delta);
	}
	
	
	public void Draw(float delta)
	{
		for (int i=0; i<this.height; i++)
		{
			for (int j=0; j < this.width; j++)
			{
				this.bricks[j][i].Draw(delta);
			}				
		}
		
		for (StairsRight stairsRight : this.stairsRight)
		{
			stairsRight.Draw(delta);
		}
		
		for (StairsLeft stairsLeft : this.stairsLeft)
		{
			stairsLeft.Draw(delta);
		}
		
		this.explorer.Draw(delta);
	}
}
