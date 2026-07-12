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

<img width="2162" height="1074" alt="image" src="[https://github.com/user-attachments/assets/940fe871-43f3-46e0-a321-40909a7697e8](https://uml.planttext.com/plantuml/svg/hLTDRziu4BqRy7yGqiCcJHtiNXTTewgYPBrmRCDIWzuAcfeux5AaGLBTDcd_-uuaYlfqhHRrmQ3VaCEPDyD7-eqsH9aivTF9TAB_PU9054azoedMlZ6AxJ832of5n9x0-xqvHp-IHFx7nDvx85n3qvHA8UcZaYbuHcMG-pRCSF0YfWsan4l0kmLjc1Jvy1uU6SsurFd4t_uwza6R5wxUtKNVdpITWCXIByIlG7AfdgSJ3pzR-L6M8_yfu-NeBIU2MdG5UsM7juhfSdGFAi7mlxMyXiXP8gtRLGQVxB9t6k5o68eF2d8kAAPOxM-azNGYnVT1k8aNwzMfD8iYUU5d2eTycmqeBGNXx8aan4PtEMmzZx2oOdzXuncUvCrcN-UbUrDaSIhmnIeEjpT-49uAd0a3we5GrmIB2dWTpwl8oLx1dgZp-C82m5dAH1CXr6H5i8YzSYXdUK-VNtX_UaiSeijHjFjletZh1x4NBFteP8kHdJPONLEU5DV1pxajZ-95IXGb64B9j0M9O18npDy21mMq0z6yPn5n_MjnABhE6ieMh2mSAEv2S-DEIWv4L65Sofq10Ifc1ramqWpdCW5D5IigFs1a-Y05st4eR5t7LAROtn3ByohtYr4q1tylbjVRS6Hpvxu_-9cfYPqH_9KIqqctC56o8nnbv1fkCb1FfE9rY8iX2WOojparehcJpMWqIu0IrG-5SIOILLRirmSHa1Gdrs70Hz3DBa8gr9u4v802b93aryLG5Tjx_NKsgyipQBYJHmnbzATxvJQCnkkWbH9tbzJa58BWSEJ2LufyARIXGkUEcqfsUgep83fTnN5ETfccBK3YDO9EDb9jYXFlbjQ6yaWtrZmmZXBZgjIEhmhS5QQhf4ZtrLMFbCRCcf2pFywybrYRivTdJiX67EJrtSRV-l5wUr8iom85XM8Goy1pMqUSYhpgoabxSUlkFRsulQTtTOKtciLChgnjjttxW8TvWwFUylaF47YpM8OZgVCLVMIVP0IA5Qr7oyDVSB3FY4g8ShQaRgv21BgMRpstGNJVSOP8nub5-el_YTQhpkeSwYoleFxw-7rSBOVF1wdm827avWvbtk6vpcBOaEyzRC6DVh1cmNeLRzVBPJY-wOLHaYFts47o2rxKhdcPOAP82cfjwH_kbWZr3BKOzKnMFjmnTmPRfMliS3rSvO727IrGByqRgTAC4yM-boZ-eNXWAcreACMNEF0MaE_VUrtqzelovq_pG8pstQBcI38vYJ-VYDMWNWlWqte-eCs3B1PpcvBJpto4koAF8_CQTtG-eV7mxE7LktCwUGCYmR-D_mC0)" />




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
