package rojas.alan.pkgfinal.java.pkg2024;


import java.util.*;
import java.io.*;
import java.util.function.*;


public class GestionVehiculos implements GestionInterface<Vehiculo>{ // Vehiculos puede declararse como vehiculos, object o como quieras
    
    // === atributo lista ===
    private ArrayList<Vehiculo> listaVehiculos; // esto es una variable  sin datos aun
    
    
    // === mini constructor ===
    public GestionVehiculos() {
        listaVehiculos = new ArrayList<>(); // luego crea el array con la variable
    }
    // iTERATOR CUSTOM
    public IteradorVehiculos iterator() {
        return new IteradorVehiculos(listaVehiculos);
    }
    
    
    
    // === metodos interfaces ===
    @Override
    public void agregar(Vehiculo vehiculo) {
    //  listaVehiculos.add(vehiculo); 
        agregarVehiculo(listaVehiculos, vehiculo);
        System.out.println("se ha interactuado");
    }
    
    @Override
    public void eliminar(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
        System.out.println("se ha eliminado");
    }
    
    @Override
    public void actualizar(Vehiculo viejo, Vehiculo nuevo) { // este metodo ya no se usa desde que se implemento otra forma de actualizar
        int indice = listaVehiculos.indexOf(viejo); // busca el indice del vehiculo indicado

        if (indice != -1) { // -1 es un valor unico si no encuentra el index
            listaVehiculos.set(indice, nuevo);
            System.out.println("actualizado");
        } else {
            System.out.println("no se encontro el vehiculo");
        }
    }
    
    @Override
    public List<Vehiculo> listar() {
        ArrayList<Vehiculo> copia = new ArrayList<>();

        IteradorVehiculos it = new IteradorVehiculos(listaVehiculos);

        while (it.hasNext()) {
            copia.add(it.next());
        }

        return copia;
    }
    
    
    
    // === metodos no-interface
    
//    public Vehiculo buscar(String marca) {  // metodo que se usara principalmente para actualizar y eliminar, podria estar en la interface tambien
//        for (Vehiculo v : listaVehiculos) {
//            if (v.getMarca().equalsIgnoreCase(marca)) {
//                return v;
//            }
//        }
//        return null;
//    } 
    // el codigo es remanente debido a que la idea era que iba a escribir el nombre de marca, esa idea ya ha cambiado desde entonces
    
    
    
    
    // --- wildcards / filtrado
    public List<Vehiculo> filtrarTipo(List<? extends Vehiculo> lista, Class<? extends Vehiculo> tipo) { // acepta cualquier vehiculo o hijo (list extends
        List<Vehiculo> resultado = new ArrayList<>(); // lista array llamada resultado creada
        for (Vehiculo v : lista) { // por cada vehiculo
            if (tipo.isInstance(v)) { 
                resultado.add(v); // si coincide con el tipo, lo agrega al array
            }
        }
        return resultado;
    }
    
    
    
    public void agregarVehiculo(List<? super Vehiculo> lista, Vehiculo vehiculo) { // <-- inutil, no se usa
        lista.add(vehiculo);// 
    } 
    
    
    // === NOTAS DE AUTO-EXPLICACION ===
    // wildcards son usados para representar un tipo desconocido, util si trabajas con diferentes tipos de variables
    // <?> : toma cualquier tipo, por ejemplo un List<?> puede ser List<String>, List<Integer>, etc
    // <? extends Type> : cuando le das el tipo, toma exclusivamente tipos de lo que le has dado y a hijo (vehiculo, moto, etc)
    // <? super Type> : al contrario, toma el tipo indicado y sus clases padres
    
    
    
    
    // --- interfaz funcional consumer (5)
    
    public void aumentoPrecio (int aumento) { // <- la unica interface
        Consumer<Vehiculo> subida = vehiculo -> {
            vehiculo.setPrecio(vehiculo.getPrecio() + (vehiculo.getPrecio()*aumento) / 100);
        };
        listaVehiculos.forEach(subida); 
    }
    
    // === AUTO-EXPLICACION ===
    // primero da una variable que se puede aplicar a un vehiculo
    // accion es un lambda, lo cual dice que por cada vehiculo, incrementar precio
    // y despues sube el precio
    
    // mas a fondo, una interface funcional refiere a una interfaz con un metodo abstracto
    // Consumer toma un objeto y hace una accion, sin devolver nada
   // 
    // Function transforma objeto a otra cosa (ex. string -> int)
    // predicate siempre devuelve un boolean
    // supplier es un opuesto de consumer, de una nada da algo
    // por ultimo lambdas son formatos cortos para escribir codigo (flecha = goes to)
    
    
    
    
    // --- serializacion ---
    public void guardarSerializado(String archivo) throws IOException { // esto crea el .dat
        ObjectOutputStream salida =
            new ObjectOutputStream(new FileOutputStream(archivo));
        salida.writeObject(listaVehiculos);
        salida.close();
    }
    public void cargarSerializado(String archivo) 
            throws IOException, ClassNotFoundException {
        ObjectInputStream entrada =
                new ObjectInputStream(new FileInputStream(archivo));
        listaVehiculos = (ArrayList<Vehiculo>) entrada.readObject();
        entrada.close();
    }
    
    // --- guardado / carga ---
    // metodo que reemplaza la lista actual en el proyecto, usado a la hora de cargar csv o json
    public void reemplazarLista(ArrayList<Vehiculo> nuevaLista) {
        listaVehiculos = nuevaLista;
    }
}






















// y tipo si realmente quieres un iterator custom, aca lo tenes
// para su propia clase

//---- CLASE ----
//public class IteradorVehiculos {
//
//    private List<? extends Vehiculo> lista;
//    private int indice;
//
//    public IteradorVehiculos(List<? extends Vehiculo> lista) {
//        this.lista = lista;
//        indice = 0;
//    }
//
//    public boolean hasNext() {
//        return indice < lista.size();
//    }
//
//    public Vehiculo next() {
//        return lista.get(indice++);
//    }
//}


// y luego para gestion :
//---- METODO NUEVO ----
//public IteradorVehiculos iterator() {
//    return new IteradorVehiculos(listaVehiculos);
//}

// ---- FILTRARTIPO() ----
// quitar el for y cambiar por

//IteradorVehiculos it = new IteradorVehiculos(lista);
//
//while (it.hasNext()) {
//    Vehiculo v = it.next();
//
//    if (tipo.isInstance(v)) {
//        resultado.add(v);
//    }
//}


//---- AUMENTOPRECIO() pero no necesario ----
// cambiar listaVehiculos.forEach(subida); por:

//IteradorVehiculos it = iterator();
//
//while (it.hasNext()) {
//    subida.accept(it.next());
//}


// ---- LISTAR() ----\

//@Override
//public List<Vehiculo> listar() {
//    ArrayList<Vehiculo> copia = new ArrayList<>();
//
//    IteradorVehiculos it = iterator();
//
//    while (it.hasNext()) {
//        copia.add(it.next());
//    }
//
//    return copia;
//}


// no fue realmente implementa por que java ya tiene uno propio, realmente no se necesita uno personalizado
// encerio, esto solo complica el proyecto mas y se ve feo y funciona feo y es feo
// mi cabeza ya no da AAAAAAAAAAAAAAAA