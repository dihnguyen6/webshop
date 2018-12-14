function addFile() {
    var input = document.getElementById('myFile').files;
    for (var i = 0; i < input.length; ++i) {
        uploadFile("product/edit-car?index=" + i, input[i]);
    }
}

function uploadFile(url, file) {
    var returnObject = new FormData();
    returnObject.append("file", file);
    $.ajax(
        {
            async: false,
            url: url,
            type: "POST",
            data: returnObject,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            success: function (data, status, xhr) {

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {

            }
        }
    )
}