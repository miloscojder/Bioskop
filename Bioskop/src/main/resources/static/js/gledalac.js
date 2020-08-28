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
                var dugme = "<button class='projekcije' id='"+ response[i]['id'] +"'>Projekcija</button>";
                red += "<td align='center'>"+ dugme +"</td>";

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
                var dugme = "<button class='projekcije' id='"+ response[i]['id'] +"'>Projekcija</button>";
                red += "<td align='center'>"+ dugme +"</td>";

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
                var dugme = "<button class='projekcije' id='"+ response[i]['id'] +"'>Projekcija</button>";
                red += "<td align='center'>"+ dugme +"</td>";

                $('#pod tbody').append(red);
            }
        },
        error: function (response) {
            console.log(response);
        }

    });
});
$(document).on('click', '.projekcije', function () {
        $('#pod2 tbody').html('');
        if($('#pod2')[0].style.display === "none") $('#pod2').css('display','block');
        else $('#pod2').css('display','none');
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/projekcija/ucitajProjekcijeFilma/"+ this.id,
            contentType: "application/json",
            success: function (response) {
                console.log(response);
                for(i = 0; i < response.length; i++){
                    var red = "<tr>";
                    red += "<td align='center'>"+ response[i]['nazivFilma'] +"</td>";
                    red += "<td align='center'>"+ response[i]['datum'].split("T")[0] +" , "+ response[i]['datum'].split("T")[1].split(".")[0] +"</td>";
                    red += "<td align='center'>"+ response[i]['cena'] +"</td>";
                    red += "<td align='center'>"+ response[i]['oznakaSale'] +"</td>";
                    var izmeni = "<button class='rezervisi' id='"+response[i]['nazivFilma']+","+response[i]['datum']+"'>Rezervisi</button>";
                    red += "<td>"+izmeni+"</td>";

                    $('#pod2 tbody').append(red);
                }

            },
            error: function (response) {
                console.log(response);
            }
        });
});
$(document).on('click', '.rezervisi', function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rezervacije/rezervisiProjekcijeFilma/"+ this.id,
        contentType: "application/json",
        success: function (response) {
            console.log(response);

        },
        error: function (response) {
            console.log(response);
        }
    });
});