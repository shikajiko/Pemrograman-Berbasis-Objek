import java.awt.Color;
import java.awt.Graphics;

public class Paddle
{

	public int paddleNumber;
	public int x, y, width = 50, height = 250;
	public int score;

	private final Pong pong;

	public Paddle(Pong pong, int paddleNumber)
	{
		this.pong = pong;
		this.paddleNumber = paddleNumber;

		x = paddleNumber == 1 ? 0 : pong.width - width;
		y = pong.height / 2 - height / 2;
	}

	public void move(boolean up)
	{
		int speed = 15;

		if (up)
		{
			y = Math.max(0, y - speed);
		}
		else
		{
			y = Math.min(pong.height - height, y + speed);
		}
	}

	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

}
