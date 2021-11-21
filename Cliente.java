package ejercicio_13;

import java.util.ArrayList;

public class Cliente{

    //Creamos un ArrayList con productos
    private ArrayList<Integer> productos = new ArrayList<Integer>();
    private int idCliente;

    public void setProductos(ArrayList<Integer> productos) {
        this.productos = productos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //constructor
    public Cliente( int idCliente) {
        this.idCliente = idCliente;
        //Añadimos de 1 a 10 productos con una duración de 1 a 5 segundos
        for(int i = 0; i < (int)Math.floor(Math.random()*10+1); i++) {
            //floor() es un método del objeto estándar Math que redondea un número dado hacia el número entero anterior
            productos.add((int)Math.floor(Math.random()*5+1));   }

    }
    public ArrayList<Integer> getProductos() {
        return productos;
    }
}
