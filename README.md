# Rojas.Alan.Final.Java.2024
====================================


# Sistema CRUD de Gestion de Vehiculos.

### Sobre Mi: 
El nombre es **Alan Rojas**, estudiante de la UTN y este proyecto de Netbeans es del trabajo final para la materia de Programacion II.

## Resumen
El proyecto consiste de una aplicacion CRUD que simula una gestion de vehiculos. permite administrar los vehiculos de la lista por medio de la interfaz grafica.

### Funcionalidades
el programa es capaz de:
1. Agregar, eliminar y editar vehiculos por medio de interfaces visuales (.fxml).
2. Listar los vehiculos existentes en una tabla organizada.
3. Filtrar por tipo de vehiculo (Auto, Moto o Camion).
4. Ordenar los vehiculos por precio, estado y mas.
5. Ordernar por Ascendencia y Descendencia.
6. Exportar la informacion a un archivo TXT legible
7. Guarda los datos mediante serializacion (.dat), formatos CSV (.csv) y JSON (.json)
8. Carga los datos guardados por medio de el formato CSV o JSON.
9. Mostrar informacion adicional de cada vehiculo en la tabla por medio de Tooltips al tener el mouse encima.


# Capturas de la aplicacion

## Pantalla principal

(Pegar aquí una captura)

![Pantalla principal](imagenes/principal.png)

## Formulario de alta

(Pegar aquí otra captura)

![Formulario](imagenes/formulario.png)

## Filtrado

(Pegar aquí otra captura)

![Filtro](imagenes/filtro.png)

## Diagrama UML del proyecto

<img width="740" height="590" alt="Image" src="https://github.com/user-attachments/assets/6a2b7553-1770-4848-87d4-f856577d5e0b" />




# Archivos generados

La aplicación genera los siguientes archivos:

- **vehiculos.dat** (serialización)
- **vehiculos.csv**
- **vehiculos.json**
- **vehiculos.txt**

Ejemplos:

### CSV

```
Tipo,Marca,Año,Precio...
```

### JSON

```json
[
  {
    "tipo":"Auto",
    "marca":"Ford"
  }
]
```

### TXT

```
===== LISTADO DE VEHICULOS =====

Tipo: Auto
Marca: Ford
Precio: $15000

...
```

Los archivos completos pueden encontrarse dentro del proyecto.
