package server;

import shared.SaludadorInterface;

public class Saludador 
    implements SaludadorInterface 
{
    @Override
    public String diHola(){
        return "Hola";
    }
}
