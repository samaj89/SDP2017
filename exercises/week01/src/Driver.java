/**
 * Created by samaj on 12/01/17.
 */
public class Driver {
    public static void main(String[] args) {
        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();

        Class<BankAccount> baCls = BankAccount.class;
        try {
            BankAccount myAccount = (BankAccount) baCls.newInstance();
            aStorage.setValue(myAccount);
            // Deposit
            myAccount.deposit(15);
        }
        catch ( InstantiationException e ) {
            // ...
        }
        catch ( IllegalAccessException e ) {
            // ...
        }

        System.out.println( aStorage.getValue().showBalance() );
        if( aStorage.getClass() == sStorage.getClass() ) {
            System.out.println( "EQUAL" );
        } else {
            System.out.println( "NOT EQUAL" );
        }
    }
}

/*  1. What are the reasons for using generics here?

    We use generics here to create different instances of storage that each contain
    a different class of object and cannot contain objects of other classes.

    2. What are the benefits?

    Using generics means that we don't need to create a different Storage class for
    every possible class of object that we might wish to store. This reduces code
    repetition, makes it easier to update the class, and makes it easier to identify
    and deal with bugs.

    3. Now add the following code to your Driver class... Compile and analyse the
    compiler output. What is the cause of the problem reported by the compiler, if any?

    aStorage.setValue(myAccount) is expecting an object of class BankAccount, but myAccount
    is of class Object, which cannot be cast down to BankAccount.

    myAccount.deposit(15) cannot work as myAccount is of class Object and Object does not
    have a deposit() method.

    4. Now replace "Object myAccount = baCls.newInstance();"
       with "BankAccount myAccount = baCls.newInstance();"

    How does this affect the compilation process? What is the problem, if any? What does
    the myAccount variable hold when the code is executed? Decide whether your diagnosis
    from question (3) was correct.

    The code does not compile, throwing an error on:

    BankAccount myAccount = baCls.newInstance();

    This is an incompatible type error; baCls.newInstance() creates an Object, which cannot
    be converted to a BankAccount. The code therefore does not compile. Dynamic casting could
    be used to resolve this error.

    5. Now add an explicit dynamic cast. What does the dynamic cast do here? Is it the compiler
    that performs the cast operation or the Java runtime environment (JVM)? Is this code safe?

    The dynamic cast converts the baCls Object to a BankAccount, meaning that the myAccount object
    can now be created and a deposit made.

    Dynamic casts are performed at runtime, so it is the JVM that performs it.

    6. Now replace your initial declaration "Class baCls = BankAccount.class;"
       with "Class<BankAccount> baCls = BankAccount.class;"

    Explain the compiler output? Are there errors? What is the reason? What does it say about
    the role of generics?

    This code compiles without error, although the explicit dynamic cast is now redundant. Because
    all objects in the code have been correctly defined using dynamic casting, the code runs without
    error. This tells us that generics only play a role up until compile time, at which point type
    erasure takes place.

    7. Now add:

    System.out.println( aStorage.getValue().showBalance() );
    if( aStorage.getClass() == sStorage.getClass() ) {
        System.out.println( "EQUAL" );
    } else {
        System.out.println( "NOT EQUAL" );
    }

    What is the run-time output? Explain why you get such output and how does this relate to generics
    and their use with reflective instantiation of objects?

    The run-time output is:
    115.0
    EQUAL

    The BankAccount object initially held 100, but 15 is deposited in Driver's main method, bringing the
    total to 115. At compile time generic types are erased, meaning that both aStorage and sStorage are
    objects of class Storage, making them equal. This shows that generics allow additional compile time
    constraints to be added to code, but that these do not carry through to run-time.
 */


