package items;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements ActionListener,KeyListener 
{
	boolean play = false;
	int score =0;
	int bricks = 21;
	Timer time;
	int delay = 8;
	int px=315;
	int bx=120;
	int by=350;
	int bxdir=-1;
	int bydir=-2;
	Brick b;
	
	
	Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time =new Timer(delay,this);
		time.start();
		b= new Brick(3,7);
	}
	public void paint(Graphics gr)
	{
	
		gr.setColor(Color.black);
		gr.fillRect(1,1,692,592);
		
		b.draw((Graphics2D)gr);
		
		gr.setColor(Color.yellow);
		gr.fillRect(0, 0, 3, 592);
		gr.fillRect(0, 0, 692,3);
		//gr.fillRect(691, 0, 45, 592);
		
		gr.setColor(Color.white);
		gr.setFont(new Font("serif",Font.BOLD,20));
		gr.drawString(""+score,592,30);
		
		gr.setColor(Color.green);
		gr.fillRect(px,550, 100, 8);
	
		gr.setColor(Color.yellow);
		gr.fillOval(bx, by, 20, 20);
		
		gr.dispose();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(px>=600)
			{
				px=600;
			}
			else
			{
				moveRight();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(px<3)
			{
				px=3;
			}
			else
			{
				moveLeft();
			}
		}
		
	}
	void moveRight()
	{
		play = true;
		px+=20;
	}
	void moveLeft()
	{
		play = true;
		px-=20;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//time.start();
		if(play)
		{
			if(new Rectangle(bx,by,20,20).intersects(px,550, 100, 8))
			{
				bydir=-bydir;
			}
		A:	for(int i=0;i<b.map.length;i++)
			{
				for(int j=0;j<b.map[0].length;j++)
				{
					if(b.map[i][j]>0)
					{
						int brx = j*b.bw+80;
						int bry = i*b.bh +50;
						int brh = b.bh;
						int brw = b.bw;
						Rectangle rect = new Rectangle(brx,bry,brw,brh);
						Rectangle rb = new Rectangle(bx,by,20,20);
						Rectangle t = rect;
//						JLabel l = new JLabel();
//						l.setForeground(Color.white);
//						l.setFont(new Font("SansSerif", Font.BOLD, 20));
//						l.setBounds(311, 208, 111, 63);
						if(rect.intersects(rb))
						{
							b.setbrickval(0,i,j);
							bricks--;
							score+=5;
							
							if(bx+19<=t.x||bx+1>=t.x+t.width)
							{
								bxdir = -bxdir;
							}
							else
							{
								bydir = -bydir;
							}
							
							break A;
						}
						
					}
				}
			}
			bx+=bxdir;
			by+=bydir;
			if(bx<0)
			{
				bxdir=-bxdir;
			}
			if(by<0)
			{
				bydir = -bydir;
			}
			if(bx>670)
			{
				bxdir=-bxdir;
			}
		}
		repaint();
		
	}

}
