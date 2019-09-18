import java.util.*;

public class Email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "mycompany.com";

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.password = randomPassword(this.defaultPasswordLength);

        this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()+companySuffix;

    }

    private String setDepartment(){
        System.out .println("DEPATMENT CODES\n1 Sales\n2 Development\n3 Accounting\n4 Nonne\nEnter Department Code: ");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        if(depChoice == 1){return "Sales";}
        else if(depChoice == 2){ return "Developer";}
        else if(depChoice == 3){ return "Accounts";}
        else{ return "None"; }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@!$#&";
        char[] password = new char[length];

        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
            
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword(){ return password; }

    public String showInfo(){
        return "Display Name: "+ firstName+" "+lastName+
        		"\nDepartment: "+ department+
                "\nCompany Email: "+ email+
                "\nPassword: "+ password+ 
                "\nMailbox Capacity: " + mailboxCapacity + "mb";

    }



}
