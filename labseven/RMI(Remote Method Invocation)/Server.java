import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server {
    public interface Calc extends Remote {
        int multiply(int a, int b) throws RemoteException;
        int divide(int a, int b) throws RemoteException;
    }

    public static class CalcImpl extends UnicastRemoteObject implements Calc {
        CalcImpl() throws RemoteException {}
        public int multiply(int a, int b) { return a * b; }
        public int divide(int a, int b) { return a / b; }
    }

    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099); // default port
        Naming.rebind("calc", new CalcImpl());
        System.out.println("Server ready...");
    }
}
