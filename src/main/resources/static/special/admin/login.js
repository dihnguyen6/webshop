function createAlertMess() {
    jQuery('<div/>', {
        id: 'alertMess',
        class: 'alert alert-warning alert-dismissible fadeIn show',
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




