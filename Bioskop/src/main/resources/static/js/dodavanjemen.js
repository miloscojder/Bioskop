$(document).on('click', '#addm', function () {
    $.ajax({

        type: "POST",
        url: "http://localhost:8080/korisnik/regMenadzera",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({"ime": $('#ime').val(), "prezime": $('#prezime').val(), "username": $('#username').val(), "lozinka": $('#password').val(),
            "telefon": $('#brtel').val(), "email": $('#mail').val(), "datumrodjenja": $('#rodjenje').val()}),
        success: function (response) {
            alert('Uspesno dodat novi menadzer!');
            window.location="menadzer.html";
        },
        error: function (response) {
            alert('Neuspesno dodavanje menadzera!');
            console.log(response);
        }

    });
});