import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class paintapp extends JFrame implements MouseListener,MouseMotionListener
{
private Canvas c;

private Paint p;
private Graphics g;
private int lastx,lasty;
Rectangle r1,r2,r3,r4,r5,r6;
paintapp()
{
lastx=0;
lasty=0;
c = new Canvas()
{ 
public void paint(Graphics ga) 
{


ga.setColor(Color.BLUE);
      ga.fillRect(0, 0,80,90);

 ga.setColor(Color.RED);

      ga.fillRect(0,90, 80,90);
ga.setColor(Color.GREEN);

      ga.fillRect(0,180 , 80,90);

ga.setColor(Color.PINK);

      ga.fillRect(0,270, 80,90);

ga.setColor(Color.YELLOW);

      ga.fillRect(0,360,80,90);
     

     
} 
};
c.addMouseListener(this);
c.addMouseMotionListener(this);
c.setBackground(Color.WHITE); 

add(c,BorderLayout.CENTER);
setSize(500,490);
setVisible(true);



g=c.getGraphics();
g.setColor(Color.BLACK);
}
public void mouseDragged(MouseEvent m)
{
int x,y;
x=m.getX();
y=m.getY();
//g.fillOval(x,y,6,6);
if(x<80) return;
g.drawLine(lastx,lasty,x,y);
lastx=x;
lasty=y;

}
public void mouseClicked(MouseEvent m)
{
int x,y;
x=m.getX();
y=m.getY();
System.out.println("Mouees");
Graphics2D g2;
if((x>0&&x<80)&&(y>0&&y<90))
{
g2=(Graphics2D)g;
g.setColor(Color.BLUE);
      g.fillRect(0, 0,80,90);

 g.setColor(Color.RED);

      g.fillRect(0,90, 80,90);
g.setColor(Color.GREEN);

      g.fillRect(0,180 , 80,90);

g.setColor(Color.PINK);

      g.fillRect(0,270, 80,90);

g.setColor(Color.YELLOW);

      g.fillRect(0,360,80,90);

g2.setStroke(new BasicStroke(5));
g2.setColor(Color.BLACK);
   g.drawRect(0, 0,78, 88);

g.setColor(Color.BLUE);
}
if((x>0&&x<80)&&(y>90&&y<180))
{
g2=(Graphics2D)g;
g.setColor(Color.BLUE);
      g.fillRect(0, 0,80,90);

 g.setColor(Color.RED);

      g.fillRect(0,90, 80,90);
g.setColor(Color.GREEN);

      g.fillRect(0,180 , 80,90);

g.setColor(Color.PINK);

      g.fillRect(0,270, 80,90);

g.setColor(Color.YELLOW);

      g.fillRect(0,360,80,90);

g2.setStroke(new BasicStroke(5));
g2.setColor(Color.BLACK);
   g.drawRect(0, 90,78, 88);

g.setColor(Color.RED);
}
if((x>0&&x<80)&&(y>180&&y<270))
{
g2=(Graphics2D)g;
g.setColor(Color.BLUE);
      g.fillRect(0, 0,80,90);

 g.setColor(Color.RED);

      g.fillRect(0,90, 80,90);
g.setColor(Color.GREEN);

      g.fillRect(0,180 , 80,90);

g.setColor(Color.PINK);

      g.fillRect(0,270, 80,90);

g.setColor(Color.YELLOW);

      g.fillRect(0,360,80,90);

g2.setStroke(new BasicStroke(5));
g2.setColor(Color.BLACK);
   g.drawRect(0, 180,78, 88);



g.setColor(Color.GREEN);
}
if((x>0&&x<80)&&(y>270&&y<360))
{
g2=(Graphics2D)g;
g.setColor(Color.BLUE);
      g.fillRect(0, 0,80,90);

 g.setColor(Color.RED);

      g.fillRect(0,90, 80,90);
g.setColor(Color.GREEN);

      g.fillRect(0,180 , 80,90);

g.setColor(Color.PINK);

      g.fillRect(0,270, 80,90);

g.setColor(Color.YELLOW);

      g.fillRect(0,360,80,90);

g2.setStroke(new BasicStroke(5));
g2.setColor(Color.BLACK);
   g.drawRect(0, 270,78, 88);


g.setColor(Color.PINK);
}
if((x>0&&x<80)&&(y>360&&y<450))
{
g2=(Graphics2D)g;
g.setColor(Color.BLUE);
      g.fillRect(0, 0,80,90);

 g.setColor(Color.RED);

      g.fillRect(0,90, 80,90);
g.setColor(Color.GREEN);

      g.fillRect(0,180 , 80,90);

g.setColor(Color.PINK);

      g.fillRect(0,270, 80,90);

g.setColor(Color.YELLOW);

      g.fillRect(0,360,80,90);

g2.setStroke(new BasicStroke(5));
g2.setColor(Color.BLACK);
   g.drawRect(0,360,78, 88);

g.setColor(Color.BLUE);
g.setColor(Color.YELLOW);
}




g.fillOval(x,y,6,6);
}
public void mouseExited(MouseEvent e) 
{ 
} 
public void mouseMoved(MouseEvent e) 
{
lastx=e.getX();
lasty=e.getY(); 
}  
public void mouseEntered(MouseEvent e) 
{ 
} 
  
public void mouseReleased(MouseEvent e) 
{ 
} 
  
public void mousePressed(MouseEvent e) 
{ 
}  
}
class ps
{
public static void main(String gg[])
{

paintapp p=new paintapp();
}
}
