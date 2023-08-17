

function populateModalFields(id, doctor, paciente, cita) {
    const idInput = document.getElementById("idExpediente");
    const doctorInput = document.getElementById("btn-cedDoctor");
    const pacienteInput = document.getElementById("btn-cedPaciente");
    const citaButton = document.getElementById("btn-numCita");

    idInput.value = id;
    doctorInput.value = doctor;
    pacienteInput.value = paciente;
    citaButton.value = cita;
}

function deleteModalField(cedPaciente){
    const cedulaHiddenInput = document.getElementById("hiddenCedula");
    
    console.log(cedPaciente);
    cedulaHiddenInput.value = cedPaciente;
}

