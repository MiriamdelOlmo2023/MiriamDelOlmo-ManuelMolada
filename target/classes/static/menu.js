//EVENT LISTENERS
const ingresar = document.getElementById("comprar");
ingresar.addEventListener("click", function() {
    openModalIngresar();
});

const aceptarIngresar = document.getElementById("aceptarIngresar");
aceptarIngresar.addEventListener("click", function() {
    acceptIngresar();
});

const retirar = document.getElementById("retirar");
retirar.addEventListener("click", function() {
    openModalRetirar();
});

const aceptarRetirar = document.getElementById("aceptarRetirar");
aceptarRetirar.addEventListener("click", function() {
    acceptRetirar();
});


//Modal retirar
function openModalRetirar() {
    document.getElementById('modalRetirar').style.display = 'block';
    document.getElementById('modal-overlayRetirar').style.display = 'block';
    document.body.classList.add('modal-open'); // Agrega la clase al body
}

function closeModalRetirar() {
    document.getElementById('modalRetirar').style.display = 'none';
    document.getElementById('modal-overlayRetirar').style.display = 'none';
    document.body.classList.remove('modal-open'); // Remueve la clase al body
}

//Modal Ingresar
function openModalIngresar() {
    document.getElementById('modalIngresar').style.display = 'block';
    document.getElementById('modal-overlayIngresar').style.display = 'block';
    document.body.classList.add('modal-open'); // Agrega la clase al body
}

function closeModalIngresar() {
    document.getElementById('modalIngresar').style.display = 'none';
    document.getElementById('modal-overlayIngresar').style.display = 'none';
    document.body.classList.remove('modal-open'); // Remueve la clase al body
}


'use strict';

function acceptIngresar() {
    var fichas = document.getElementById("inputIngresarFichas").value;
    var fichasActuales = document.getElementById("fichas").innerHTML;

    if (!isNaN(fichas) && fichas !== "") {
        llamada(fichas, fichasActuales);
    } else {
        window.alert("Ingresa un número válido");
    }

    closeModalIngresar();
}

function acceptRetirar() {
    var fichas = document.getElementById("inputRetirarFichas").value;
    var fichasActuales = document.getElementById("fichas").innerHTML;

    if (!isNaN(fichas) && fichas !== "" && parseInt(fichas) <= parseInt(fichasActuales)) {
        llamada(-fichas, fichasActuales);
    } else {
        window.alert("Ingresa un número válido");
    }

    closeModalRetirar();
}

function llamada(fichas, fichasActuales) {
    $.ajax({
        type: "POST",
        url: "/llamadaFichas",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({ fichas: fichas }),
        success: function (data) {
            document.getElementById("fichas").innerHTML = parseInt(fichasActuales) + parseInt(fichas);
        },
        error: function (error) {
            console.log("Error en la llamada AJAX: ", error);
        }
    });
}
