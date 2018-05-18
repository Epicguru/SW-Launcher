package co.uk.epicguru.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.uk.epicguru.main.Debug;

public class SettingsWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static SettingsWindow openNew() {
		try {
			SettingsWindow dialog = new SettingsWindow();
			dialog.setVisible(true);
			
			return dialog;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Create the frame.
	 */
	public SettingsWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SettingsWindow.class.getResource("/co/uk/epicguru/main/assets/Settings.png")));
		setTitle("Skillwarz Launcher Settings");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Launcher Settings");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("SansSerif", Font.BOLD, 24));
		title.setBounds(6, 6, 364, 37);
		contentPane.add(title);
		
		JButton saveButton = new JButton("Save Settings");
		saveButton.setBounds(6, 337, 114, 28);
		contentPane.add(saveButton);
		
		JLabel gameDirLabel = new JLabel("Game Install Location");
		gameDirLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		gameDirLabel.setBounds(6, 55, 364, 16);
		contentPane.add(gameDirLabel);
		
		JButton changeGameDir = new JButton("Change");
		changeGameDir.addActionListener((x) -> {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File("."));
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = fc.showOpenDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION){
				File selected = fc.getSelectedFile();
				Debug.log(selected.getAbsolutePath());
			}
		});
		changeGameDir.setBounds(280, 74, 90, 28);
		contentPane.add(changeGameDir);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 74, 265, 28);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel currentGameDir = new JLabel("D:\\Documents\\Skillwarz");
		currentGameDir.setBounds(6, 6, 352, 16);
		panel.add(currentGameDir);
	}
}
