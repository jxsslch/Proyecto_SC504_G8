

function populateModalFields(id, espec, cirugia, cedPaciente) {
    const idInput = document.getElementById("idTratamiento");
    const especInput = document.getElementById("especialista");
    const cirugiaInput = document.getElementById("cirugia");
    const cedPacienteBtn = document.getElementById("btn-cedPaciente");
    console.log(espec);
    idInput.value = id;
    especInput.value = espec;
    cirugiaInput.value = cirugia;
    cedPacienteBtn.value = cedPaciente;
}

function deleteModalField(cedPaciente){
    const cedulaHiddenInput = document.getElementById("hiddenCedula");
    
    console.log(cedPaciente);
    cedulaHiddenInput.value = cedPaciente;
}

