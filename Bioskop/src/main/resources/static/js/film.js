$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/film/ucitaj",
        dataType: "json",
        success: function(response){
            console.log(response);
           //$('#pod tbody').html('');
            for(i = 0; i < response.length; i++){
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
$(document).on('change','#odabir', function () {
        console.log($('#odabir').val());
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/film/sortiraj/" + $('#odabir').val(),
        dataType: "json",
        success: function(response){
            console.log(response);
           $('#pod tbody').html('');
            for(i = 0; i < response.length; i++){
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
$(document).on('click', '#pretraga', function () {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/film/pretrazi",
        contentType: "application/json",
        data: JSON.stringify({"naziv": $('#naz').val(), "opis": $('#opis').val(), "zanr": $('#zanr').val(), "trajanje": $('#trajanje').val(), "ocena": $('#ocena').val()}),
        success: function (response) {
            console.log(response);
            $('#pod tbody').html('');
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
$(document).on('click', '#vrati', function () {
    window.history.back();
});