# Generador de Números de Control #
### Este sistema permite la generación de números de control para las inscripciones de estudiantes de diversos campus. ###
 ### La aplicación cliente al iniciarse solicitará al usuario introducir el año de ingreso y número de tecnológico. Se generará el número de control y se imprimirá en la pantalla del cliente. ###
# #
## Compilación y ejecución del generador de número de control ##
#### Se debe estar en la carpeta raíz del proyecto (donde existen las carpetas que contienen las clases) ####
### Para compilar se utiliza ### 
```shell
javac -encoding UTF-8 shared/IGeneradorNC.java servidor/GeneradorNC.java servidor/Servidor.java cliente/Cliente.java
```
# #
### Para realizar la ejecución ###
#### Servidor ####
```
java servidor.Servidor
```
#### Cliente ####
```
java cliente.Cliente
```