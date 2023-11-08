/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {

    $("tr #btnDelete").click(function () {
        var idpod = $(this).parent().find("#idpod");

        eliminar(idpod);

    });
    function eliminar(idpod) {

        var url = "Controlador?menu=Abastecimiento&accion=Delete";
        $.ajax({

            type: 'POST',
            url: url,
            data: "idpod=" + idpod,
            success: function (data, textStatus, jqXHR) {
                alert("Registro eliminado");

            }

        })

    }
});
