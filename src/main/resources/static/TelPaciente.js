

function populateModalFields(idTelPaciente, cedPaciente, numTelefono) {
    const idTelPacienteInput = document.getElementById("idTelPaciente");
    const cedulaInput = document.getElementById("btn-cedPaciente");
    const numTelefonoInput = document.getElementById("numTelefono");

    idTelPacienteInput.value = idTelPaciente;
    cedulaInput.value = cedPaciente;
    numTelefonoInput.value = numTelefono;
}

function deleteModalField(idHorario){
    const idHorarioHiddenInput = document.getElementById("hiddenidHorario");
    
    idHorarioHiddenInput.value = idHorario;
}

