# **TIFC2DEV-JAVA-MJ10 Lab – Address-Book (Collections)**

## **Laboratorio: Agenda de Contactos**

## **Objetivo**

Aplicar los conceptos del Framework de Colecciones de Java vistos en la sesión anterior: uso de List , Set , Map , genéricos, comparación de implementaciones y elección de la colección adecuada según el caso de uso.

## **Descripción del Proyecto**

Vas a construir una Agenda de Contactos que permita almacenar, buscar, eliminar y listar contactos, organizarlos en grupos, y mantener un historial de los contactos agregados en orden de inserción.

El sistema debe manejar:

- Contactos individuales (nombre, teléfono, email).

- Grupos de contactos (categorías únicas).

- Búsqueda rápida por nombre.

- Listado alfabético de contactos y de grupos.

- Contactos organizados por grupo.

- Historial de contactos agregados en orden de inserción.

## **Requerimientos Técnicos**

### **1. Clase** Contacto

Crea una clase Contacto con los siguientes atributos privados:

nombre : String

telefono : String

email : String

#### **Métodos:**

Constructor que recibe todos los atributos.

Getters para todos los atributos.

Setters para todos los atributos.

- toString() que devuelve Nombre | Teléfono: X | Email: Y .

### **2. Clase** Agenda

Crea una clase Agenda que gestione contactos, grupos e historial. Debe usar las siguientes estructuras:

|**Estructura**|**Tipo**|**Por qué esta implementación**|
|---|---|---|
|Map<String,<br>Contacto>|TreeMap|Búsqueda rápida por nombre y orden<br>alfabético garantizado.|
|Set<String>|TreeSet|Grupos únicos y ordenados<br>alfabéticamente.|
|Map<String,<br>Set<String>>|TreeMapde<br>TreeSet|Relación grupo → nombres de<br>contactos.|
|List<Contacto>|ArrayList|Historial de contactos en orden de<br>inserción.|



#### **Métodos requeridos:**

|**Método**|**Descripción**|
|---|---|
|agregarContacto(Contacto c)|Agrega el contacto al<br>Mapy al<br>historial. Si el nombre ya existe,<br>muestra error y no agrega.|
|buscarContacto(String nombre)|Retorna el contacto o<br>nullsi<br>no existe.|



|**Método**|**Descripción**|
|---|---|
|eliminarContacto(String nombre)|Elimina del<br>Map, del historial y<br>de todos los grupos. Retorna<br>truesi se eliminó.|
|listarContactos()|Muestra todos los contactos en<br>orden alfabético (recorriendo el<br>TreeMap).|
|listarHistorial()|Muestra los contactos en el<br>orden en que se agregaron<br>(recorriendo el<br>ArrayList).|
|agregarGrupo(String nombreGrupo)|Agrega un grupo nuevo. Si ya<br>existe, muestra error.|
|agregarContactoAGrupo(String<br>nombreContacto,String nombreGrupo)|Agrega el nombre del contacto al<br>grupo. Valida que ambos existan.|
|listarGrupos()|Muestra los grupos en orden<br>alfabético.|
|mostrarContactosPorGrupo(String<br>nombreGrupo)|Muestra los contactos del grupo.<br>Si el grupo no existe o está<br>vacío, muestra mensaje.|



**Nota sobre el historial:** el historial es una List<Contacto> que guarda los contactos en el orden en que se agregaron. Es independiente del TreeMap , que los guarda ordenados por nombre. Esto te permite comparar dos comportamientos: orden de inserción ( ArrayList ) vs orden alfabético ( TreeMap ).

### **3. Clase** MenuPrincipal

Crea un menú interactivo con las siguientes opciones:

=== AGENDA DE CONTACTOS ===

1. Agregar contacto

2. Buscar contacto

3. Eliminar contacto

4. Listar contactos (orden alfabetico)

5. Listar historial (orden de insercion)

6. Agregar grupo

7. Agregar contacto a grupo

8. Listar grupos

9. Mostrar contactos por grupo

10. Salir

==========================

Elige una opcion:

#### **Requisitos del menú:**

- Bucle while hasta que el usuario elija "Salir".

- switch para procesar las opciones.

- Scanner para leer la entrada.

- Manejo de entradas inválidas (letras, opciones fuera de rango).

- Limpiar el buffer del Scanner después de nextInt() .

- Cerrar el Scanner al salir.

#### **Pistas para entradas inválidas:**

- Usa scanner.hasNextInt() antes de nextInt() .

- Si no es número, consume con scanner.nextLine() y muestra error.

- Después de nextInt() , usa scanner.nextLine() para consumir el salto pendiente.

## **Ejemplo de Salida Esperada**

=== AGENDA DE CONTACTOS ===

1. Agregar contacto

Elige una opcion: 1

--- AGREGAR CONTACTO --Nombre: Ana Perez Telefono: 555-1234 Email: ana@email.com

Contacto agregado: Ana Perez

Elige una opcion: 1 Nombre: Carlos Gomez Telefono: 555-5678 Email: carlos@email.com

Contacto agregado: Carlos Gomez

Elige una opcion: 1 Nombre: Ana Perez Telefono: 555-9999 Email: ana2@email.com Error: Ya existe un contacto con el nombre 'Ana Perez'

Elige una opcion: 4

--- LISTA DE CONTACTOS (orden alfabetico) --Ana Perez | Telefono: 555-1234 | Email: ana@email.com Carlos Gomez | Telefono: 555-5678 | Email: carlos@email.com

Elige una opcion: 5

--- HISTORIAL (orden de insercion) --Ana Perez | Telefono: 555-1234 | Email: ana@email.com Carlos Gomez | Telefono: 555-5678 | Email: carlos@email.com

Elige una opcion: 6 Nombre del grupo: Trabajo Grupo 'Trabajo' creado

Elige una opcion: 7 Nombre del contacto: Ana Perez Nombre del grupo: Trabajo Contacto agregado al grupo 'Trabajo'

Elige una opcion: 9 Nombre del grupo: Trabajo Contactos en 'Trabajo': - Ana Perez | Telefono: 555-1234 | Email: ana@email.com

Elige una opcion: 10 Saliendo de la agenda...

**Nota:** en este ejemplo, el orden alfabético y el orden de inserción coinciden porque se agregaron en orden alfabético. Para ver la diferencia, agrega primero "Carlos" y luego "Ana": el listado alfabético mostrará "Ana" primero, y el historial mostrará "Carlos" primero.

## **Cómo Verificar que Funciona**

|**#**|**Caso**|**Resultado esperado**|
|---|---|---|
|1|Agregar contacto nuevo|"Contacto agregado: X"|
|2|Agregar contacto duplicado|"Error: Ya existe un contacto con el<br>nombre 'X'"|
|3|Buscar contacto existente|Muestra el contacto|
|4|Buscar contacto inexistente|"Contacto no encontrado: X"|
|5|Eliminar contacto existente|"Contacto eliminado: X"|
|6|Eliminar contacto inexistente|"Contacto no encontrado: X"|
|7|Listar contactos|Orden alfabético|
|8|Listar historial|Orden de inserción|
|9|Agregar grupo nuevo|"Grupo 'X' creado"|
|10|Agregar grupo duplicado|"Error: El grupo 'X' ya existe"|
|11|Agregar contacto a grupo<br>existente|"Contacto agregado al grupo 'X'"|
|12|Agregar contacto inexistente a<br>grupo|"Error: El contacto 'X' no existe"|
|13|Agregar contacto a grupo<br>inexistente|"Error: El grupo 'X' no existe"|
|14|Mostrar contactos de grupo<br>con contactos|Lista de contactos|
|15|Mostrar contactos de grupo<br>vacío|"El grupo 'X' no tiene contactos"|
|16|Mostrar contactos de grupo<br>inexistente|"Error: El grupo 'X' no existe"|



|**#**|**Caso**|**Resultado esperado**|
|---|---|---|
|17|Eliminar contacto que está en|Se elimina del<br>Map, del historial y de|
||grupos|todos los grupos|
|18|Ingresar opción inválida (letra)|"Opcion invalida, intenta de nuevo"|
|19|Ingresar opción fuera de rango|"Opcion invalida, intenta de nuevo"|
|20|Salir del menú|"Saliendo de la agenda..."|



- List → orden de inserción, permite duplicados, acceso por índice.

- Set → sin duplicados, sin orden garantizado ( HashSet ) u ordenado ( TreeSet ).

- Map → clave-valor, búsqueda rápida, sin orden ( HashMap ) u ordenado por clave

- ( TreeMap ).

## **Entregables**

1. Archivos de código:

    - Contacto.java

    - Agenda.java

    - MenuPrincipal.java

2. Captura de pantalla de la ejecución mostrando:

    - Agregar al menos 3 contactos.

    - Listar contactos en orden alfabético.

    - Listar historial en orden de inserción.

    - Crear al menos 2 grupos.

    - Agregar contactos a grupos.

    - Mostrar contactos por grupo.

    - Buscar un contacto existente.

    - Buscar un contacto inexistente.

    - Eliminar un contacto.

    - Intentar agregar un contacto duplicado.

## **Recomendaciones**

- Comienza por Contacto y asegúrate de que compile antes de continuar.

- Prueba Agenda con un main simple antes de construir el menú.

- Usa nombres descriptivos para variables y métodos.

- Agrega comentarios para explicar la lógica no obvia.

- Prueba casos límite: contacto duplicado, búsqueda inexistente, eliminación inexistente, grupo inexistente, opción inválida.

- Asegúrate de que el menú no termine hasta que el usuario elija "Salir".

- Cierra el Scanner al salir.

- Si terminas antes de los 90 minutos, agrega una nueva funcionalidad: Buscar contactos por dominio de email.

    - Eliminar un grupo completo (y quitarlo de los contactos asociados). Mostrar todos los contactos ordenados por email.

## **Notas para el Estudiante**

- **Usa** TreeMap **y** TreeSet **en la versión base.** El laboratorio pide orden alfabético garantizado. En la Sección 5 experimentas con HashMap y HashSet para ver la diferencia.

- **Declara contra la interfaz, instancia contra la implementación.** Map<String, Contacto> contactos = new TreeMap<>(); , no TreeMap<String, Contacto> contactos = new TreeMap<>(); .

- **Usa genéricos siempre.** Map<String, Contacto> , Set<String> , List<Contacto> , Map<String, Set<String>> .

- **No necesitas** equals **y** hashCode **en** Contacto **.** El Map usa el nombre como clave y el Set de grupos guarda nombres ( String ), no objetos Contacto .

- **Prueba cada parte antes de avanzar.** Si Contacto no compila, Agenda tampoco.

- **Comenta tu código.** No para que se vea bonito, sino para que puedas entenderlo después. 

## Imagenes 

![Imagen 1](/photos/imagen_1.webp "Imagen 1")
![Imagen 2](/photos/imagen_2.webp "Imagen 2")
![Imagen 3](/photos/imagen_3.webp "Imagen 3")