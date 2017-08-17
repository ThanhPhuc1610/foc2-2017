package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import da.SQLiteDB;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.util.Vector;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private SQLiteDB foc2warehouseDb;
	private JTextField textFieldPrice;
	private JTextField textFieldProductCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI frame = new CreateGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateGUI() {
		setType(Type.UTILITY);
		
		foc2warehouseDb = new SQLiteDB();
		foc2warehouseDb.getAllCategories();
		
		//foc2warehouse = new SQLiteDB();
		//foc2warehouse.getAllCategories();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 332);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddProduct.setBounds(149, 18, 111, 14);
		contentPane.add(lblAddProduct);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(25, 81, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(128, 82, 216, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoryid");
		lblNewLabel_1.setBounds(25, 112, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//System.out.println(comboBox.getSelectedItem());
				Category cat = (Category)comboBox.getSelectedItem();
				
			}
		});
		
		
		Vector<Category> catList = foc2warehouseDb.getAllCategories();
		comboBox.setModel(new DefaultComboBoxModel(catList));
		
		comboBox.setBounds(128, 113, 216, 20);
		contentPane.add(comboBox);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(25, 212, 46, 14);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(128, 206, 216, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLabel lblInstock = new JLabel("Product Code");
		lblInstock.setBounds(25, 53, 72, 14);
		contentPane.add(lblInstock);
		
		textFieldProductCode = new JTextField();
		textFieldProductCode.setBounds(128, 54, 216, 20);
		contentPane.add(textFieldProductCode);
		textFieldProductCode.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productname = textFieldName.getText();
				double unitUnitprice = Double.parseDouble(textFieldPrice.getText());
				int unitStock = Integer.parseInt(textFieldProductCode.getText());
				Category selectedCat = (Category) comboBox.getSelectedItem();
				int catId = selectedCat.getCategoryId();
				
				//salesDb.insert(productname, catId, unitUnitprice, unitStock);
				foc2warehouseDb.getAllProducts();
			}
		});
		btnOk.setBounds(82, 245, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(211, 245, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblUnitOfMeasure = new JLabel("Unit of Measure");
		lblUnitOfMeasure.setBounds(25, 143, 93, 14);
		contentPane.add(lblUnitOfMeasure);
		
		JComboBox comboBox_Measure = new JComboBox();
		comboBox_Measure.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				UnitOfMeasure uom = (UnitOfMeasure)comboBox_Measure.getSelectedItem();
			}
		});
		
		Vector<UnitOfMeasure> unitOfMeasuresList = foc2warehouseDb.getAllUnitOfMeasure();
		comboBox_Measure.setModel(new DefaultComboBoxModel(unitOfMeasuresList));
		
		comboBox_Measure.setBounds(128, 144, 216, 20);
		contentPane.add(comboBox_Measure);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(25, 174, 86, 14);
		contentPane.add(lblBrand);
		
		JComboBox comboBox_Brand = new JComboBox();
		comboBox_Brand.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Brand bra = (Brand)comboBox_Brand.getSelectedItem();
			}
		});
		
		Vector<Brand> BrandList = foc2warehouseDb.getAllBrands();
		comboBox_Brand.setModel(new DefaultComboBoxModel(BrandList));
		
		comboBox_Brand.setBounds(128, 175, 216, 20);
		contentPane.add(comboBox_Brand);
	}
}
