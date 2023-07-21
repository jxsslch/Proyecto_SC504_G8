------------------------------------------------------------------------
-- Creación de tablas
------------------------------------------------------------------------

CREATE TABLE doctor (
    cedDoctor NUMBER(10) NOT NULL,
    puesto VARCHAR2(30) NOT NULL,
    nomDoctor VARCHAR2(30) NOT NULL,
    genero CHAR(1) NOT NULL,
    idHorario NUMBER(10) NOT NULL,
    CONSTRAINT pk_doctor PRIMARY KEY(cedDoctor)
);

CREATE TABLE telDoctor (
  idTelDoctor NUMBER(10) NOT NULL,
  cedDoctor NUMBER(10) NOT NULL,
  numTelefono NUMBER(10) NOT NULL,
  CONSTRAINT pk_telDoctor PRIMARY KEY (idTelDoctor),
  CONSTRAINT fk_telDoctor FOREIGN KEY (cedDoctor) REFERENCES doctor (cedDoctor)
);

CREATE TABLE horario (
  idHorario NUMBER(10) NOT NULL,
  dias VARCHAR2(25) NOT NULL,
  horas TIMESTAMP NOT NULL,
  CONSTRAINT pk_horario PRIMARY KEY (idHorario)
);

CREATE TABLE medicamento (
  idMedicamento NUMBER(10) NOT NULL,
  nomMedicamento VARCHAR2(30) NOT NULL,
  cantDisponible NUMBER(10) NOT NULL,
  fechaVencimiento DATE NOT NULL,
  CONSTRAINT pk_medicamento PRIMARY KEY (idMedicamento)
);

CREATE TABLE dosis (
  idDosis NUMBER(10) NOT NULL,
  racion VARCHAR2(30) NOT NULL,
  CONSTRAINT pk_dosis PRIMARY KEY (idDosis)
);

CREATE TABLE medicamento_dosis (
  idDosisMedicamento NUMBER(10) NOT NULL,
  idDosis NUMBER(10) NOT NULL,
  idMedicamento NUMBER(10) NOT NULL,
  CONSTRAINT pk_medicamento_dosis PRIMARY KEY (idDosisMedicamento),
  CONSTRAINT fk_medicamento_dosis_dosis FOREIGN KEY (idDosis) REFERENCES dosis (idDosis),
  CONSTRAINT fk_medicamento_dosis_medicamento FOREIGN KEY (idMedicamento) REFERENCES medicamento (idMedicamento)
);

CREATE TABLE paciente (
  cedPaciente NUMBER(10) NOT NULL,
  nomPaciente VARCHAR2(30) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  edad NUMBER(3) NOT NULL,
  genero CHAR(1) NOT NULL,
  CONSTRAINT pk_paciente PRIMARY KEY (cedPaciente)
);

CREATE TABLE nacionalidad (
  idNacionalidad NUMBER(10) NOT NULL,
  nacionalidad VARCHAR2(30) NOT NULL,
  CONSTRAINT pk_nacionalidad PRIMARY KEY (idNacionalidad)
);

CREATE TABLE paciente_nacionalidad (
  idPacienteNacionalidad NUMBER(10) NOT NULL,
  idNacionalidad NUMBER(10) NOT NULL,
  cedPaciente NUMBER(10) NOT NULL,
  CONSTRAINT pk_paciente_nacionalidad PRIMARY KEY (idPacienteNacionalidad),
  CONSTRAINT fk_paciente_nacionalidad_nacionalidad FOREIGN KEY (idNacionalidad) REFERENCES nacionalidad (idNacionalidad),
  CONSTRAINT fk_paciente_nacionalidad_paciente FOREIGN KEY (cedPaciente) REFERENCES paciente (cedPaciente)
);

CREATE TABLE telPaciente (
  idTelPaciente NUMBER(10) NOT NULL,
  cedPaciente NUMBER(10) NOT NULL,
  numTelefono NUMBER(10) NOT NULL,
  CONSTRAINT pk_telPaciente PRIMARY KEY (idTelPaciente),
  CONSTRAINT fk_telPaciente FOREIGN KEY (cedPaciente) REFERENCES paciente (cedPaciente)
);

CREATE TABLE citas (
  numCita NUMBER(10) NOT NULL,
  motivo VARCHAR2(30) NOT NULL,
  estado CHAR(1) NOT NULL,
  fecha DATE NOT NULL,
  hora TIMESTAMP NOT NULL,
  cedPaciente NUMBER(10) NOT NULL,
  CONSTRAINT pk_citas PRIMARY KEY (numCita)
);

CREATE TABLE citas_activas (
  idActivas NUMBER(10) NOT NULL,
  numCita NUMBER(10) NOT NULL,
  CONSTRAINT pk_citas_activas PRIMARY KEY (idActivas),
  CONSTRAINT fk_citas_activas_citas FOREIGN KEY (numCita) REFERENCES citas (numCita)
);

CREATE TABLE citas_canceladas (
  idCanceladas NUMBER(10) NOT NULL,
  numCita NUMBER(10) NOT NULL,
  CONSTRAINT pk_citas_canceladas PRIMARY KEY (idCanceladas),
  CONSTRAINT fk_citas_canceladas_citas FOREIGN KEY (numCita) REFERENCES citas (numCita)
);

CREATE TABLE citas_pasadas (
  idPasadas NUMBER(10) NOT NULL,
  numCita NUMBER(10) NOT NULL,
  CONSTRAINT pk_citas_pasadas PRIMARY KEY (idPasadas),
  CONSTRAINT fk_citas_pasadas_citas FOREIGN KEY (numCita) REFERENCES citas (numCita)
);

CREATE TABLE tratamiento (
  idTratamiento NUMBER(10) NOT NULL,
  visitaEspecialista VARCHAR2(100) NOT NULL,
  cirugia CHAR(1) NOT NULL,
  cedPaciente NUMBER(10) NOT NULL,
  CONSTRAINT pk_tratamiento PRIMARY KEY (idTratamiento),
  CONSTRAINT fk_tratamiento_paciente FOREIGN KEY (cedPaciente) REFERENCES paciente (cedPaciente)
);

CREATE TABLE tratamiento_dosis (
  idTratamientoDosis NUMBER(10) NOT NULL,
  idTratamiento NUMBER(10) NOT NULL,
  idDosis NUMBER(10) NOT NULL,
  CONSTRAINT pk_tratamiento_dosis PRIMARY KEY (idTratamientoDosis),
  CONSTRAINT fk_tratamiento_dosis_tratamiento FOREIGN KEY (idTratamiento) REFERENCES tratamiento (idTratamiento),
  CONSTRAINT fk_tratamiento_dosis_dosis FOREIGN KEY (idDosis) REFERENCES dosis (idDosis)
);

CREATE TABLE tratamiento_medicamento (
  idTratamientoMedicamento NUMBER(10) NOT NULL,
  idTratamiento NUMBER(10) NOT NULL,
  idMedicamento NUMBER(10) NOT NULL,
  CONSTRAINT pk_tratamiento_medicamento PRIMARY KEY (idTratamientoMedicamento),
  CONSTRAINT fk_tratamiento_medicamento_tratamiento FOREIGN KEY (idTratamiento) REFERENCES tratamiento (idTratamiento),
  CONSTRAINT fk_tratamiento_medicamento_medicamento FOREIGN KEY (idMedicamento) REFERENCES medicamento (idMedicamento)
);

CREATE TABLE expediente (
  idExpediente NUMBER(10) NOT NULL,
  cedDoctor NUMBER(10) NOT NULL,
  cedPaciente NUMBER(10) NOT NULL,
  numCita NUMBER(10) NOT NULL,
  CONSTRAINT pk_expediente PRIMARY KEY (idExpediente),
  CONSTRAINT fk_expediente_doctor FOREIGN KEY (cedDoctor) REFERENCES doctor (cedDoctor),
  CONSTRAINT fk_expediente_paciente FOREIGN KEY (cedPaciente) REFERENCES paciente (cedPaciente),
  CONSTRAINT fk_expediente_citas FOREIGN KEY (numCita) REFERENCES citas (numCita)
);

CREATE TABLE resultados (
  idResultado NUMBER(10) NOT NULL,
  dictamen VARCHAR2(200) NOT NULL,
  analisis VARCHAR2(50) NOT NULL,
  cedPaciente NUMBER(10) NOT NULL,
  cedDoctor NUMBER(10) NOT NULL,
  idExpediente NUMBER(10) NOT NULL,
  CONSTRAINT pk_resultados PRIMARY KEY (idResultado),
  CONSTRAINT fk_resultados_paciente FOREIGN KEY (cedPaciente) REFERENCES paciente (cedPaciente),
  CONSTRAINT fk_resultados_doctor FOREIGN KEY (cedDoctor) REFERENCES doctor (cedDoctor),
  CONSTRAINT fk_resultados_expediente FOREIGN KEY (idExpediente) REFERENCES expediente (idExpediente)
);

CREATE TABLE expediente_tratamiento (
  idExpTrat NUMBER(10) NOT NULL,
  idTratamiento NUMBER(10) NOT NULL,
  idExpediente NUMBER(10) NOT NULL,
  CONSTRAINT pk_expediente_tratamiento PRIMARY KEY (idExpTrat),
  CONSTRAINT fk_expediente_tratamiento_tratamiento FOREIGN KEY (idTratamiento) REFERENCES tratamiento (idTratamiento),
  CONSTRAINT fk_expediente_tratamiento_expediente FOREIGN KEY (idExpediente) REFERENCES expediente (idExpediente)
);

-------------------------------------------------------------------------
-- Procesos solicitados
-------------------------------------------------------------------------

-- 25 procedimientos almacenados
-- 15 cursores

-- 1. Utilizando un cursor crear un procedimiento que traiga los datos del doctor
-- Cursor 1

CREATE OR REPLACE PROCEDURE get_doctor_details AS
  p_cedDoctor doctor.cedDoctor%TYPE;
  p_puesto doctor.puesto%TYPE;
  p_nomDoctor doctor.nomDoctor%TYPE;
  p_genero doctor.genero%TYPE;
  p_idHorario doctor.idHorario%TYPE;

  CURSOR doctor_cursor IS
    SELECT cedDoctor, puesto, nomDoctor, genero, idHorario
    FROM doctor;
BEGIN
  OPEN doctor_cursor;
  LOOP
    FETCH doctor_cursor INTO p_cedDoctor, p_puesto, p_nomDoctor, p_genero, p_idHorario;
    EXIT WHEN doctor_cursor%NOTFOUND;
  END LOOP;
  CLOSE doctor_cursor;
END;

-- 2. Procedimiento almacenado que permite agregar doctores

CREATE OR REPLACE PROCEDURE insert_doctor(
    p_cedDoctor IN NUMBER,
    p_puesto IN VARCHAR2,
    p_nomDoctor IN VARCHAR2,
    p_genero IN CHAR,
    p_idHorario IN NUMBER,
    mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
    INSERT INTO doctor (cedDoctor, puesto, nomDoctor, genero, idHorario)
    VALUES (p_cedDoctor, p_puesto, p_nomDoctor, p_genero, p_idHorario);
    
    mensaje := 'El doctor fue incluido satisfactoriamente';
END;

-- 3. Procedimiento almacenado para actualizar el puesto de un doctor

CREATE OR REPLACE PROCEDURE update_doctor (
  p_cedDoctor IN doctor.cedDoctor%TYPE,
  p_puesto IN doctor.puesto%TYPE,
  p_idHorario IN doctor.idHorario%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM doctor
  WHERE cedDoctor = p_cedDoctor;

  IF validacion > 0 THEN
    UPDATE doctor
    SET puesto = p_puesto,
    idHorario = p_idHorario
    WHERE cedDoctor = p_cedDoctor;
    mensaje := 'El doctor fue modificado correctamente';
  ELSE
    mensaje := 'Lo sentimos, la cédula indicada no corresponde a ningún doctor registrado. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos del doctor. Vuelva a intentarlo.';
END;

-- 4. Procedimiento almacenado que permita eliminar a un doctor

CREATE OR REPLACE PROCEDURE delete_doctor (
  p_cedDoctor IN doctor.cedDoctor%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM doctor
  WHERE cedDoctor = p_cedDoctor;

  IF validacion > 0 THEN
    DELETE FROM doctor
    WHERE cedDoctor = p_cedDoctor;

    mensaje := 'El doctor fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, la cédula indicada no corresponde a ningún doctor registrado. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar al empleado. Intente de nuevo';
END;

-- 5. Utilizando un cursor crear un procedimiento que traiga la cédula de los doctores y los números de teléfono registrados
-- Cursor 2

CREATE OR REPLACE PROCEDURE get_telDoctor_details AS
  p_idTelDoctor telDoctor.idTelDoctor%TYPE;
  p_cedDoctor telDoctor.cedDoctor%TYPE;
  p_numTelefono telDoctor.numTelefono%TYPE;

  CURSOR telDoctor_cursor IS
    SELECT idTelDoctor,cedDoctor, numTelefono
    FROM telDoctor;
BEGIN
  OPEN telDoctor_cursor;
  LOOP
    FETCH telDoctor_cursor INTO p_idTelDoctor, p_cedDoctor, p_numTelefono;
    EXIT WHEN telDoctor_cursor%NOTFOUND;
  END LOOP;
  CLOSE telDoctor_cursor;
END;

-- 6. Procedimiento que permite insertar números de teléfono de los doctores

CREATE OR REPLACE PROCEDURE insert_telDoctor(
    p_idTelDoctor IN NUMBER,
    p_cedDoctor IN NUMBER,
    p_numTelefono IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO telDoctor (idTelDoctor, cedDoctor, numTelefono)
    VALUES (p_idTelDoctor, p_cedDoctor, p_numTelefono);
    
    mensaje := 'El número de teléfono del doctor fue incluido satisfactoriamente';
END;

-- 7. Procedimiento almacenado para actualizar un número de teléfono de un doctor

CREATE OR REPLACE PROCEDURE update_telDoctor (
  p_idTelDoctor IN telDoctor.idTelDoctor%TYPE,
  p_numTelefono IN telDoctor.numTelefono%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM telDoctor
  WHERE idTelDoctor = p_idTelDoctor;

  IF validacion > 0 THEN
    UPDATE telDoctor
    SET numTelefono = p_numTelefono
    WHERE idTelDoctor = p_idTelDoctor;
    mensaje := 'El número de teléfono fue modificado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún número de teléfono registrado. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos de teléfono. Vuelva a intentarlo.';
END;

-- 8. Procedimiento para eliminar un número de teléfono perteneciente a un doctor

CREATE OR REPLACE PROCEDURE delete_telDoctor(
  p_idTelDoctor IN telDoctor.idTelDoctor%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM telDoctor
  WHERE idTelDoctor = p_idTelDoctor;

  IF validacion > 0 THEN
    DELETE FROM telDoctor
    WHERE idTelDoctor = p_idTelDoctor;

    mensaje := 'El número de teléfono fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún número de teléfono registrado. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar el teléfono. Intente de nuevo';
END;

-- 9. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los horarios laborales
-- Cursor 3

CREATE OR REPLACE PROCEDURE get_horario_details AS
  p_idHorario horario.idHorario%TYPE;
  p_dias horario.dias%TYPE;
  p_horas horario.horas%TYPE;

  CURSOR horario_cursor IS
    SELECT idHorario, dias, horas
    FROM horario;
BEGIN
  OPEN horario_cursor;
  LOOP
    FETCH horario_cursor INTO p_idHorario, p_dias, p_horas;
    EXIT WHEN horario_cursor%NOTFOUND;
  END LOOP;
  CLOSE horario_cursor;
END;

-- 10. Procedimiento que permite insertar horarios nuevos

CREATE OR REPLACE PROCEDURE insert_horario(
    p_idHorario IN NUMBER,
    p_dias IN VARCHAR2,
    p_horas IN TIMESTAMP,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO horario (idHorario, dias, horas)
    VALUES (p_idHorario, p_dias, p_horas);
    
    mensaje := 'El horario digitado fue incluido satisfactoriamente';
END;

-- 11. Procedimiento almacenado para actualizar un horario

CREATE OR REPLACE PROCEDURE update_horario (
  p_idHorario IN horario.idHorario%TYPE,
  p_horas IN horario.horas%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM horario
  WHERE idHorario = p_idHorario;

  IF validacion > 0 THEN
    UPDATE horario
    SET horas = p_horas
    WHERE idHorario = p_idHorario;
    mensaje := 'El horario fue modificado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún horario registrado. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos de horario. Vuelva a intentarlo.';
END;

-- 12. Procedimiento para eliminar un horario

CREATE OR REPLACE PROCEDURE delete_horario(
  p_idHorario IN horario.idHorario%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM horario
  WHERE idHorario = p_idHorario;

  IF validacion > 0 THEN
    DELETE FROM horario
    WHERE idHorario = p_idHorario;

    mensaje := 'El horario fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún horario registrado. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar el horario. Intente de nuevo';
END;

-- 13. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los medicamentos
-- Cursor 4

CREATE OR REPLACE PROCEDURE get_medicamento_details AS
  p_idMedicamento medicamento.idMedicamento%TYPE;
  p_nomMedicamento medicamento.nomMedicamento%TYPE;
  p_cantDisponible medicamento.cantDisponible%TYPE;
  p_fechaVencimiento medicamento.fechaVencimiento%TYPE;

  CURSOR medicamento_cursor IS
    SELECT idMedicamento, nomMedicamento, cantDisponible, fechaVencimiento
    FROM medicamento;
BEGIN
  OPEN medicamento_cursor;
  LOOP
    FETCH medicamento_cursor INTO p_idMedicamento, p_nomMedicamento, p_cantDisponible, p_fechaVencimiento;
    EXIT WHEN medicamento_cursor%NOTFOUND;
  END LOOP;
  CLOSE medicamento_cursor;
END;

-- 14. Procedimiento que permite insertar medicamentos nuevos

CREATE OR REPLACE PROCEDURE insert_medicamento(
    p_idMedicamento IN NUMBER,
    p_nomMedicamento IN VARCHAR2,
    p_cantDisponible IN NUMBER,
    p_fechaVencimiento IN DATE,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO medicamento (idMedicamento, nomMedicamento, cantDisponible, fechaVencimiento)
    VALUES (p_idMedicamento, p_nomMedicamento, p_cantDisponible, p_fechaVencimiento);
    
    mensaje := 'El medicamento digitado fue incluido satisfactoriamente';
END;

-- 15. Procedimiento almacenado para actualizar un medicamento

CREATE OR REPLACE PROCEDURE update_medicamento (
  p_idMedicamento IN medicamento.idMedicamento%TYPE,
  p_cantDisponible IN medicamento.cantDisponible%TYPE,
  p_fechaVencimiento IN medicamento.fechaVencimiento%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM medicamento
  WHERE idMedicamento = p_idMedicamento;

  IF validacion > 0 THEN
    UPDATE medicamento
    SET cantDisponible = p_cantDisponible,
    fechaVencimiento = p_fechaVencimiento
    WHERE idMedicamento = p_idMedicamento;
    mensaje := 'El medicamento fue modificado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún medicamento registrado. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos del medicamento. Intente de nuevo';
END;

-- 16. Procedimiento almacenado para eliminar un medicamento

CREATE OR REPLACE PROCEDURE delete_medicamento(
  p_idMedicamento IN medicamento.idMedicamento%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM medicamento
  WHERE idMedicamento = p_idMedicamento;

  IF validacion > 0 THEN
    DELETE FROM medicamento
    WHERE idMedicamento = p_idMedicamento;

    mensaje := 'El medicamento fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún medicamento registrado. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar el medicamento. Intente de nuevo';
END;

-- 17. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de las dosis
-- Cursor 5

CREATE OR REPLACE PROCEDURE get_dosis_details AS
  p_idDosis dosis.idDosis%TYPE;
  p_racion dosis.racion%TYPE;

  CURSOR dosis_cursor IS
    SELECT idDosis, racion
    FROM dosis;
BEGIN
  OPEN dosis_cursor;
  LOOP
    FETCH dosis_cursor INTO p_idDosis, p_racion;
    EXIT WHEN dosis_cursor%NOTFOUND;
  END LOOP;
  CLOSE dosis_cursor;
END;

-- 18. Procedimiento que permite insertar dosis nuevas

CREATE OR REPLACE PROCEDURE insert_dosis(
    p_idDosis IN NUMBER,
    p_racion IN VARCHAR2,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO dosis (idDosis, racion)
    VALUES (p_idDosis, p_racion);
    mensaje := 'La dosis digitada fue incluida satisfactoriamente';
END;

-- 19. Procedimiento almacenado para actualizar una dosis

CREATE OR REPLACE PROCEDURE update_dosis (
  p_idDosis IN dosis.idDosis%TYPE,
  p_racion IN dosis.racion%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM dosis
  WHERE idDosis = p_idDosis;

  IF validacion > 0 THEN
    UPDATE dosis
    SET racion = p_racion
    WHERE idDosis = p_idDosis;
    mensaje := 'La dosis fue modificada correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ninguna dosis registrada. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos de la dosis. Intente de nuevo';
END;

-- 20. Procedimiento almacenado para eliminar una dosis

CREATE OR REPLACE PROCEDURE delete_dosis(
  p_idDosis IN dosis.idDosis%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM dosis
  WHERE idDosis = p_idDosis;

  IF validacion > 0 THEN
    DELETE FROM dosis
    WHERE idDosis = p_idDosis;

    mensaje := 'La dosis fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ninguna dosis registrada. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar la dosis. Intente de nuevo';
END;

-- 21. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los pacientes
-- Cursor 6

CREATE OR REPLACE PROCEDURE get_paciente_details AS
  p_cedPaciente paciente.cedPaciente%TYPE;
  p_nomPaciente paciente.nomPaciente%TYPE;
  p_fechaNacimiento paciente.fechaNacimiento%TYPE;
  p_edad paciente.edad%TYPE;
  p_genero paciente.genero%TYPE;

  CURSOR paciente_cursor IS
    SELECT cedPaciente, nomPaciente, fechaNacimiento, edad, genero
    FROM paciente;
BEGIN
  OPEN paciente_cursor;
  LOOP
    FETCH paciente_cursor INTO p_cedPaciente, p_nomPaciente, p_fechaNacimiento, p_edad, p_genero;
    EXIT WHEN paciente_cursor%NOTFOUND;
  END LOOP;
  CLOSE paciente_cursor;
END;

-- 22. Procedimiento que permite insertar pacientes nuevos

CREATE OR REPLACE PROCEDURE insert_paciente(
    p_cedPaciente IN NUMBER,
    p_nomPaciente IN VARCHAR2,
    p_fechaNacimiento IN DATE,
    p_edad IN NUMBER,
    p_genero IN CHAR,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO paciente (cedPaciente, nomPaciente, fechaNacimiento, edad, genero)
    VALUES (p_cedPaciente, p_nomPaciente, p_fechaNacimiento, p_edad, p_genero);
    mensaje := 'El paciente digitado fue incluido satisfactoriamente';
END;

-- 23. Procedimiento almacenado para actualizar un paciente

CREATE OR REPLACE PROCEDURE update_paciente (
  p_cedPaciente IN paciente.cedPaciente%TYPE,
  p_edad IN paciente.edad%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM paciente
  WHERE cedPaciente = p_cedPaciente;

  IF validacion > 0 THEN
    UPDATE paciente
    SET edad = p_edad
    WHERE cedPaciente = p_cedPaciente;
    mensaje := 'El paciente fue modificado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún paciente registrado. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos del paciente. Intente de nuevo';
END;

-- 24. Procedimiento almacenado para eliminar un paciente

CREATE OR REPLACE PROCEDURE delete_paciente(
  p_cedPaciente IN paciente.cedPaciente%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM paciente
  WHERE cedPaciente = p_cedPaciente;

  IF validacion > 0 THEN
    DELETE FROM paciente
    WHERE cedPaciente = p_cedPaciente;

    mensaje := 'El paciente fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún paciente registrado. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar el paciente. Intente de nuevo';
END;

-- 25. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de las nacionalidades
-- Cursor 7

CREATE OR REPLACE PROCEDURE get_nacionalidad_details AS
  p_idNacionalidad nacionalidad.idNacionalidad%TYPE;
  p_nacionalidad nacionalidad.nacionalidad%TYPE;

  CURSOR nacionalidad_cursor IS
    SELECT idNacionalidad, nacionalidad
    FROM nacionalidad;
BEGIN
  OPEN nacionalidad_cursor;
  LOOP
    FETCH nacionalidad_cursor INTO p_idNacionalidad, p_nacionalidad;
    EXIT WHEN nacionalidad_cursor%NOTFOUND;
  END LOOP;
  CLOSE nacionalidad_cursor;
END;

-- 26. Procedimiento que permite insertar nacionalidades nuevas

CREATE OR REPLACE PROCEDURE insert_nacionalidad(
    p_idNacionalidad IN NUMBER,
    p_nacionalidad IN VARCHAR2,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO nacionalidad (idNacionalidad, nacionalidad)
    VALUES (p_idNacionalidad, p_nacionalidad);

    mensaje := 'La nacionalidad digitada fue incluida satisfactoriamente';
END;

-- 27. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los teléfonos de pacientes
-- Cursor 8

CREATE OR REPLACE PROCEDURE get_telPaciente_details AS
  p_idTelPaciente telPaciente.idTelPaciente%TYPE;
  p_cedPaciente telPaciente.cedPaciente%TYPE;
  p_numTelefono telPaciente.numTelefono%TYPE;

  CURSOR telPaciente_cursor IS
    SELECT idTelPaciente, cedPaciente, numTelefono
    FROM telPaciente;
BEGIN
  OPEN telPaciente_cursor;
  LOOP
    FETCH telPaciente_cursor INTO p_idTelPaciente, p_cedPaciente, p_numTelefono;
    EXIT WHEN telPaciente_cursor%NOTFOUND;
  END LOOP;
  CLOSE telPaciente_cursor;
END;

-- 28. Procedimiento que inserte números de teléfono de pacientes

CREATE OR REPLACE PROCEDURE insert_telPaciente(
    p_idTelPaciente IN NUMBER,
    p_cedPaciente IN NUMBER,
    p_numTelefono IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO telPaciente (idTelPaciente, cedPaciente, numTelefono)
    VALUES (p_idTelPaciente, p_cedPaciente, p_numTelefono);

    mensaje := 'El número de teléfono digitado fue incluido satisfactoriamente';
END;

-- 29. Procedimiento almacenado para actualizar un número de teléfono de un paciente

CREATE OR REPLACE PROCEDURE update_telPaciente (
  p_idTelPaciente IN telPaciente.idTelPaciente%TYPE,
  p_numTelefono IN telPaciente.numTelefono%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM telPaciente
  WHERE idTelPaciente = p_idTelPaciente;

  IF validacion > 0 THEN
    UPDATE telPaciente
    SET numTelefono = p_numTelefono
    WHERE idTelPaciente = p_idTelPaciente;
    mensaje := 'El número de teléfono fue modificado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún número de teléfono registrado. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos de teléfono. Vuelva a intentarlo.';
END;

-- 30. Procedimiento para eliminar un número de teléfono perteneciente a un paciente

CREATE OR REPLACE PROCEDURE delete_telPaciente(
  p_idTelPaciente IN telPaciente.idTelPaciente%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM telPaciente
  WHERE idTelPaciente = p_idTelPaciente;

  IF validacion > 0 THEN
    DELETE FROM telPaciente
    WHERE idTelPaciente = p_idTelPaciente;

    mensaje := 'El número de teléfono fue eliminado correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ningún número de teléfono registrado. Intente de nuevo';
  END IF;
  
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al eliminar el teléfono. Intente de nuevo';
END;

-- 31. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de citas
-- Cursor 9

CREATE OR REPLACE PROCEDURE get_citas_details AS
  p_numCita citas.numCita%TYPE;
  p_motivo citas.motivo%TYPE;
  p_estado citas.estado%TYPE;
  p_fecha citas.fecha%TYPE;
  p_hora citas.hora%TYPE;
  p_cedPaciente citas.cedPaciente%TYPE;

  CURSOR citas_cursor IS
    SELECT numCita, motivo, estado, fecha, hora, cedPaciente
    FROM citas;
BEGIN
  OPEN citas_cursor;
  LOOP
    FETCH citas_cursor INTO p_numCita, p_motivo, p_estado, p_fecha, p_hora, p_cedPaciente;
    EXIT WHEN citas_cursor%NOTFOUND;
  END LOOP;
  CLOSE citas_cursor;
END;

-- 32. Procedimiento que inserte citas

CREATE OR REPLACE PROCEDURE insert_citas(
    p_numCita IN NUMBER,
    p_motivo VARCHAR2,
    p_estado CHAR,
    p_fecha DATE,
    p_hora TIMESTAMP,
    p_cedPaciente IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO citas (numCita, motivo, estado, fecha, hora, cedPaciente)
    VALUES (p_numCita, p_motivo, p_estado, p_fecha, p_hora, p_cedPaciente);

    mensaje := 'La cita digitada fue incluida satisfactoriamente';
END;

-- 33. Procedimiento almacenado para actualizar una cita

CREATE OR REPLACE PROCEDURE update_citas (
  p_numCita IN citas.numCita%TYPE,
  p_motivo IN citas.motivo%TYPE,
  p_estado IN citas.estado%TYPE,
  p_fecha IN citas.fecha%TYPE,
  p_hora IN citas.hora%TYPE,
  p_cedPaciente IN citas.cedPaciente%TYPE,
  mensaje OUT VARCHAR2
) AS
  validacion NUMBER;
BEGIN
  SELECT COUNT(*) INTO validacion
  FROM citas
  WHERE numCita = p_numCita;

  IF validacion > 0 THEN
    UPDATE citas
    SET estado = p_estado
    WHERE numCita = p_numCita;
    mensaje := 'La cita fue modificada correctamente';
  ELSE
    mensaje := 'Lo sentimos, el ID indicado no corresponde a ninguna cita registrada. Intente de nuevo';
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    mensaje := 'Lo sentimos, ocurrió un error al actualizar los datos de cita. Vuelva a intentarlo.';
END;

-- 34. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los expedientes
-- Cursor 11

CREATE OR REPLACE PROCEDURE get_expediente_details AS
  p_idExpediente expediente.idExpediente%TYPE;
  p_cedDoctor expediente.cedDoctor%TYPE;
  p_cedPaciente expediente.cedPaciente%TYPE;
  p_numCita expediente.numCita%TYPE;

  CURSOR expediente_cursor IS
    SELECT idExpediente, cedDoctor, cedPaciente, numCita
    FROM expediente;
BEGIN
  OPEN expediente_cursor;
  LOOP
    FETCH expediente_cursor INTO p_idExpediente, p_cedDoctor, p_cedPaciente, p_numCita;
    EXIT WHEN expediente_cursor%NOTFOUND;
  END LOOP;
  CLOSE expediente_cursor;
END;

-- 35. Procedimiento que inserte expedientes

CREATE OR REPLACE PROCEDURE insert_expediente(
    p_idExpediente IN NUMBER,
    p_cedDoctor IN NUMBER,
    p_cedPaciente IN NUMBER,
    p_numCita IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO expediente (idExpediente, cedDoctor, cedPaciente, numCita)
    VALUES (p_idExpediente, p_cedDoctor, p_cedPaciente, p_numCita);

    mensaje := 'El expediente digitado fue incluido satisfactoriamente';
END;

-- 36. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los resultados
-- Cursor 12

CREATE OR REPLACE PROCEDURE get_resultados_details AS
  p_idResultado resultados.idResultado%TYPE;
  p_dictamen resultados.dictamen%TYPE;
  p_analisis resultados.analisis%TYPE;
  p_cedPaciente resultados.cedPaciente%TYPE;
  p_cedDoctor resultados.cedDoctor%TYPE;
  p_idExpediente resultados.idExpediente%TYPE;

  CURSOR resultados_cursor IS
    SELECT idResultado, dictamen, analisis, cedPaciente, cedDoctor, idExpediente
    FROM resultados;
BEGIN
  OPEN resultados_cursor;
  LOOP
    FETCH resultados_cursor INTO p_idResultado, p_dictamen, p_analisis, p_cedPaciente, p_cedDoctor, p_idExpediente;
    EXIT WHEN resultados_cursor%NOTFOUND;
  END LOOP;
  CLOSE resultados_cursor;
END;

-- 37. Procedimiento que inserte los resultados

CREATE OR REPLACE PROCEDURE insert_resultados(
    p_idResultado IN NUMBER,
    p_dictamen VARCHAR2,
    p_analisis IN VARCHAR2,
    p_cedPaciente IN NUMBER,
    p_cedDoctor IN NUMBER,
    p_idExpediente IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO resultados (idResultado, dictamen, analisis, cedPaciente, cedDoctor, idExpediente)
    VALUES (p_idResultado, p_dictamen, p_analisis, p_cedPaciente, p_cedDoctor, p_idExpediente);

    mensaje := 'Los resultados digitados fueron incluidos satisfactoriamente';
END;

-- 38. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los resultados
-- Cursor 13

CREATE OR REPLACE PROCEDURE get_resultados_details AS
  p_idResultado resultados.idResultado%TYPE;
  p_dictamen resultados.dictamen%TYPE;
  p_analisis resultados.analisis%TYPE;
  p_cedPaciente resultados.cedPaciente%TYPE;
  p_cedDoctor resultados.cedDoctor%TYPE;
  p_idExpediente resultados.idExpediente%TYPE;

  CURSOR resultados_cursor IS
    SELECT idResultado, dictamen, analisis, cedPaciente, cedDoctor, idExpediente
    FROM resultados;
BEGIN
  OPEN resultados_cursor;
  LOOP
    FETCH resultados_cursor INTO p_idResultado, p_dictamen, p_analisis, p_cedPaciente, p_cedDoctor, p_idExpediente;
    EXIT WHEN resultados_cursor%NOTFOUND;
  END LOOP;
  CLOSE resultados_cursor;
END;

-- 39. Procedimiento que inserte los resultados

CREATE OR REPLACE PROCEDURE insert_resultados(
    p_idResultado IN NUMBER,
    p_dictamen VARCHAR2,
    p_analisis IN VARCHAR2,
    p_cedPaciente IN NUMBER,
    p_cedDoctor IN NUMBER,
    p_idExpediente IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO resultados (idResultado, dictamen, analisis, cedPaciente, cedDoctor, idExpediente)
    VALUES (p_idResultado, p_dictamen, p_analisis, p_cedPaciente, p_cedDoctor, p_idExpediente);

    mensaje := 'Los resultados digitados fueron incluidos satisfactoriamente';
END;

-- 40. Utilizando un cursor crear un procedimiento que traiga los datos almacenados de los resultados
-- Cursor 14

CREATE OR REPLACE PROCEDURE get_resultados_details AS
  p_idResultado resultados.idResultado%TYPE;
  p_dictamen resultados.dictamen%TYPE;
  p_analisis resultados.analisis%TYPE;
  p_cedPaciente resultados.cedPaciente%TYPE;
  p_cedDoctor resultados.cedDoctor%TYPE;
  p_idExpediente resultados.idExpediente%TYPE;

  CURSOR resultados_cursor IS
    SELECT idResultado, dictamen, analisis, cedPaciente, cedDoctor, idExpediente
    FROM resultados;
BEGIN
  OPEN resultados_cursor;
  LOOP
    FETCH resultados_cursor INTO p_idResultado, p_dictamen, p_analisis, p_cedPaciente, p_cedDoctor, p_idExpediente;
    EXIT WHEN resultados_cursor%NOTFOUND;
  END LOOP;
  CLOSE resultados_cursor;
END;

-- 41. Procedimiento que inserte los resultados

CREATE OR REPLACE PROCEDURE insert_resultados(
    p_idResultado IN NUMBER,
    p_dictamen VARCHAR2,
    p_analisis IN VARCHAR2,
    p_cedPaciente IN NUMBER,
    p_cedDoctor IN NUMBER,
    p_idExpediente IN NUMBER,
    mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO resultados (idResultado, dictamen, analisis, cedPaciente, cedDoctor, idExpediente)
    VALUES (p_idResultado, p_dictamen, p_analisis, p_cedPaciente, p_cedDoctor, p_idExpediente);

    mensaje := 'Los resultados digitados fueron incluidos satisfactoriamente';
END;

-- 42. Procedimiento con cursor para obtener datos de doctores
-- Cursor 15

CREATE OR REPLACE PROCEDURE get_doctors (
   p_doctors OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_doctors FOR SELECT * FROM doctor;
END;

-- 43. Procedimiento con cursor para obtener datos de pacientes
-- Cursor 16

CREATE OR REPLACE PROCEDURE get_pacientes (
   p_pacientes OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_pacientes FOR SELECT * FROM paciente;
END;

-- 44. Procedimiento con cursor para obtener datos de tel doctor
-- Cursor 17

CREATE OR REPLACE PROCEDURE get_telDoctores (
   p_telDoctores OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_telDoctores FOR SELECT * FROM telDoctor;
END;

-- 45. Procedimiento con cursor para obtener datos de horarios
-- Cursor 18

CREATE OR REPLACE PROCEDURE get_horarios (
   p_horarios OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_horarios FOR SELECT * FROM horario;
END;

-- 46. Procedimiento con cursor para obtener datos de medicamentos
-- Cursor 19

CREATE OR REPLACE PROCEDURE get_medicamentos (
   p_medicamentos OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_medicamentos FOR SELECT * FROM medicamento;
END;

-- 47. Procedimiento con cursor para obtener datos de dosis
-- Cursor 20

CREATE OR REPLACE PROCEDURE get_dosis (
   p_dosis OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_dosis FOR SELECT * FROM dosis;
END;

-- 48. Procedimiento con cursor para obtener datos de nacionalidades
-- Cursor 21

CREATE OR REPLACE PROCEDURE get_nacionalidades (
   p_nacionalidades OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_nacionalidades FOR SELECT * FROM nacionalidad;
END;

-- 49. Procedimiento con cursor para obtener datos de tel pacientes
-- Cursor 22

CREATE OR REPLACE PROCEDURE get_telPacientes (
   p_telPacientes OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_telPacientes FOR SELECT * FROM telPaciente;
END;

-- 50. Procedimiento con cursor para obtener datos de citas
-- Cursor 23

CREATE OR REPLACE PROCEDURE get_citas (
   p_citas OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_citas FOR SELECT * FROM citas;
END;

-- 51. Procedimiento con cursor para obtener datos de tratamiento
-- Cursor 24

CREATE OR REPLACE PROCEDURE get_tratamientos (
   p_tratamientos OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_tratamientos FOR SELECT * FROM tratamiento;
END;

-- 52. Procedimiento con cursor para obtener datos de resultados
-- Cursor 25

CREATE OR REPLACE PROCEDURE get_resultados (
   p_resultados OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_resultados FOR SELECT * FROM resultados;
END;

-- 53. Procedimiento con cursor para obtener datos de expedientes
-- Cursor 26

CREATE OR REPLACE PROCEDURE get_expedientes (
   p_expedientes OUT SYS_REFCURSOR
)AS
BEGIN
  OPEN p_expedientes FOR SELECT * FROM expediente;
END;

----------------------------------------------------------------------

-- 10 vistas

-- 1. Vista de doctores con filtro por puesto

CREATE OR REPLACE VIEW doctor_view AS
SELECT cedDoctor, puesto, nomDoctor, genero, idHorario
FROM doctor
WHERE puesto = 'Cardiólogo';

-- 2. Vista de pacientes por rango de edad

CREATE OR REPLACE VIEW paciente_view AS
SELECT cedPaciente, nomPaciente, fechaNacimiento, edad, genero
FROM paciente
WHERE edad >= 18;

-- 3. Vista de horarios por rango de dias

CREATE OR REPLACE VIEW horario_view AS
SELECT idHorario, dias, horas
FROM horario
WHERE dias IN ('lunes', 'martes', 'miércoles', 'jueves', 'viernes');

-- 4. Vista de medicamentos que tengan una cantidad disponible menor a 5

CREATE OR REPLACE VIEW medicamento_view AS
SELECT idMedicamento, nomMedicamento, cantDisponible, fechaVencimiento
FROM medicamento
WHERE cantDisponible < 5;

-- 5. Vista de pacientes por filtro de nacionalidad

CREATE OR REPLACE VIEW nacionalidad_view AS
SELECT p.cedPaciente, p.nomPaciente, p.fechaNacimiento, p.edad, p.genero
FROM paciente p
JOIN paciente_nacionalidad pn ON p.cedPaciente = pn.cedPaciente
JOIN nacionalidad n ON pn.idNacionalidad = n.idNacionalidad
WHERE n.nacionalidad = 'Costarricense';

-- 6. Vista de tratamientos que requieran cirugia

CREATE OR REPLACE VIEW tratamiento_view AS
SELECT idTratamiento, visitaEspecialista, cirugia, cedPaciente
FROM tratamiento
WHERE cirugia = 'S';

-- 7. Vista de los doctores con sus datos de telefono y horario

CREATE OR REPLACE VIEW doctores_view AS
SELECT d.cedDoctor, d.puesto, d.nomDoctor, d.genero,
       h.dias, h.horas,
       td.numTelefono
FROM doctor d
LEFT JOIN horario h ON d.idHorario = h.idHorario
LEFT JOIN telDoctor td ON d.cedDoctor = td.cedDoctor;

-- 8. Vista que muestra los datos de cada paciente con su nacionalidad y numero de telefono

CREATE OR REPLACE VIEW pacientes_view AS
SELECT p.cedPaciente, p.nomPaciente, p.fechaNacimiento, p.edad, p.genero,
       n.nacionalidad,
       tp.numTelefono
FROM paciente p
LEFT JOIN paciente_nacionalidad pn ON p.cedPaciente = pn.cedPaciente
LEFT JOIN nacionalidad n ON pn.idNacionalidad = n.idNacionalidad
LEFT JOIN telPaciente tp ON p.cedPaciente = tp.cedPaciente;

-- 9. Vista que muestra los datos de cada expediente con sus debidos tratamientos

CREATE OR REPLACE VIEW expediente_view AS
SELECT e.idExpediente, e.cedDoctor, e.cedPaciente, e.numCita,
       t.idTratamiento, t.visitaEspecialista, t.cirugia
FROM expediente e
LEFT JOIN expediente_tratamiento et ON e.idExpediente = et.idExpediente
LEFT JOIN tratamiento t ON et.idTratamiento = t.idTratamiento;

-- 10. Vista de los doctores con filtro por género

CREATE OR REPLACE VIEW genero_view AS
SELECT cedDoctor, puesto, nomDoctor, genero, idHorario
FROM doctor
WHERE genero = 'M';

----------------------------------------------------------------------

-- 15 funciones

-- 1. Traer los datos de las tablas paciente y tel paciente que tengan un mismo número de cédula registrado

CREATE OR REPLACE TYPE paciente_tel_obj AS OBJECT (
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  fechaNacimiento DATE,
  edad NUMBER(3),
  genero CHAR(1),
  idTelPaciente NUMBER(10),
  numTelefono NUMBER(10)
);

CREATE OR REPLACE TYPE paciente_tel_tab AS TABLE OF paciente_tel_obj;

CREATE OR REPLACE FUNCTION get_paciente_telefonos
RETURN paciente_tel_tab PIPELINED
AS
BEGIN
  FOR paciente_rec IN (SELECT p.cedPaciente, p.nomPaciente, p.fechaNacimiento, p.edad, p.genero, t.idTelPaciente, t.numTelefono
                       FROM paciente p
                       JOIN telPaciente t ON p.cedPaciente = t.cedPaciente)
  LOOP
    PIPE ROW(paciente_tel_obj(paciente_rec.cedPaciente, paciente_rec.nomPaciente, 
                              paciente_rec.fechaNacimiento, paciente_rec.edad, 
                              paciente_rec.genero, paciente_rec.idTelPaciente, paciente_rec.numTelefono));
  END LOOP;
  RETURN;
END;

-- 2. Traer los datos de las tablas doctor y tel doctor que tengan un mismo número de cédula registrado

CREATE OR REPLACE TYPE doctor_tel_obj AS OBJECT (
  cedDoctor NUMBER(10),
  nomDoctor VARCHAR2(30),
  puesto VARCHAR2(30),
  genero CHAR(1),
  idTelDoctor NUMBER(10),
  numTelefono NUMBER(10)
);

CREATE OR REPLACE TYPE doctor_tel_tab AS TABLE OF doctor_tel_obj;

CREATE OR REPLACE FUNCTION get_doctor_telefonos
RETURN doctor_tel_tab PIPELINED
AS
BEGIN
  FOR doctor_rec IN (SELECT d.cedDoctor, d.nomDoctor, d.puesto, d.genero, t.idTelDoctor, t.numTelefono
                       FROM doctor d
                       JOIN telDoctor t ON d.cedDoctor = t.cedDoctor)
  LOOP
    PIPE ROW(doctor_tel_obj(doctor_rec.cedDoctor, doctor_rec.nomDoctor, 
                              doctor_rec.puesto, doctor_rec.genero, 
                              doctor_rec.idTelDoctor, doctor_rec.numTelefono));
  END LOOP;
  RETURN;
END;

-- 3. Traer los datos del doctor que atiende a un paciente según los datos del expediente del paciente

CREATE OR REPLACE TYPE doctor_paciente_obj AS OBJECT (
  cedDoctor NUMBER(10),
  puesto VARCHAR2(30),
  nomDoctor VARCHAR2(30),
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  fechaNacimiento DATE,
  edad NUMBER(3)
);

CREATE OR REPLACE TYPE doctor_paciente_tab AS TABLE OF doctor_paciente_obj;

CREATE OR REPLACE FUNCTION get_doctor_paciente(idExpediente_in NUMBER)
RETURN doctor_paciente_tab PIPELINED
AS
BEGIN
  FOR dp_rec IN (SELECT d.cedDoctor, d.puesto, d.nomDoctor,
                        p.cedPaciente, p.nomPaciente, p.fechaNacimiento, p.edad
                 FROM doctor d
                 JOIN expediente e ON d.cedDoctor = e.cedDoctor
                 JOIN paciente p ON e.cedPaciente = p.cedPaciente
                 WHERE e.idExpediente = idExpediente_in)
  LOOP
    PIPE ROW(doctor_paciente_obj(dp_rec.cedDoctor, dp_rec.puesto, dp_rec.nomDoctor,
                                 dp_rec.cedPaciente, dp_rec.nomPaciente, dp_rec.fechaNacimiento, dp_rec.edad));
  END LOOP;
  RETURN;
END;

-- 4. Traer las citas que se encuentran bajo la cédula de un paciente concreto

CREATE OR REPLACE TYPE paciente_cita_obj AS OBJECT (
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  edad NUMBER(3),
  genero CHAR(1),
  numCita NUMBER(10),
  motivo VARCHAR2(30),
  estado CHAR(1),
  fecha DATE,
  hora TIMESTAMP
);

CREATE OR REPLACE TYPE paciente_cita_tab AS TABLE OF paciente_cita_obj;

CREATE OR REPLACE FUNCTION get_paciente_citas(cedPaciente_in NUMBER)
RETURN paciente_cita_tab PIPELINED
AS
BEGIN
  FOR pc_rec IN (SELECT p.cedPaciente, p.nomPaciente, p.edad, p.genero,
                        c.numCita, c.motivo, c.estado, c.fecha, c.hora
                 FROM paciente p
                 JOIN citas c ON p.cedPaciente = c.cedPaciente
                 WHERE p.cedPaciente = cedPaciente_in)
  LOOP
    PIPE ROW(paciente_cita_obj(pc_rec.cedPaciente, pc_rec.nomPaciente,
                               pc_rec.edad, pc_rec.genero, pc_rec.numCita, pc_rec.motivo,
                               pc_rec.estado, pc_rec.fecha, pc_rec.hora));
  END LOOP;
  RETURN;
END;


-- 5. Traer las citas cuyo estado se encuentre activo y correspondan a un paciente concreto

CREATE OR REPLACE TYPE citas_ac_paciente_obj AS OBJECT (
  numCita NUMBER(10),
  motivo VARCHAR2(30),
  fecha DATE,
  hora TIMESTAMP,
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  edad NUMBER(3),
  genero CHAR(1)
);

CREATE OR REPLACE TYPE citas_ac_paciente_tab AS TABLE OF citas_ac_paciente_obj;

CREATE OR REPLACE FUNCTION get_citas_ac_paciente(cedPaciente_in NUMBER)
RETURN citas_ac_paciente_tab PIPELINED
AS
  CURSOR citas_cur IS
    SELECT c.numCita, c.motivo, c.fecha, c.hora,
           p.cedPaciente, p.nomPaciente, p.edad, p.genero
    FROM citas c
    JOIN paciente p ON c.cedPaciente = p.cedPaciente
    WHERE c.estado = 'A' AND c.cedPaciente = cedPaciente_in;
BEGIN
  FOR cp_rec IN citas_cur
  LOOP
    PIPE ROW(citas_ac_paciente_obj(cp_rec.numCita, cp_rec.motivo,
                                cp_rec.fecha, cp_rec.hora, cp_rec.cedPaciente,
                                cp_rec.nomPaciente, cp_rec.edad, cp_rec.genero));
  END LOOP;
  RETURN;
END;

-- 6. Traer las citas cuyo estado se encuentre cancelado y correspondan a un paciente concreto

CREATE OR REPLACE TYPE citas_can_paciente_obj AS OBJECT (
  numCita NUMBER(10),
  motivo VARCHAR2(30),
  fecha DATE,
  hora TIMESTAMP,
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  edad NUMBER(3),
  genero CHAR(1)
);

CREATE OR REPLACE TYPE citas_can_paciente_tab AS TABLE OF citas_can_paciente_obj;

CREATE OR REPLACE FUNCTION get_citas_can_paciente(cedPaciente_in NUMBER)
RETURN citas_can_paciente_tab PIPELINED
AS
  CURSOR citas_can_cur IS
    SELECT c.numCita, c.motivo, c.fecha, c.hora,
           p.cedPaciente, p.nomPaciente, p.edad, p.genero
    FROM citas c
    JOIN paciente p ON c.cedPaciente = p.cedPaciente
    WHERE c.estado = 'C' AND c.cedPaciente = cedPaciente_in;
BEGIN
  FOR cp_rec IN citas_can_cur
  LOOP
    PIPE ROW(citas_can_paciente_obj(cp_rec.numCita, cp_rec.motivo,
                                cp_rec.fecha, cp_rec.hora, cp_rec.cedPaciente,
                                cp_rec.nomPaciente, cp_rec.edad, cp_rec.genero));
  END LOOP;
  RETURN;
END;

-- 7. Traer las citas cuyo estado se encuentren pasadas y correspondan a un paciente concreto

CREATE OR REPLACE TYPE citas_pas_paciente_obj AS OBJECT (
  numCita NUMBER(10),
  motivo VARCHAR2(30),
  fecha DATE,
  hora TIMESTAMP,
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  edad NUMBER(3),
  genero CHAR(1)
);

CREATE OR REPLACE TYPE citas_pas_paciente_tab AS TABLE OF citas_pas_paciente_obj;

CREATE OR REPLACE FUNCTION get_citas_pas_paciente(cedPaciente_in NUMBER)
RETURN citas_pas_paciente_tab PIPELINED
AS
  CURSOR citas_pas_cur IS
    SELECT c.numCita, c.motivo, c.fecha, c.hora,
           p.cedPaciente, p.nomPaciente, p.edad, p.genero
    FROM citas c
    JOIN paciente p ON c.cedPaciente = p.cedPaciente
    WHERE c.estado = 'C' AND c.cedPaciente = cedPaciente_in;
BEGIN
  FOR cp_rec IN citas_pas_cur
  LOOP
    PIPE ROW(citas_pas_paciente_obj(cp_rec.numCita, cp_rec.motivo,
                                cp_rec.fecha, cp_rec.hora, cp_rec.cedPaciente,
                                cp_rec.nomPaciente, cp_rec.edad, cp_rec.genero));
  END LOOP;
  RETURN;
END;

-- 8. Traer los datos del paciente con sus nacionalidades registradas segun su cedula

CREATE OR REPLACE TYPE paciente_nacionalidad_obj AS OBJECT (
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  edad NUMBER(3),
  genero CHAR(1),
  idNacionalidad NUMBER(10),
  nacionalidad VARCHAR2(30)
);

CREATE OR REPLACE TYPE paciente_nacionalidad_tab AS TABLE OF paciente_nacionalidad_obj;

CREATE OR REPLACE FUNCTION get_paciente_nacionalidades(cedPaciente_in NUMBER)
RETURN paciente_nacionalidad_tab PIPELINED
AS
  CURSOR paciente_nacionalidad_cur IS
    SELECT p.cedPaciente, p.nomPaciente, p.edad, p.genero,
           n.idNacionalidad, n.nacionalidad
    FROM paciente p
    JOIN paciente_nacionalidad pn ON p.cedPaciente = pn.cedPaciente
    JOIN nacionalidad n ON pn.idNacionalidad = n.idNacionalidad
    WHERE p.cedPaciente = cedPaciente_in AND n.idNacionalidad = pn.idNacionalidad
    AND p.cedPaciente = pn.cedPaciente;
BEGIN
  FOR pn_rec IN paciente_nacionalidad_cur
  LOOP
    PIPE ROW(paciente_nacionalidad_obj(pn_rec.cedPaciente, pn_rec.nomPaciente,
                                       pn_rec.edad, pn_rec.genero, pn_rec.idNacionalidad,
                                       pn_rec.nacionalidad));
  END LOOP;
  RETURN;
END;

-- 9. Traer los datos de tratamiento y la dosis determinada segun el ID de tratamiento que se coloque

CREATE OR REPLACE TYPE tratamiento_dosis_obj AS OBJECT (
  idTratamiento NUMBER(10),
  visitaEspecialista VARCHAR2(100),
  cirugia CHAR(1),
  cedPaciente NUMBER(10),
  idDosis NUMBER(10),
  racion VARCHAR2(30)
);

CREATE OR REPLACE TYPE tratamiento_dosis_tab AS TABLE OF tratamiento_dosis_obj;

CREATE OR REPLACE FUNCTION get_tratamiento_dosis(idTratamiento_in NUMBER)
RETURN tratamiento_dosis_tab PIPELINED
AS
  CURSOR tratamiento_dosis_cur IS
    SELECT t.idTratamiento, t.visitaEspecialista, t.cirugia, t.cedPaciente,
           d.idDosis, d.racion
    FROM tratamiento t
    JOIN tratamiento_dosis td ON t.idTratamiento = td.idTratamiento
    JOIN dosis d ON td.idDosis = d.idDosis
    WHERE t.idTratamiento = idTratamiento_in AND d.idDosis = td.idDosis 
    AND t.idTratamiento = td.idTratamiento;
BEGIN
  FOR td_rec IN tratamiento_dosis_cur
  LOOP
    PIPE ROW(tratamiento_dosis_obj(td_rec.idTratamiento, td_rec.visitaEspecialista, td_rec.cirugia,
                                   td_rec.cedPaciente, td_rec.idDosis, td_rec.racion));
  END LOOP;
  RETURN;
END;

-- 10. Traer los datos de medicamentos y la dosis determinada segun el ID de medicamento que se coloque

CREATE OR REPLACE TYPE medicamento_dosis_obj AS OBJECT (
  idMedicamento NUMBER(10),
  nomMedicamento VARCHAR2(30),
  cantDisponible NUMBER(10),
  fechaVencimiento DATE,
  idDosis NUMBER(10),
  racion VARCHAR2(30)
);

CREATE OR REPLACE TYPE medicamento_dosis_tab AS TABLE OF medicamento_dosis_obj;

CREATE OR REPLACE FUNCTION get_medicamento_dosis(idMedicamento_in NUMBER)
RETURN medicamento_dosis_tab PIPELINED
AS
  CURSOR medicamento_dosis_cur IS
    SELECT m.idMedicamento, m.nomMedicamento, m.cantDisponible, m.fechaVencimiento,
           d.idDosis, d.racion
    FROM medicamento m
    JOIN medicamento_dosis md ON m.idMedicamento = md.idMedicamento
    JOIN dosis d ON md.idDosis = d.idDosis
    WHERE m.idMedicamento = idMedicamento_in AND d.idDosis = md.idDosis
    AND m.idMedicamento = md.idMedicamento;
BEGIN
  FOR md_rec IN medicamento_dosis_cur
  LOOP
    PIPE ROW(medicamento_dosis_obj(md_rec.idMedicamento, md_rec.nomMedicamento, md_rec.cantDisponible,
                                   md_rec.fechaVencimiento, md_rec.idDosis, md_rec.racion));
  END LOOP;
  RETURN;
END;

-- 11. Traer los datos del tratamiento y el medicamento determinada segun el ID de tratamiento que se coloque

CREATE OR REPLACE TYPE tratamiento_medicamento_obj AS OBJECT (
  idTratamiento NUMBER(10),
  visitaEspecialista VARCHAR2(100),
  cirugia CHAR(1),
  cedPaciente NUMBER(10),
  idMedicamento NUMBER(10),
  nomMedicamento VARCHAR2(30),
  cantDisponible NUMBER(10),
  fechaVencimiento DATE
);

CREATE OR REPLACE TYPE tratamiento_medicamento_tab AS TABLE OF tratamiento_medicamento_obj;

CREATE OR REPLACE FUNCTION get_tratamiento_medicamento(idTratamiento_in NUMBER)
RETURN tratamiento_medicamento_tab PIPELINED
AS
  CURSOR tratamiento_medicamento_cur IS
    SELECT t.idTratamiento, t.visitaEspecialista, t.cirugia, t.cedPaciente,
           m.idMedicamento, m.nomMedicamento, m.cantDisponible, m.fechaVencimiento
    FROM tratamiento t
    JOIN tratamiento_medicamento tm ON t.idTratamiento = tm.idTratamiento
    JOIN medicamento m ON tm.idMedicamento = m.idMedicamento
    WHERE t.idTratamiento = idTratamiento_in AND m.idMedicamento = tm.idMedicamento
    AND t.idTratamiento = tm.idTratamiento;
BEGIN
  FOR tm_rec IN tratamiento_medicamento_cur
  LOOP
    PIPE ROW(tratamiento_medicamento_obj(tm_rec.idTratamiento, tm_rec.visitaEspecialista, tm_rec.cirugia,
                                         tm_rec.cedPaciente, tm_rec.idMedicamento, tm_rec.nomMedicamento,
                                         tm_rec.cantDisponible, tm_rec.fechaVencimiento));
  END LOOP;
  RETURN;
END;

-- 12. Traer los datos de los pacientes junto a su expediente

CREATE OR REPLACE TYPE paciente_expediente_obj AS OBJECT (
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  fechaNacimiento DATE,
  edad NUMBER(3),
  genero CHAR(1),
  idExpediente NUMBER(10),
  cedDoctor NUMBER(10),
  numCita NUMBER(10)
);

CREATE OR REPLACE TYPE paciente_expediente_tab AS TABLE OF paciente_expediente_obj;

CREATE OR REPLACE FUNCTION get_paciente_expediente
RETURN paciente_expediente_tab PIPELINED
AS
BEGIN
  FOR pe_rec IN (SELECT p.cedPaciente, p.nomPaciente, p.fechaNacimiento, p.edad, p.genero,
                        e.idExpediente, e.cedDoctor, e.numCita
                 FROM paciente p
                 JOIN expediente e ON p.cedPaciente = e.cedPaciente)
  LOOP
    PIPE ROW(paciente_expediente_obj(pe_rec.cedPaciente, pe_rec.nomPaciente, pe_rec.fechaNacimiento,
                                     pe_rec.edad, pe_rec.genero, pe_rec.idExpediente,
                                     pe_rec.cedDoctor, pe_rec.numCita));
  END LOOP;
  RETURN;
END;

-- 13. Traer los datos de los pacientes y los resultados de las citas

CREATE OR REPLACE TYPE paciente_resultado_obj AS OBJECT (
  cedPaciente NUMBER(10),
  nomPaciente VARCHAR2(30),
  fechaNacimiento DATE,
  edad NUMBER(3),
  genero CHAR(1),
  idResultado NUMBER(10),
  dictamen VARCHAR2(200),
  analisis VARCHAR2(50),
  cedDoctor NUMBER(10),
  idExpediente NUMBER(10)
);

CREATE OR REPLACE TYPE paciente_resultado_tab AS TABLE OF paciente_resultado_obj;

CREATE OR REPLACE FUNCTION get_paciente_resultado
RETURN paciente_resultado_tab PIPELINED
AS
  CURSOR paciente_resultado_cur IS
    SELECT p.cedPaciente, p.nomPaciente, p.fechaNacimiento, p.edad, p.genero,
           r.idResultado, r.dictamen, r.analisis, r.cedDoctor, r.idExpediente
    FROM paciente p
    JOIN resultados r ON p.cedPaciente = r.cedPaciente;
BEGIN
  FOR pr_rec IN paciente_resultado_cur
  LOOP
    PIPE ROW(paciente_resultado_obj(pr_rec.cedPaciente, pr_rec.nomPaciente, pr_rec.fechaNacimiento,
                                    pr_rec.edad, pr_rec.genero, pr_rec.idResultado,
                                    pr_rec.dictamen, pr_rec.analisis, pr_rec.cedDoctor, pr_rec.idExpediente));
  END LOOP;
  RETURN;
END;

----------------------------------------------------------------------

-- 10 paquetes

-- 1. 


----------------------------------------------------------------------

-- 5 triggers

-- 1. Trigger para determinar si el doctor que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_doctor
BEFORE INSERT ON doctor
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    
    FROM doctor
    WHERE cedDoctor = :NEW.cedDoctor;
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un doctor con el mismo número de cédula.');
    END IF;
END;

-- 2. Trigger para determinar si el paciente que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_paciente
BEFORE INSERT ON paciente
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    
    FROM paciente
    WHERE cedPaciente = :NEW.cedPaciente;
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un paciente con el mismo número de cédula.');
    END IF;
END;

-- 3. Trigger para determinar si el telDoctor que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_telDoctor
BEFORE INSERT ON telDoctor
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    
    FROM telDoctor
    WHERE idTelDoctor = :NEW.idTelDoctor;
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un teléfono con dicho ID');
    END IF;
END;

-- 4. Trigger para determinar si el horario que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_horario
BEFORE INSERT ON horario
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM horario
    WHERE idHorario = :NEW.idHorario;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un horario con dicho ID');
    END IF;
END;

-- 5. Trigger para determinar si el medicamento que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_medicamento
BEFORE INSERT ON medicamento
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM medicamento
    WHERE idMedicamento = :NEW.idMedicamento;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un medicamento con dicho ID');
    END IF;
END;

-- 6. Trigger para determinar si la dosis que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_dosis
BEFORE INSERT ON dosis
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM dosis
    WHERE idDosis = :NEW.idDosis;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe una dosis con dicho ID');
    END IF;
END;

-- 7. Trigger para determinar si la nacionalidad que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_nacionalidad
BEFORE INSERT ON nacionalidad
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM nacionalidad
    WHERE idNacionalidad = :NEW.idNacionalidad;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe una nacionalidad con dicho ID');
    END IF;
END;

-- 8. Trigger para determinar si el telefono de paciente que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_telPaciente
BEFORE INSERT ON telPaciente
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM telPaciente
    WHERE idTelPaciente = :NEW.idTelPaciente;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un teléfono de paciente con dicho ID');
    END IF;
END;

-- 9. Trigger para determinar si la cita que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_citas
BEFORE INSERT ON citas
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM citas
    WHERE numCita = :NEW.numCita;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe una cita con dicho ID');
    END IF;
END;

-- 10. Trigger para determinar si el tratamiento que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_tratamiento
BEFORE INSERT ON tratamiento
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM tratamiento
    WHERE idTratamiento = :NEW.idTratamiento;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un tratamiento con dicho ID');
    END IF;
END;

-- 11. Trigger para determinar si los resultados que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_resultados
BEFORE INSERT ON resultados
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM resultados
    WHERE idResultado = :NEW.idResultado;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un tratamiento con dicho ID');
    END IF;
END;

-- 12. Trigger para determinar si el expediente que se quiere insertar a la tabla ya existe

CREATE OR REPLACE TRIGGER before_insert_expediente
BEFORE INSERT ON expediente
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM expediente
    WHERE idExpediente = :NEW.idExpediente;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Lo sentimos, ya existe un expediente con dicho ID');
    END IF;
END;
