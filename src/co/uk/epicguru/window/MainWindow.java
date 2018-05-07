package co.uk.epicguru.window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import co.uk.epicguru.interaction.Interaction;
import co.uk.epicguru.main.assets.Assets;

public class MainWindow {

	private JFrame frame;

	public static void launch(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception e) {
						e.printStackTrace();
					}
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
		frame.setResizable(false);
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
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		playButton.setBorder(emptyBorder);
		
		JLabel forumLabel = new JLabel("");
		forumLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Forums.png")));
		springLayout.putConstraint(SpringLayout.NORTH, forumLabel, 6, SpringLayout.SOUTH, titleLogo);
		springLayout.putConstraint(SpringLayout.WEST, forumLabel, 0, SpringLayout.WEST, titleLogo);
		frame.getContentPane().add(forumLabel);
		
		JButton forumsButton = new JButton("Visit Forums");
		forumsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interaction.openForums();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, forumsButton, 6, SpringLayout.SOUTH, titleLogo);
		springLayout.putConstraint(SpringLayout.WEST, forumsButton, 6, SpringLayout.EAST, forumLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, forumsButton, 0, SpringLayout.SOUTH, forumLabel);
		springLayout.putConstraint(SpringLayout.EAST, forumsButton, 172, SpringLayout.EAST, forumLabel);
		forumsButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(forumsButton);
		
		JLabel youtubeLabel = new JLabel("");
		youtubeLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Youtube.png")));
		springLayout.putConstraint(SpringLayout.NORTH, youtubeLabel, 6, SpringLayout.SOUTH, forumLabel);
		springLayout.putConstraint(SpringLayout.WEST, youtubeLabel, 0, SpringLayout.WEST, titleLogo);
		frame.getContentPane().add(youtubeLabel);
		
		JButton youtubeButton = new JButton("Youtube Channel");
		youtubeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interaction.openYoutube();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, youtubeButton, 6, SpringLayout.SOUTH, forumsButton);
		springLayout.putConstraint(SpringLayout.WEST, youtubeButton, 6, SpringLayout.EAST, youtubeLabel);
		springLayout.putConstraint(SpringLayout.EAST, youtubeButton, 172, SpringLayout.EAST, youtubeLabel);
		youtubeButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(youtubeButton);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, playButton);
		springLayout.putConstraint(SpringLayout.WEST, panel, 4, SpringLayout.EAST, playButton);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -5, SpringLayout.SOUTH, playButton);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frame.getContentPane());
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel stateLabel = new JLabel("Ready to play!");
		sl_panel.putConstraint(SpringLayout.NORTH, stateLabel, 3, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, stateLabel, 5, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, stateLabel, -5, SpringLayout.EAST, panel);
		panel.add(stateLabel);
		
		JLabel versionLabel = new JLabel("Downloaded game version: 18b");
		sl_panel.putConstraint(SpringLayout.NORTH, versionLabel, 5, SpringLayout.SOUTH, stateLabel);
		sl_panel.putConstraint(SpringLayout.WEST, versionLabel, 0, SpringLayout.WEST, stateLabel);
		sl_panel.putConstraint(SpringLayout.EAST, versionLabel, -5, SpringLayout.EAST, panel);
		panel.add(versionLabel);
		
		JButton testDownload = new JButton("Test Download");
		testDownload.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				Interaction.testDownload();
			}			
		});
		springLayout.putConstraint(SpringLayout.NORTH, testDownload, 6, SpringLayout.SOUTH, youtubeButton);
		springLayout.putConstraint(SpringLayout.WEST, testDownload, 0, SpringLayout.WEST, forumsButton);
		springLayout.putConstraint(SpringLayout.EAST, testDownload, 0, SpringLayout.EAST, forumsButton);
		frame.getContentPane().add(testDownload);
		
		frame.setIconImage(Assets.loadImage("Icon.png"));
		frame.setTitle("Skillwarz Launcher");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Youtube link https://www.youtube.com/user/OneManArmy3D
	}
}
