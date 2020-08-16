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
                red += "<td>"+izmeni+"</td>";
                red += "<td>"+obrisi+"</td>";

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
    if($('#pod2')[0].style.display === "none") $('#pod2').css('display','block');
    else $('#pod2').css('display','none');

    $('#pod2 thead').append('<th>Hed</th>');



});