package librarysystem.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import librarysystem.business.impl.ControllerFactory;
import librarysystem.business.usecase.CheckOutBookUseCase;
import librarysystem.domain.BookCopy;
import librarysystem.domain.CheckOutRecord;
import librarysystem.domain.CheckOutRecordEntry;
import librarysystem.domain.exception.BookCopyNotAvailableException;
import librarysystem.domain.exception.BookNotFoundException;
import librarysystem.domain.exception.MemberNotFoundException;

public class CheckoutBookWindow extends JFrame implements LibWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final CheckoutBookWindow INSTANCE = new CheckoutBookWindow();

	private CheckoutBookWindow() {
	}

	CheckOutBookUseCase checkOutBookUseCase = ControllerFactory.createCheckOutBookUseCase();
	private boolean isInitialized = false;

	JTextField txtISBN, txtMemberID;
	JComboBox<BookCopy> cmbCopies;
	JTable jt;
	// private boolean idWasValidated = false;

    public void checkOutBook() {
        // TODO Auto-generated method stub
    	setResizable(false);
		setTitle("Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 657);
		
        JPanel panelCheckoutFields = new JPanel();
        panelCheckoutFields.setLayout(null);
        panelCheckoutFields.setSize(500,500);

		this.setTitle("Checkout Book");
		this.setMinimumSize(new Dimension(850, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLayout(new BorderLayout());

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(20, 20, 100, 20);
		txtISBN = new JTextField(10);
		txtISBN.setBounds(110, 20, 100, 20);
		JLabel lblMemberID = new JLabel("Member ID");
		lblMemberID.setBounds(20, 50, 100, 20);
		txtMemberID = new JTextField(10);
		txtMemberID.setBounds(110, 50, 100, 20);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(110, 80, 100, 20);
		addCheckoutListener(btnCheckout);

        JButton btnBackToMain = new JButton("HOME");
        addBackButtonListener(btnBackToMain);

        JPanel pnlButtonSave = new JPanel();
        pnlButtonSave.add(btnBackToMain);
        pnlButtonSave.setBounds(20, 150, 800, 35);
        pnlButtonSave.setBackground(new Color(244, 244, 244,0));

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Member Id");
		model.addColumn("Member Name");
		model.addColumn("ISBN");
		model.addColumn("Book Name");
		model.addColumn("Checkout Date");
		model.addColumn("Due Date");

		jt = new JTable(model);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(20, 200, 800, 150);
		panelCheckoutFields.add(sp);

		panelCheckoutFields.add(lblMemberID);
		panelCheckoutFields.add(txtISBN);

		panelCheckoutFields.add(lblISBN);
		panelCheckoutFields.add(txtMemberID);

		panelCheckoutFields.add(btnCheckout);
		panelCheckoutFields.add(pnlButtonSave, BorderLayout.CENTER);

        
        panelCheckoutFields.setBackground(new Color(244, 244, 244,180));
//		this.mainPanel.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
        panelCheckoutFields.setBounds(40, 49, 850, 600);
		
//		this.add(panelCheckoutFields);
        
		getContentPane().add(panelCheckoutFields);
        
    	JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 920, 633);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(MainLogin.class.getResource("/librarysystem/library.png")).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(lblNewLabel);

	}

	private void addCheckoutListener(JButton butn) {
		butn.addActionListener(evt -> {
			String bkISBN = txtISBN.getText().trim();
			String memberID = txtMemberID.getText().trim();

			if (bkISBN.length() == 0 || memberID.length() == 0) {
				JOptionPane.showMessageDialog(this, "ISBN and member ID required", "Checkout Failed",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					checkOutBookUseCase.checkOutBook(memberID, bkISBN);
					JOptionPane.showMessageDialog(this, "Checkout successful", "Thank you", JOptionPane.PLAIN_MESSAGE);
					displayCheckoutInfo();
				} catch (BookNotFoundException | MemberNotFoundException | BookCopyNotAvailableException e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Check out book", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

    private void addBackButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            LibrarySystem.hideAllWindows();
            MainView.INSTANCE.setVisible(true);
        });
    }

	private void displayCheckoutInfo() {
		CheckOutRecord cr = checkOutBookUseCase.getCheckOutRecord(txtMemberID.getText());
		if (cr == null)
			return;

		DefaultTableModel model2 = (DefaultTableModel) jt.getModel();
		model2.setRowCount(0);

		for (CheckOutRecordEntry entry : cr.getCheckOutRecordEntries()) {
			model2.addRow(new Object[] { cr.getMember().getMemberId(), cr.getMember().getFullName(),
					entry.getBookCopy().getBook().getIsbn(), entry.getBookCopy().getBook().getTitle(),
					entry.getCheckOutDate().toString(), entry.getDueDate().toString() });

		}

	}

	public boolean isInitialized() {
		return this.isInitialized;
	}

	public void isInitialized(boolean val) {
		this.isInitialized = val;
	}

	@Override
	public void init() {
		checkOutBook();
	}

}