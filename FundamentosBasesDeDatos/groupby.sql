SELECT estatus, COUNT(*) post_quantity
FROM posts
GROUP BY estatus;

SELECT YEAR(fecha_publicacion) AS post_year, COUNT(*) post_quantity
FROM posts
GROUP BY post_year;

SELECT estatus, MONTHNAME(fecha_publicacion) AS post_month, COUNT(*) post_quantity
FROM posts
GROUP BY estatus, post_month;