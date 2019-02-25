window.setTimeout(function () {
    $('#alertMess').fadeTo(1000, -100).slideUp(500, function () {
        $(this).remove();
    })
}, 5000);




