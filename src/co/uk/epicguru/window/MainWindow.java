package co.uk.epicguru.window;

import java.awt.EventQueue;

import javax.swing.JFrame;

import co.uk.epicguru.main.assets.Assets;

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
		frmSkillwarzLauncher.setIconImage(Assets.loadImage("Icon.png"));
		frmSkillwarzLauncher.setTitle("Skillwarz Launcher");
		frmSkillwarzLauncher.setBounds(100, 100, 450, 300);
		frmSkillwarzLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
