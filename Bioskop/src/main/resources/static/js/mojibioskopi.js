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
                var dodajpr = "<button class='dodajp' id='"+response[i]['id']+"'>Dodaj Projekciju</button>";
                red += "<td>"+izmeni+"</td>";
                red += "<td>"+obrisi+"</td>";
                red += "<td>"+dodaj+"</td>";
                red += "<td>"+dodajpr+"</td>";
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
        url: "http://localhost:8080/projekcija/ucitajProjekcije/"+ this.id,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            for(i = 0; i < response.length; i++){
                var red = "<tr>";
                red += "<td align='center'>"+ response[i]['nazivFilma'] +"</td>";
                red += "<td align='center'>"+ response[i]['datum'].split("T")[0] +" , "+ response[i]['datum'].split("T")[1].split(".")[0] +"</td>";
                red += "<td align='center'>"+ response[i]['cena'] +"</td>";
                red += "<td align='center'>"+ response[i]['oznakaSale'] +"</td>";
                var izmeni = "<button class='izmenap' id='"+response[i]['id']+","+response[i]['bioskopId']+"'>Izmeni</button>";
                red += "<td>"+izmeni+"</td>";

                $('#pod3 tbody').append(red);
            }

        },
        error: function (response) {
            console.log(response);
        }
    });
});
$(document).on('click', '.ponisti2', function () {
    $('#pod3').css('display','none');
});
$(document).on('click', '.izmenap', function () {
    $('#pod3 tbody').html('');
    var red = "<tr>";
    red += "<td align='center'><select id='naz'></select></td>";
    red += "<td align='center'><input type='datetime-local' id='dat'></td>";
    red += "<td align='center'><input type='number' id='cen'></td>";
    red += "<td align='center'><select id='oznsal'></select></td>";
    var izmeni = "<button class='unesi2' id='" + this.id + "'>Unesi</button>";
    var obrisi = "<button class='ponisti2'>Ponisti</button>";
    red += "<td>" + izmeni + "</td>";
    red += "<td>" + obrisi + "</td>";

    $('#pod3 tbody').append(red);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/film/ucitaj",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            var red;
            red += "<option disabled selected value> -- selektuj film -- </option>";
            for (i = 0;i < response.length;i++){
                red += "<option value='"+ response[i]['naziv'] +"'>"+ response[i]['naziv']+"</option>";
               // console.log(red);
            }
            $('#naz').append(red);

        },
        error: function (response) {
            console.log(response);
        }
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sale/getSale/" + this.id.split(",")[1],
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            var red;
            red += "<option disabled selected value> -- selektuj salu -- </option>";
            for (i = 0;i < response.length;i++){
                red += "<option value='"+ response[i]['oznakasale'] +"'>"+ response[i]['oznakasale']+"</option>";
                //console.log(red);
            }
            $('#oznsal').append(red);

        },
        error: function (response) {
            console.log(response);
        }
    });


    /*$.ajax({
        type: "POST",
        url: "http://localhost:8080/sale/izmeniSalu",
        contentType: "application/json",
        data: JSON.stringify({"id": this.id, "kapacitet": $('#kap').val(), "oznakaSale": $('#oznaka').val()}),
        success: function (response) {
            console.log(response);
            $('#pod3').css('display','none');
        },
        error: function (response) {
            console.log(response);
        }
    });*/
});

$(document).on('click', '.unesi2', function () {
    var danas = new Date();
    var datumm = new Date($('#dat').val());
   // alert(danas);
   // alert(datumm);



    if($('#naz').val() == null && $('#oznsal').val() == null){
        alert("Potrebno je uneti film i salu za projekciju");
    }else if($('#naz').val() == null ) alert("Potrebno  je odabrati film koji se prikazuje");
          else if ($('#oznsal').val() == null) alert("Potrebno je odabrati salu u kojoj se film prikazuje");
          else if(datumm < danas) alert("Potrebno je uneti neki datum u buducnosti!!");
          else if ($('#cen').val() === '') alert("Potrebno je uneti cenu!");
          else {
           $.ajax({
               type: "POST",
               url: "http://localhost:8080/projekcija/izmeniProjekciju",
               contentType: "application/json",
               data: JSON.stringify({"id": this.id.split(",")[0], "datum": $('#dat').val(), "cena": $('#cen').val(), "nazivFilma": $('#naz').val(), "oznakaSale": $('#oznsal').val()}),
               success: function (response) {
                   console.log(response);
                   $('#pod3').css('display', 'none');
               },
               error: function (response) {
                   console.log(response);
                   if(response.responseText === 'Zauzet datum') alert("Za odabrani datum projekcije sala je zauzeta");
               }
        });
    }
});
$(document).on('click', '.dodajp', function () {
    $('#pod3 tbody').html('');

    if($('#pod3')[0].style.display === "none") $('#pod3').css('display','block');
    else $('#pod3').css('display','none');
    var red = "<tr>";
    red += "<td align='center'><select id='naz'></select></td>";
    red += "<td align='center'><input type='datetime-local' id='dat'></td>";
    red += "<td align='center'><input type='number' id='cen'></td>";
    red += "<td align='center'><select id='oznsal'></select></td>";
    var izmeni = "<button class='unesi3' id='" + this.id + "'>Unesi</button>";
    var obrisi = "<button class='ponisti2'>Ponisti</button>";
    red += "<td>" + izmeni + "</td>";
    red += "<td>" + obrisi + "</td>";

    $('#pod3 tbody').append(red);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/film/ucitaj",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            var red;
            red += "<option disabled selected value> -- selektuj film -- </option>";
            for (i = 0;i < response.length;i++){
                red += "<option value='"+ response[i]['naziv'] +"'>"+ response[i]['naziv']+"</option>";
                // console.log(red);
            }
            $('#naz').append(red);

        },
        error: function (response) {
            console.log(response);
        }
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sale/getSale/" + this.id,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            var red;
            red += "<option disabled selected value> -- selektuj salu -- </option>";
            for (i = 0;i < response.length;i++){
                red += "<option value='"+ response[i]['oznakasale'] +"'>"+ response[i]['oznakasale']+"</option>";
                //console.log(red);
            }
            $('#oznsal').append(red);

        },
        error: function (response) {
            console.log(response);
        }
    });


    /*$.ajax({
        type: "POST",
        url: "http://localhost:8080/sale/izmeniSalu",
        contentType: "application/json",
        data: JSON.stringify({"id": this.id, "kapacitet": $('#kap').val(), "oznakaSale": $('#oznaka').val()}),
        success: function (response) {
            console.log(response);
            $('#pod3').css('display','none');
        },
        error: function (response) {
            console.log(response);
        }
    });*/
});
$(document).on('click', '.unesi3', function () {
    var danas = new Date();
    var datumm = new Date($('#dat').val());
    // alert(danas);
    // alert(datumm);

    //alert($('#cen').val());

    if($('#naz').val() == null && $('#oznsal').val() == null){
        alert("Potrebno je uneti film i salu za projekciju");
    }else if($('#naz').val() == null ) alert("Potrebno  je odabrati film koji se prikazuje");
    else if ($('#oznsal').val() == null) alert("Potrebno je odabrati salu u kojoj se film prikazuje");
    else if(datumm < danas) alert("Potrebno je uneti neki datum u buducnosti!!");
    else if ($('#cen').val() === '') alert("Potrebno je uneti cenu!");
    else {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/projekcija/dodajProjekciju",
            contentType: "application/json",
            data: JSON.stringify({"datum": $('#dat').val(), "cena": $('#cen').val(), "nazivFilma": $('#naz').val(), "oznakaSale": $('#oznsal').val()}),
            success: function (response) {
                console.log(response);
                $('#pod3').css('display', 'none');
            },
            error: function (response) {
                console.log(response);
                if(response.responseText === 'Zauzet datum') alert("Za odabrani datum projekcije sala je zauzeta");
            }
        });
    }
});