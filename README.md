# Cinemapp
<b>Las capas de la aplicación:</b>

Estoy incursionando en el patron de diseño Model view view-model (MVVM) , por ende hice el proyecto basado en él,
sin embargo tengo detalles que mejorar

Todas las clases que estan dentro de la carpeta 'model', son las clases modelos y sirven como su nombre lo indica 
para modelar la data, tanto la que viene en formato JSon de la API como para modelar las tablas de la base de datos.
Aqui es donde deberia estar toda la logica de negocio.

En la carpeta viewModel estan las clases encargadas de enlazar la vista con la data , en estas clases tambien se 
encuentran acciones de botones y data reactiva para los cambios en tiempo real de la vista

En la carpeta View se encuentran las actividates y fragmentos encargados de mostrar la informacion en una forma 
que el usuario pueda entenderla. tambien se encuentran los adaptadores de vista.

La carpeta db estan los archivos necesarios para crear la persistencia , en la clase MovieDataBase exactamente es donde
yace la creacion de la misma , en la interface MovieDao es donde se encuentran las llamadas SQL. Para crearla uso la 
libreria AndroidRoom.

<b>Principio de Responsabilidad única</b>
Este princio nos dice que cada clase debe tener una unica responsabilidad , su fin es separar todas las actividades
de una app en clases tal que las capas esten totalmente separadas y puedan crearce aplicaciones mantenibles y mas 
escalables.

<b>Codigo limpio</b>
Segun mi experiencia un buen codigo o codigo limpio deberia cumplir con varias caracteristicas por ejemplo:
* Seguir un patron de diseño.
* La vista debe estar separada de la logica.
* Las clases deben tener una sola responsabilidad
* El codigo debe seguir una convencion en los nombres de variables,metodos,clases,etc.

<b>Librerias y herramientas usadas</b>

Para hacer esta app utilicé: 

* AndroidRoom para las base de datos.
* DataBinding para enlazar la vista con la logica.
* LiveData para que la vista cambiara cuando la data lo haga.
* MVVM como patron de diseño.
* RecyclerView para presentar la data.
* Retrofit para hacer las llamadas a la api.





