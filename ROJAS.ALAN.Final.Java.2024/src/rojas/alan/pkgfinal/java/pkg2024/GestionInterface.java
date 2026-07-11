
package rojas.alan.pkgfinal.java.pkg2024;
import java.util.List;


public interface GestionInterface<T> { // T = generico

    void agregar(T vehiculo);
    void eliminar(T vehiculo);
    void actualizar(T viejo, T nuevo);
    List<T> listar();
    
}


// COMENTARIO RESERVADO PARA AUTO-EXPLICARSE INTERFACE
// interfaces son como un contrato, como un control remoto universal, todas las teles deben tener un boton de apagado y cambiar control y cambiar volumen
// puedes declarar en la interface como hacerlo, si requiere X cosa o Y otra
// toda clase que la implemente debera usar lo que se declaro en la interface, sin embargo no importa como lo haga
// se separa de abstract por que ahi se comparte, aca en interface se DEBE implementar

// en todo caso una interface no tiene tanto poder tecnico, es mas una forma de organizar y muchas cosas se pueden hacer sin usarlas
// pero en el contexto del proyecto es un requerimiento