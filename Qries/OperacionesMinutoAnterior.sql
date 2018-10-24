/* MySQL */
SELECT op.*
FROM mont_operacion op 
WHERE op.fecha 
between (date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) 
AND 	(date_format(current_timestamp(), '%Y-%m-%d %H:%i:59') - INTERVAL 1 MINUTE)


/*

SELECT op.*,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) as inicio,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:59') - INTERVAL 1 MINUTE) as fin
FROM mont_operacion op 
WHERE op.fecha 
between (date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) 
AND 	(date_format(current_timestamp(), '%Y-%m-%d %H:%i:59') - INTERVAL 1 MINUTE)

SELECT op.*,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) as inicio,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:59') - INTERVAL 1 MINUTE) as fin
FROM mont_operacion op


SELECT op.*,
date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') as minuto_actual,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) as minuto_anterior
FROM mont_operacion op 
WHERE op.fecha between (date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) 
AND (date_format(current_timestamp(), '%Y-%m-%d %H:%i:59') - INTERVAL 1 MINUTE)


SELECT op.*,
date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') as minuto_actual,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) as minuto_anterior
 
FROM mont_operacion op 
WHERE op.fecha between minuto_anterior and minuto_actual


SELECT 
date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') as minutoactual,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) as ,
 op.*
FROM `mont_operacion` op WHERE 1


SELECT now() as 'HORA', 
(now() - INTERVAL 1 MINUTE) as 'HORA2',
date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') as ts_zero_seconds,
(date_format(current_timestamp(), '%Y-%m-%d %H:%i:00') - INTERVAL 1 MINUTE) as ts_zero_seconds_less1minute,
 op.*
FROM `mont_operacion` op WHERE 1

*/