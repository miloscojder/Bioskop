$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/bioskop/mojiBioskopi",
        dataType: "json",
        success: function (response) {
            console.log(response);
            for(i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['naziv'] +"</td>";
                red += "<td align='center'>"+ response[i]['email'] +"</td>";
                red += "<td align='center'>"+ response[i]['adresa'] +"</td>";
                red += "<td align='center'>"+ response[i]['brcentrale'] +"</td>";
                var izmeni = "<button class='sala' id='"+response[i]['id']+"'>Sale</button>";
                var obrisi = "<button class='raspored' id='"+response[i]['id']+"'>Raspored</button>";
                var dodaj = "<button class='dodavanje' id='"+response[i]['id']+"'>Dodaj Salu</button>";
                red += "<td>"+izmeni+"</td>";
                red += "<td>"+obrisi+"</td>";
                red += "<td>"+dodaj+"</td>";
                $('#pod tbody').append(red);
            }
        },
        error: function (response) {
            console.log(response)
        }

    });

});
$(document).on('click', '.sala', function () {
    //var x = document.getElementById("pod2");
    //$('#pod2').css('display','block');
   // $('#pod2')[0].style.display = "block";
    $('#pod2 tbody').html('');
    if($('#pod2')[0].style.display === "none") $('#pod2').css('display','block');
    else $('#pod2').css('display','none');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sale/getSale/" + this.id,
        dataType: "json",
        success: function (response) {
            console.log(response);
             for(i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['kapacitet'] +"</td>";
                red += "<td align='center'>"+ response[i]['oznakasale'] +"</td>";
                var izmeni = "<button class='izmenii' id='"+response[i]['id']+"'>Izmeni</button>";
                var obrisi = "<button class='obrisii' id='"+response[i]['id']+"'>Obrisi</button>";
                red += "<td>"+izmeni+"</td>";
                red += "<td>"+obrisi+"</td>";

                $('#pod2 tbody').append(red);
            }
        },
        error: function (response) {
            console.log(response)
        }

    });


});
$(document).on('click', '.izmenii', function () {
    $('#pod2 tbody').html('');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sale/sala/" + this.id,
        dataType: "json",
        success: function (response) {
            console.log(response);
            var red = "<tr>";
            red += "<td align='center'><input type='text' id='kap' value='"+ response['kapacitet']+"'></td>";
            red += "<td align='center'><input type='text' id='oznaka' value='"+ response['oznakasale']+"'></td>";
            var izmeni = "<button class='izmenaa' id='" + response['id'] + "'>Izmeni</button>";
            var obrisi = "<button class='ponisti'>Ponisti</button>";
            red += "<td>" + izmeni + "</td>";
            red += "<td>" + obrisi + "</td>";

            $('#pod2 tbody').append(red);
        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.izmenaa', function () {

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/sale/izmeniSalu",
        contentType: "application/json",
        data: JSON.stringify({"id": this.id, "kapacitet": $('#kap').val(), "oznakaSale": $('#oznaka').val()}),
        success: function (response) {
            console.log(response);
            $('#pod2').css('display','none');
        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.obrisii', function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sale/brisiSalu/"+ this.id,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            $('#pod2').css('display','none');
        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.ponisti', function () {
    $('#pod2').css('display','none');
});
$(document).on('click', '.dodavanje', function () {
    $('#pod2 tbody').html('');
    if($('#pod2')[0].style.display === "none") $('#pod2').css('display','block');
    else $('#pod2').css('display','none');
    var red = "<tr>";
    red += "<td align='center'><input type='text' id='kap'></td>";
    red += "<td align='center'><input type='text' id='oznaka'></td>";
    var izmeni = "<button class='unesi' id='" + this.id + "'>Unesi</button>";
    var obrisi = "<button class='ponisti'>Ponisti</button>";
    red += "<td>" + izmeni + "</td>";
    red += "<td>" + obrisi + "</td>";

    $('#pod2 tbody').append(red);
});
$(document).on('click', '.unesi', function () {

    $.ajax({
            type: "POST",
            url: "http://localhost:8080/sale/dodajSalu",
            contentType: "application/json",
            data: JSON.stringify({"id": this.id, "kapacitet": $('#kap').val(), "oznakaSale": $('#oznaka').val()}),
            success: function (response) {
                console.log(response);
                alert('Sala uspesno dodata u bioskop '+response['naziv']);
                $('#pod2').css('display','none');
            },
            error: function (response) {
                console.log(response);
            }
        });
});
$(document).on('click', '.raspored', function () {
    $('#pod3 tbody').html('');
    if($('#pod3')[0].style.display === "none") $('#pod3').css('display','block');
    else $('#pod3').css('display','none');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sale/brisiSalu/"+ this.id,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            $('#pod2').css('display','none');
        },
        error: function (response) {
            console.log(response);
        }
    });
});
