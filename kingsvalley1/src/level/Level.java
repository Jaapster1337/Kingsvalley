package level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.FPSLogger;

import nl.am1a.kingsvalley1.KingsValley;

public class Level
{
	//Field
	private KingsValley game;
	private String levelPath;
	private ArrayList<String> lines;
	
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
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(handle.read()));
		String line = reader.readLine();
		Gdx.app.log("line", line);
		
		while ( line != null)
		{
			lines.add(line);
			line = reader.readLine();
			//Gdx.app.log("line", line);	
		}
				
	}
}
