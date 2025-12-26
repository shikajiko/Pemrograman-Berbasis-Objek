import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball
{

	public int x, y, width = 25, height = 25;
	public int motionX, motionY;
	public int amountOfHits;

	private final Random random;
	private final Pong pong;

	public Ball(Pong pong)
	{
		this.pong = pong;
		this.random = new Random();
		spawn();
	}

	public void update(Paddle paddle1, Paddle paddle2)
	{
		int speed = 5;

		x += motionX * speed;
		y += motionY * speed;

		if (y + height > pong.height || y < 0)
		{
			if (motionY < 0)
			{
				y = 0;
				motionY = random.nextInt(4);
			}
			else
			{
				y = pong.height - height;
				motionY = -random.nextInt(4);
			}

			if (motionY == 0)
			{
				motionY = motionY < 0 ? -1 : 1;
			}
		}

		if (checkCollision(paddle1) == 1)
		{
			motionX = 1 + amountOfHits / 5;
			motionY = -2 + random.nextInt(4);
			if (motionY == 0) motionY = 1;
			amountOfHits++;
		}
		else if (checkCollision(paddle2) == 1)
		{
			motionX = -1 - amountOfHits / 5;
			motionY = -2 + random.nextInt(4);
			if (motionY == 0) motionY = 1;
			amountOfHits++;
		}

		if (checkCollision(paddle1) == 2)
		{
			paddle2.score++;
			spawn();
		}
		else if (checkCollision(paddle2) == 2)
		{
			paddle1.score++;
			spawn();
		}
	}

	public void spawn()
	{
		amountOfHits = 0;
		x = pong.width / 2 - width / 2;
		y = pong.height / 2 - height / 2;

		motionY = -2 + random.nextInt(4);
		if (motionY == 0) motionY = 1;

		motionX = random.nextBoolean() ? 1 : -1;
	}

	public int checkCollision(Paddle paddle)
	{
		if (x < paddle.x + paddle.width &&
			x + width > paddle.x &&
			y < paddle.y + paddle.height &&
			y + height > paddle.y)
		{
			return 1;
		}

		if ((paddle.paddleNumber == 1 && x < 0) ||
			(paddle.paddleNumber == 2 && x > pong.width))
		{
			return 2;
		}

		return 0;
	}

	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}

}
