package co.uk.epicguru.window;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class ConfirmCancelDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmCancelDialog dialog = new ConfirmCancelDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmCancelDialog() {
		setBounds(100, 100, 450, 300);

	}

}
