class NodoDoble {
    String cancion;
    NodoDoble siguiente, anterior;

    NodoDoble(String cancion) { this.cancion = cancion; }
}

class ListaDoble {
    private NodoDoble cabeza, cola;

    public void insertarFinal(String cancion) {
        NodoDoble nuevo = new NodoDoble(cancion);
        if (cola == null) {
            cabeza = nuevo; 
            cola = nuevo;
        } else {
            cola.siguiente = nuevo; 
            nuevo.anterior = cola;  
            cola = nuevo;           
        }
    }
public boolean insertarDespuesDe(String existente, String nueva) {
        NodoDoble actual = cabeza;
        while (actual != null && !actual.cancion.equals(existente)) {
            actual = actual.siguiente;
        }
        if (actual == null) return false;

        NodoDoble nuevo = new NodoDoble(nueva);
        nuevo.anterior = actual;                
        nuevo.siguiente = actual.siguiente;     
        if (actual.siguiente != null) {
            actual.siguiente.anterior = nuevo;  
        }
        actual.siguiente = nuevo;               
        if (actual == cola) {
            cola = nuevo;                       
        }
        return true;
    }

    public void mostrarAdelante() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.cancion + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
public void mostrarInverso() {
        NodoDoble actual = cola;
        while (actual != null) {
            System.out.print(actual.cancion + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}
public class Reto2 {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        lista.insertarFinal("Canción A");
        lista.insertarFinal("Canción B");
        lista.insertarFinal("Canción C");
        lista.insertarFinal("Canción D");

        System.out.println("Adelante:");
        lista.mostrarAdelante();
        System.out.println("Inverso:");
        lista.mostrarInverso();

        lista.insertarDespuesDe("Canción B", "Canción X");
        lista.insertarDespuesDe("Canción D", "Canción Y");

        System.out.println("\nDespués de insertar X (tras B) e Y (tras D):");
        lista.mostrarAdelante();
        lista.mostrarInverso();

        System.out.println("\nInsertar tras una canción que no existe: "
                + lista.insertarDespuesDe("Nada", "Z"));
    }
}