# Calculadora de figuras 2D; perímetro y área #
### La aplicación cliente mostrará un menú con las opciones para agregar cada una de las figuras, solicitando las longitudes respectivas. ###
 ### El servidor expondrá mediante el registro de RMI un objeto de la clase ListaFiguras, que implementa ListaFigurasInterface, con el nombre “figuras”. ###
# #
## Compilación y ejecución de la calculadora 2D ##
#### Se debe estar en la carpeta raíz del proyecto (donde existen las carpetas que contienen las clases) ####
### Para compilar se utiliza ### 
```shell
javac -encoding UTF-8 cliente/*.java servidor/*.java  shared/*.java
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