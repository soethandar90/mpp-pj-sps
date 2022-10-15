package spslibsys.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import spslibsys.utility.Util;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView extends JFrame  implements LibWindow{

	private JPanel contentPane;
	
	public final static MainView INSTANCE = new MainView();
	
	JLabel lblGreeting;
	
	JMenu mnNewMenu_1,mnNewMenu_2;
	
	JMenuItem logout, addLibraryMember, checkOutBook, addBookCopy, addBook,
	printCheckOutRecord;
	
	private static LibWindow[] allWindows = { 
			LibrarySystem.INSTANCE,
			AddMemberWindow.INSTANCE, 
			BookWindow.INSTANCE, 
			BookCopyWindow.INSTANCE,
			CheckoutBookWindow.INSTANCE,
			PrintCheckOutRecordWindow.INSTANCE,
			MainView.INSTANCE,
			MainLogin.INSTANCE};

	/**
	 * Create the frame.
	 */
	public MainView() {
		setResizable(false);
		setTitle("Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 657);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Auth");
		menuBar.add(mnNewMenu);
		
		JMenuItem logout = new JMenuItem("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySystem.hideAllWindows();
				MainLogin.INSTANCE.init();
				Util.centerFrameOnDesktop(MainLogin.INSTANCE);
				MainLogin.INSTANCE.setVisible(true);
			}
		});
		mnNewMenu.add(logout);
		
		mnNewMenu_1  = new JMenu("Book Checkout");
		menuBar.add(mnNewMenu_1);
		
		checkOutBook = new JMenuItem("Checkout Book");
		checkOutBook.addActionListener(new CheckOutBookListener());
		mnNewMenu_1.add(checkOutBook);
		
		printCheckOutRecord = new JMenuItem("Print Checkout Record");
		printCheckOutRecord.addActionListener(new PrintCheckOutRecordListener());
		mnNewMenu_1.add(printCheckOutRecord);
		
		mnNewMenu_2 = new JMenu("Add");
		menuBar.add(mnNewMenu_2);
		
		addLibraryMember = new JMenuItem("Add Library Member");
		addLibraryMember.addActionListener(new AddLibraryMemberListener());
		mnNewMenu_2.add(addLibraryMember);
		
		addBookCopy = new JMenuItem("Add Book Copy");
		addBookCopy.addActionListener(new AddBookCopyListener());
		mnNewMenu_2.add(addBookCopy);
		
		addBook = new JMenuItem("Add New Book");
		addBook.addActionListener(new AddBookListener());
		mnNewMenu_2.add(addBook);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 244, 244,210));
		panel.setBounds(163, 99, 627, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblGreeting = new JLabel("Dear User");
		lblGreeting.setFont(new Font("Segoe UI", Font.ITALIC, 29));
		lblGreeting.setBounds(214, 21, 270, 58);
		panel.add(lblGreeting);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 920, 633);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(MainLogin.class.getResource("/librarysystem/library.png")).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);
	}
	
	public static void hideAllWindows() {

		for (LibWindow frame : allWindows) {
			frame.setVisible(false);

		}
	}
	
	static void doLibrarianAuthentication() {
		MainView.INSTANCE.mnNewMenu_1.setVisible(true);
		MainView.INSTANCE.checkOutBook.setVisible(true);
		MainView.INSTANCE.printCheckOutRecord.setVisible(true);
		
		MainView.INSTANCE.mnNewMenu_2.setVisible(false);
		MainView.INSTANCE.addLibraryMember.setVisible(false);
		MainView.INSTANCE.addBookCopy.setVisible(false);
		MainView.INSTANCE.addBook.setVisible(false);
	}
	
	static void doAdminAuthentication() {
		MainView.INSTANCE.mnNewMenu_1.setVisible(false);
		MainView.INSTANCE.checkOutBook.setVisible(false);
		MainView.INSTANCE.printCheckOutRecord.setVisible(false);
		
		MainView.INSTANCE.mnNewMenu_2.setVisible(true);
		MainView.INSTANCE.addLibraryMember.setVisible(true);
		MainView.INSTANCE.addBookCopy.setVisible(true);
		MainView.INSTANCE.addBook.setVisible(true);
	}
	
	static void permitAll() {
		MainView.INSTANCE.mnNewMenu_1.setVisible(true);
		MainView.INSTANCE.checkOutBook.setVisible(true);
		MainView.INSTANCE.printCheckOutRecord.setVisible(true);
		
		MainView.INSTANCE.mnNewMenu_2.setVisible(true);
		MainView.INSTANCE.addLibraryMember.setVisible(true);
		MainView.INSTANCE.addBookCopy.setVisible(true);
		MainView.INSTANCE.addBook.setVisible(true);
	}
	
	static void denyAll() {
		MainView.INSTANCE.mnNewMenu_1.setVisible(false);
		MainView.INSTANCE.checkOutBook.setVisible(false);
		MainView.INSTANCE.printCheckOutRecord.setVisible(false);
		
		MainView.INSTANCE.mnNewMenu_2.setVisible(false);
		MainView.INSTANCE.addLibraryMember.setVisible(false);
		MainView.INSTANCE.addBookCopy.setVisible(false);
		MainView.INSTANCE.addBook.setVisible(false);		
	}
	
	class AddLibraryMemberListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AddMemberWindow.INSTANCE.init();
			AddMemberWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(AddMemberWindow.INSTANCE);
			AddMemberWindow.INSTANCE.setVisible(true);
		}

	}

	class CheckOutBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			CheckoutBookWindow.INSTANCE.init();
			CheckoutBookWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(CheckoutBookWindow.INSTANCE);
			CheckoutBookWindow.INSTANCE.setVisible(true);

		}

	}

	class AddBookCopyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			BookCopyWindow.INSTANCE.init();
			BookCopyWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(BookCopyWindow.INSTANCE);
			BookCopyWindow.INSTANCE.setVisible(true);

		}

	}

	class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			BookWindow.INSTANCE.init();
			BookWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(BookWindow.INSTANCE);
			BookWindow.INSTANCE.setVisible(true);
		}

	}

	class PrintCheckOutRecordListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			PrintCheckOutRecordWindow.INSTANCE.init();
			PrintCheckOutRecordWindow.INSTANCE.pack();
			Util.centerFrameOnDesktop(PrintCheckOutRecordWindow.INSTANCE);
			PrintCheckOutRecordWindow.INSTANCE.setVisible(true);

		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		
	}
}
