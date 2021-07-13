SELECT *
FROM posts
WHERE id > 50;

SELECT *
FROM posts
WHERE estatus != 'inactivo';

-- buscar por fraccion de texto
SELECT *
FROM posts
WHERE titulo LIKE '%escandalo%';
-- buscar por fraccion de texto con terminacion roja, con inicio es poner roja%
SELECT *
FROM posts
WHERE titulo LIKE '%roja';

-- filtro por fechas
SELECT *
FROM posts
WHERE fecha_publicacion < '2025-01-01';

-- filtro entre fechas
SELECT *
FROM posts
WHERE fecha_publicacion BETWEEN '2023-01-01' AND '2025-12-31';
-- filtro entre id
SELECT *
FROM posts
WHERE id BETWEEN 50 AND 60;

-- filtrar tomando solo el year

SELECT *
FROM posts
WHERE YEAR(fecha_publicacion) BETWEEN '2023' AND '2024';
-- filtrar tomando solo el mes

SELECT *
FROM posts
WHERE MONTH(fecha_publicacion)='04';

