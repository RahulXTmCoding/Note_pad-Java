import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
class Goto extends JFrame implements ActionListener
{
private JPanel jp1,jp2,jp3;
private JLabel label;
private JTextField tf;
private JButton b1,b2;
private JTextArea taa;
Goto(JTextArea taa)
{
this.taa=taa;
label=new JLabel("Line number :");
tf=new JTextField();
b1=new JButton("GO TO");
b2=new JButton("Cancle");
b1.addActionListener(this);
b2.addActionListener(this); 
jp1=new JPanel();
jp1.setLayout(new GridLayout(1,2));
jp2=new JPanel();
jp2.setLayout(new GridLayout(1,1));
jp3=new JPanel();
jp3.setLayout(new GridLayout(1,3));

jp1.add(label);
jp1.add(new JLabel(" "));
jp2.add(tf);
jp3.add(new JLabel(" "));
jp3.add(b1);
jp3.add(b2);

setLayout(new GridLayout(3,1));
add(jp1);
add(jp2);
add(jp3);
setLocation(20,20);
setSize(240,130);
setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
String lineno;
if(e.getSource()==b1)
{
lineno=tf.getText();
if(lineno!=null&&lineno.trim().equals("")==false)
{

taa.setCaretPosition(taa.getDocument().getDefaultRootElement()
                         .getElement(Integer.parseInt(lineno)-1).getStartOffset());
setVisible(false);
}

}
if(e.getSource()==b2)
{
setVisible(false);

}

}


}
class Notepad extends JFrame implements ActionListener,CaretListener 
{
private JMenuBar bar;
private JMenu m1,m2,m3,m4,m5;
private JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;
private JMenuItem me1,me2,me3,me4,me5,me6;
private JMenuItem mf1,mf2;
private JMenuItem mv1;
private JMenuItem mh1,mh2;
private JTextArea ta;
private String path;
private Panel p;
private JLabel label;
private JScrollPane jsp;
Notepad()
{
p=new Panel();
p.setLayout(new GridLayout(1,3));
ta=new JTextArea();
bar=new JMenuBar();
m1=new JMenu("File");
m2=new JMenu("Edit");
m3=new JMenu("Format");
m4=new JMenu("View");
m5=new JMenu("Help");
mi1=new JMenuItem("New");
mi2=new JMenuItem("Open");
mi3=new JMenuItem("Save");
mi4=new JMenuItem("SaveAs");
mi5=new JMenuItem("Print..");
mi6=new JMenuItem("Exit");
me1=new JMenuItem("Cut");
me2=new JMenuItem("Copy");
me3=new JMenuItem("Paste");
me4=new JMenuItem("Delete");
me5=new JMenuItem("Goto");
mf1=new JMenuItem("Word Wrap");
mf2=new JMenuItem("Font..");
mv1=new JMenuItem("Status Bar");
mh1=new JMenuItem("Help");
mh2=new JMenuItem("About");
p.add(new JLabel(" "));
p.add(new JLabel(" "));
label=new JLabel("Ln "+"1"+",Col "+"0");
p.add(label);
p.setVisible(true);
mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
me1.addActionListener(this);
me2.addActionListener(this);
me3.addActionListener(this);
me4.addActionListener(this);
mv1.addActionListener(this);
me5.addActionListener(this);
ta.addCaretListener(this);
m1.add(mi1);
m1.add(mi2);
m1.add(mi3);
m1.add(mi4);
m1.add(mi5);
m1.add(mi6);
m2.add(me1);
m2.add(me2);
m2.add(me3);
m2.add(me4);
m2.add(me5);
m3.add(mf1);
m3.add(mf2);
m4.add(mv1);
m5.add(mh1);
m5.add(mh2);
bar.add(m1);
bar.add(m2);
bar.add(m3);
bar.add(m4);
bar.add(m5);
setLayout(new BorderLayout());
jsp=new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants .HORIZONTAL_SCROLLBAR_AS_NEEDED);
add(bar,BorderLayout.NORTH);
add(jsp,BorderLayout.CENTER);
add(p,BorderLayout.SOUTH);

Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setTitle("Rahul_pad");
setSize(d.width,d.height-50);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent e)
{
try{
if(e.getSource()==mi1)
{
ta.setText("");
setTitle("new-Notepad");

}
if(e.getSource()==mi2)
{
JFileChooser file=new JFileChooser();

int i=file.showOpenDialog(this);
if(i==JFileChooser.APPROVE_OPTION)
{
File f=file.getSelectedFile();
RandomAccessFile raf=new RandomAccessFile(f,"rw");
ta.setText("");
while(raf.getFilePointer()<raf.length())
{
ta.append(raf.readLine()+"\n");

}
setTitle(file.getSelectedFile().getName());
path=file.getSelectedFile().getAbsolutePath();
raf.close();
}
}
if(e.getSource()==mi3)
{
JFileChooser file=null;
int i=0;
if(path==null)
{
 file=new JFileChooser();
i=file.showOpenDialog(this);
if(i==JFileChooser.APPROVE_OPTION)
{
path=file.getSelectedFile().getAbsolutePath();
}
else
{
return;
}
}
File f=new File(path);
RandomAccessFile raf=new RandomAccessFile(f,"rw");
raf.writeBytes(ta.getText());
raf.setLength(ta.getText().length());
raf.close();

}
if(e.getSource()==mi4)
{
JFileChooser file=new JFileChooser();
int l=file.showSaveDialog(this);
if(l==JFileChooser.APPROVE_OPTION)
{
File f=file.getSelectedFile();
RandomAccessFile raf=new RandomAccessFile(f,"rw");
raf.writeBytes(ta.getText());
raf.setLength(ta.getText().length());
raf.close();
}
setTitle(file.getSelectedFile().getName());
path=file.getSelectedFile().getAbsolutePath();
}
if(e.getSource()==mi6)
{
System.exit(0);
}
if(e.getSource()==mv1)
{
if(p.isVisible())
{
p.setVisible(false);
}
else
{
p.setVisible(true);
}
}
if(e.getSource()==me1)
{
ta.cut();
}
if(e.getSource()==me2)
{
ta.copy();
}
if(e.getSource()==me3)
{
ta.paste();
}
if(e.getSource()==me4)
{
ta.replaceSelection("");
}
if(e.getSource()==mi5)
{
ta.print();
}
if(e.getSource()==me5)
{ 
Goto g=new Goto(ta);


}
}
catch(Exception exception)
{
System.out.println(exception.toString());
}
}            
public void caretUpdate(CaretEvent c)
{
try{
JTextArea taa=(JTextArea)c.getSource();
int pos=taa.getCaretPosition();
int ln=taa.getLineOfOffset(pos);
int col=pos-taa.getLineStartOffset(ln);
String temp="Ln "+(ln+1)+",Col "+col;
label.setText(temp);
}
catch(Exception e)
{
System.out.println(e);
}

}
}
class psp
{
public static void main(String gg[])
{
Notepad n=new Notepad();

}
}