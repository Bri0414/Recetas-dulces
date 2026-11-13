# Módulo de Gestión de Recetas Dulces (Java + JDBC)

**Evidencia:** GA7-220501096-AA2-EV01 - Codificación de módulos del software  
**Programa:** Análisis y Desarrollo de Software (ADSO) - SENA  
**Ficha:** 3336221  
**Aprendiz:** Briggyth Daniela Tellez Mogollón  

## Estructura del Proyecto
- `src/conexion/ConexionBD.java`: Clase encargada de establecer la conexión con MySQL mediante JDBC.
- `src/modelo/Receta.java`: Clase entidad que modela los atributos y métodos de una receta dulce.
- `src/controlador/RecetaDAO.java`: Implementación del patrón DAO con operaciones CRUD (Inserción, Consulta, Actualización y Eliminación).
- `src/vista/Main.java`: Clase principal para ejecutar y validar las funcionalidades del módulo.
- `database/recetas_dulces_db.sql`: Script SQL para crear la base de datos y tabla `recetas`.

## Requisitos de Ejecución
1. Java JDK 17 o superior.
2. Servidor MySQL activo (ej. XAMPP).
3. Librería `mysql-connector-j` (Driver JDBC) agregada al Classpath del proyecto.
