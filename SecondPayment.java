import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class SecondPayment extends JFrame implements ActionListener{
	public Color defaultBg = new Color(0xF6F1D5);
	
	String email,firstName,lastName;
	Date checkIn,checkOut;
	long convertedTime;
	int totalPay;
	private int roomNumber;
	JButton confirmBtn;
	
	public SecondPayment(String [] userData, Date checkIn,Date checkOut,int roomnum) {
				
				email = userData[0];
				firstName = userData[1];
				lastName = userData[2];
				this.roomNumber=roomnum;
				this.checkIn = checkIn;
				this.checkOut = checkOut;
				
				long totalTime = checkOut.getTime() - checkIn.getTime();
				convertedTime = totalTime /(1000*60*60*24);
				totalPay = (int) (convertedTime *1800); 
		
				//set title
				setTitle("Payment Page");
				
				//set size
				setSize(750, 500);
				
				//end app when closed
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				//center
				setLocationRelativeTo(null);
				
				//no resize
				setResizable(false);
				
				getContentPane().setLayout(null);
				
				appIcon();
				
				mainLabels();
				
				getContentPane().setBackground(defaultBg);
				
				
				setVisible(true);
	}
	private void mainLabels() {
		JLabel roomTxt = new JLabel("Room Type: ");
		roomTxt.setBounds(30,30,getWidth()-30, 40);
		roomTxt.setForeground(Color.black);
		roomTxt.setFont(new Font(null,Font.PLAIN,12));
		
		JLabel roomPic = new JLabel();
		roomPic.setBounds(130,-100,500, 300);
		roomPic.setIcon(singleIcon());
		
		JLabel singleTxt = new JLabel("Twin Bedwise");
		singleTxt.setBounds(440,30,getWidth()-30, 40);
		singleTxt.setForeground(Color.gray);
		singleTxt.setFont(new Font(null,Font.BOLD,20));
		
		JLabel emailTxt = new JLabel("Email: ");
		emailTxt.setBounds(10,100,getWidth()-30, 40);
		emailTxt.setForeground(Color.black);
		emailTxt.setFont(new Font(null,Font.PLAIN,14));
		
		JLabel userEmail = new JLabel(email);
		userEmail.setBounds(100,100,getWidth()-30, 40);
		userEmail.setForeground(Color.black);
		userEmail.setFont(new Font(null,Font.BOLD,14));
		
		JLabel fnTxt = new JLabel("First Name: ");
		fnTxt.setBounds(10,130,getWidth()-30, 40);
		fnTxt.setForeground(Color.black);
		fnTxt.setFont(new Font(null,Font.PLAIN,14));
		
		JLabel userFn = new JLabel(firstName);
		userFn.setBounds(100,130,getWidth()-30, 40);
		userFn.setForeground(Color.black);
		userFn.setFont(new Font(null,Font.BOLD,14));
		
		JLabel lnTxt = new JLabel("Last Name: ");
		lnTxt.setBounds(10,160,getWidth()-30, 40);
		lnTxt.setForeground(Color.black);
		lnTxt.setFont(new Font(null,Font.PLAIN,14));
		
		JLabel userLn = new JLabel(lastName);
		userLn.setBounds(100,160,getWidth()-30, 40);
		userLn.setForeground(Color.black);
		userLn.setFont(new Font(null,Font.BOLD,14));
		
		JLabel checkinTxt = new JLabel("Check-in: ");
		checkinTxt.setBounds(10,190,getWidth()-30, 40);
		checkinTxt.setForeground(Color.black);
		checkinTxt.setFont(new Font(null,Font.PLAIN,14));
		
		@SuppressWarnings("deprecation")
		JLabel checkinEdit = new JLabel(checkIn.getMonth()+"/"+checkIn.getDate()+"/"+(checkIn.getYear()+1900));
		checkinEdit.setBounds(100,190,getWidth()-30, 40);
		checkinEdit.setForeground(Color.black);
		checkinEdit.setFont(new Font(null,Font.BOLD,14));
		
		JLabel checkoutTxt = new JLabel("Check-out: ");
		checkoutTxt.setBounds(10,220,getWidth()-30, 40);
		checkoutTxt.setForeground(Color.black);
		checkoutTxt.setFont(new Font(null,Font.PLAIN,14));
		
		@SuppressWarnings("deprecation")
		JLabel checkoutEdit = new JLabel(checkOut.getMonth()+"/"+checkOut.getDate()+"/"+(checkOut.getYear()+1900));
		checkoutEdit.setBounds(100,220,getWidth()-30, 40);
		checkoutEdit.setForeground(Color.black);
		checkoutEdit.setFont(new Font(null,Font.BOLD,14));

		JLabel totalDays = new JLabel("Total Days: ");
		totalDays.setBounds(10,250,getWidth()-30, 40);
		totalDays.setForeground(Color.black);
		totalDays.setFont(new Font(null,Font.PLAIN,14));
		
		JLabel totalEdit = new JLabel();
		totalEdit.setText(convertedTime +" day/s");
		totalEdit.setBounds(100,250,getWidth()-30, 40);
		totalEdit.setForeground(Color.black);
		totalEdit.setFont(new Font(null,Font.BOLD,14));
		
		
		JLabel paymentTxt = new JLabel("Select Payment Method: ");
		paymentTxt.setBounds(10,280,getWidth()-30, 40);
		paymentTxt.setForeground(Color.black);
		paymentTxt.setFont(new Font(null,Font.PLAIN,14));
		
		JComboBox <String>paymentBox = new JComboBox<String>();
		paymentBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Cash","Bank Transfer","Credit Card"}));
		paymentBox.setBounds(200,290,130, 20);
		paymentBox.setBackground(Color.white);
		paymentBox.setForeground(Color.black);
		paymentBox.setFocusable(false);
		paymentBox.setFont(new Font(null,Font.BOLD,14));
		
		JLabel totalTxt = new JLabel("Total Payment: ");
		totalTxt.setBounds(10,350,getWidth()-30, 40);
		totalTxt.setForeground(Color.black);
		totalTxt.setFont(new Font(null,Font.PLAIN,14));
		
		JLabel totalPayment = new JLabel("$"+totalPay);
		totalPayment.setBounds(120,350,getWidth()-30, 40);
		totalPayment.setForeground(Color.black);
		totalPayment.setFont(new Font(null,Font.BOLD,14));
		
		JLabel userRoomnumEdit = new JLabel("Room Number: #"+roomNumber);
		userRoomnumEdit.setBounds(10,310,getWidth()-30, 40);
		userRoomnumEdit.setForeground(Color.black);
		userRoomnumEdit.setFont(new Font(null,Font.BOLD,14));
		
		confirmBtn = new JButton("Confirm Payment");
		confirmBtn.setBounds(180,363,130,20);
		confirmBtn.addActionListener(this);
		confirmBtn.setFocusable(false);
		confirmBtn.setBackground(Color.white);
		confirmBtn.setFont(new Font(null, Font.PLAIN, 10));
		
		add(roomTxt);
		add(roomPic);
		add(singleTxt);
		add(emailTxt);
		add(userEmail);
		add(fnTxt);
		add(userFn);
		add(lnTxt);
		add(userLn);
		add(checkinTxt);
		add(checkinEdit);
		add(checkoutTxt);
		add(checkoutEdit);
		add(totalDays);
		add(totalEdit);
		add(paymentTxt);
		add(paymentBox);
		add(totalTxt);
		add(totalPayment);
		add(confirmBtn);
		
		add(userRoomnumEdit);
		
	}
	private void appIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Logo.png");
		setIconImage(icon.getImage());
	}
	private Icon singleIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\doubleBed.jpg");
		return icon;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==confirmBtn) {
			AdminPage adminPage = AdminPage.instance;
            if (adminPage == null) {
                adminPage = new AdminPage();
                AdminPage.instance = adminPage;
            }
            
            // Add booking to AdminPage with room number 1 for single room
            adminPage.addBooking(firstName + " " + lastName, email, checkIn, checkOut, roomNumber,"Twin Bedwise");
			JOptionPane.showMessageDialog(confirmBtn, "Reserved Complete! \nThank you for using SolLuna Hotel Reservation");
			dispose();
			new HotelGUI();
			
		}
		
	}
}
