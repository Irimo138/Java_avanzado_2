window.onload = inicio

function inicio(){
    document.querySelector("#cambio").addEventListener("click", cambiarLocalStorage);
    //document.querySelector
    cambioColor();
}

function cambiarLocalStorage(){
	if(localStorage.getItem("fondo") != "claro"){
        localStorage.setItem("fondo","claro");
        cambioColor()
    }else{
        localStorage.setItem("fondo","oscuro");
        cambioColor()
    }
}

function cambioColor() {
    if(localStorage.getItem("fondo") != "claro"){
        document.querySelector("#cambio").textContent="Modo Oscuro";
        document.querySelector("#content").classList.remove("oscuro");
        document.querySelector("#content").classList.add("claro");
    }else{
        document.querySelector("#cambio").textContent="Modo Claro";
        document.querySelector("#content").classList.remove("claro");
        document.querySelector("#content").classList.add("oscuro");
    }
    console.log(localStorage.getItem("fondo"));
}