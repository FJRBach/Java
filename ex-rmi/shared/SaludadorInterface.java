package shared;

public interface SaludadorInterface 
    extends java.rmi.Remote
{
    public String diHola()
        throws java.rmi.RemoteException;
}