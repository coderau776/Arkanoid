package items;

import java.awt.*;

public class Brick {
	
	int map[][];
	int bh;
	int bw;
	Brick(int r,int c)
	{
		map = new int[r][c];
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				map[i][j]=1;			
			}
		}
		bh=150/r;
		bw=540/c;
	}
	
	public void draw(Graphics2D g)
	{
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				if(map[i][j]>0)
				{
					g.setColor(Color.white);
					g.fillRect(j*bw+80, i*bh+50, bw, bh);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*bw+80, i*bh+50, bw, bh);
				}
			}
		}
	}
	void setbrickval(int v,int i,int j)
	{
		map[i][j]=v;
	}
}
