package explorer;
import animatedsprite.AnimatedSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import nl.am1a.kingsvalley1.KingsValley;

public class Explorer {
	
	//Fields
	private KingsValley game;
	private Vector2 position;
	private float speed;
	private Texture texture;
	private AnimatedSprite state;
	private ExplorerWalkRight walkRight;
	private ExplorerIdleRight idleRight;
	private ExplorerIdleLeft idleLeft;
	private ExplorerWalkLeft walkLeft;
	private ExplorerJumpRight jumpRight;
	private ExplorerJumpLeft jumpLeft;
	private ExplorerIdleJumpLeft idleJumpLeft;
	private ExplorerIdleJumpRight idleJumpRight;
	
	
	
	//Properties
	public Vector2 getPosition()
	{
		return this.position;
	}
	public void setPosition(Vector2 position)
	{
		this.position = position;
	}
	public float getSpeed()
	{
		return this.speed;
	}
	public Texture getTexture()
	{
		return this.texture;
	}
	public KingsValley getGame()
	{
		return this.game;
	}
	public AnimatedSprite getState()
	{
		return this.state;
	}
	public void setState(AnimatedSprite state)
	{
		this.state = state;
	}
	public ExplorerIdleRight getIdleRight()
	{
		return this.idleRight;
	}
	public void setIdleRight(ExplorerIdleRight idleRight)
	{
		this.idleRight = idleRight;
	}
	public ExplorerWalkRight getWalkRight()
	{
		return this.walkRight;
	}
	public void setWalkRight(ExplorerWalkRight walkRight)
	{
		this.walkRight = walkRight;
	}
	public ExplorerIdleLeft getIdleLeft()
	{
		return this.idleLeft;
	}
	public void setIdleLeft(ExplorerIdleLeft idleLeft)
	{
		this.idleLeft = idleLeft;
	}	
	public ExplorerWalkLeft getWalkLeft() {
		return this.walkLeft;
	}
	public void setWalkLeft(ExplorerWalkLeft walkLeft) {
		this.walkLeft = walkLeft;
	}
	public ExplorerJumpLeft getJumpLeft() {
		return jumpLeft;
	}
	public void setJumpLeft(ExplorerJumpLeft jumpLeft) {
		this.jumpLeft = jumpLeft;
	}	
	public ExplorerJumpRight getJumpRight() {
		return jumpRight;
	}
	public void setJumpRight(ExplorerJumpRight jumpRight) {
		this.jumpRight = jumpRight;
	}
	public ExplorerIdleJumpLeft getIdleJumpLeft() {
		return idleJumpLeft;
	}
	public void setIdleJumpLeft(ExplorerIdleJumpLeft idleJumpLeft) {
		this.idleJumpLeft = idleJumpLeft;
	}
	public ExplorerIdleJumpRight getIdleJumpRight() {
		return idleJumpRight;
	}
	public void setIdleJumpRight(ExplorerIdleJumpRight idleJumpRight) {
		this.idleJumpRight = idleJumpRight;
	}
	
	//Constructor
	public Explorer(KingsValley game, Vector2 position, float speed)
	{
		this.game = game;
		this.position = position;
		this.speed = speed;	
		this.texture = new Texture("data/explorer.png");	
		this.walkRight = new ExplorerWalkRight(this);
		this.idleRight = new ExplorerIdleRight(this);
		this.idleLeft = new ExplorerIdleLeft(this);
		this.walkLeft = new ExplorerWalkLeft(this);
		this.jumpRight = new ExplorerJumpRight(this, 20, 32);
		this.jumpLeft = new ExplorerJumpLeft(this, -20, 32);
		this.idleJumpLeft = new ExplorerIdleJumpLeft(this, -20, 32);
		this.idleJumpRight = new ExplorerIdleJumpRight(this, 20, 32);
		this.state = this.idleRight;
	}
	
	
	//Update
	public void Update(float delta)
	{
		this.state.Update(delta);
	}
	
	
	//Draw
	public void Draw(float delta)
	{
		this.state.Draw(delta);		
	}
}
