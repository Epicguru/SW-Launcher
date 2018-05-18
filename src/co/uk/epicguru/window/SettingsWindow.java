package co.uk.epicguru.window;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.uk.epicguru.main.Debug;

public class SettingsWindow extends JFrame {

	public static SettingsWindow open;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static SettingsWindow openNew() {
		if(open != null){
			Debug.log("Settings already open, cannot open new window!");
			return null;
		}
		try {
			SettingsWindow dialog = new SettingsWindow();
			dialog.setVisible(true);
			
			open = dialog;
			
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.addWindowListener(new WindowListener(){

			public void windowActivated(WindowEvent arg0) {
				
			}

			public void windowClosed(WindowEvent arg0) {
				
			}

			public void windowClosing(WindowEvent arg0) {
				Debug.log("Closing settings window...");
				
				setVisible(false);
				dispose();
				
				open = null;
			}

			public void windowDeactivated(WindowEvent arg0) {
				
			}

			public void windowDeiconified(WindowEvent arg0) {
				
			}

			public void windowIconified(WindowEvent arg0) {
				
			}

			public void windowOpened(WindowEvent arg0) {
				
			}
			
		});
		setBounds(100, 100, 382, 134);
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
		saveButton.setBounds(6, 71, 114, 28);
		contentPane.add(saveButton);
		SettingsWindow win = this;
		saveButton.addActionListener((x) -> {
			// Just close settings window. It will be saved.
			dispatchEvent(new WindowEvent(win, WindowEvent.WINDOW_CLOSING));
		});
	}
}
