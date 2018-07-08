package imit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
/**
 * This class emulates animation using the MouseListener and MouseMotionListener. 
 * @author Aganus, Marc Kevin; Alcantara, Tristan Jake 
 *  Mangoma, Reah Jeanne; Manzan, Lhea 
 *  Morales, Mae Ann; Viernes, Kevin  
 *  BSCS 2A
 * @version 1.0		October 12, 2012
 */
public class ImitatorWindow extends Frame implements MouseListener, MouseMotionListener, WindowListener, ActionListener {
/**
 * @var x and y, An int that controls the movement of the object.
 * @var z and w, An int that sets the size of the object.
 */
	private static final long serialVersionUID = 1L;
	private int x,y,i;
	private Button start, stop, quit;//buttons added for short manipulation of the program
	boolean activate=false;//activate controls the start of the animation
	private Vector<Object> vect;
	Shape shape = new Shape();
	
	public ImitatorWindow(String title){
		super(title);
		this.setSize(500,500);//frame 500 x 500
		this.setLayout(new FlowLayout());
		this.setBackground(Color.BLUE);
		//this.setForeground(Color.BLACK);
		i=0;	
		vect=new Vector<Object>();
		x=y=-20;//initial state of the object
		stop=new Button ("Stop");//add button stop
		start=new Button("Start");//add button start
		quit=new Button("Quit");//add button quit
		add(start);
		add(stop);
		add(quit);
		addMouseMotionListener(this);
		addMouseListener(this);
		addWindowListener(this);
		start.addActionListener(this);
		stop.addActionListener(this);
		quit.addActionListener(this);
	}
	/**
	 * Double Buffering. 
	 */
	public void paint(Graphics g){
		Image offscrean = createImage(1500,750);
		Graphics delta = offscrean.getGraphics();
		for(int x=0;x<vect.size();x++){
			shape=(Shape)vect.elementAt(x);
			shape.shape(delta);
		}
		g.drawImage(offscrean,0,0,this);
		repaint();
	}
	/**
	 * Start of main method.
	 */
	public static void main(String[] args) {
		ImitatorWindow imit = new ImitatorWindow("Imitator Window");
		imit.setVisible(true);
	}
	@Override
	public void update(Graphics g){
		paint(g);
	}
	/**
	 * This method plots the object.
	 */
	public void mouseClicked(MouseEvent arg0) {
		if(activate==true){
			if(!arg0.isMetaDown()){
		vect.addElement(new Shape());
		x=arg0.getX();
		y=arg0.getY();
		i++;
		shape=(Shape) vect.elementAt(i-1);
		shape.setX(x);
		shape.setY(y);
		}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {

	}
	@Override
	/**
	 * This method prints a string on the console.
	 */
	public void mouseExited(MouseEvent arg0) {
		System.out.println("Don't go outside!");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	@Override
	/**
	 * This method drags the object and set the new location of the object. 
	 */
	public void mouseDragged(MouseEvent arg0) {
		if(activate==true){
		if(!arg0.isMetaDown()){
			
			vect.addElement(new Shape());
			
			shape.setX(arg0.getX());
			shape.setY(arg0.getY());
		
		} 
		else{			
			for(int z=0;z<vect.size();z++){
				shape=(Shape)vect.elementAt(z);
				if(shape.getX()<arg0.getX() && shape.getY()<arg0.getY()){
						shape.setX(shape.getX()+1);
						shape.setY(shape.getY()+1);
				}
				else if(shape.getX()>arg0.getX() && shape.getY()>arg0.getY()){
						shape.setX(shape.getX()-1);
						shape.setY(shape.getY()-1);
				}
				else if(shape.getX()<arg0.getX() && shape.getY()>arg0.getY()){
						shape.setX(shape.getX()+1);
						shape.setY(shape.getY()-1);
				}
				else if(shape.getX()>arg0.getX() && shape.getY()<arg0.getY()){
						shape.setX(shape.getX()-1);
						shape.setY(shape.getY()+1);
				}
				repaint();
			}
		}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}
	@Override
	/**
	 * This method exits the window.
	 */
	public void windowClosing(WindowEvent arg0) {
		dispose();
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
	
	}
	@Override
	/**
	 * This method prints a string on the console.
	 */
	public void windowDeiconified(WindowEvent arg0) {
		System.out.println("There you are!");
	}
	@Override
	/**
	 * This method prints a string on the console.
	 */
	public void windowIconified(WindowEvent arg0) {
		System.out.println("Where are you?");
	}
	@Override
	/**
	 * This method prints a string on the console.
	 */
	public void windowOpened(WindowEvent arg0) {
		System.out.println("Welcome To My World!");	
	}
	@Override
	/**
	 * This method gets information when buttons where click.
	 */
	public void actionPerformed(ActionEvent arg0) {
		//start button
		if(arg0.getActionCommand().equalsIgnoreCase("Start"))
		{
			activate=true;//sets the activate to true 
			System.out.println("Right-click + drag to move!");
		}
		//stop button
		if(arg0.getActionCommand().equalsIgnoreCase("Stop")){
			activate=false;//sets the activate to false
			System.out.println("I can't move!");
			repaint();
		}
		//quit button
		if(arg0.getActionCommand().equalsIgnoreCase("Quit"))
			System.exit(0);//terminates the program
	}
}
