
/**
 * JBank Phase 1.
 * 
 * @author (Abdul Chandra Irawan)
 * @NPM (1306405244)
 * @version (20-02-2016)
 */
public class Customer
{
    private Account accounts = new Account(); //Membuat variabel bertipe Account berdasarkan class Account
    private String cityAddress,dateOfBirth,email,firstName,lastName,streetAdress,phoneNumber,zipOrPostalCode; //membuat variabel bertipe string,variable berupa sekumpulan karakter
    private int custId,numberOfCurrentAccounts; //membuat variabel bertipe integer, yaitu variabel berisi angka dengan batasan -32768 sampai 32767
    
    public Customer(){}
    public Customer(String fname,String lname, String dob){}
    public Customer(String firstName,String lastName, String dateOfBirth, int custId){}
    private String getAddress(){
    return "";
    }
    private Account getAccount(){ //pembuatan fungsi getAccount untuk menerima nama akun
    return accounts;
    }
    private int getCustomerId(){//pembuatan fungsi getCustomerId untuk menerima id pelanggan
    return 0;
    }
    private String getEmail(){//membuat fungsi getEmail untuk menerima input email
    return "";
    }
    private int getNumOfAccounts(){//membuat fungsi getNumAccounts untuk menerima input nomer akun
    return 0;
    }
    private String getPhoneNumber(){//membuat fungsi getPhoneNumber, untuk menerima input nomer telepon
    return "";
    }
    
    private void setAddress(String street, String city, String code) {//membuat fungsi setaddress dengan variabel street,city dan code
        return;
    }
    private void setEmail(String emailAddress) {//membuat fungsi setEmail, dengan variabel emailAddress
        return;
    }
    private void setCustomerName(String lname, String cfname) {//membuat fungsi setCustomerName, dengan variabel lname dan cfname
        return;
    }
    private void setPhoneNumber(String phoneNum) {//membuat fungsi sePhoneNumber 
        return;
    }
}
