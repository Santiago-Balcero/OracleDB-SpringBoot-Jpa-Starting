-- CREAR TABLA CLIENTE
CREATE TABLE cliente (
    id_cliente NUMBER(10) PRIMARY KEY,
    documento VARCHAR2(100) NOT NULL UNIQUE,
    nombres VARCHAR2(100) NOT NULL,
    apellidos VARCHAR2(100) NOT NULL,
    correo VARCHAR2(100) NOT NULL,
    ciudad VARCHAR2(100) NOT NULL,
    direccion VARCHAR2(250) NOT NULL,
    celular VARCHAR2(25) NOT NULL
);

-- Crear secuencia para campo autoincrement idmascota
CREATE SEQUENCE seq_idcliente --Nombre de secuencia
START WITH 1 --Valor de inicio
INCREMENT BY 1
NOMAXVALUE;

-- Crear disparador para automatizar el llamado a la secuencia
-- CREATE TRIGGER tr_seq_idcliente
--     BEFORE INSERT ON CLIENTE
--     FOR EACH ROW
--     BEGIN
--         SELECT seq_idcliente.nextval INTO :new.id_cliente FROM dual;
--     END;