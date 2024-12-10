import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class SuitePage extends JFrame implements ActionListener{
	
	public Color sol = new Color(0xFDB813);
	JButton proceedBtn,backBtn;
	JDateChooser checkinDate,checkoutDate;
	public Date checkIn,checkOut;
	JTextField userEdit,fnEdit,lnEdit;
	public SuitePage() {

		//set title
		setTitle("Super Suite");
		
		//set size
		setSize(300, 500);
		
		//end app when closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//center
		setLocationRelativeTo(null);
		
		//no resize
		setResizable(false);
		
		setLayout(null);
		
		appIcon();	
		
		getContentPane().setBackground(sol);
		
		//set GUI components
		mainLabels();
		
		setVisible(true);
	}
	private void appIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Logo.png");
		setIconImage(icon.getImage());
	}
	private void mainLabels() {
		
		JLabel title = new JLabel("Super Suite Registration");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0,20,getWidth()-30, 40);
		title.setForeground(Color.black);
		title.setFont(new Font(null,Font.BOLD,18));
		
		JLabel userText = new JLabel("Email:");
		userText.setBounds(10,70,getWidth()-30, 40);
		userText.setForeground(Color.black);
		userText.setFont(new Font(null,Font.PLAIN,12));
		
		userEdit = new JTextField();
		userEdit.setBounds(80,80,180, 20);
		userEdit.setForeground(Color.black);
		userEdit.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel fnTxt = new JLabel("First Name:");
		fnTxt.setBounds(10,120,getWidth()-30, 40);
		fnTxt.setForeground(Color.black);
		fnTxt.setFont(new Font(null,Font.PLAIN,12));
		
		fnEdit = new JTextField();
		fnEdit.setBounds(80,130,180, 20);
		fnEdit.setForeground(Color.black);
		fnEdit.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel lnTxt = new JLabel("Last Name:");
		lnTxt.setBounds(10,170,getWidth()-30, 40);
		lnTxt.setForeground(Color.black);
		lnTxt.setFont(new Font(null,Font.PLAIN,12));
		
		lnEdit = new JTextField();
		lnEdit.setBounds(80,180,180, 20);
		lnEdit.setForeground(Color.black);
		lnEdit.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel roomTxt = new JLabel("Room Type: ");
		roomTxt.setBounds(10,220,getWidth()-30, 40);
		roomTxt.setForeground(Color.black);
		roomTxt.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel roomType = new JLabel("Super Suite");
		roomType.setBounds(130,220,getWidth()-30, 40);
		roomType.setForeground(Color.black);
		roomType.setFont(new Font(null,Font.BOLD,14));
		
		JLabel checkin = new JLabel("Check in: ");
		checkin.setBounds(10,260,getWidth()-30, 40);
		checkin.setForeground(Color.black);
		checkin.setFont(new Font(null,Font.PLAIN,12));
		
		checkinDate = new JDateChooser();
		checkinDate.setBounds(80, 271, 180, 20);
		
		JLabel checkout = new JLabel("Check out: ");
		checkout.setBounds(10,300,getWidth()-30, 40);
		checkout.setForeground(Color.black);
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
		
		add(title);
		add(userText);
		add(userEdit);
		add(fnTxt);
		add(fnEdit);
		add(lnTxt);
		add(lnEdit);
		add(roomTxt);
		add(roomType);
		add(checkin);
		getContentPane().add(checkout);
		getContentPane().add(checkinDate);
		getContentPane().add(checkoutDate);
		add(proceedBtn);
		add(backBtn);
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
	    int[] Space = new int[5];

	   
	    AdminPage adminPage = AdminPage.instance;
	    
	    
	    if (adminPage == null) {
	        adminPage = new AdminPage();
	        AdminPage.instance = adminPage;
	    }

	    // Calculate next room number
	    int roomnum = (lastAssignedRoom % Space.length) + 11;
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
	    } else if (roomnum == 16) {
	        JOptionPane.showMessageDialog(this.rootPane, "No Twin Bedwise Available", "Cannot Proceed", 2);
	        proceedBtn.setEnabled(false);
	        isButtonDisabled = true;
	    } else if (this.checkIn != null && this.checkOut != null) {
	        if (e.getSource() == this.proceedBtn) {
	       
	            
	            
	            String[] userData = {username, firstName, lastName};
	            this.dispose();
	            new SuitePayment(userData, this.checkIn, this.checkOut, roomnum);
                
	        }
	    } else {
	        JOptionPane.showMessageDialog(this.rootPane, "Please Enter Date", "Cannot Proceed", 2);
	    }
	 
	}
}
