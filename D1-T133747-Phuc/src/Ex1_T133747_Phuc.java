import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ex1_T133747_Phuc extends JFrame{
	//Field - Instance Variable
	JLabel lblUsername;
	JTextField jtf;
	private JPasswordField txtPassword;
	
	//Hàm dựng - Constructor
	public Ex1_T133747_Phuc(){
		getContentPane().setBackground(new Color(204, 153, 102));
		getContentPane().setLayout(null);
		//Label
		JLabel lblUsername = new JLabel("Username:" );
		lblUsername.setLocation(30, 50);
		lblUsername.setSize(80, 25);
		
		//TextField
		JTextField jtf = new JTextField(" ");
		jtf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
			}
		});
		jtf.setBackground(Color.WHITE);
		jtf.setLocation(30, 75);
		jtf.setSize(150, 25);
		
		//Add to JFrame
		getContentPane().add(lblUsername);
		getContentPane().add(jtf);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(30, 111, 66, 14);
		getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setBackground(new Color(204, 153, 102));
		chckbxNewCheckBox.setBounds(30, 174, 127, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = jtf.getText();
				char[] passArray = txtPassword.getPassword();
				String password = new String(passArray);
				System.out.println(password+userName);
				if(userName.equals("admin")&& password.equals("root")){
					//JOptionPane.showMessageDialog(Ex1_T133747_Phuc.this, "Hello"+userName);
					MainWindow mainGUI = new MainWindow();
					mainGUI.setVisible(true);
					Ex1_T133747_Phuc.this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(Ex1_T133747_Phuc.this, "Fail");
				}
			}
		});
		btnNewButton.setBounds(30, 216, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblLogin.setBounds(75, 11, 66, 39);
		getContentPane().add(lblLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(30, 136, 150, 20);
		getContentPane().add(txtPassword);
		setLocationRelativeTo(null);
	} 
	
	
	public static void main(String[] args){
		Ex1_T133747_Phuc gui = new Ex1_T133747_Phuc();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(
			JFrame.EXIT_ON_CLOSE);
		gui.setSize(400, 300);
	}
}