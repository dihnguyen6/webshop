function createAlertMess() {
    jQuery('<div/>', {
        id: 'alertMess',
        class: 'alert alert-warning alert-dismissible bound_left show',
        role: 'alert'
    }).appendTo('body')

    jQuery('<h1/>', {
        text: 'Notification'
    }).appendTo('#alertMess');

    jQuery('<p/>', {
        id: 'mess'
    }).appendTo('#alertMess');
}

window.setTimeout(function () {
    $('#alertMess').fadeTo(1000, -100).slideUp(500, function () {
        $(this).remove();
    })
}, 5000);

function login() {
    var serializedData = "username=" + $("#username").val() + "&password=" + $("#password").val();

    $("#loginButton").attr("disabled", "disabled");
    var request = $.ajax({
        url: "/admin",
        type: "post",
        data: serializedData
    });

    request.done(function (response, textStatus, jqXHR){
        if(response.status === "failed") {
            message = response.mess;
            messColor = response.mColor;
            if (message !== "") {
                createAlertMess();
                $('#mess').html(message);
                $('#mess').css('color', messColor);

                $('form').addClass($('form').addClass('ahashakeheartache'));
                $('form').on('webkitAnimationEnd oanimationend msAnimationEnd animationend', function(e){
                    $('form').delay(200).removeClass('ahashakeheartache');
                });
            }
        } else {
            window.location.replace(response.location);
        }
    });

    request.fail(function (jqXHR, textStatus, errorThrown){
        console.log(
            "The following error occurred: "+
            textStatus, errorThrown
        );
    });

    request.always(function () {
        $("#loginButton").removeAttr("disabled");
    });
}




