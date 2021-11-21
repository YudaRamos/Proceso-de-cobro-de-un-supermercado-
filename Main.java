package ejercicio_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ColaTienda colaClientes = new ColaTienda();

        ColaClientes cola= new ColaClientes(colaClientes);
        Cajera cajera1 = new Cajera(colaClientes, 1);
        Cajera cajera2 = new Cajera(colaClientes,2);
        cola.start();
        cajera1.start();
        cajera2.start();




    }
}
