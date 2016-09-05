$(document).ready(function(){
    $("#button1").click(function(){
        $.ajax({
            url: "http://localhost:8080/example/",
            success: function( result ) {
                $( "#ajax_response" ).text(JSON.stringify(result));
            }
        });
    })
})