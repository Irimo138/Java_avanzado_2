window.onload = iniciar();

function iniciar() {
	llamadaAPI();
}

function printar(data) {
	console.log(data);
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
	xhttp.open("GET", "https://pokeapi.co/api/v2/pokemon?offset=0&limit=20", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	// Si quisieramos mandar parámetros a nuestra API, podríamos hacerlo desde el método send()
	xhttp.send();
}