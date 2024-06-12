Anotaciones importantes

se adjunto en la carpeta documentos que esta en la carpeta raiz la documentacion necesaria(prueba de los servicios , despliegue en docker , diagrama de casos de uso , 
diagrama de base de datos)

Diagrama de base de datos :

se creo solo tres tablas para demostracion de los servicios registrar y consultar notas , la tabla usuario para acceder al sistema y la tabla cursos que tiene todo 
los cursos asignados a los alumnos 

la relacion basica seria con la tabla notas que estarian relacionadas por su codigo , ya que la tabla notas es necesaria tener el codigo del alumno y el codigo de materia , en la creacion
de la base de datos se creo esa relacion con clave foraneas

Patrones de diseño basicos

patron abstract factory , singleton son usados en spring para la creacion de objetos y no instanciar nuevamente los objetos sino reutilizarlos
