# Proyecto_SC504_G8
Proyecto final para Lenguaje de Base de Datos

##Procedimientos almacenados:

PROCEDURE get_doctor_details ###Listo###

PROCEDURE insert_doctor

PROCEDURE update_doctor ###Listo!!!###

PROCEDURE delete_doctor

PROCEDURE get_telDoctor_details

PROCEDURE insert_telDoctor

PROCEDURE update_telDoctor

PROCEDURE delete_telDoctor

PROCEDURE get_horario_details

PROCEDURE insert_horario

PROCEDURE update_horario

PROCEDURE delete_horario

PROCEDURE get_medicamento_details

PROCEDURE insert_medicamento

PROCEDURE update_medicamento

PROCEDURE delete_medicamento

PROCEDURE get_dosis_details

PROCEDURE insert_dosis

PROCEDURE update_dosis

PROCEDURE delete_dosis

PROCEDURE get_paciente_details

PROCEDURE insert_paciente

PROCEDURE update_paciente

PROCEDURE delete_paciente

PROCEDURE get_nacionalidad_details


##Vistas:

VIEW doctor_view

VIEW telDoctor_view

VIEW horario_view

VIEW medicamento_view

VIEW dosis_view

VIEW paciente_view

VIEW nacionalidad_view

VIEW telPaciente_view

VIEW citas_view

VIEW tratamiento_view


##Funciones:

FUNCTION calculate_age

FUNCTION get_doctor_pacientes

FUNCTION get_paciente_citas

FUNCTION get_citas_activas

FUNCTION get_citas_canceladas

FUNCTION get_paciente_nacionalidades

FUNCTION get_paciente_telefonos

FUNCTION get_tratamiento_dosis

FUNCTION get_tratamiento_medicamentos

FUNCTION get_resultados_by_paciente


##Paquetes:

PACKAGE doctor_package

PACKAGE telDoctor_package

PACKAGE horario_package

PACKAGE medicamento_package

PACKAGE dosis_package

PACKAGE paciente_package

PACKAGE nacionalidad_package

PACKAGE telPaciente_package

PACKAGE citas_package

PACKAGE tratamiento_package


##Triggers:

TRIGGER before_insert_doctor

TRIGGER before_update_doctor

TRIGGER before_delete_doctor

TRIGGER after_insert_paciente

TRIGGER after_delete_paciente


##Cursores:

CURSOR doctor_cursor

CURSOR telDoctor_cursor

CURSOR horario_cursor

CURSOR medicamento_cursor

CURSOR dosis_cursor

CURSOR paciente_cursor

CURSOR nacionalidad_cursor

CURSOR telPaciente_cursor

CURSOR citas_cursor

CURSOR tratamiento_cursor

CURSOR expediente_cursor

CURSOR tratamiento_dosis_cursor

CURSOR tratamiento_medicamento_cursor

CURSOR resultados_cursor

CURSOR expediente_tratamiento_cursor
