
/*MySql query para tiempos de respuesta*/ 
SELECT
    ambi.`NOMBREAMBIENTE` as 'NOMBREAMBIENTE', 
	DATE_FORMAT(`FECHA`, '%H') as 'HORA',
	COUNT(*) as 'COUNT'
FROM
    `mont_operacion` oper
INNER JOIN `mona_servidores` serv  ON oper.`IDSERVIDOR`=serv.`IDSERVIDOR`
INNER JOIN `monc_ambientes` ambi  ON serv.`IDAMBIENTE`=ambi.`IDAMBIENTE`
WHERE
    DATE(`FECHA`) = CURRENT_DATE()
	AND oper.`IDESTATUS` != 200
GROUP BY ambi.`IDAMBIENTE`,HORA