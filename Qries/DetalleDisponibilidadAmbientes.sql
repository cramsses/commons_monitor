SELECT 
	amb.NOMBREAMBIENTE as NOMBRE,
    amb.DISPONIBILIDAD_REQ,
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL	
FROM mont_operacion op
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR
INNER JOIN monc_ambientes amb on amb.IDAMBIENTE=srv.IDAMBIENTE
INNER JOIN mona_url urls on srv.IDURL=urls.IDURL
group BY amb.NOMBREAMBIENTE
ORDER BY amb.IDAMBIENTE

/*
SELECT 
	amb.NOMBREAMBIENTE as NOMBRE,
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL,
	
FROM mont_operacion op
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR
INNER JOIN monc_ambientes amb on amb.IDAMBIENTE=srv.IDAMBIENTE
INNER JOIN mona_url urls on srv.IDURL=urls.IDURL
group BY amb.NOMBREAMBIENTE
ORDER BY amb.IDAMBIENTE

SELECT 
	amb.NOMBREAMBIENTE as NOMBRE,
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL,
	count(*) as totalOPS,
	SUM(case when op.IDESTATUS = 200 then 1 else 0 end) as OK, 
	SUM(case when op.IDESTATUS = 200 then 0 else 1 end) as KO 
FROM mont_operacion op
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR
INNER JOIN monc_ambientes amb on amb.IDAMBIENTE=srv.IDAMBIENTE
INNER JOIN mona_url urls on srv.IDURL=urls.IDURL
group BY amb.NOMBREAMBIENTE
ORDER BY amb.IDAMBIENTE

SELECT 
	amb.NOMBREAMBIENTE as NOMBRE, 
	srv.DESCRIPCIONSERVIDOR,
	urls.DIRECCION,
	count(*) as totalOPS,
	SUM(case when op.IDESTATUS = 200 then 1 else 0 end) as OK, 
	SUM(case when op.IDESTATUS = 200 then 0 else 1 end) as KO 
FROM mont_operacion op
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR
INNER JOIN monc_ambientes amb on amb.IDAMBIENTE=srv.IDAMBIENTE
INNER JOIN mona_url urls on srv.IDURL=urls.IDURL
group BY urls.DIRECCION
ORDER BY amb.NOMBREAMBIENTE


SELECT op.* ,srv.DESCRIPCIONSERVIDOR,urls.DIRECCION
FROM mont_operacion op
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR
INNER JOIN mona_url urls on srv.IDURL=urls.IDURL
ORDER BY urls.DIRECCION  DESC
*/