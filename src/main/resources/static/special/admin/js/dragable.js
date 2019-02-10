var tempList;

$(document).ready(function () {
    if(carouselList == null) {
        carouselList = [];
    }
    discard();

    //prevent browser from loading image
    window.addEventListener("dragover",function(e){
        e = e || event;
        e.preventDefault();
    },false);
    window.addEventListener("drop",function(e){
        e = e || event;
        e.preventDefault();
    },false);
});

function getCarousel() {
    content = "";
    for(var i = 0, len = tempList.length; i < len; ++i) {
        content += '<div class="col-md-10">\n' +
            '                    <img src="' + tempList[i] + '" draggable="true" ondragstart="drag(event, {0})" ondragend="cancelDrag();" alt="Carousel{0}">\n' +
            '                    <input type="file" id="editCar{0}" accept="image/*" onchange="editCar(this.files, {0})"hidden/>\n' +
            '                    <button type="button" class="btn-round edit" onclick="selectCar({0});"><span class="fa fa-edit"></span></button>\n' +
            '                    <button type="button" class="btn-round delete" onclick="removeCar({0});"><span class="fa fa-remove"></span></button>\n' +
            '                    <div class="dropable" ondrop="drop(event, this, {0})" ondragover="allowDrop(event, this)" ondragleave="stopDrop(this);">\n' +
            '                        <span class="fa fa-plus-square-o fa-2x"></span>\n' +
            '                    </div>\n' +
            '                </div>';
        content = String.format(content, i);
    }
    $("#carousel").html(content);
}

//allow drop on obj
function allowDrop(ev, obj) {
    ev.preventDefault();
    obj.classList.add('gray');
}

//using drag out obj area
function stopDrop(obj) {
    obj.classList.remove('gray');
}

//open dropable area for switching position of carousel when user start dragging
function drag(ev, id) {
    ev.dataTransfer.effectAllowed = 'move';
    ev.dataTransfer.setData("id", id);
    $(".dropable").css("height", "100px");
    $(".dropable").css("border", "solid black 1px");
    $(".dropable").css("border-style", "dashed");
    $(".dropable").children(".fa").css("display", "inline-block");
}

//hide drop area
function cancelDrag() {
    $(".dropable").css("height", "0px");
    $(".dropable").css("border", "none");
    $(".dropable").children(".fa").css("display", "none");
}

//when user drop item on obj area
function drop(ev, obj, id) {
    ev.preventDefault();
    obj.classList.remove('gray');
    var lastId = ev.dataTransfer.getData("id");
    var temp = tempList[id];
    tempList[id] = tempList[lastId];
    tempList[lastId] = temp;
    getCarousel();
}

//open select file window when user not using drag and drop
function selectFile() {
    document.getElementById('fileElem').click();
}

//user dropping file into upload area
function handleDrop(ev, obj) {
    obj.classList.remove('gray');
    var dt = ev.dataTransfer;
    var files = dt.files;
    handleFiles(files);
}

//read uploaded file and append into casrousel list
function handleFiles(files) {
    for(var i = 0, len = files.length; i < len; ++i) {
        (function(file) {
            var reader = new FileReader();
            reader.onload = function() {
                tempList.push(reader.result);
                getCarousel();
            }
            reader.readAsDataURL(file);
        })(files[i]);
    }
}

//upload new image to replace old carousel
function selectCar(id) {
    document.getElementById('editCar' + id).click();
}

//remove casrousel
function removeCar(id) {
    tempList.splice(id, 1);
    getCarousel();
}

//read new file and replace to position of old carousel
function editCar(files, id) {
    var reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload = function () {
        tempList[id] = reader.result;
        getCarousel();
    };
    reader.onerror = function (error) {
        console.log('Error: ', error);
    };
}

//updating casrousel list
function discard() {
    tempList = JSON.parse(carouselList);
    getCarousel();
}

//when apply remove all old carousel and save new carousel
function addFile() {
    $('button').prop("disable", true);
    $.ajax({
        url : "../admin/clean-car",
        type : "get",
        async: true,
        success : function(data) {
            for (var i = 0, len = tempList.length; i < len; ++i) {
                var file = dataURLtoFile(tempList[i], 'temp');
                uploadFile("../admin/edit-car?index=" + i, file);
            }
        },
        error: function(error) {
            console.log('Error: ', error);
        }
    });
}

//convert base64 image in to file for upload
function dataURLtoFile(dataurl, filename) {
    var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
    while(n--){
        u8arr[n] = bstr.charCodeAt(n);
    }
    return new File([u8arr], filename, {type:mime});
}

//upload a single file
function uploadFile(url, file) {
    var returnObject = new FormData();
    returnObject.append("file", file);
    $.ajax(
        {
            async: true,
            url: url,
            type: "POST",
            data: returnObject,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            success: function (data, status, xhr) {
                window.location.reload();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $('button').prop("disable", true);
            }
        }
    )
}