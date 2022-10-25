window.onload = inicio

function inicio(){
    window.localStorage.setItem("fondo","claro");
    document.querySelector("#cambio").addEventListener("click", cambioColor);
    //document.querySelector
}

function cambioColor() {
    if(localStorage.getItem("fondo") != "claro"){
        localStorage.setItem("fondo","claro");
        document.querySelector("#cambio").textContent="Modo Oscuro";
        document.querySelector("#content").setAttribute("class", "claro");
    }else{
        localStorage.setItem("fondo","oscuro");
        document.querySelector("#cambio").textContent="Modo Claro";
        document.querySelector("#content").setAttribute("class", "oscuro");
    }
    console.log(localStorage.getItem("fondo"));
}