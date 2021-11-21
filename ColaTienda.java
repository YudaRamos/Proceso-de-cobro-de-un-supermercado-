package ejercicio_13;

import java.util.LinkedList;
/*esta clase  contiene un atributo Linkedlist
*con ella haremos metodos syncronized para que los
* demas hilos puedan acceder a los metodos de la clase LinkedList
* */
public class ColaTienda {

    private LinkedList<Cliente> colaCliente;

    //constructor
    public ColaTienda() {
        colaCliente = new LinkedList<>();
    }

    public synchronized void entrarCliente(Cliente cliente){
        colaCliente.addLast(cliente);
    }

    /*controla que si la cola esta vacia no se intente atender a un cliente*/
    public synchronized Cliente atenderCLiente(){
        Cliente result;
        if (!colaCliente.isEmpty()){
            result = colaCliente.removeFirst();
        }else {
            result= null;
        }
        return result;
    }

    public synchronized boolean isEmpty(){
        return colaCliente.isEmpty();
    }

    public synchronized int size(){
        return colaCliente.size();
    }
}
