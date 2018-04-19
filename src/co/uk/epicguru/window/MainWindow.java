package co.uk.epicguru.window;

import java.awt.EventQueue;

import javax.swing.JFrame;

import co.uk.epicguru.main.assets.Assets;
import java.awt.Color;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window.Type;

public class MainWindow {

	private JFrame frmSkillwarzLauncher;

	public static void launch(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSkillwarzLauncher.setVisible(true);
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
		frmSkillwarzLauncher = new JFrame();
		frmSkillwarzLauncher.setBackground(Color.LIGHT_GRAY);
		frmSkillwarzLauncher.getContentPane().setBackground(Color.DARK_GRAY);
		SpringLayout springLayout = new SpringLayout();
		frmSkillwarzLauncher.getContentPane().setLayout(springLayout);
		
		JLabel titleLogo = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, titleLogo, 10, SpringLayout.NORTH, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, titleLogo, 10, SpringLayout.WEST, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, titleLogo, 88, SpringLayout.NORTH, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, titleLogo, -10, SpringLayout.EAST, frmSkillwarzLauncher.getContentPane());
		titleLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/co/uk/epicguru/main/assets/Logo.png")));
		frmSkillwarzLauncher.getContentPane().add(titleLogo);
		
		JButton playButton = new JButton("PLAY");
		playButton.setBackground(new Color(152, 251, 152));
		playButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, playButton, -67, SpringLayout.SOUTH, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, playButton, 10, SpringLayout.WEST, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, playButton, -10, SpringLayout.SOUTH, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, playButton, 160, SpringLayout.WEST, frmSkillwarzLauncher.getContentPane());
		frmSkillwarzLauncher.getContentPane().add(playButton);
		
		JLabel stateLabel = new JLabel("Ready to play!");
		springLayout.putConstraint(SpringLayout.EAST, stateLabel, 0, SpringLayout.EAST, titleLogo);
		stateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, stateLabel, -67, SpringLayout.SOUTH, frmSkillwarzLauncher.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, stateLabel, -36, SpringLayout.SOUTH, frmSkillwarzLauncher.getContentPane());
		stateLabel.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, stateLabel, 6, SpringLayout.EAST, playButton);
		frmSkillwarzLauncher.getContentPane().add(stateLabel);
		frmSkillwarzLauncher.setIconImage(Assets.loadImage("Icon.png"));
		frmSkillwarzLauncher.setTitle("Skillwarz Launcher");
		frmSkillwarzLauncher.setBounds(100, 100, 729, 487);
		frmSkillwarzLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
