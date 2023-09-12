function seleccionarModificar() {
    var table = document.getElementById("mitabla");

    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            document.getElementById("idActualizar").value = this.cells[0].innerHTML;
            document.getElementById("nombresActualizar").value = this.cells[1].innerHTML;
            document.getElementById("apellidosActualizar").value = this.cells[2].innerHTML;
        };
    }
}

function seleccionarEliminar() {
    var table = document.getElementById("mitabla");

    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            document.getElementById("idEliminar").value = this.cells[0].innerHTML;
            document.getElementById("nombresEliminar").value = this.cells[1].innerHTML;
            document.getElementById("apellidosEliminar").value = this.cells[2].innerHTML;
        };
    }
}
