import com.gfg.jbdl.domain.BankAccount;
import com.gfg.jbdl.domain.Person;

public class FirstMain {

    public static void main(String[] args) {
        System.out.println("hi");

        Person person=new Person();
        person.setAge(8);
        person.setName("john");
        person.setLastname("M");

        person.setAge(-100);

       // System.out.printbln(person);

        BankAccount bankAccount=new BankAccount();

        bankAccount.deposit(1000.0);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdarw(500.0);
        System.out.println(bankAccount.getBalance());



        //save in database

    }
}





