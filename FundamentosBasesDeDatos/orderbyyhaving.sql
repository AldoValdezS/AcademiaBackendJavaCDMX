-- orden ascendente 1-2-3 por defecto es ascendente
SELECT *
FROM posts
ORDER BY fecha_publicacion ASC;
-- Orden descendente 3-2-1
SELECT *
FROM posts
ORDER BY fecha_publicacion DESC;

-- al ser letras se ordenan en orden alfabetico
SELECT *
FROM posts
ORDER BY titulo DESC;

SELECT *
FROM posts
ORDER BY usuario_id DESC;

-- limit limita la cantidad de registros
SELECT *
FROM posts
ORDER BY fecha_publicacion ASC
LIMIT 5;

-- HAVING, where da error si se trabaja con grupos, having hace lo mismo que where, pero este puede trabajar con groups

SELECT MONTHNAME(fecha_publicacion) AS post_month, estatus, COUNT(*) AS post_quantity
FROM posts
GROUP BY estatus, post_month
HAVING post_quantity >2
ORDER BY post_month;

