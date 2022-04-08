-- 1	
DELIMITER //

CREATE PROCEDURE obtenerTodo()
BEGIN
SELECT * FROM clientes, productos;
END //

DELIMITER ;
  
CALL obtenerTodo();

-- 2
DELIMITER //
CREATE PROCEDURE obtenerDatosEmpleado(IN i INT)
BEGIN
SELECT * FROM empleados WHERE i = nroEmpleado;
END //

DELIMITER ;

CALL obtenerDatosEmpleado(35);

-- 3
DELIMITER //

CREATE PROCEDURE CountOrderByStatus()
BEGIN
   SELECT * FROM clientes WHERE id > 2 AND id_Clientes IN (SELECT id_cliente FROM pedidos);	
   
END //

DELIMITER ;