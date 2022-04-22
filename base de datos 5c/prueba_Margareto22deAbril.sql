create database veterinaria_si_no_vive_se_muere;
use veterinaria_si_no_vive_se_muere;


-- 1
select * from Mascotas group by edad;

-- 2
select * from Mascotas group by peso;

-- 3 
select COUNT(id_mascota) from Mascotas group by edad;

-- 4
select COUNT(id_mascota) from Mascotas group by peso;

-- 5
select sum(peso) from Mascotas where edad between 5 and 10;

-- 6
select avg(peso) from Mascotas;

-- 7
DELIMITER $$
CREATE PROCEDURE mascotasPorAmo(in id_amo int, out cantidadMascotas int)
BEGIN
	select count(id_mascota) into cantidadMascotas from Dueños where id_dueño = id_amo;
END$$

-- 8
 CREATE PROCEDURE mascotaGorda(in id_mascotaEjemplo int, out gorda varchar(255))
BEGIN
		DECLARE pesoMascota int;
		select peso into pesoMascota from Mascota where id_mascota = id_mascotaEjemplo; 
	IF (pesoMascota > 15) THEN
		SET gorda = "si";
	ELSE
		SET gorda = "no";
	END IF;
END$$

-- 9
CREATE PROCEDURE datosVeterinario(in id_veterinario int)
BEGIN
		select * from Veterinarios where id_vet = id_veterinario;
END$$

-- 10
CREATE PROCEDURE mascotasPeso(in pesoEjemplo int)
BEGIN
		select * from Mascota where peso >= pesoEjemplo;
END$$

DELIMITER ;

call mascotaPeso(6);