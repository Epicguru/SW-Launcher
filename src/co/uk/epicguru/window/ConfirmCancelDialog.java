package co.uk.epicguru.window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import co.uk.epicguru.main.Debug;

@SuppressWarnings("serial")
public class ConfirmCancelDialog extends JDialog {

	public static void open(Runnable confirm, Runnable cancel){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmCancelDialog dialog = new ConfirmCancelDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.confirm = confirm;
					dialog.cancel = cancel;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean closed = false;

	private Runnable confirm;
	private Runnable cancel;
	
	private boolean alreadyRan = false;
	
	/**
	 * Create the dialog.
	 */
	public ConfirmCancelDialog() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmCancelDialog.class.getResource("/co/uk/epicguru/main/assets/Download Cancel Icon.png")));
		setTitle("Confirm Download Cancel");
		setBounds(100, 100, 306, 135);
		getContentPane().setLayout(null);
		
		JButton confirmButton = new JButton("Yes, Cancel");
		confirmButton.setBackground(new Color(255, 99, 71));
		confirmButton.setBounds(6, 72, 94, 28);
		getContentPane().add(confirmButton);
		
		confirmButton.addActionListener((x) -> {
			alreadyRan = true;
			this.confirmCancel();
		});
		
		JButton returnButton = new JButton("No, Continue Download");
		returnButton.setBackground(new Color(60, 179, 113));
		returnButton.setBounds(112, 72, 182, 28);
		getContentPane().add(returnButton);
		
		returnButton.addActionListener((x) -> {
			alreadyRan = true;
			this.continueDownload(false);
		});
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to STOP the download?");
		lblAreYouSure.setBounds(6, 6, 288, 16);
		getContentPane().add(lblAreYouSure);
		
		JLabel lblTheDownloadCan = new JLabel("The download CAN NOT be resumed later.");
		lblTheDownloadCan.setBounds(6, 34, 288, 16);
		getContentPane().add(lblTheDownloadCan);
		
		super.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				
				if(!alreadyRan){					
					continueDownload(true);
				}
				closed = true;
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	private void confirmCancel(){
		Debug.log("User chose to cancel download, ok then...");
		
		if(this.confirm != null) this.confirm.run();
		
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	private void continueDownload(boolean isClosing){
		Debug.log("User chose to continue download, cool.");
		
		if(this.cancel != null) this.cancel.run();		
		
		if(!isClosing)
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
