

function populateModalFields(numCita, motivo, estado, fecha, hora, cedPaciente) {
    const idInput = document.getElementById("numCita");
    const motInput = document.getElementById("motivo");
    const estadoInput = document.getElementById("btn-estado");
    const fechaInput = document.getElementById("fecha");
    const horaInput = document.getElementById("hora");
    const cedPacienteBtn = document.getElementById("btn-cedPaciente");
     
    idInput.value = numCita;
    motInput.value = motivo;
    estadoInput.value = estado;
    fechaInput.value = fecha;
    horaInput.value = hora;
    cedPacienteBtn.value = cedPaciente;
}

function deleteModalField(cedPaciente){
    const cedulaHiddenInput = document.getElementById("hiddenCedula");
    
    console.log(cedPaciente);
    cedulaHiddenInput.value = cedPaciente;
}

