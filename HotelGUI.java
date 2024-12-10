import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HotelGUI extends JFrame implements ActionListener{
		
	
	public Color sol = new Color(0xFDB813);
	public Color luna = new Color(0x484849);
	public Color defaultBg = new Color(0xF6F1D5);
	
	
	JButton singleBtn, doubleBtn,suiteBtn, adminBtn;
	
	public HotelGUI() {
		
		//set title
		setTitle("SolLuna Hotel Reservation");
		
		//set size
		setSize(700, 400);
		
		//end app when closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//center
		setLocationRelativeTo(null);
		
		//no resize
		setResizable(false);
		
		setLayout(null);
		
		appIcon();	
		
		getContentPane().setBackground(defaultBg);
		
		//set GUI components
		mainLabels();
		
		pagePanels();
		
		setVisible(true);
		
	}

	private void appIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Logo.png");
		setIconImage(icon.getImage());
	}
	
	private void mainLabels() {
		JLabel welcomeLabel = new JLabel("Welcome To");
		welcomeLabel.setBounds(280,0,100,100);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel hotel = new JLabel("SolLuna Hotel \nReservation");
		hotel.setBounds(100,20,500,100);
		hotel.setHorizontalAlignment(SwingConstants.CENTER);
		hotel.setFont(new Font("Dialog", Font.BOLD, 24));
		
		

		
		add(welcomeLabel);
		add(hotel);
	}
public void pagePanels() {
		
		JLabel roomTypes = new JLabel("Select your desired room type: ");
		roomTypes.setBounds(250,90,300,15);
		roomTypes.setFont(new Font(null,Font.PLAIN, 10));
		
		//single bed
		JLabel singleTitle = new JLabel("Sleeping One");
		singleTitle.setBounds(20,50,250,150);
		singleTitle.setFont(new Font(null, Font.BOLD, 20));
		singleTitle.setForeground(new Color(0xF78D7D));
		
		JLabel singleDescription = new JLabel("Perfect for One");
		singleDescription.setBounds(20,100,250,150);
		
		JLabel singlePrice = new JLabel("$1000");
		singlePrice.setBounds(20,120,250,150);
		
		singleBtn = new JButton();
		singleBtn.addActionListener(this);
		singleBtn.setBounds(20,280,150,20);
		singleBtn.setText("Reserve Sleeping One");
		singleBtn.setFocusable(false);
		singleBtn.setBackground(Color.white);
		singleBtn.setFont(new Font(null, Font.PLAIN, 10));
		
		//double bed
		JLabel doubleTitle = new JLabel("Twin Bedwise");
		doubleTitle.setBounds(260,50,250,150);
		doubleTitle.setFont(new Font(null, Font.BOLD, 20));
		doubleTitle.setForeground(new Color(0x947481));
		
		JLabel doubleDescription = new JLabel("Perfect for Couples");
		doubleDescription.setBounds(260,100,250,150);
		
		JLabel doublePrice = new JLabel("$1800");
		doublePrice.setBounds(260,120,250,150);
		
		doubleBtn = new JButton();
		doubleBtn.addActionListener(this);
		doubleBtn.setBounds(260,280,140,20);
		doubleBtn.setText("Reserve Twin Bedwise");
		doubleBtn.setFocusable(false);
		doubleBtn.setBackground(Color.white);
		doubleBtn.setFont(new Font(null, Font.PLAIN, 10));
		
		//hotel suite
		JLabel suiteTitle = new JLabel("Super Suite");
		suiteTitle.setBounds(510,50,250,150);
		suiteTitle.setFont(new Font(null, Font.BOLD, 20));
		suiteTitle.setForeground(new Color(0x82716A));
		
		JLabel suiteDescription = new JLabel("Perfect for many People");
		suiteDescription.setBounds(510,100,250,150);
		
		JLabel suitePrice = new JLabel("$5000");
		suitePrice.setBounds(510,120,250,150);
		
		suiteBtn = new JButton();
		suiteBtn.addActionListener(this);
		suiteBtn.setBounds(510,280,140,20);
		suiteBtn.setText("Reserve Super Suite");
		suiteBtn.setFocusable(false);
		suiteBtn.setBackground(Color.white);
		suiteBtn.setFont(new Font(null, Font.PLAIN, 10));
		
		adminBtn = new JButton();
		adminBtn.addActionListener(this);
		adminBtn.setBounds(520,330,140,20);
		adminBtn.setText("<html> <u>Admin</u></html>");
		adminBtn.setFocusable(false);
		adminBtn.setContentAreaFilled(false);
		adminBtn.setBorderPainted(false); 
		adminBtn.setFocusPainted(false);
		adminBtn.setFont(new Font(null, Font.PLAIN, 10));
		adminBtn.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        adminBtn.setForeground(Color.BLUE);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		        adminBtn.setForeground(Color.BLACK);
		    }
		});
		
		add(roomTypes);
		add(singleTitle);
		add(doubleTitle);
		add(suiteTitle);
		add(singleDescription);
		add(singlePrice);
		add(doubleDescription);
		add(doublePrice);
		add(suiteDescription);
		add(suitePrice);
		add(singleBtn);
		add(doubleBtn);
		add(suiteBtn);
		add(adminBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==singleBtn){
			dispose();
			new SinglePage();
		}
		else if(e.getSource()==doubleBtn) {
			dispose();
			new DoublePage();
		}
		else if(e.getSource()==suiteBtn) {
			dispose();
			new SuitePage();
		}
		else if(e.getSource()==adminBtn) {
			dispose();
			new LoginAdmin();
		}
		
		
		
	}
	
	
	
	
}
