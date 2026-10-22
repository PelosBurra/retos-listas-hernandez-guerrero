
New messages
reto 3
class NodoCircular {
    String cancion;
    NodoCircular siguiente;

    NodoCircular(String cancion) { this.cancion = cancion; }
}

class ListaCircular {
    private NodoCircular actual; 
    private NodoCircular cola;

    public void insertar(String cancion) {
        NodoCircular nuevo = new NodoCircular(cancion);
        if (cola == null) {
            nuevo.siguiente = nuevo; 
            actual = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cola.siguiente; 
            cola.siguiente = nuevo;           
            cola = nuevo;                     
        }
    }
public void rotar(int n) {
        if (actual == null) return;
        for (int i = 0; i < n; i++) {
            actual = actual.siguiente; // TODO 4
        }
    }

    public void eliminarActual() {
        if (cola == null) return;
        if (actual == actual.siguiente) { 
            actual = null;
            cola = null;
            return;
        }
 
        NodoCircular anterior = actual;
        while (anterior.siguiente != actual) {
            anterior = anterior.siguiente;
        }

        anterior.siguiente = actual.siguiente;
        if (actual == cola) {
            cola = anterior;
        }
        actual = actual.siguiente;
    }


    public String cancionActual() {
        return actual == null ? null : actual.cancion;
    }
public void mostrar() {
        if (actual == null) {
            System.out.println("(lista vacía)");
            return;
        }
        NodoCircular aux = actual;
        do {
            System.out.print(aux.cancion + " -> ");
            aux = aux.siguiente;
        } while (aux != actual);
        System.out.println("(vuelve a " + actual.cancion + ")");
    }
}

public class Reto3 {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.insertar("Canción A");
        lista.insertar("Canción B");
        lista.insertar("Canción C");
        lista.insertar("Canción D");

        System.out.println("Lista inicial:");
        lista.mostrar();
        System.out.println("Suena: " + lista.cancionActual());

        lista.rotar(6);
        System.out.println("\nTras rotar 6:");
        lista.mostrar();
        System.out.println("Suena: " + lista.cancionActual());
for (int i = 1; i <= 4; i++) {
            lista.eliminarActual();
            System.out.println("\nTras eliminar la actual (" + i + "):");
            lista.mostrar();
        }
    }
}