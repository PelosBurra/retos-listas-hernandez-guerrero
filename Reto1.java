class Nodo {
    String cancion;
    Nodo siguiente;
    Nodo(String cancion) { this.cancion = cancion; }
}

class ListaSimple {
    private Nodo cabeza;

    public void insertarInicio(String cancion) {
        Nodo nuevo = new Nodo(cancion);
        nuevo.siguiente = cabeza; 
        cabeza = nuevo;           
    }

    public int contar() {
        int total = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            total++;
            actual = actual.siguiente;
        }
        return total;
    }

    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo proximo = actual.siguiente; 
            actual.siguiente = anterior;     
            anterior = actual;               
            actual = proximo;                
        }
        cabeza = anterior; 
    }
public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.cancion + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class Reto1 {
    public static void main(String[] args) {
        ListaSimple cola = new ListaSimple();
        cola.insertarInicio("Canción A");
        cola.insertarInicio("Canción B");
        cola.insertarInicio("Canción C");
        cola.insertarInicio("Canción D");
        cola.mostrar();
        System.out.println("Total: " + cola.contar());
        cola.invertir();
        cola.mostrar();
    }
}