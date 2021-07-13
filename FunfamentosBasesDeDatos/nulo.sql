-- is null
SELECT *
FROM posts
WHERE categoria_id IS NULL;

-- is not null
SELECT *
FROM posts
WHERE usuario_id IS NOT NULL;

-- is not null con where
SELECT *
FROM posts
WHERE usuario_id IS NOT NULL
	AND estatus ='activo'
    AND id<50 
    AND categoria_id =2
    AND YEAR(fecha_publicacion)=2025;