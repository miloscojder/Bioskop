$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/bioskop/bioskopi",
        dataType: "json",
        success: function (response) {
            console.log(response);
            for(i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['naziv'] +"</td>";
                red += "<td align='center'>"+ response[i]['email'] +"</td>";
                red += "<td align='center'>"+ response[i]['adresa'] +"</td>";
                red += "<td align='center'>"+ response[i]['brcentrale'] +"</td>";
                var izmeni = "<button class='izmena' id='"+response[i]['id']+"'>Izmeni</button>";
                var obrisi = "<button class='brisanje' id='"+response[i]['id']+"'>Obrisi</button>";
                red += "<td>"+izmeni+"</td>";
                red += "<td>"+obrisi+"</td>";

                $('#pod tbody').append(red);
            }
        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.brisanje', function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/bioskop/brisiBioskop/" + this.id,
        contentType: "application/json",
        success: function (response) {
           window.location.reload();
        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.izmena', function () {

    $('#pod tbody').html('');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/bioskop/vratiBioskop/" + this.id,
        dataType: "json",
        success: function (response) {
            console.log(response);
                var red = "<tr>";
                red += "<td align='center'><input type='text' id='naziv' value='"+ response['naziv']+"'></td>";
                red += "<td align='center'><input type='text' id='mail' value='"+ response['email']+"'></td>";
                red += "<td align='center'><input type='text' id='adresa' value='"+ response['adresa']+"'></td>";
                red += "<td align='center'><input type='text' id='brcentrale' value='"+ response['brcentrale']+"'></td>";
                red += "<td align='center'><select id='men'></select></td>";
                var izmeni = "<button class='izmenaaa' id='" + response['id'] + "'>Izmeni</button>";
                var obrisi = "<button class='brisanje' id='" + response['id'] + "'>Ponisti</button>";
                red += "<td>" + izmeni + "</td>";
                red += "<td>" + obrisi + "</td>";

                $('#pod tbody').append(red);
        },
        error: function (response) {
            console.log(response);
        }
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/korisnik/menadzeri",
        dataType: "json",
        success:function (response) {
            console.log(response);
            var red;
            red += "<option disabled selected value> -- selektuj menadzera -- </option>";
            for (i = 0;i < response.length;i++){
                red += "<option value='"+ response[i]['username'] +"'>"+ response[i]['username']+"</option>";
                console.log(red);
            }
            $('#men').append(red);
        },
        error: function (response) {
            console.log(response);
        }
    });
});

$(document).on('click', '.izmenaaa', function () {

    if($('#men').val()==null) alert('Obavezno je selektovati menadzera!!');
    else{
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/bioskop/izmeniBioskop",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({"naziv": $('#naziv').val(), "brcentrale": $('#brcentrale').val(), "adresa": $('#adresa').val(), "email": $('#mail').val(), "menId": $('#men').val(), "biosId": this.id}),
            success: function (response) {
                console.log(response);
                window.location.reload();
            },
            error: function (response) {
                console.log(response);
            }
        });
    }

});