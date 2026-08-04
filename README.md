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

<img width="1399" height="1416" alt="image" src="https://github.com/user-attachments/assets/e887c599-fe08-49d0-b86c-827553413015" />





# Archivos generados

La aplicación genera los siguientes archivos:

- **vehiculos.dat** (serialización)
- **vehiculos.csv**
- **vehiculos.json**
- **vehiculos.txt**

Ejemplos:

### CSV

```
Tipo,Marca,Anio,Precio,Color,Estado,Electrico,Atributo1,Atributo2
Auto,Ford,2010,8000,Otro,Usado,false,true,120
```

### JSON

```json
[
  {
    "tipo": "Auto",
    "marca": "Ford",
    "anio": 2010,
    "precio": 8000,
    "color": "Otro",
    "estado": "Usado",
    "electrico": false,
    "automatico": true,
    "caballosDeFuerza": 120
  },
]
```

### TXT

```
===== LISTADO DE VEHICULOS =====
Cantidad de vehiculos: 1
================================

Tipo: Auto
Marca: Ford
Año: 2010
Precio: $8000
Color: Otro
Estado: Usado
Electrico: false
Automatico: true
Caballos de fuerza: 120
----------------------------------------
```

Los archivos completos pueden encontrarse dentro del proyecto.
