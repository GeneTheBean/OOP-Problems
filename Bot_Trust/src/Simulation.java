import javax.swing.*;
import java.awt.*;

public class Simulation {
	private Robot r1;
	private Robot r2;
	public static float time = 0;
	public static boolean running;
	String sequence;
	
	public Simulation () {
		r1 = new Robot("O");
		r2 = new Robot("B");
		sequence = "O 2 B 1 B 2 B 4";
	}
	
	public void start() {
		running = true;
		r1.commence(sequence);
		r2.commence(sequence);
	}

	public void createAndShowGUI() {
    	JFrame f = new JFrame();
    	
    	JPanel panel = new JPanel();
    	f.getContentPane().add(panel);
    	panel.setLayout(new BorderLayout());
    	
    	MyPanel canvas = new MyPanel(r1,r2);
    	panel.add(canvas, BorderLayout.CENTER);
    	
    	f.setTitle("Bot Trust");
    	f.setSize(300, 200);
    	f.setLocationRelativeTo(null);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setVisible(true);
	}

	public static void main(String [] args) {
		Simulation sim = new Simulation();
		sim.createAndShowGUI();
		sim.start();
	}
}

class MyPanel extends JPanel {
    private Robot r1;
    private Robot r2;
    private int scale = 5;
    
	public MyPanel(Robot r1, Robot r2) {
		this.r1 = r1;
		this.r2 = r2;
        setBackground(Color.WHITE);
    }
	
    public void paintComponent(Graphics g) {
    	if(Simulation.running) {
    		super.paintComponent(g);       
    		
    		//Robot 1
    		g.setColor(r1.getColor());
    		g.fillOval (r1.getPosition() * scale, 20, 50, 50); 
        
    		//Robot 2
    		g.setColor(r2.getColor());
    		g.fillOval (r2.getPosition() * scale, 100, 50, 50); 
    		
    		repaint();  		
    	}
    }  
}
