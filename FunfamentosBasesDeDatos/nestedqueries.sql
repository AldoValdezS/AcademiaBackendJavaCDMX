-- la consulta anidada trae la primera publicacion de cada year con min
-- y la agrupa por year
-- Despues la consulta principal, cuenta las publicaciones de la tabla resultante
-- de la consulta anidada y agrupa y ordena por fecha 
SELECT new_table_projection.date, COUNT(*) AS post_count
FROM (
	SELECT DATE(MIN(fecha_publicacion))AS date, 
		YEAR(fecha_publicacion) AS post_year
	FROM posts
    GROUP BY post_year
) AS new_table_projection
GROUP BY new_table_projection.date
ORDER BY new_table_projection.date;

-- obtiene los posts con la fecha mas reciente (MAX)
SELECT * 
FROM posts
WHERE fecha_publicacion =(
	SELECT MAX(fecha_publicacion)
	FROM posts
);

