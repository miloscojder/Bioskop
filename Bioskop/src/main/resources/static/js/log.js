$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/korisnik/izloguj",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click','#loguj',function () {


    $.ajax({
        type:"POST",
        url: "http://localhost:8080/korisnik/login",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({"username":  $('#username').val(), "password": $('#password').val()}),
        success: function(response){
            alert('Uspesno logovanje!!!');
            if(response.uloga === 'ADMIN')  window.location="admin.html";
            else if(response.uloga === 'MENADZER')  window.location="menpocetna.html";
            else window.location="pocetna.html";
        },
        error: function (response) {
            alert('Neuspesno logovanje!');
            console.log(response);
        }

    });

});
$(document).on('click','#reg',function () {

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/korisnik/registracija",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({"username": $('#username').val(), "lozinka": $('#password').val(), "ime": $('#ime').val(),
                "prezime": $('#prezime').val(), "telefon": $('#brtel').val(), "email": $('#mail').val(), "datumrodjenja": $('#rodjenje').val()}),
            success: function (response) {
                alert('Uspesna registracija, mozete da se ulogujete!');
                window.location="logovanje.html";
            },
            error: function (response) {
                alert('Neuspesna registracija!');
                console.log(response)
            }
        });
});


