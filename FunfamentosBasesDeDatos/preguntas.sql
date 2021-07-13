-- saber la cantidad de etiquetas por cada post
SELECT posts.titulo, COUNT(*) num_etiquetas
FROM posts 
	INNER JOIN posts_etiquetas ON posts.id = posts_etiquetas.post_id
    INNER JOIN etiquetas ON etiquetas.id = posts_etiquetas.etiqueta_id
GROUP BY posts.id
ORDER BY num_etiquetas DESC;

 -- ahora mostrando las etiquetas, group concat concatena las etiquetas en un solo campo
SELECT posts.titulo, GROUP_CONCAT(nombre_etiqueta)
FROM posts 
	INNER JOIN posts_etiquetas ON posts.id = posts_etiquetas.post_id
    INNER JOIN etiquetas ON etiquetas.id = posts_etiquetas.etiqueta_id
GROUP BY posts.id;

-- Post que no teienen etiquetas, se trabaja con la tabla
-- intermedia post_etiqueta.

SELECT *
FROM etiquetas
	LEFT JOIN posts_etiquetas ON etiquetas.id = posts_etiquetas.etiqueta_id
WHERE posts_etiquetas.etiqueta_id IS NULL;

-- Obtener categorias y ordenar de mayor a menor
SELECT c.nombre_categoria, COUNT(*) cantidad
FROM categorias AS c
	INNER JOIN posts AS p ON c.id = p.categoria_id
GROUP BY c.id
ORDER BY cantidad DESC
LIMIT 1;

-- Usuario que ha creado mas post
SELECT u.nickname, COUNT(*) cantidad
FROM usuarios AS u
	INNER JOIN posts AS p ON u.id = p.usuario_id
GROUP BY u.id
ORDER BY cantidad DESC;

-- Usuario que ha creado mas post y su categoria
SELECT u.nickname, COUNT(*) cantidad, GROUP_CONCAT(nombre_categoria)
FROM usuarios AS u
	INNER JOIN posts AS p ON u.id = p.usuario_id
    INNER JOIN categorias c ON p.categoria_id = c.id
GROUP BY u.id
ORDER BY cantidad DESC;

-- usuarios que no han escrito ningun post
SELECT *
FROM usuarios AS u
	LEFT JOIN posts AS p ON u.id = p.usuario_id
WHERE p.usuario_id IS NULL;



