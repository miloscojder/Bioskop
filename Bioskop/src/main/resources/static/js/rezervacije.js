$(document).ready(function() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rezervacije/ucitajRezervacije",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            for(i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['nazivFilma'] +"</td>";
                red += "<td align='center'>"+ response[i]['datum'].split("T")[0] +" , "+ response[i]['datum'].split("T")[1].split(".")[0] +"</td>";
                var izmeni = "<button class='otkazi' id='"+response[i]['id']+"'>Otkazi rezervaciju</button>";
                red += "<td>"+izmeni+"</td>";

                $('#pod tbody').append(red);
            }

        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.otkazi', function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rezervacije/obrisiRezervaciju/" + this.id,
        contentType:"application/json",
        success: function (response) {
            alert("USPESNO OTKAZANA REZERVACIJA!")
            console.log(response);
            window.location.reload();
        },
        error(response){
            console.log(response);
        }
    });
});