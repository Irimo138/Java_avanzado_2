window.onload = iniciar();

function iniciar() {
	llamadaAPI();
	document.addEventListener("keydown", llamadaAPI);
}

function calcular(data) {
	var comp = document.getElementById("buscador").value;
	var cuerpo = document.getElementById("container");
	cuerpo.innerHTML="";
	for(let i = 0; i < data.length; i++){
		 var nom = data[i].nombre;
		if(nom.toUpperCase().includes(comp.toUpperCase())){
			var anadir = document.createElement("div");
			anadir.className="caja";
			var tit = document.createElement("h3");
			tit.textContent=nom;
			var partidas = document.createElement("h4");
			partidas.textContent="Partidas Jugadas: "+data[i].partidasJugadas;
			var max = document.createElement("h4");
			max.textContent="Puntuacion maxima: "+data[i].puntuacionMax;
			var editForm = document.createElement("form");
			editForm.method="GET";
			editForm.action="/editaJuego";
			var deleteForm = document.createElement("form");
			deleteForm.method="POST";
			deleteForm.action="/eliminaJuego";
			var submit = document.createElement("input");
			submit.type="submit"
			submit.value="Editar";
			var submit2 = document.createElement("input");
			submit2.type="submit"
			submit2.value="Eliminar";
			var hid = document.createElement("input");
			hid.type="hidden";
			hid.value=data[i].id;
			hid.name="idJuego";
			var hid2 = document.createElement("input");
			hid2.type="hidden";
			hid2.value=data[i].id;
			hid2.name="idJuego";
			editForm.appendChild(submit);
			editForm.appendChild(hid2);
			deleteForm.appendChild(submit2);
			deleteForm.appendChild(hid);
			var opciones = document.createElement("div");
			opciones.className="opciones";
			opciones.appendChild(editForm);
			opciones.appendChild(deleteForm);
			anadir.appendChild(tit);
			anadir.appendChild(partidas);
			anadir.appendChild(max);
			anadir.appendChild(opciones);
			cuerpo.appendChild(anadir);
		}
	}
}

function llamadaAPI() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		// Si nada da error
		if (this.readyState == 4 && this.status == 200) {
			// La respuesta, aunque sea JSON, viene en formato texto, por lo que tendremos que hace run parse
			//console.log(JSON.parse(this.responseText));
			calcular(JSON.parse(this.responseText));
		}
	};

	// Endpoint de la API y método que se va a usar para llamar
	xhttp.open("GET", "/api/obtenerJuegos", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	// Si quisieramos mandar parámetros a nuestra API, podríamos hacerlo desde el método send()
	xhttp.send();
}