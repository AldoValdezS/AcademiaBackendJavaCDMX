-- Trae los usuarios tengan o no posts
SELECT *
FROM usuarios
	LEFT JOIN posts ON usuarios.id =posts.usuario_id;
-- Trae los usuarios que no tienen posts
SELECT *
FROM usuarios
	LEFT JOIN posts ON usuarios.id =posts.usuario_id
    WHERE posts.usuario_id IS NULL;
    
-- Trae los usuarios que tienen posts asociados y todos los posts que tienen o no usuario
SELECT *
FROM usuarios
	RIGHT JOIN posts ON usuarios.id =posts.usuario_id
    WHERE posts.usuario_id IS NULL;
    
-- Trae los datos que tienen usuario y post
SELECT * 
FROM usuarios
	INNER JOIN posts ON usuarios.id=posts.usuario_id;

-- Unir ambas tablas, simular el OUTER JOIN
SELECT *
FROM usuarios
	LEFT JOIN posts ON usuarios.id = posts.usuario_id
UNION
SELECT *
FROM usuarios 
RIGHT JOIN posts ON usuarios.id = posts.usuario_id;

-- Unir ambas tablas, simular el contrario a innerJoin diferencia simetrica
SELECT *
FROM usuarios
	LEFT JOIN posts ON usuarios.id = posts.usuario_id
WHERE posts.usuario_id IS NULL
UNION
SELECT *
FROM usuarios 
RIGHT JOIN posts ON usuarios.id = posts.usuario_id
WHERE posts.usuario_id IS NULL;
