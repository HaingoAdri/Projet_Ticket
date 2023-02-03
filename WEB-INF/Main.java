package main;
import fonction.*;
import connexion.Connexion;

import java.util.Vector;

import asa.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Confirmation asa = new Confirmation();

        Vector<Confirmation> ff = asa.getConfirmation();
    }
}
