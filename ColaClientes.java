package ejercicio_13;

import java.time.LocalDateTime;
/*esta clase sera el hilo que gestione la entrada de clientes a la cola
 *tiene un atributo de tipo ColaTienda
 **/

public class ColaClientes extends Thread {

    private ColaTienda colaCliente;

    //constructor
    public ColaClientes(ColaTienda colaCliente) {
        this.colaCliente = colaCliente;
    }

    public void run() {
        try {
            int idCliente = 0;
            //te devuelve la hora actual en que se ejecute esta linea
            LocalDateTime horaInicio = LocalDateTime.now();

            //controlamos el tiempo que estaran entrando clientes a la cola: 1 min en este caso
            while (LocalDateTime.now().minusMinutes(1).isBefore(horaInicio)) {
                idCliente += 1;

                //creamos un nuevo cliente
                Cliente cliente = new Cliente(idCliente);

                //llamamos a nuestro metodo synchronized y añadimos el cliente a la cola
                colaCliente.entrarCliente(cliente);

                System.out.println("Ha entrado el cliente " + idCliente);
                //esperamos un tiempo en segundos alaeatorio y añadimos un nuevo cliente
                Thread.sleep((int) Math.floor(Math.random() * 10 + 1) * 1000);
            }
            System.out.println("***********************************************************************");
            System.out.println("La tienda ha cerrado , hoy se han atendido :" + idCliente + " clientes, quedan en la cola "
                    + colaCliente.size() + " clientes");

        } catch (InterruptedException ie) {
            System.out.print("\n Se ha interrumpido la cola...");
        }


    }
}
