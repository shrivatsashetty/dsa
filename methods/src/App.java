import com.dsa.methods.NameOps;

public class App {
    public static void main(String[] args) throws Exception {

        NameOps nameOps = new NameOps();

        String myName = "Kunal";

        System.out.println("Initial Value of name: " + myName);

        nameOps.changeName(myName);

        System.out.println("Final Value of Name: " + myName);

        nameOps.mutateString();
    }
}
