import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class AdminPage extends JFrame {
    public static AdminPage instance;
	private JTable bookingTable;
    private DefaultTableModel tableModel;
    private JLabel statusLabel;
    private ArrayList<BookingInfo> bookings;
    private static final int MAX_ROOMS = 15;
    public Color defaultBg = new Color(0xF6F1D5);

  
    
    public AdminPage() {
        setTitle("Admin");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        appIcon();
        bookings = new ArrayList<>();
        mainComponents();
		
    }

    private void appIcon() {
		ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Logo.png");
		setIconImage(icon.getImage());
	}
    private void mainComponents() {
        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        // Create table
        String[] columns = {"Room No.", "Guest Name", "Email","Room Type", "Check-in", "Check-out", "Status"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        bookingTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookingTable);
        
        // Style the table
        bookingTable.setFillsViewportHeight(true);
        bookingTable.setRowHeight(25);
        bookingTable.getTableHeader().setFont(new Font(null, Font.BOLD, 12));
        bookingTable.setBackground(defaultBg);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton sortButton = new JButton("Sort by Date of Check-out");
        sortButton.setFocusable(false);
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        statusLabel = new JLabel();
        statusLabel.setText(String.format("Available Rooms: %d", MAX_ROOMS - bookings.size()));
        statusLabel.setForeground(new Color(0, 100, 0));
        statusLabel.setFont(new Font(null, Font.BOLD, 14));

        buttonPanel.add(sortButton);
        buttonPanel.add(backButton);
        buttonPanel.add(statusLabel);

        // Add components to main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add action listeners
        sortButton.addActionListener(e -> sortBookings());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HotelGUI();
            }
        });

        add(mainPanel);
    }

    private void sortBookings() {
        Collections.sort(bookings, (a,b)-> a.getCheckOut().compareTo(b.getCheckOut()));
        updateTable();
    }

    private void refreshBookings() {
        updateTable();
        checkRoomAvailability();
    }

    private void updateTable() {
        tableModel.setRowCount(0); // Clear table
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (BookingInfo booking : bookings) {
            Object[] row = {
            	
                booking.getRoomNumber(),
                booking.getGuestName(),
                booking.getEmail(),
                booking.getRoomType(),
                dateFormat.format(booking.getCheckIn()),
                dateFormat.format(booking.getCheckOut()),
                booking.getStatus()
            };
            tableModel.addRow(row);
        }
    }

    private void checkRoomAvailability() {
        if (bookings.size() >= MAX_ROOMS) {
            statusLabel.setText("All rooms are occupied!");
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setText(String.format("Available Rooms: %d", MAX_ROOMS - bookings.size()));
            statusLabel.setForeground(new Color(0, 100, 0));
        }
    }

    // Method to add new booking
    public void addBooking(String guestName, String email, Date checkIn, Date checkOut, int roomNumber, String roomType) {
        try {
            bookings.add(new BookingInfo(guestName, email, checkIn, checkOut, roomNumber,roomType));
            refreshBookings();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Failed to add booking: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

   
    
    public boolean roomAvail(int roomNumber, Date checkIn, Date checkOut) {
        for(BookingInfo booking : bookings) {
            if(booking.getRoomNumber() == roomNumber) {
                // Check if dates overlaps
                if(!(checkOut.before(booking.getCheckIn()) || checkIn.after(booking.getCheckOut()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getNextroom(Date checkIn, Date checkOut) { {
        for (int i = 1; i <= MAX_ROOMS; i++) {
        	 if (roomAvail(i, checkIn, checkOut)) {
                return i;
            }
        }
        return -1; 
    }
    
}
    }