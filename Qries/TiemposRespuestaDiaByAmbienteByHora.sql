/*MySql query para tiempos de respuesta*/ 
SELECT
    ambi.`NOMBREAMBIENTE` as 'NOMBREAMBIENTE', 
	DATE_FORMAT(`FECHA`, '%H') as 'HORA',
	AVG(oper.`TIEMPORESPUESTA`) as 'AVG'
FROM
    `mont_operacion` oper
INNER JOIN `mona_servidores` serv  ON oper.`IDSERVIDOR`=serv.`IDSERVIDOR`
INNER JOIN `monc_ambientes` ambi  ON serv.`IDAMBIENTE`=ambi.`IDAMBIENTE`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()--Oracle CURRENT_DATE sin parentesis
GROUP BY ambi.`IDAMBIENTE`,HORA


/*Oracle query para tiempos de respuesta*/ 
/*TODO Test*/
SELECT
    ambi.`NOMBREAMBIENTE` as 'NOMBREAMBIENTE', 
	TO_CHAR(`FECHA`, 'HH24') as 'HORA',
	AVG(oper.`TIEMPORESPUESTA`) as 'AVG'
FROM
    `mont_operacion` oper
INNER JOIN `mona_servidores` serv  ON oper.`IDSERVIDOR`=serv.`IDSERVIDOR`
INNER JOIN `monc_ambientes` ambi  ON serv.`IDAMBIENTE`=ambi.`IDAMBIENTE`
WHERE
    DATE(`FECHA`) = CURRENT_DATE--Oracle CURRENT_DATE sin parentesis
GROUP BY ambi.`IDAMBIENTE`,HORA

/*MySql
SELECT
    *
FROM
    `mont_operacion`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()
	

	
SELECT
    `mont_operacion`.*, DATE_FORMAT(`FECHA`, '%H') as 'HORA'
FROM
    `mont_operacion`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()


SELECT
    serv.`DESCRIPCIONSERVIDOR`,oper.*, DATE_FORMAT(`FECHA`, '%H') as 'HORA'
FROM
    `mont_operacion` oper
JOIN `mona_servidores` serv  ON oper.`IDSERVIDOR`=serv.`IDSERVIDOR`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()
	
	
SELECT
    ambi.`NOMBREAMBIENTE`serv.`DESCRIPCIONSERVIDOR`,oper.*, DATE_FORMAT(`FECHA`, '%H') as 'HORA'
FROM
    `mont_operacion` oper
JOIN `mona_servidores` serv  ON oper.`IDSERVIDOR`=serv.`IDSERVIDOR`
JOIN `monc_ambientes` ambi  ON serv.`IDAMBIENTE`=ambi.`IDAMBIENTE`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()
	
SELECT
    ambi.`NOMBREAMBIENTE`, 
	DATE_FORMAT(`FECHA`, '%H') as 'HORA',
	oper.`TIEMPORESPUESTA`
FROM
    `mont_operacion` oper
JOIN `mona_servidores` serv  ON oper.`IDSERVIDOR`=serv.`IDSERVIDOR`
JOIN `monc_ambientes` ambi  ON serv.`IDAMBIENTE`=ambi.`IDAMBIENTE`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()

*/
