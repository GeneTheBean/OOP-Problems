import java.util.*;
import java.awt.*;

public class Robot extends Thread {
	private String color;
	private int position;
	private static Queue<String> q; //stores the steps of the sequence
	private static String turn;
	private static int dest;
	public static boolean running;
	private boolean buttonPushed;
	public Color swingColor;
	public boolean finished;
	
	Robot(String color) {
		this.color = color;
		
		if(color.equals("O"))
			swingColor = Color.ORANGE;
		
		else if(color.equals("B"))
			swingColor = Color.BLUE;
		
		setPosition(1);
	}
	
	public void commence(String sequence) {
		q = new LinkedList<String>();
		setSequence(sequence);
		update();	
		start();
	}
	
	public void run() {
	    try {
	    	Thread.sleep(1000);
	    	running = true;
	    	Color original = swingColor;
	    	
	    	while(running) {
	    		buttonPushed = false;
	    		if(turn.equals(color)) {
	    			if(getPosition() < dest){
	    				setPosition(getPosition() + 1);
	    				System.out.println(color + " Move to button " + getPosition());
	    			}
	    	
	    			else if(getPosition() == dest){
	    				swingColor = Color.GRAY;
	    				System.out.println(color + " Push button " + getPosition());	
	    				buttonPushed = true;
	    			}
	    		}
	    		else {
	    			System.out.println(color + " Stay at button " + getPosition());
	    		}
	    		Thread.sleep(1000);
	    		
	    		Simulation.time += 0.5;
	    		
	    		if(buttonPushed == true){
	    			update();
	    			swingColor = original;
	    		}
	    	}
	    } catch (InterruptedException e) {
	    	System.out.println("Bot " +  color + " interrupted.");
	      }
	}

	public static void update() {
		try{
			turn = q.remove();
			dest = Integer.parseInt(q.remove());
			
		} catch (NoSuchElementException e) { 
			running = Simulation.running = false;
			if(running == false ) {
    			System.out.println("Time elapsed: " + Simulation.time + "s");
    		}
    	 }
	}
	
	public static void setSequence(String sequence) {
		int i = 0;
		String s = "";
		
		while(true) {
			if(i >= sequence.length()) {
				q.add(s);
				break;
			}
			
			if(sequence.charAt(i) == ' ') {
				q.add(s);
				s = "";
			}
			
			else s += sequence.charAt(i);
			i++;
		}
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Color getColor() {
		return swingColor;
	}
}