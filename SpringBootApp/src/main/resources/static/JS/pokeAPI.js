window.onload = iniciar();

var numero;
var dataPoke;
function iniciar() {
	setVariable();
	llamadaAPI();
}

function funciones(){
	document.getElementById("adelante").addEventListener("click", adelante);
}

function setVariable(){
	numero = 0;
}

function adelante(){
		numero +=20;
		llamadaAPI();
	
}

function atras(){
		numero -=20;
		llamadaAPI();
}

function printar(data) {
	var images = numero;
	var datos = data.results;
	console.log(datos[0]);
	cuerpo = document.getElementById("mostrar");
	cuerpo.innerHTML="";
	for(var i = 0; i <= 20; i++){
		var anadir = document.createElement("div");
		anadir.className="caja";
		var nombre = document.createElement("h2");
		nombre.textContent = datos[i].name;
		var imagen = document.createElement("img");
		imagen.src= "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+(images+1)+".png";
		images++;
		console.log(dataPoke);
		anadir.appendChild(nombre);
		anadir.appendChild(imagen);
		cuerpo.appendChild(anadir);
	}
}

function llamadaAPI() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		// Si nada da error
		if (this.readyState == 4 && this.status == 200) {
			// La respuesta, aunque sea JSON, viene en formato texto, por lo que tendremos que hace run parse
			//console.log(JSON.parse(this.responseText));
			printar(JSON.parse(this.responseText));
		}
	};

	// Endpoint de la API y método que se va a usar para llamar
	xhttp.open("GET", "https://pokeapi.co/api/v2/pokemon?offset="+numero+"&limit=21", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	// Si quisieramos mandar parámetros a nuestra API, podríamos hacerlo desde el método send()
	xhttp.send();
}
