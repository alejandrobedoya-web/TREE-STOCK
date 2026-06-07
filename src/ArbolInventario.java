public class ArbolInventario {
    private Producto raiz;  // Primer nodo del árbol (punto de entrada)

    // Constructor: árbol vacío al inicio
    public ArbolInventario() {
        this.raiz = null;

    }
    // Getter: permite obtener la raíz desde Main
    public Producto getRaiz() {
        return raiz;
    }

    // Inserta un nuevo nodo en el árbol
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    // Método recursivo que busca dónde colocar el nuevo nodo
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Si llegó a un lugar vacío, crea el nuevo nodo aquí
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // Si el id es menor, va a la rama izquierda
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        } 
        // Si el id es mayor, va a la rama derecha
        else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        }
        // Si son iguales, no hace nada (evita duplicados)
        
        return actual;  // Devuelve el nodo actualizado
    }


    // Recorrido INORDEN: Izquierda -> Raíz -> Derecha (menor a mayor)
    public void mostrarInorden(Producto nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.getIzquierdo());
            System.out.println("Extensión: " + nodo.getId() + " | Producto: " + nodo.getNombre());
            mostrarInorden(nodo.getDerecho());
        }
    }


    // Busca un ID en el árbol y devuelve un mensaje
    public String buscar(int id) {
        return buscarRecursivo(raiz, id) ? "ID encontrado en el sistema: "  : "El ID no existe.";
    }

    // Método recursivo para buscar
    private boolean buscarRecursivo(Producto actual, int id) {
        if (actual == null) return false;           // No lo encontró
        if (id == actual.getId()) return true;      // ¡Lo encontró!

        // Decide si buscar a la izquierda o derecha
        return id < actual.getId() 
            ? buscarRecursivo(actual.getIzquierdo(), id) 
            : buscarRecursivo(actual.getDerecho(), id);
    }

}