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
        dataType: "json",
        success: function (response) {
           window.location.reload();
        },
        error: function (response) {
            console.log(response);
        }
    });
});