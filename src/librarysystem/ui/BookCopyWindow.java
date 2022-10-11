package librarysystem.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import librarysystem.business.impl.ControllerFactory;
import librarysystem.business.usecase.BookCopyUseCase;
import librarysystem.domain.Author;
import librarysystem.domain.Book;
import librarysystem.domain.exception.BookNotFoundException;

public class BookCopyWindow extends JFrame implements LibWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final BookCopyWindow INSTANCE = new BookCopyWindow();
	private boolean isInitialized = false;

	BookCopyUseCase addBookCopyUseCase = ControllerFactory.createBookCopyUseCase();

	private JTextField txtISBN, txtCopyNumber;

	public void initComponent() {
		JPanel panelCreateCopyField = new JPanel();
		panelCreateCopyField.setLayout(null);
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setBounds(20, 20, 100, 20);

		txtISBN = new JTextField(10);
		txtISBN.setBounds(110, 20, 100, 20);

		JLabel lblCopyNumber = new JLabel("Copy Number:");
		lblCopyNumber.setBounds(20, 50, 100, 20);

		txtCopyNumber = new JTextField(10);
		txtCopyNumber.setBounds(110, 50, 100, 20);

		JPanel pnlButtonSave = new JPanel();

		JButton btnSave = new JButton("Save");
		addCreateCopyButtonListener(btnSave);

		JButton btnBacktoMain = new JButton("<< Back to Main");
		addBackButtonListener(btnBacktoMain);

		pnlButtonSave.add(btnBacktoMain);
		pnlButtonSave.add(btnSave);
		pnlButtonSave.setBounds(20, 100, 360, 35);
		pnlButtonSave.setBackground(Color.white);

		panelCreateCopyField.add(lblISBN);
		panelCreateCopyField.add(txtISBN);

		panelCreateCopyField.add(lblCopyNumber);
		panelCreateCopyField.add(txtCopyNumber);

		panelCreateCopyField.add(pnlButtonSave, BorderLayout.CENTER);

		getContentPane().add(panelCreateCopyField);

		this.setTitle("Create Book Copy");
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});
	}

	private void addCreateCopyButtonListener(JButton butn) {
		butn.addActionListener(evt -> {

			int noOfCopies = 0;

			try {
				noOfCopies = Integer.parseInt(txtCopyNumber.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Invalid Input", "Save Failed", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (txtISBN.getText().equals("") || txtCopyNumber.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Required Fields can not be left empty", "Save Failed",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Book book = new Book(txtISBN.getText(), null, 0, new ArrayList<Author>());

				book = addBookCopyUseCase.addBookCopy(book, noOfCopies);

				txtISBN.setText("");
				txtCopyNumber.setText("");

				JOptionPane.showMessageDialog(this, "Book copy added successfully, Book " + book.getIsbn() + " has "
						+ book.getNumCopies() + " copies");

			} catch (BookNotFoundException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Save Failed", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void isInitialized(boolean val) {
		this.isInitialized = true;
	}

	@Override
	public void init() {
		initComponent();
	}

}