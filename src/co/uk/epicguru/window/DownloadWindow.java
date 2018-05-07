package co.uk.epicguru.window;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

public class DownloadWindow extends JDialog {

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
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			return dialog;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Create the dialog.
	 */
	public DownloadWindow() {
		setType(Type.POPUP);
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
		cancelButton.setBounds(10, 57, 90, 28);
		contentPanel.add(cancelButton);
		
		JLabel downloadState = new JLabel("50 Mb/s - 0.35 of 2GB");
		downloadState.setBounds(110, 63, 324, 16);
		contentPanel.add(downloadState);
	}
	public JProgressBar getDownloadPercentage() {
		return downloadPercentage;
	}
}
