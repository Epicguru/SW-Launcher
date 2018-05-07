package co.uk.epicguru.window;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import co.uk.epicguru.interaction.Interaction;
import co.uk.epicguru.main.Debug;

public class DownloadWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JProgressBar downloadPercentage;

	/**
	 * Launch the application.
	 */
	public static DownloadWindow openNew() {
		try {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}
			DownloadWindow dialog = new DownloadWindow();
			dialog.setVisible(true);
			
			return dialog;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean dialogOpen = false;
	private JLabel downloadState;
	
	/**
	 * Create the dialog.
	 */
	public DownloadWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DownloadWindow.class.getResource("/co/uk/epicguru/main/assets/Downloading Icon.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Downloading new version...");
		setBounds(100, 100, 450, 121);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel versionLabel = new JLabel("Downloading Skillwarz version [19a]");
		versionLabel.setBounds(10, 11, 424, 14);
		contentPanel.add(versionLabel);
		
		downloadPercentage = new JProgressBar();
		downloadPercentage.setBounds(10, 36, 424, 19);
		contentPanel.add(downloadPercentage);
		
		JButton cancelButton = new JButton("Cancel");
		DownloadWindow win = this;
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Is the user sure they want to cancel?
				if(dialogOpen)
					return;
				
				dialogOpen = true;
				ConfirmCancelDialog.open(() -> {
					
					// Confirm cancel.
					dialogOpen = false;
					
					// Just close, the window listener will detect the closing and will stop the download.
					dispatchEvent(new WindowEvent(win, WindowEvent.WINDOW_CLOSING));
					
				}, () -> {
					
					// Resume download.
					dialogOpen = false;				
					
				});
			}
		});
		cancelButton.setBounds(10, 57, 90, 28);
		contentPanel.add(cancelButton);
		
		super.addWindowListener(new WindowListener(){

			public void windowActivated(WindowEvent arg0) {	}
			public void windowClosed(WindowEvent arg0) {  }
			public void windowDeactivated(WindowEvent arg0) {  }
			public void windowDeiconified(WindowEvent arg0) {  }
			public void windowIconified(WindowEvent arg0) {  }
			public void windowOpened(WindowEvent arg0) {  }

			public void windowClosing(WindowEvent arg0) {
				Debug.log("Download window is closing, requested by user.");	
				
				Interaction.downloadWindowClosed();
				
				setVisible(false);
	            dispose();
			}			
		});
		
		downloadState = new JLabel("50 Mb/s - 0.35 of 2GB");
		downloadState.setBounds(110, 63, 324, 16);
		contentPanel.add(downloadState);
	}
	
	public JProgressBar getDownloadPercentage() {
		return downloadPercentage;
	}
	public JLabel getDownloadState() {
		return downloadState;
	}
}
