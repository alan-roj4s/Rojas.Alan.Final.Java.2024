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

## Menu principal

<img width="727" height="545" alt="image" src="https://github.com/user-attachments/assets/80b759ba-72b8-446c-bf57-fb8d166ffacc" />


## Formulario (utilizado para agregar y actualizar)

<img width="493" height="427" alt="image" src="https://github.com/user-attachments/assets/f1334149-17cf-43bf-a63f-d2e8d1be1433" />


## Seleccion (utilizado para actualizar y eliminar)

<img width="359" height="202" alt="image" src="https://github.com/user-attachments/assets/d53df7a0-5ffc-4789-a675-da5dc5862b90" />


## Filtrado

<img width="267" height="405" alt="image" src="https://github.com/user-attachments/assets/43d2e81b-723e-425e-a39b-d8aa4be91da9" />


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
