-- Script de creación de Base de Datos para el Proyecto Formativo: Recetas Dulces
-- Evidencia: GA7-220501096-AA2-EV01

CREATE DATABASE IF NOT EXISTS recetas_dulces_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE recetas_dulces_db;

CREATE TABLE IF NOT EXISTS recetas (
    id_receta INT AUTO_INCREMENT PRIMARY KEY,
    nombre_receta VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    ingredientes TEXT NOT NULL,
    preparacion TEXT NOT NULL,
    tiempo_preparacion_min INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Registros iniciales de prueba
INSERT INTO recetas (nombre_receta, categoria, ingredientes, preparacion, tiempo_preparacion_min) VALUES
('Torta Tres Leches', 'Tortas', 'Harina de trigo, huevos, azúcar, leche entera, leche evaporada, leche condensada, crema de leche', 'Hornear el bizcochuelo, pinchar y bañar con la mezcla de las tres leches. Decorar con merengue.', 60),
('Arroz con Leche Tradicional', 'Postres Típicos', 'Arroz blanco, leche entera, leche condensada, astillas de canela, uvas pasas, esencia de vainilla', 'Cocinar el arroz con canela, incorporar las leches a fuego bajo hasta obtener cremosidad.', 45);
