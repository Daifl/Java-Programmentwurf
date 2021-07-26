import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.Desktop;
import static java.util.concurrent.TimeUnit.*;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.DropMode;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;

public class ErstesFrame extends JFrame implements ActionListener {

	/**
	 * Launch the application.
	 */
	
	public SoundLoader sound = new SoundLoader();
	private JTextField txtDial;
	JPanel header = new JPanel();
	JLabel ClientID = new JLabel("Client - "+ID);
	
	optionen os = new optionen();
	public static int ID = 1;
	public static int rings = 0;

	
	public static void main(String[] args) {
		ErstesFrame frame = new ErstesFrame();	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	      Timer t = new Timer();
	      t.schedule(new TimerTask(){

	         @Override
	         public void run() { 
	        	frame.setTitle("Phone Client - Client "+ID);
	        	frame.ClientID.setText("Client - "+ID);
	    		
	    		int call = 0;
	    		
	    		try {
	            	URL meineurl = new URL("http://localhost:8080/getCall");	            	
	            	URLConnection verbindung = meineurl.openConnection();
	            	final BufferedReader in = new BufferedReader(
	            	                        new InputStreamReader(
	            	                        verbindung.getInputStream()));

	            	call = Integer.parseInt(in.readLine());
	      	
            	} catch ( IOException e2) {
            		;
            	}
	    		
	    		if(ID == call) {
	    			
	    			if(rings == 0) {
	    				frame.browser();
	    			}
	    			
	    			if(rings <=7) {
	    				frame.ring();
	    				frame.header.setBackground(Color.green);
	    			try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    			frame.header.setBackground(null);

	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		frame.getContentPane().setBackground(null);
	    		rings++;
	    		}else{
	    			rings = 0;
	    			try {
	    				
	    				URL meineurl2 = new URL("http://localhost:8080/receiveCall/0/");
	    	        	URLConnection verbindung2 = meineurl2.openConnection();
	    	        	final BufferedReader in2 = new BufferedReader(new InputStreamReader(verbindung2.getInputStream()));
    	        	} catch ( IOException e2) {
    	        		
    	        	}
	    		}
    		}
         }
         
      }, 0, 2000);
   }
	
	private void schedule(TimerTask timerTask, int i, int j) {
		
	}


	/**
	 * Create the frame.
	 */
	public ErstesFrame() {
		setTitle("Phone Client - Client "+ID);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 320);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		getContentPane().add(header, BorderLayout.NORTH);
		
		JLabel ClientID = new JLabel("Client - "+ID);
		header.add(ClientID);
		ClientID.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JPanel left = new JPanel();
		getContentPane().add(left, BorderLayout.WEST);
		left.setLayout(new BorderLayout(0, 0));
			
		String OnlineClients [] = {"1", "2","3"};
		
		JList ClientList = new JList(OnlineClients);
		ClientList.setBorder(new EmptyBorder(10, 10, 10, 10));
		ClientList.setFont(new Font("Segoe UI", Font.BOLD, 20));
		left.add(ClientList);
		
		JPanel right = new JPanel();
		getContentPane().add(right, BorderLayout.CENTER);
		right.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		right.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtDial = new JTextField();
		panel.add(txtDial);
		txtDial.setForeground(new Color(51, 51, 51));
		txtDial.setText("Dial");
		txtDial.setBackground(new Color(204, 255, 204));
		txtDial.setFont(new Font("Segoe UI", Font.BOLD, 33));
		txtDial.setHorizontalAlignment(SwingConstants.CENTER);
		txtDial.setColumns(10);
		
		
		txtDial.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	                txtDial.setText("");
	            }
	        });
		
		JPanel panel_1 = new JPanel();
		right.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton acceptCall = new JButton("");
		acceptCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
    				
    				URL meineurl2 = new URL("http://localhost:8080/receiveCall/" + Integer.parseInt(txtDial.getText()) + "/");
    	        	URLConnection verbindung2 = meineurl2.openConnection();
    	        	final BufferedReader in2 = new BufferedReader(new InputStreamReader(verbindung2.getInputStream()));
    				
    	        	
	        	} catch ( IOException e2) {
	        		
	        	}
			}
		});
		panel_1.add(acceptCall);
		acceptCall.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\res\\" + "acceptCall.png"));
		
		JButton declineCall = new JButton("");
		declineCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
    				
    				URL meineurl2 = new URL("http://localhost:8080/receiveCall/0/");
    	        	URLConnection verbindung2 = meineurl2.openConnection();
    	        	final BufferedReader in2 = new BufferedReader(new InputStreamReader(verbindung2.getInputStream()));
    				
    	        	
    	        	} catch ( IOException e2) {
    	        		
    	        	}
			}
		});
		panel_1.add(declineCall);
		declineCall.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\res\\" + "declineCall.png"));
		
		JButton options = new JButton("");
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionen.OptionScreen();
				System.out.println("Hallo");
			}
		});
		panel_1.add(options);
		options.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\res\\" + "options.png"));
		

	}
	
	public void browser() {

		String url = "http://www.google.com";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
	}
	
	public void ring() {
		sound.load();
		sound.play(SoundLoader.sound);
	}
	
	public void actionPerformed(ActionEvent e) {

		}
}
