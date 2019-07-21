$(document).ready(function() {
    $('#cancel-btn').click(function() {
        $('#about-us').animate({opacity: 0},500);
    $('#about-us').slideUp(500);
    });

    $('#goto-top-btn').hide();
    var bodyHeight = $(document).height();

    $(window).scroll(function() {
        var height = $(window).scrollTop();
        var ratio = height/bodyHeight;
        if(ratio > 0.5) {
            $('#goto-top-btn').show();
        }
        else {
            $('#goto-top-btn').hide();
        }
    });      

});