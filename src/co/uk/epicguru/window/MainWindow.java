package co.uk.epicguru.window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import co.uk.epicguru.main.assets.Assets;

public class MainWindow {

	private JFrame frame;

	public static void launch(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel titleLogo = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, titleLogo, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, titleLogo, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, titleLogo, 88, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, titleLogo, -10, SpringLayout.EAST, frame.getContentPane());
		titleLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Logo.png")));
		frame.getContentPane().add(titleLogo);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBackground(new Color(152, 251, 152));
		playButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, playButton, -67, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, playButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, playButton, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, playButton, 160, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(playButton);
		
		JLabel stateLabel = new JLabel("Ready to play!");
		springLayout.putConstraint(SpringLayout.EAST, stateLabel, 0, SpringLayout.EAST, titleLogo);
		stateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, stateLabel, -67, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, stateLabel, -36, SpringLayout.SOUTH, frame.getContentPane());
		stateLabel.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, stateLabel, 6, SpringLayout.EAST, playButton);
		frame.getContentPane().add(stateLabel);
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		playButton.setBorder(emptyBorder);
		
		JLabel forumLabel = new JLabel("");
		forumLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Forums.png")));
		springLayout.putConstraint(SpringLayout.NORTH, forumLabel, 6, SpringLayout.SOUTH, titleLogo);
		springLayout.putConstraint(SpringLayout.WEST, forumLabel, 0, SpringLayout.WEST, titleLogo);
		frame.getContentPane().add(forumLabel);
		frame.setIconImage(Assets.loadImage("Icon.png"));
		frame.setTitle("Skillwarz Launcher");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
