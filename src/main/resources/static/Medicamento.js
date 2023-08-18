    function populateModalFields(id, nom, cantDis,fecha ) {
    const idInput = document.getElementById("idMedicamento");
    const nomInput = document.getElementById("nomMedicamento");
    const cantDisInput = document.getElementById("cantDisponible");
    const fechaInput = document.getElementById("date");
    
    idInput.value = id;
    nomInput.value = nom;
    cantDisInput.value = cantDis;
    fechaInput.value = fecha;
}

function deleteModalField(cedPaciente){
    const cedulaHiddenInput = document.getElementById("hiddenCedula");
    
    console.log(cedPaciente);
    cedulaHiddenInput.value = cedPaciente;
}

