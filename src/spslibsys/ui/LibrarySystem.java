package spslibsys.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import spslibsys.dataaccess.Auth;
import spslibsys.utility.Util;

public class LibrarySystem extends JFrame implements LibWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static LibrarySystem INSTANCE = new LibrarySystem();
	JPanel mainPanel;
	JMenuBar menuBar;
	JMenu options;
	JMenuItem login, addLibraryMember, checkOutBook, addBookCopy, addBook, printCheckOutRecord;
	String pathToImage;
	private boolean isInitialized = false;

	private static LibWindow[] allWindows = { 
			LibrarySystem.INSTANCE,
			AddMemberWindow.INSTANCE, 
			BookWindow.INSTANCE, 
			BookCopyWindow.INSTANCE,
			CheckoutBookWindow.INSTANCE,
			PrintCheckOutRecordWindow.INSTANCE,
			MainView.INSTANCE,
			MainLogin.INSTANCE};

	public static void hideAllWindows() {

		for (LibWindow frame : allWindows) {
			frame.setVisible(false);

		}
	}

	private LibrarySystem() {
	}

	public void init() {
//		formatContentPane();
//		setPathToImage();
//		insertSplashImage();
//
//		createMenus();
//		// pack();
//		setSize(660, 500);
//		isInitialized = true;
		LibrarySystem.hideAllWindows();
		MainLogin.INSTANCE.init();
		Util.centerFrameOnDesktop(MainLogin.INSTANCE);
		MainLogin.INSTANCE.setVisible(true);
	}

//	private void formatContentPane() {
//		mainPanel = new JPanel();
//		mainPanel.setLayout(new GridLayout(1, 1));
//		getContentPane().add(mainPanel);
//	}
//
//	private void setPathToImage() {
//		String currDirectory = System.getProperty("user.dir");
//		pathToImage = currDirectory + "/src/librarysystem/library.jpg";
//	}
//
//	private void insertSplashImage() {
//		ImageIcon image = new ImageIcon(pathToImage);
//		mainPanel.add(new JLabel(image));
//	}

//	private void createMenus() {
//		menuBar = new JMenuBar();
//		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
//		addMenuItems();
//		setJMenuBar(menuBar);
//	}

//	private void addMenuItems() {
//		options = new JMenu("Options");
//		menuBar.add(options);
//		login = new JMenuItem("Log in");
//		login.addActionListener(new LoginListener());
//
//		addLibraryMember = new JMenuItem("Add Library Member");
//		addLibraryMember.addActionListener(new AddLibraryMemberListener());
//
//		checkOutBook = new JMenuItem("Checkout Book");
//		checkOutBook.addActionListener(new CheckOutBookListener());
//
//		addBookCopy = new JMenuItem("Add Book Copy");
//		addBookCopy.addActionListener(new AddBookCopyListener());
//
//		addBook = new JMenuItem("Add New Book");
//		addBook.addActionListener(new AddBookListener());
//
//		printCheckOutRecord = new JMenuItem("Print Checkout Record");
//		printCheckOutRecord.addActionListener(new PrintCheckOutRecordListener());
//
//		options.add(login);
//		options.add(addLibraryMember);
//		options.add(checkOutBook);
//		options.add(addBookCopy);
//		options.add(addBook);
//		options.add(printCheckOutRecord);
//		
//		doAuth();
//	}
	
//	private void doAuth() {
//		LibrarySystem.INSTANCE.checkOutBook.setVisible(false);
//		LibrarySystem.INSTANCE.printCheckOutRecord.setVisible(false);
//		
//		LibrarySystem.INSTANCE.addLibraryMember.setVisible(false);
//		LibrarySystem.INSTANCE.addBookCopy.setVisible(false);
//		LibrarySystem.INSTANCE.addBook.setVisible(false);
//	}
//	
//	class AddLibraryMemberListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			LibrarySystem.hideAllWindows();
//			AddMemberWindow.INSTANCE.init();
//			AddMemberWindow.INSTANCE.pack();
//			Util.centerFrameOnDesktop(AddMemberWindow.INSTANCE);
//			AddMemberWindow.INSTANCE.setVisible(true);
//		}
//
//	}
//
//	class CheckOutBookListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			LibrarySystem.hideAllWindows();
//			CheckoutBookWindow.INSTANCE.init();
//			CheckoutBookWindow.INSTANCE.pack();
//			Util.centerFrameOnDesktop(CheckoutBookWindow.INSTANCE);
//			CheckoutBookWindow.INSTANCE.setVisible(true);
//
//		}
//
//	}
//
//	class AddBookCopyListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			LibrarySystem.hideAllWindows();
//			BookCopyWindow.INSTANCE.init();
//			BookCopyWindow.INSTANCE.pack();
//			Util.centerFrameOnDesktop(BookCopyWindow.INSTANCE);
//			BookCopyWindow.INSTANCE.setVisible(true);
//
//		}
//
//	}
//
//	class AddBookListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			LibrarySystem.hideAllWindows();
//			BookWindow.INSTANCE.init();
//			BookWindow.INSTANCE.pack();
//			Util.centerFrameOnDesktop(AddMemberWindow.INSTANCE);
//			BookWindow.INSTANCE.setVisible(true);
//		}
//
//	}
//
//	class PrintCheckOutRecordListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			LibrarySystem.hideAllWindows();
//			PrintCheckOutRecordWindow.INSTANCE.init();
//			PrintCheckOutRecordWindow.INSTANCE.pack();
//			Util.centerFrameOnDesktop(PrintCheckOutRecordWindow.INSTANCE);
//			PrintCheckOutRecordWindow.INSTANCE.setVisible(true);
//
//		}
//
//	}

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;

	}
	
	public void doAuthentication(Auth auth) {
		if (auth == Auth.ADMIN) {
			MainView.doAdminAuthentication();
		} else if (auth == Auth.LIBRARIAN) {
			MainView.doLibrarianAuthentication();
		} else if (auth == Auth.BOTH) {
			MainView.permitAll();
		}
	}
	
	

}
