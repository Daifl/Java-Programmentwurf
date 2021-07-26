import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class optionen {

	private JFrame frmOptions;
	private JTextField namefield;
	public JTextField clientID;

	/**
	 * Launch the application.
	 */
	public static void OptionScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					optionen window = new optionen();
					window.frmOptions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public optionen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOptions = new JFrame();
		frmOptions.setTitle("Options");
		frmOptions.setBounds(100, 100, 646, 351);
		frmOptions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOptions.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmOptions.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		
		
		JList list = new JList(getRingtones());
		list.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ringtone");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selected = (String) list.getSelectedValue();
				SoundLoader.ringtone = selected;
				
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		frmOptions.getContentPane().add(panel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		namefield = new JTextField();
		namefield.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Client ID");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		clientID = new JTextField();
		clientID.setColumns(10);
		
		JButton set = new JButton("Apply Changes");
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ErstesFrame.ID = Integer.parseInt(clientID.getText());
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(set, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(clientID, Alignment.LEADING)
						.addComponent(namefield, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
					.addContainerGap(255, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(namefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(clientID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(set)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		

		
		
		
	}
	
	public String[] getRingtones(){
		
		File f = new File(System.getProperty("user.dir") + "\\res\\" + "ringtones");
		
		return f.list();
	
	
	}
}
