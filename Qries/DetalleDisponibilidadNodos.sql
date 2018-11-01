--Oracle
SELECT 
	nds.NOMNODO,
    nds.DISPONIBILIDAD_REQ,    
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL    
FROM mont_operacion op 
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR 
INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO 
group by nds.NOMNODO,nds.DISPONIBILIDAD_REQ;

--MYSQL
SELECT 
	nds.NOMNODO,
    nds.DISPONIBILIDAD_REQ,    
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(1) ) as DISPONIBILIDAD_REAL
    
FROM mont_operacion op 
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR 
INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO 
group by nds.NOMNODO

/*

SELECT op.* ,srv.DESCRIPCIONSERVIDOR,nds.NOMNODO
FROM mont_operacion op
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR
INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO
ORDER BY nds.NOMNODO  DESC

//Disponibilidad por nodo
SELECT 
	nds.NOMNODO,
	count(*) as totalOPS, 
	SUM(case when op.IDESTATUS = 200 then 1 else 0 end) as OK, 
	SUM(case when op.IDESTATUS = 200 then 0 else 1 end) as KO 
FROM mont_operacion op 
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR 
INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO 
group by nds.NOMNODO


SELECT 
	nds.NOMNODO,
    nds.DISPONIBILIDAD_REQ,    
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(*) ) as DISPONIBILIDAD_REAL,
    ((SUM(case when op.IDESTATUS = 200 then 0 else 1 end)*100) / count(*) ) as NO_DISPONIBILIDAD_REAL,
    count(*) as totalOPS, 
	SUM(case when op.IDESTATUS = 200 then 1 else 0 end) as OK, 
	SUM(case when op.IDESTATUS = 200 then 0 else 1 end) as KO 
FROM mont_operacion op 
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR 
INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO 
group by nds.NOMNODO

SELECT 
	nds.NOMNODO,
    nds.DISPONIBILIDAD_REQ,    
	((SUM(case when op.IDESTATUS = 200 then 1 else 0 end)*100) / count(*) ) as DISPONIBILIDAD_REAL
    
FROM mont_operacion op 
INNER JOIN mona_servidores srv ON op.IDSERVIDOR=srv.IDSERVIDOR 
INNER JOIN monc_nodos nds on srv.IDNODO=nds.IDNODO 
group by nds.NOMNODO

*/