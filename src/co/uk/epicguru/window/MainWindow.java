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
		frame.getContentPane().setLayout(null);
		
		JLabel titleLogo = new JLabel("");
		titleLogo.setBounds(10, 10, 574, 78);
		titleLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Logo.png")));
		frame.getContentPane().add(titleLogo);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBounds(10, 354, 150, 57);
		playButton.setBackground(new Color(152, 251, 152));
		playButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.getContentPane().add(playButton);
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		playButton.setBorder(emptyBorder);
		
		JLabel forumLabel = new JLabel("");
		forumLabel.setBounds(10, 95, 32, 32);
		forumLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Forums.png")));
		frame.getContentPane().add(forumLabel);
		
		JButton forumsButton = new JButton("Visit Forums");
		forumsButton.setBounds(50, 95, 175, 32);
		forumsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interaction.openForums();
			}
		});
		forumsButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(forumsButton);
		
		JLabel youtubeLabel = new JLabel("");
		youtubeLabel.setBounds(10, 135, 32, 32);
		youtubeLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Youtube.png")));
		frame.getContentPane().add(youtubeLabel);
		
		JButton youtubeButton = new JButton("Youtube Channel");
		youtubeButton.setBounds(50, 135, 175, 32);
		youtubeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interaction.openYoutube();
			}
		});
		youtubeButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(youtubeButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(164, 359, 420, 47);
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
		testDownload.setBounds(353, 177, 175, 32);
		testDownload.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				Interaction.testDownload();
			}			
		});
		frame.getContentPane().add(testDownload);
		
		JButton manualButton = new JButton("Manual Download");
		manualButton.addActionListener((x) -> {
			Interaction.openManualDownload();
		});
		manualButton.setBounds(50, 175, 175, 32);
		manualButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(manualButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.addActionListener((x) -> {
			// Open settings window.
			SettingsWindow.openNew();
		});
		settingsButton.setBounds(50, 215, 175, 32);
		settingsButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(settingsButton);
		
		JLabel manualLabel = new JLabel("");
		manualLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Manual Download.png")));
		manualLabel.setBounds(10, 175, 32, 32);
		frame.getContentPane().add(manualLabel);
		
		JLabel settingsLabel = new JLabel("");
		settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Settings.png")));
		settingsLabel.setBounds(10, 215, 32, 32);
		frame.getContentPane().add(settingsLabel);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Background.png")));
		background.setBounds(0, -20, 600, 450);
		frame.getContentPane().add(background);
		
		frame.setIconImage(Assets.loadImage("Icon.png"));
		frame.setTitle("Skillwarz Launcher");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
