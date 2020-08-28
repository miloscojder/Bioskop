$(document).ready( function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/korisnik/ucitaj",
        dataType: "json",
        success: function (response) {
            console.log(response);
            var red = "<tr>";
            red += "<td align='center'><b>Username:</b></td><td align='center'>"+ response['username'] +"</td>";
            $('#pod tbody').append(red);
            var red = "<tr>";
            red += "<td align='center'><b>Ime:</b></td><td align='center'>"+ response['ime'] +"</td>";
            $('#pod tbody').append(red);
            var red = "<tr>";
            red += "<td align='center'><b>Prezime:</b></td><td align='center'>"+ response['prezime'] +"</td>";
            $('#pod tbody').append(red);
            var red = "<tr>";
            red += "<td align='center'><b>Telefon:</b></td><td align='center'>"+ response['telefon'] +"</td>";
            $('#pod tbody').append(red);
            var red = "<tr>";
            red += "<td align='center'><b>Email:</b></td><td align='center'>"+ response['email'] +"</td>";
            $('#pod tbody').append(red);
            var red = "<tr>";
            red += "<td align='center'><b>Datum rodjenja:</b></td><td align='center'>"+ response['datumrodjenja'].split("T")[0] +"</td>";

            $('#pod tbody').append(red);


        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '#vrati', function () {
    window.history.back();
});