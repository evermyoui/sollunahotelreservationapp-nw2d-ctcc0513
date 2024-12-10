import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class SinglePage extends JFrame implements ActionListener{
	
	public Color luna = new Color(0x484849);
	JButton proceedBtn,backBtn;
	public JTextField userEdit, fnEdit, lnEdit;
	JDateChooser checkinDate,checkoutDate;
	public Date checkIn,checkOut;
	
	public SinglePage() {

		//set title
		setTitle("Sleeping One");
		
		//set size
		setSize(300, 500);
		
		//end app when closed
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//center
		setLocationRelativeTo(null);
		
		//no resize
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		appIcon();	
		
		getContentPane().setBackground(luna);
		
		//set GUI components
		mainLabels();
		
		setVisible(true);
	}
	private void appIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Logo.png");
		setIconImage(icon.getImage());
	}
	private void mainLabels() {
		
		JLabel title = new JLabel("Sleeping One Registration");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0,20,getWidth()-30, 40);
		title.setForeground(Color.white);
		title.setFont(new Font(null,Font.BOLD,18));
		
		JLabel userText = new JLabel("Email:");
		userText.setBounds(10,70,getWidth()-30, 40);
		userText.setForeground(Color.white);
		userText.setFont(new Font(null,Font.PLAIN,12));
		
		userEdit = new JTextField();
		userEdit.setBounds(80,80,180, 20);
		userEdit.setForeground(Color.black);
		userEdit.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel fnTxt = new JLabel("First Name:");
		fnTxt.setBounds(10,120,getWidth()-30, 40);
		fnTxt.setForeground(Color.white);
		fnTxt.setFont(new Font(null,Font.PLAIN,12));
		
		fnEdit = new JTextField();
		fnEdit.setBounds(80,130,180, 20);
		fnEdit.setForeground(Color.black);
		fnEdit.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel lnTxt = new JLabel("Last Name:");
		lnTxt.setBounds(10,170,getWidth()-30, 40);
		lnTxt.setForeground(Color.white);
		lnTxt.setFont(new Font(null,Font.PLAIN,12));
		
		lnEdit = new JTextField();
		lnEdit.setBounds(80,180,180, 20);
		lnEdit.setForeground(Color.black);
		lnEdit.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel roomTxt = new JLabel("Room Type: ");
		roomTxt.setBounds(10,220,getWidth()-30, 40);
		roomTxt.setForeground(Color.white);
		roomTxt.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel roomType = new JLabel("Sleeping One");
		roomType.setBounds(130,220,getWidth()-30, 40);
		roomType.setForeground(Color.white);
		roomType.setFont(new Font(null,Font.BOLD,14));
		
		JLabel checkin = new JLabel("Check in: ");
		checkin.setBounds(10,260,getWidth()-30, 40);
		checkin.setForeground(Color.white);
		checkin.setFont(new Font(null,Font.PLAIN,12));
		
		checkinDate = new JDateChooser();
		checkinDate.setBounds(80, 271, 180, 20);
		
		JLabel checkout = new JLabel("Check out: ");
		checkout.setBounds(10,300,getWidth()-30, 40);
		checkout.setForeground(Color.white);
		checkout.setFont(new Font(null,Font.PLAIN,12));
	
		checkoutDate = new JDateChooser();
		checkoutDate.setBounds(80, 308, 180, 20);

		
		proceedBtn = new JButton("Proceed Payment");
		proceedBtn.addActionListener(this);
		proceedBtn.setBounds(60,380,150,20);
		proceedBtn.setFocusable(false);
		proceedBtn.setBackground(Color.white);
		proceedBtn.setFont(new Font(null, Font.PLAIN, 10));
		
		if (isButtonDisabled) {
			proceedBtn.setEnabled(false);
		}
		backBtn = new JButton("Back");
		backBtn.addActionListener(this);
		backBtn.setBounds(98,412,84,20);
		backBtn.setFocusable(false);
		backBtn.setBackground(Color.white);
		backBtn.setFont(new Font(null, Font.PLAIN, 10));
		
		
		
		
		getContentPane().add(title);
		getContentPane().add(userText);
		getContentPane().add(userEdit);
		getContentPane().add(fnTxt);
		getContentPane().add(fnEdit);
		getContentPane().add(lnTxt);
		getContentPane().add(lnEdit);
		getContentPane().add(roomTxt);
		getContentPane().add(roomType);
		getContentPane().add(checkin);
		getContentPane().add(proceedBtn);
		getContentPane().add(checkout);
		getContentPane().add(checkinDate);
		getContentPane().add(checkoutDate);
		getContentPane().add(backBtn);
		
		
		
	}
	
	private static int lastAssignedRoom = 0;
	private static boolean isButtonDisabled = false;
	@Override
	public void actionPerformed(ActionEvent e) {
	    String username = this.userEdit.getText();
	    String firstName = this.fnEdit.getText();
	    String lastName = this.lnEdit.getText();
	    this.checkIn = this.checkinDate.getDate();
	    this.checkOut = this.checkoutDate.getDate();
	    int[] Space = new int[2];

	   
	    AdminPage adminPage = AdminPage.instance;
	    
	    
	    if (adminPage == null) {
	        adminPage = new AdminPage();
	        AdminPage.instance = adminPage;
	    }

	    // Calculate next room number
	    int roomnum = (lastAssignedRoom % Space.length) + 1;
	    lastAssignedRoom = roomnum; 
	    
	    if(e.getSource()==backBtn) {
	    	dispose();
	    	new HotelGUI();
	    }

	    else if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(this.rootPane, "Please Enter Email", "Cannot Proceed", 2);
	    } else if (firstName.isEmpty()) {
	        JOptionPane.showMessageDialog(this.rootPane, "Please Enter First Name", "Cannot Proceed", 2);
	    } else if (lastName.isEmpty()) {
	        JOptionPane.showMessageDialog(this.rootPane, "Please Enter Last Name", "Cannot Proceed", 2);
	    } else if (checkOut.before(checkIn)) {
	    	 JOptionPane.showMessageDialog(this.rootPane, "Error Date", "Cannot Proceed", 2);
	    } else if (roomnum == 2) {
	        JOptionPane.showMessageDialog(this.rootPane, "No Sleeping One Available", "Cannot Proceed", 2);
	        proceedBtn.setEnabled(false);
	        isButtonDisabled = true;
	    } else if (this.checkIn != null && this.checkOut != null) {
	        if (e.getSource() == this.proceedBtn) {
	       
	            
	            
	            String[] userData = {username, firstName, lastName};
	            this.dispose();
	            new PaymentPage(userData, this.checkIn, this.checkOut, roomnum);
                
	        }
	    } else {
	        JOptionPane.showMessageDialog(this.rootPane, "Please Enter Date", "Cannot Proceed", 2);
	    }
	 
	}
}
