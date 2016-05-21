import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

/**
 * Class CustomerGUI - GUI untuk Customer
 * 
 * @author Abdul Chandra Irawan - 1306405244
 * @version 21.04.2016
 */
public class CustomerGUI extends JFrame implements ActionListener, FocusListener, ItemListener
{
	private JPanel pane;
    private JButton cancelBtn;
    private JButton saveBtn;
    private JButton searchBtn;
    private JTextField idField;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField dobField;
    private JTextField amountField;
    private JTextField termField;
    private JTextField creditField;
    private JComboBox<String> accountList;
	
	/**
	 * Constructor for objects of class CustomerGUI
     */
    public CustomerGUI(){

		super("Customer Input & Update");
        
        pane = new JPanel();
        
        cancelBtn = new JButton();
        saveBtn = new JButton();
        searchBtn = new JButton();
        
        idField = new JTextField();
        lastNameField = new JTextField();
        firstNameField = new JTextField();
        addressField = new JTextField();
        cityField = new JTextField();
        stateField = new JTextField();
        zipField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        dobField = new JTextField();
        amountField = new JTextField();
        termField = new JTextField();
        creditField = new JTextField();
        
        String[] acctList = 
        {
            "Account",
            "Savings",
            "Investment",
            "Checking/OverDraft",
            "Line Of Credit"
        };
        
        accountList = new JComboBox<>(acctList);
        
        buildGUI();
	}

	/**
     * Method buildGUI untuk membangun GUI
     */
    public void buildGUI()
    {
        super.setSize(600,300);
        super.setResizable(false);
        super.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
        
        pane.setPreferredSize(new Dimension(600,300));
        pane.setBackground(new Color(31,192,214));
        
        cancelBtn.setPreferredSize(new Dimension(80,35));
        cancelBtn.setBackground(new Color(214,217,223));
        cancelBtn.setForeground(new Color(0,0,0));
        cancelBtn.setEnabled(true);
        cancelBtn.setFont(new Font("sansserif",0,12));
        cancelBtn.setText("Cancel");
        cancelBtn.setVisible(true);
        cancelBtn.addActionListener(this);
        
        saveBtn.setPreferredSize(new Dimension(120,35));
        saveBtn.setBackground(new Color(214,217,223));
        saveBtn.setForeground(new Color(0,0,0));
        saveBtn.setEnabled(true);
        saveBtn.setFont(new Font("sansserif",0,12));
        saveBtn.setText("Save & Return");
        saveBtn.setVisible(true);
        saveBtn.addActionListener(this);
        
        searchBtn.setPreferredSize(new Dimension(170,35));
        searchBtn.setBackground(new Color(214,217,223));
        searchBtn.setForeground(new Color(0,0,0));
        searchBtn.setEnabled(true);
        searchBtn.setFont(new Font("sansserif",0,12));
        searchBtn.setText("Search Customer by ID");
        searchBtn.setVisible(true);
        searchBtn.addActionListener(this);
        
        accountList.setPreferredSize(new Dimension(180,35));
        accountList.setBackground(new Color(255,255,255));
        accountList.setForeground(new Color(150,150,150));
        accountList.setEnabled(true);
        accountList.setFont(new Font("sansserif",0,12));
        accountList.setVisible(true);
        accountList.addItemListener(this);
        
        idField.setPreferredSize(new Dimension(60,35));
        idField.setBackground(new Color(255,255,255));
        idField.setForeground(new Color(150,150,150));
        idField.setEnabled(true);
        idField.setFont(new Font("sansserif",0,12));
        idField.setText("ID");
        idField.setVisible(true);
        idField.addFocusListener(this);
        
        lastNameField.setPreferredSize(new Dimension(185,35));
        lastNameField.setBackground(new Color(255,255,255));
        lastNameField.setForeground(new Color(150,150,150));
        lastNameField.setEnabled(true);
        lastNameField.setFont(new Font("sansserif",0,12));
        lastNameField.setText("Last Name");
        lastNameField.setVisible(true);
        lastNameField.addFocusListener(this);
        
        firstNameField.setPreferredSize(new Dimension(185,35));
        firstNameField.setBackground(new Color(255,255,255));
        firstNameField.setForeground(new Color(150,150,150));
        firstNameField.setEnabled(true);
        firstNameField.setFont(new Font("sansserif",0,12));
        firstNameField.setText("First Name");
        firstNameField.setVisible(true);
        firstNameField.addFocusListener(this);
        
        dobField.setPreferredSize(new Dimension(120,35));
        dobField.setBackground(new Color(255,255,255));
        dobField.setForeground(new Color(150,150,150));
        dobField.setEnabled(true);
        dobField.setFont(new Font("sansserif",0,12));
        dobField.setText("DOB (dd/MM/yyyy)");
        dobField.setVisible(true);
        dobField.addFocusListener(this);
        
        addressField.setPreferredSize(new Dimension(360,35));
        addressField.setBackground(new Color(255,255,255));
        addressField.setForeground(new Color(150,150,150));
        addressField.setEnabled(true);
        addressField.setFont(new Font("sansserif",0,12));
        addressField.setText("Address");
        addressField.setVisible(true);
        addressField.addFocusListener(this);
        
        cityField.setPreferredSize(new Dimension(200,35));
        cityField.setBackground(new Color(255,255,255));
        cityField.setForeground(new Color(150,150,150));
        cityField.setEnabled(true);
        cityField.setFont(new Font("sansserif",0,12));
        cityField.setText("City");
        cityField.setVisible(true);
        cityField.addFocusListener(this);
        
        stateField.setPreferredSize(new Dimension(120,35));
        stateField.setBackground(new Color(255,255,255));
        stateField.setForeground(new Color(150,150,150));
        stateField.setEnabled(true);
        stateField.setFont(new Font("sansserif",0,12));
        stateField.setText("State");
        stateField.setVisible(true);
        stateField.addFocusListener(this);
        
        zipField.setPreferredSize(new Dimension(100,35));
        zipField.setBackground(new Color(255,255,255));
        zipField.setForeground(new Color(150,150,150));
        zipField.setEnabled(true);
        zipField.setFont(new Font("sansserif",0,12));
        zipField.setText("Zip Code");
        zipField.setVisible(true);
        zipField.addFocusListener(this);
        
        phoneField.setPreferredSize(new Dimension(130,35));
        phoneField.setBackground(new Color(255,255,255));
        phoneField.setForeground(new Color(150,150,150));
        phoneField.setEnabled(true);
        phoneField.setFont(new Font("sansserif",0,12));
        phoneField.setText("Phone");
        phoneField.setVisible(true);
        phoneField.addFocusListener(this);
        
        emailField.setPreferredSize(new Dimension(200,35));
        emailField.setBackground(new Color(255,255,255));
        emailField.setForeground(new Color(150,150,150));
        emailField.setEnabled(true);
        emailField.setFont(new Font("sansserif",0,12));
        emailField.setText("Email");
        emailField.setVisible(true);
        emailField.addFocusListener(this);
        
        amountField.setPreferredSize(new Dimension(135,35));
        amountField.setBackground(new Color(255,255,255));
        amountField.setForeground(new Color(150,150,150));
        amountField.setEnabled(true);
        amountField.setFont(new Font("sansserif",0,12));
        amountField.setText("Amount");
        amountField.setVisible(false);
        amountField.addFocusListener(this);
        
        termField.setPreferredSize(new Dimension(135,35));
        termField.setBackground(new Color(255,255,255));
        termField.setForeground(new Color(150,150,150));
        termField.setEnabled(true);
        termField.setFont(new Font("sansserif",0,12));
        termField.setText("Investment Term");
        termField.setVisible(false);
        termField.addFocusListener(this);
        
        creditField.setPreferredSize(new Dimension(135,35));
        creditField.setBackground(new Color(255,255,255));
        creditField.setForeground(new Color(150,150,150));
        creditField.setEnabled(true);
        creditField.setFont(new Font("sansserif",0,12));
        creditField.setText("Credit Amount");
        creditField.setVisible(false);
        creditField.addFocusListener(this);
        
        pane.add(cancelBtn);
        pane.add(saveBtn);
        pane.add(searchBtn);
        pane.add(accountList);
        pane.add(idField);
        pane.add(lastNameField);
        pane.add(firstNameField);
        pane.add(dobField);
        pane.add(addressField);
        pane.add(cityField);
        pane.add(stateField);
        pane.add(zipField);
        pane.add(phoneField);
        pane.add(emailField);
        pane.add(amountField);
        pane.add(termField);
        pane.add(creditField);
        
        super.add(pane);
        //super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.pack();
        super.setVisible(true);
    }
	
	/**
     * Button handler
     * @param e Action event
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cancelBtn) {
            dispose();
        }
        else if(e.getSource() == saveBtn) {
            try {
                if(Teller.getCustomer(getID()) != null) {
                    editCustomer(Teller.getCustomer(getID()));
                    dispose();
                }
                else {
                    addCustomer();
                    dispose();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Please fill all values");
            }
        }
        else if(e.getSource() == searchBtn) {
            try {
                Customer c = Teller.getCustomer(getID());
                if(c != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    lastNameField.setText(c.getLastName());
                    lastNameField.setForeground(new Color(0,0,0));
                    firstNameField.setText(c.getFirstName());
                    firstNameField.setForeground(new Color(0,0,0));
                    addressField.setText(c.getStreetAddress());
                    addressField.setForeground(new Color(0,0,0));
                    cityField.setText(c.getCityAddress());
                    cityField.setForeground(new Color(0,0,0));
                    stateField.setText(c.getStateAddress());
                    stateField.setForeground(new Color(0,0,0));
                    zipField.setText(c.getZipCode());
                    zipField.setForeground(new Color(0,0,0));
                    phoneField.setText(c.getPhone());
                    phoneField.setForeground(new Color(0,0,0));
                    if(c.getEmail() != null) {
                        emailField.setText(c.getEmail());
                        emailField.setForeground(new Color(0,0,0));
                    }
                    if(c.getDOB() != null) {
                        dobField.setText(sdf.format(c.getDOB()));
                        dobField.setForeground(new Color(0,0,0));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Customer does not exist");
                    lastNameField.setText("Last Name");
                    lastNameField.setForeground(new Color(150,150,150));
                    firstNameField.setText("First Name");
                    firstNameField.setForeground(new Color(150,150,150));
                    addressField.setText("Address");
                    addressField.setForeground(new Color(150,150,150));
                    cityField.setText("City");
                    cityField.setForeground(new Color(150,150,150));
                    stateField.setText("State");
                    stateField.setForeground(new Color(150,150,150));
                    zipField.setText("Zip Code");
                    zipField.setForeground(new Color(150,150,150));
                    phoneField.setText("Phone");
                    phoneField.setForeground(new Color(150,150,150));
                    emailField.setText("Email");
                    emailField.setForeground(new Color(150,150,150));
                    dobField.setText("DOB (dd/MM/yyyy)");
                    dobField.setForeground(new Color(150,150,150));
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter ID to search");
            }
        }
    }
	
	
    /**
     * Set text inside JTextField to empty when field is selected
     * @param e Focus event
     */
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == idField) {
            if(idField.getText().equals("ID")) {
                idField.setText("");
                idField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == lastNameField) {
            if(lastNameField.getText().equals("Last Name")) {
                lastNameField.setText("");
                lastNameField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == firstNameField) {
            if(firstNameField.getText().equals("First Name")) {
                firstNameField.setText("");
                firstNameField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == addressField) {
            if(addressField.getText().equals("Address")) {
                addressField.setText("");
                addressField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == cityField) {
            if(cityField.getText().equals("City")) {
                cityField.setText("");
                cityField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == stateField) {
            if(stateField.getText().equals("State")) {
                stateField.setText("");
                stateField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == zipField) {
            if(zipField.getText().equals("Zip Code")) {
                zipField.setText("");
                zipField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == phoneField) {
            if(phoneField.getText().equals("Phone")) {
                phoneField.setText("");
                phoneField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == emailField) {
            if(emailField.getText().equals("Email")) {
                emailField.setText("");
                emailField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == dobField) {
            if(dobField.getText().equals("DOB (dd/MM/yyyy)")) {
                dobField.setText("");
                dobField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == amountField) {
            if(amountField.getText().equals("Amount")) {
                amountField.setText("");
                amountField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == termField) {
            if(termField.getText().equals("Investment Term")) {
                termField.setText("");
                termField.setForeground(new Color(0,0,0));
            }
        }
        else if(e.getSource() == creditField) {
            if(creditField.getText().equals("Credit Amount")) {
                creditField.setText("");
                creditField.setForeground(new Color(0,0,0));
            }
        }
    }
    
    /**
     * Set placeholder inside JTextField when field is not selected
     * @param e Focus event
     */
    public void focusLost(FocusEvent e)
    {
        if(e.getSource() == idField) {
            if(idField.getText().equals("")) {
                idField.setText("ID");
                idField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == lastNameField) {
            if(lastNameField.getText().equals("")) {
                lastNameField.setText("Last Name");
                lastNameField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == firstNameField) {
            if(firstNameField.getText().equals("")) {
                firstNameField.setText("First Name");
                firstNameField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == addressField) {
            if(addressField.getText().equals("")) {
                addressField.setText("Address");
                addressField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == cityField) {
            if(cityField.getText().equals("")) {
                cityField.setText("City");
                cityField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == stateField) {
            if(stateField.getText().equals("")) {
                stateField.setText("State");
                stateField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == zipField) {
            if(zipField.getText().equals("")) {
                zipField.setText("Zip Code");
                zipField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == phoneField) {
            if(phoneField.getText().equals("")) {
                phoneField.setText("Phone");
                phoneField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == emailField) {
            if(emailField.getText().equals("")) {
                emailField.setText("Email");
                emailField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == dobField) {
            if(dobField.getText().equals("")) {
                dobField.setText("DOB (dd/MM/yyyy)");
                dobField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == amountField) {
            if(amountField.getText().equals("")) {
                amountField.setText("Amount");
                amountField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == termField) {
            if(termField.getText().equals("")) {
                termField.setText("Investment Term");
                termField.setForeground(new Color(150,150,150));
            }
        }
        else if(e.getSource() == creditField) {
            if(creditField.getText().equals("")) {
                creditField.setText("Credit Amount");
                creditField.setForeground(new Color(150,150,150));
            }
        }
    }
    
    /**
     * Show/hide input field depending on which account type is selected
     * @param e Item event
     */
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(getAcctType().equals("Savings")) {
                amountField.setVisible(true);
                termField.setVisible(false);
                creditField.setVisible(false);
                pane.revalidate();
                super.repaint();
            }
            else if(getAcctType().equals("Investment")) {
                amountField.setVisible(true);
                termField.setVisible(true);
                creditField.setVisible(false);
                pane.revalidate();
                super.repaint();
            }
            else if(getAcctType().equals("Checking/OverDraft")) {
                amountField.setVisible(true);
                termField.setVisible(false);
                creditField.setVisible(false);
                pane.revalidate();
                super.repaint();
            }
            else if(getAcctType().equals("Line Of Credit")) {
                amountField.setVisible(true);
                termField.setVisible(false);
                creditField.setVisible(true);
                pane.revalidate();
                super.repaint();
            }
            else if(getAcctType().equals("Account")) {
                amountField.setVisible(false);
                termField.setVisible(false);
                creditField.setVisible(false);
                pane.revalidate();
                super.repaint();
            }
        }
    }
    
    /**
     * Method to add Customer from GUI
     */
    public void addCustomer()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date DOB = null;
        try {
            DOB = sdf.parse(getDOB());
        } catch (ParseException e) {
            DOB = null;
        }
        Customer c = new Customer(getFirstName(), getLastName(), DOB);
        c.setPhone(getPhone());
        c.setAddress(getAddress(), getCity(), getStateAddress(), getZipCode());
        if(!getEmail().equals("Email")) {
            c.setEmail(getEmail());
        }
        if(!Integer.toString(getID()).equals("ID")) {
            c.setCustID(getID());
        }
        if(getAcctType().equals("Savings")) {
            Savings s = new Savings(c, getAmount());
            try {
                c.addAccount(s);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        else if(getAcctType().equals("Investment")) {
            Investment i = new Investment(c, getAmount(), getTerm());
            try {
                c.addAccount(i);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        else if(getAcctType().equals("Line Of Credit")) {
            LineOfCredit l = new LineOfCredit(c, getAmount(), getCredit());
            try {
                c.addAccount(l);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        else if(getAcctType().equals("Checking/OverDraft")) {
            try {
                Savings s = (Savings) c.getAccount('S');
                OverDraftProtection o = new OverDraftProtection(c, getAmount(), s);
                try {
                    c.addAccount(o);
                } catch(AccountTypeAlreadyExistsException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            } catch(AccountTypeNotFoundException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        try {
            Teller.createNewCustomer(c);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to add customer");
        }
    }
    
    /**
     * Method to edit Customer information
     * @param c Customer
     */
    public void editCustomer(Customer c)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date DOB = null;
        try {
            DOB = sdf.parse(getDOB());
        } catch (ParseException e) {
            DOB = null;
        }
        c.setDOB(DOB);
        c.setName(getLastName(), getFirstName());
        c.setPhone(getPhone());
        c.setAddress(getAddress(), getCity(), getStateAddress(), getZipCode());
        if(!getEmail().equals("Email")) {
            c.setEmail(getEmail());
        }
        if(getAcctType().equals("Savings")) {
            Savings s = new Savings(c, getAmount());
            try {
                c.addAccount(s);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        else if(getAcctType().equals("Investment")) {
            Investment i = new Investment(c, getAmount(), getTerm());
            try {
                c.addAccount(i);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        else if(getAcctType().equals("Line Of Credit")) {
            LineOfCredit l = new LineOfCredit(c, getAmount(), getCredit());
            try {
                c.addAccount(l);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        else if(getAcctType().equals("Checking/OverDraft")) {
            Savings s = null;
            try {
                s = (Savings) c.getAccount('S');
            } catch(AccountTypeNotFoundException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            OverDraftProtection o = new OverDraftProtection(c, getAmount(), s);
            try {
                c.addAccount(o);
            } catch(AccountTypeAlreadyExistsException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        Teller.editCustomer(c);
    }
    
    /**
     * Method untuk mendapatkan ID customer
     * @return ID
     */
    public int getID()
    {
        return Integer.parseInt(idField.getText());
    }
    
    /**
     * Method untuk mendapatkan nama belakang
     * @return Nama belakang
     */
    public String getLastName()
    {
        return lastNameField.getText();
    }
    
    /**
     * Method untuk mendapatkan nama depan
     * @return Nama depan
     */
    public String getFirstName()
    {
        return firstNameField.getText();
    }
    
    /**
     * Method untuk mendapatkan alamat
     * @return Alamat
     */
    public String getAddress()
    {
        return addressField.getText();
    }
    
    /**
     * Method untuk mendapatkan alamat kota
     * @return Kota
     */
    public String getCity()
    {
        return cityField.getText();
    }
    
    /**
     * Method untuk mendapatkan alamat state
     * @return State
     */
    public String getStateAddress()
    {
        return stateField.getText();
    }
    
    /**
     * Method untuk mendapatkan zip code
     * @return Zip code
     */
    public String getZipCode()
    {
        return zipField.getText();
    }
    
    /**
     * Method untuk mendapatkan nomor telepon
     * @return Nomor telepon
     */
    public String getPhone()
    {
        return phoneField.getText();
    }
    
    /**
     * Method untuk mendapatkan alamat email
     * @return Email
     */
    public String getEmail()
    {
        return emailField.getText();
    }
    
    /**
     * Method untuk mendapatkan tanggal lahir/DOB
     * @return DOB
     */
    public String getDOB()
    {
        return dobField.getText();
    }
    
    /**
     * Method untuk mendapatkan tipe akun
     * @return Tipe akun
     */
    public String getAcctType()
    {
        return accountList.getSelectedItem().toString();
    }
    
    /**
     * Method untuk mendapatkan jumlah uang
     * @return Jumlah uang
     */
    public int getAmount()
    {
        return Integer.parseInt(amountField.getText());
    }
    
    /**
     * Method untuk mendapatkan waktu investasi
     * @return Waktu investasi dalam bulan
     */
    public int getTerm()
    {
        return Integer.parseInt(termField.getText());
    }
    
    /**
     * Method untuk mendapatkan jumlah kredit
     * @return Jumlah kredit
     */
    public int getCredit()
    {
        return Integer.parseInt(creditField.getText());
    }
}