$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv
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
$(document).on('click','#add',function () {

    if($('#men').val()==null) alert('Obavezno je selektovati menadzera!!');
    else {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/bioskop/kreiraj",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({"naziv": $('#naziv').val(), "brcentrale": $('#brcentrale').val(), "adresa": $('#adresa').val(), "email": $('#mail').val(), "menId": $('#men').val()}),
            success: function (response) {
                alert('Uspesno dodat novi bioskop!');
                window.location="admin.html";
            },
            error: function (response) {
                alert('Neuspesno dodavanje!');
                console.log(response);
            }
        });
    }

});