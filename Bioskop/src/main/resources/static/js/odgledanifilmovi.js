$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/rezervacije/odgledaniFilmovi",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            for( i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['naziv'] +"</td>";
                red += "<td align='center'>"+ response[i]['ocena'] +"</td>";
                red += "<td align='center'>"+ response[i]['opis'] +"</td>";
                red += "<td align='center'>"+ response[i]['zanr'] +"</td>";
                red += "<td align='center'>"+ response[i]['trajanje'] +"</td>";

                $('#pod tbody').append(red);
            }
        },
        error: function (response) {
            console.log(response);
        }
    });
});