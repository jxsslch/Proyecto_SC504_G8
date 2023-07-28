

function populateModalFields(ceddoctor, puesto, nomdoctor, genero, dias) {
    const cedulaInput = document.getElementById("cedula");
    const puestoInput = document.getElementById("puesto");
    const nombreInput = document.getElementById("nombre");
    const generoButton = document.getElementById("btn-genero");
    const diasButton = document.getElementById("btn-dias");

    console.log(dias);
    cedulaInput.value = ceddoctor;
    puestoInput.value = puesto;
    nombreInput.value = nomdoctor;
    generoButton.value = genero;
    diasButton.value = dias;
}

function deleteModalField(ceddoctor){
    const cedulaHiddenInput = document.getElementById("hiddenCedula");
    
    console.log(ceddoctor);
    cedulaHiddenInput.value = ceddoctor;
}

