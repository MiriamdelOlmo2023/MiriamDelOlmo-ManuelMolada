document.addEventListener('DOMContentLoaded', function () { 
    const menuHamburguesa = document.getElementById('menuHamburguesa');
    const nav = document.querySelector('nav');  
    menuHamburguesa.addEventListener('click', function () {
        nav.classList.toggle('mostrar');
        menuHamburguesa.classList.toggle('transicion')    
    });  
});