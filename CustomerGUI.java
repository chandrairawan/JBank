import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class Savings yang merupakan extend dari Account
 * 
 * @author Abdul Chandra Irawan
 * @version 10.04.2016
 */
public class CustomerGUI extends JFrame {

	private JMenuBar menuBar;
	private JButton butCancel;
	private JButton butSave;
	private JList list;
	private JPanel panel1;
	private JTextField fieldDOB;
	private JTextField fieldLname;
	private JTextField fieldFname;
	private JTextField fieldAddr;
	private JTextField fieldCity;
	private JTextField fieldState;
	private JTextField fieldZip;
	private JTextField fieldPhone;
	private JTextField fieldEmail;

	//Constructor 
	public CustomerGUI(){

		this.setTitle("CustomerGUI");
		this.setSize(500,400);
		this.setJMenuBar(menuBar);

		//panel layout null
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500,400));
		contentPane.setBackground(new Color(192,192,192));


		butCancel = new JButton();
		butCancel.setActionCommand("CANCEL");
		butCancel.setBounds(10,19,67,35);
		butCancel.setBackground(new Color(214,217,223));
		butCancel.setForeground(new Color(0,0,0));
		butCancel.setEnabled(true);
		butCancel.setFont(new Font("sansserif",0,12));
		butCancel.setText("Cancel");
		butCancel.setVisible(true);

		butSave = new JButton();
		butSave.setBounds(80,19,110,35);
		butSave.setBackground(new Color(214,217,223));
		butSave.setForeground(new Color(0,0,0));
		butSave.setEnabled(true);
		butSave.setFont(new Font("sansserif",0,12));
		butSave.setText("Save & Return");
		butSave.setVisible(true);

		list = new JList();
		list.setBounds(338,139,148,175);
		list.setBackground(new Color(255,255,255));
		list.setForeground(new Color(0,0,0));
		list.setEnabled(true);
		list.setFont(new Font("sansserif",0,12));
		list.setVisible(true);

		panel1 = new JPanel(null);
		panel1.setBorder(BorderFactory.createEtchedBorder(1));
		panel1.setBounds(196,23,98,28);
		panel1.setBackground(new Color(214,217,223));
		panel1.setForeground(new Color(0,0,0));
		panel1.setEnabled(true);
		panel1.setFont(new Font("sansserif",0,12));
		panel1.setVisible(true);

		fieldDOB = new JTextField();
		fieldDOB.setBounds(246,206,90,35);
		fieldDOB.setBackground(new Color(255,255,255));
		fieldDOB.setForeground(new Color(0,0,0));
		fieldDOB.setEnabled(true);
		fieldDOB.setFont(new Font("sansserif",0,12));
		fieldDOB.setText("DOB");
		fieldDOB.setVisible(true);

		fieldLname = new JTextField();
		fieldLname.setBounds(302,20,186,35);
		fieldLname.setBackground(new Color(255,255,255));
		fieldLname.setForeground(new Color(0,0,0));
		fieldLname.setEnabled(true);
		fieldLname.setFont(new Font("sansserif",0,12));
		fieldLname.setText("Last Name");
		fieldLname.setVisible(true);

		fieldFname = new JTextField();
		fieldFname.setBounds(9,59,240,35);
		fieldFname.setBackground(new Color(255,255,255));
		fieldFname.setForeground(new Color(0,0,0));
		fieldFname.setEnabled(true);
		fieldFname.setFont(new Font("sansserif",0,12));
		fieldFname.setText("First Name");
		fieldFname.setVisible(true);

		fieldAddr = new JTextField();
		fieldAddr.setBounds(249,59,240,35);
		fieldAddr.setBackground(new Color(255,255,255));
		fieldAddr.setForeground(new Color(0,0,0));
		fieldAddr.setEnabled(true);
		fieldAddr.setFont(new Font("sansserif",0,12));
		fieldAddr.setText("Address");
		fieldAddr.setVisible(true);

		fieldCity = new JTextField();
		fieldCity.setBounds(10,98,240,35);
		fieldCity.setBackground(new Color(255,255,255));
		fieldCity.setForeground(new Color(0,0,0));
		fieldCity.setEnabled(true);
		fieldCity.setFont(new Font("sansserif",0,12));
		fieldCity.setText("City");
		fieldCity.setVisible(true);

		fieldState = new JTextField();
		fieldState.setBounds(251,98,40,35);
		fieldState.setBackground(new Color(255,255,255));
		fieldState.setForeground(new Color(0,0,0));
		fieldState.setEnabled(true);
		fieldState.setFont(new Font("sansserif",0,12));
		fieldState.setText("State");
		fieldState.setVisible(true);

		fieldZip = new JTextField();
		fieldZip.setBounds(293,98,70,35);
		fieldZip.setBackground(new Color(255,255,255));
		fieldZip.setForeground(new Color(0,0,0));
		fieldZip.setEnabled(true);
		fieldZip.setFont(new Font("sansserif",0,12));
		fieldZip.setText("ZIP Code");
		fieldZip.setVisible(true);

		fieldPhone = new JTextField();
		fieldPhone.setBounds(365,98,123,35);
		fieldPhone.setBackground(new Color(255,255,255));
		fieldPhone.setForeground(new Color(0,0,0));
		fieldPhone.setEnabled(true);
		fieldPhone.setFont(new Font("sansserif",0,12));
		fieldPhone.setText("Phone");
		fieldPhone.setVisible(true);

		fieldEmail = new JTextField();
		fieldEmail.setBounds(12,206,232,35);
		fieldEmail.setBackground(new Color(255,255,255));
		fieldEmail.setForeground(new Color(0,0,0));
		fieldEmail.setEnabled(true);
		fieldEmail.setFont(new Font("sansserif",0,12));
		fieldEmail.setText("Email Address");
		fieldEmail.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(butCancel);
		contentPane.add(butSave);
		contentPane.add(list);
		contentPane.add(panel1);
		contentPane.add(fieldDOB);
		contentPane.add(fieldLname);
		contentPane.add(fieldFname);
		contentPane.add(fieldAddr);
		contentPane.add(fieldCity);
		contentPane.add(fieldState);
		contentPane.add(fieldZip);
		contentPane.add(fieldPhone);
		contentPane.add(fieldEmail);

		//adding panel to JFrame and seting of window position and close operation
		this.add(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
		}

	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CustomerGUI();
			}
		});
	}

}