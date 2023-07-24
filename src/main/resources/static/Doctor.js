
document.addEventListener('DOMContentLoaded', function () {
    const navLinks = document.querySelectorAll('.nav-link');

    navLinks.forEach(function (link) {
        link.addEventListener('click', function (event) {
            event.preventDefault();

            if (!link.classList.contains('active')) {
                const activeLink = document.querySelector('.nav-link.active');
                activeLink.classList.remove('active');
                activeLink.classList.add('text-white');

                link.classList.add('active');
                link.classList.remove('text-white');
            }
        });
    });
});

function populateModalFields(ceddoctor, puesto, nomdoctor, genero, dias) {
    // Get the modal fields
    const cedulaInput = document.getElementById("cedula");
    const puestoInput = document.getElementById("puesto");
    const nombreInput = document.getElementById("nombre");
    const generoButton = document.getElementById("btn-genero");
    const diasButton = document.getElementById("btn-dias");

    // Populate the modal fields with the data from the selected row
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

