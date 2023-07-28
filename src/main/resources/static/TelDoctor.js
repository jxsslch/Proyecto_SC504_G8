

function populateModalFields(idHorario, dias, horas) {
    const idHorarioInput = document.getElementById("idHorario");
    const diasInput = document.getElementById("dias");
    const horasInput = document.getElementById("horas");

    idHorarioInput.value = idHorario;
    diasInput.value = dias;
    horasInput.value = horas;
}

function deleteModalField(idHorario){
    const idHorarioHiddenInput = document.getElementById("hiddenidHorario");
    
    idHorarioHiddenInput.value = idHorario;
}

