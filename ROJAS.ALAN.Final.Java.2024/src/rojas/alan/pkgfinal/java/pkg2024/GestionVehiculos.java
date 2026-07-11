package rojas.alan.pkgfinal.java.pkg2024;

import java.util.List;
import java.util.*;
import java.io.*;
import java.util.function.*;


public class GestionVehiculos implements GestionInterface<Vehiculo>{ // Vehiculos puede declararse como vehiculos, object o como quieras
    
    // === atributo lista ===
    private ArrayList<Vehiculo> listaVehiculos; // esto es una variable array sin datos aun
    // === constructor ===
    public GestionVehiculos() {
        listaVehiculos = new ArrayList<>(); // luego crea el array con la variable
    }
    
    // === metodos interfaces ===
    @Override
    public void agregar(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo); // 
        System.out.println("se ha interactuado");
    }
    
    @Override
    public void eliminar(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
        System.out.println("se ha interactuado");
    }
    
    @Override
    public void actualizar(Vehiculo viejo, Vehiculo nuevo) {
        int indice = listaVehiculos.indexOf(viejo);

        if (indice != -1) {
            listaVehiculos.set(indice, nuevo);
            System.out.println("Vehiculo actualizado.");
        } else {
            System.out.println("No se encontro el vehiculo.");
        }
    }
    
    @Override
    public List<Vehiculo> listar() {
        return new ArrayList<>(listaVehiculos); // envia una copia del array existente, protegiendo el interno
    }
    
    
    
    // === metodos no-interface
    
    public Vehiculo buscar(String marca) {  // metodo que se usara principalmente para actualizar y eliminar, podria estar en la interface tambien
        for (Vehiculo v : listaVehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)) {
                return v;
            }
        }
        return null;
    }
    
    // --- comparadores
    public void ordenarPorPrecio() {
        Collections.sort(listaVehiculos, new CompararPrecio());
    }

    public void ordenarPorEstado() {
        Collections.sort(listaVehiculos, new CompararEstado());
    }
    
    
    
    // --- wildcards / filtrado
    public List<Vehiculo> filtrarTipo(List<? extends Vehiculo> lista, Class<? extends Vehiculo> tipo) { // pide de un tipo, declara como variable
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : lista) {
            if (tipo.isInstance(v)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    public void agregarVehiculo(List<? super Vehiculo> lista, Vehiculo vehiculo) { // <-- medio inutil pero bueno
        lista.add(vehiculo);
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
    public void cargarSerializado(String archivo) // esto no se si realmente hace algo a pesar de su codigo
            throws IOException, ClassNotFoundException {
        ObjectInputStream entrada =
                new ObjectInputStream(new FileInputStream(archivo));
        listaVehiculos = (ArrayList<Vehiculo>) entrada.readObject();
        entrada.close();
    }
    
    // --- guardado / carga ---
    // metodo que reemplaza la lista actual en el proyecto
    public void reemplazarLista(ArrayList<Vehiculo> nuevaLista) {
        listaVehiculos = nuevaLista;
    }
}
