// Main.java
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("Logging from another part of the app.");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the SAME instance.");
        } else {
            System.out.println("Different instances! Singleton failed.");
        }
    }
}
