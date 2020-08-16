$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/korisnik/menadzeri",
        dataType: "json",
        success: function (response) {
            console.log(response);
            for(i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['ime'] +"</td>";
                red += "<td align='center'>"+ response[i]['prezime'] +"</td>";
                red += "<td align='center'>"+ response[i]['username'] +"</td>";
                red += "<td align='center'>"+ response[i]['telefon'] +"</td>";
                red += "<td align='center'>"+ response[i]['email'] +"</td>";
                red += "<td align='center'>"+ response[i]['aktivan'] +"</td>";
                var obrisi = "<button class='brisanje' id='"+response[i]['id']+"'>Obrisi</button>";
                red += "<td>"+obrisi+"</td>";

                $('#pod tbody').append(red);
            }
        },
        error: function (response) {
            console.log(response)
        }

    });
});
$(document).on('click', '.brisanje', function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/korisnik/brisiMenadzera/" + this.id,
        contentType: "application/json",
        success: function (response) {
            alert("OBRISANO");
            window.location.reload(false);
        },
        error: function (response) {
            alert("NIJE OBRISANO");
            console.log(response);
        }
    });
});
