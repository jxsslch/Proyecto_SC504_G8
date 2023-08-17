

function populateModalFields(cedPaciente, nombre, fecha, edad, genero) {
    const cedulaInput = document.getElementById("cedula");
    const nombreInput = document.getElementById("nombre");
    const fechaInput = document.getElementById("fecha");
    const generoButton = document.getElementById("btn-genero");
    const edadInput = document.getElementById("edad");

    cedulaInput.value = cedPaciente;
    nombreInput.value = nombre;
    fechaInput.value = fecha;
    edadInput.value = edad;
    generoButton.value = genero;
}

function deleteModalField(cedPaciente){
    const cedulaHiddenInput = document.getElementById("hiddenCedula");
    
    console.log(cedPaciente);
    cedulaHiddenInput.value = cedPaciente;
}

