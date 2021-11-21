package ejercicio_13;

import java.time.LocalDateTime;
/*esta clase sera el hilo que atienda a cada cliente de la cola
* tiene como atributos un objeto ColaTienda y un id
* */

public class Cajera extends Thread {
    private ColaTienda colaCliente;
    private int id;

    //constructor
    public Cajera(ColaTienda colaCliente, int id) {
        this.colaCliente = colaCliente;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            LocalDateTime horaInicio = LocalDateTime.now();
            Cliente cliente;
            //si cierra la tienda y aun quedan clientes siguen atendiendo las cajeras
            while (LocalDateTime.now().minusMinutes(1).isBefore(horaInicio)
                    || (LocalDateTime.now().minusMinutes(1).isAfter(horaInicio) && !colaCliente.isEmpty())) {

                    //llamamos a nuestro metodo synchronized
                    cliente = colaCliente.atenderCLiente();
                    //si no hay clientes en la cola pero no hemos cerrado la tienda , la cajera espera unos 500 ms
                    if (cliente!= null){

                        System.out.println("La cajera " + id + " está atiendo al Cliente " + cliente.getIdCliente());
                        for (int i = 0; i < cliente.getProductos().size(); i++) {
                            //la cajera se demora en cada producto el valor entero del array en esa iteracion
                            Thread.sleep(cliente.getProductos().get(i) * 1000);
                            System.out.println("\nla Cajera " + id + " ha procesado el producto " + (i + 1)
                                    + " de " + cliente.getProductos().size() + " productos del cliente " +
                                    cliente.getIdCliente()
                                    + " en " + cliente.getProductos().get(i) + " segundos");
                        }

                    }else {
                        Thread.sleep(500);
                    }

            }
            System.out.println("\nCobro finalizado... Cajera " + id + " liberada.");
        } catch (InterruptedException ie) {
            System.out.println("\n Se ha interrumpido el cobro...");
        }
    }
}

