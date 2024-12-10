
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginAdmin extends JFrame implements ActionListener{
	
	JButton proceedBtn, backBtn;
	JPasswordField passEdit;
	
	public LoginAdmin(){
		//set title
		setTitle("Confirm Admin");
		
		//set size
		setSize(430, 100);
		
		//end app when closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//center
		setLocationRelativeTo(null);
		
		//no resize
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		appIcon();
		
		mainLabels();
		
		setVisible(true);
	}
	private void appIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Logo.png");
		setIconImage(icon.getImage());
	}

	private void mainLabels() {
		JLabel passTxt = new JLabel("Password: ");
		passTxt.setBounds(10,10,getWidth()-30,20);
		
		passEdit = new JPasswordField();
		passEdit.setBounds(10,30,getWidth()-165,20);
		
		proceedBtn = new JButton("Enter");
		proceedBtn.setBounds(275,29,70,20);
		proceedBtn.setFocusable(false);
		proceedBtn.addActionListener(this);
		proceedBtn.setFont(new Font(null,Font.PLAIN,10));
		
		backBtn = new JButton("Back");
		backBtn.setBounds(345,29,70,20);
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		backBtn.setFont(new Font(null,Font.PLAIN,10));
		
		add(passTxt);
		add(passEdit);
		add(proceedBtn);
		add(backBtn);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		char[] pass = passEdit.getPassword();
		String password = new String (pass);
		
		if(e.getSource()==proceedBtn) {
			if(password.equals("Admin")) {
				AdminPage adminPage = AdminPage.instance;
				if (adminPage == null) {
					adminPage = new AdminPage();
					AdminPage.instance = adminPage;
				}
				adminPage.setVisible(true);
				dispose();
				
			}
			else {
				JOptionPane.showMessageDialog(this.rootPane, "Wrong Password", "Cannot Proceed", 2);
				passEdit.setText("");
			}
		}
		else if (e.getSource()==backBtn) {
			dispose();
			new HotelGUI();
		}
	}
	
	
}
