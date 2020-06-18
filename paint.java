import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class paintapp extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{
private Canvas c;
private JButton b1,b2,b3,b4,b5;
private JPanel p1,p2,pi1,pi2,pi3,pi4,pi5;
private Border bor;
private Graphics g;
private int lastx,lasty;
paintapp()
{
lastx=0;
lasty=0;
c = new Canvas() { 
            public void paint(Graphics g) 
            { 
            } 
};
c.addMouseListener(this);
c.addMouseMotionListener(this);
c.setBackground(Color.WHITE); 
p1=new JPanel(new GridLayout(1,1));
p2=new JPanel(new GridLayout(5,1));
pi1=new JPanel(new GridLayout());
pi2=new JPanel(new GridLayout());
pi3=new JPanel(new GridLayout());
pi4=new JPanel(new GridLayout());
pi5=new JPanel(new GridLayout());
b1=new JButton();
b2=new JButton();
b3=new JButton();
b4=new JButton();
b5=new JButton();
b1.setBackground(Color.BLUE);
//bor=new BevelBorder(EtchedBorder.RAISED,Color.BLACK,Color.BLACK);//top=1,left=1,bottom=1,right=1


b2.setBackground(Color.RED);
b3.setBackground(Color.YELLOW);
b4.setBackground(Color.GREEN);
b5.setBackground(Color.PINK);     
b1.addActionListener(this);
b5.addActionListener(this);
b4.addActionListener(this);
b3.addActionListener(this);
b2.addActionListener(this);
pi1.add(b1);
pi2.add(b2);
pi3.add(b3);
pi4.add(b4);
pi5.add(b5);
p2.add(pi1);
p2.add(pi2);
p2.add(pi3);
p2.add(pi4);
p2.add(pi5);
p1.add(c);

setLayout(new BorderLayout());
add(p2,BorderLayout.WEST);
add(c,BorderLayout.CENTER);
setSize(400,400);
setVisible(true);
g=c.getGraphics();
g.setColor(Color.BLACK);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
pi1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
pi2.setBorder(null);
pi3.setBorder(null);
pi4.setBorder(null);
pi5.setBorder(null);


g.setColor(Color.BLUE);
}
if(e.getSource()==b2)
{
pi2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
pi1.setBorder(null);
pi3.setBorder(null);
pi4.setBorder(null);
pi5.setBorder(null);

g.setColor(Color.RED);
}
if(e.getSource()==b3)
{
pi3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
pi1.setBorder(null);
pi2.setBorder(null);
pi4.setBorder(null);
pi5.setBorder(null);

g.setColor(Color.YELLOW);                                                                                                                   
}
if(e.getSource()==b4)
{
pi4.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
pi1.setBorder(null);
pi2.setBorder(null);
pi3.setBorder(null);
pi5.setBorder(null);

g.setColor(Color.GREEN);
}
if(e.getSource()==b5)
{
pi5.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
pi1.setBorder(null);
pi2.setBorder(null);
pi3.setBorder(null);
pi4.setBorder(null);

g.setColor(Color.PINK);
}
}
public void mouseDragged(MouseEvent m)
{
int x,y;
x=m.getX();
y=m.getY();
//g.fillOval(x,y,6,6);

g.drawLine(lastx,lasty,x,y);
lastx=x;
lasty=y;
}
public void mouseClicked(MouseEvent m)
{
int x,y;
x=m.getX();
y=m.getY();
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
class psp
{
public static void main(String gg[])
{

paintapp p=new paintapp();
}
}
