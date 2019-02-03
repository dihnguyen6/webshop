$(document).ready(function () {
    console.log(getCookie("locale"));
    $('#locales').val(getCookie("locale")).change();
    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        var unselectOption = (selectedOption === "de") ? "en" : "de";
        if (selectedOption != '') {
            window.location.replace(window.location.href.replace(unselectOption, selectedOption));
        }
    });
});

(function ($) {
    "use strict";

    /*[ Load page ]
    ===========================================================*/
    $(".animsition").animsition({
        inClass: 'fade-in',
        outClass: 'fade-out',
        inDuration: 1500,
        outDuration: 800,
        linkElement: '.animsition-link',
        loading: true,
        loadingParentElement: 'html',
        loadingClass: 'animsition-loading-1',
        loadingInner: '<div data-loader="ball-scale"></div>',
        timeout: false,
        timeoutCountdown: 5000,
        onLoadEvent: true,
        browser: ['animation-duration', '-webkit-animation-duration'],
        overlay: false,
        overlayClass: 'animsition-overlay-slide',
        overlayParentElement: 'html',
        transition: function (url) {
            window.location.href = url;
        }
    });

    /*[ Back to top ]
    ===========================================================*/
    var windowH = $(window).height() / 2;

    $(window).on('scroll', function () {
        if ($(this).scrollTop() > windowH) {
            $("#myBtn").css('display', 'flex');
        } else {
            $("#myBtn").css('display', 'none');
        }
    });

    $('#myBtn').on("click", function () {
        $('html, body').animate({scrollTop: 0}, 300);
    });


    /*[ Show header dropdown ]
    ===========================================================*/
    $('.js-show-header-dropdown').on('click', function () {
        $(this).parent().find('.header-dropdown')
    });

    var menu = $('.js-show-header-dropdown');
    var sub_menu_is_showed = -1;

    for (var i = 0; i < menu.length; i++) {
        $(menu[i]).on('click', function () {

            if (jQuery.inArray(this, menu) == sub_menu_is_showed) {
                $(this).parent().find('.header-dropdown').toggleClass('show-header-dropdown');
                sub_menu_is_showed = -1;
            } else {
                for (var i = 0; i < menu.length; i++) {
                    $(menu[i]).parent().find('.header-dropdown').removeClass("show-header-dropdown");
                }

                $(this).parent().find('.header-dropdown').toggleClass('show-header-dropdown');
                sub_menu_is_showed = jQuery.inArray(this, menu);
            }
        });
    }

    $(".js-show-header-dropdown, .header-dropdown").click(function (event) {
        event.stopPropagation();
    });

    $(window).on("click", function () {
        for (var i = 0; i < menu.length; i++) {
            $(menu[i]).parent().find('.header-dropdown').removeClass("show-header-dropdown");
        }
        sub_menu_is_showed = -1;
    });


    /*[ Fixed Header ]
   ===========================================================*/
    var posWrapHeader = $('.topbar').height();
    var header = $('.container-menu-header');

    $(window).on('scroll', function () {

        if ($(this).scrollTop() >= posWrapHeader) {
            $('.header1').addClass('fixed-header');
            $(header).css('top', -posWrapHeader);

        } else {
            var x = -$(this).scrollTop();
            $(header).css('top', x);
            $('.header1').removeClass('fixed-header');
        }

        if ($(this).scrollTop() >= 200 && $(window).width() > 992) {
            $('.fixed-header2').addClass('show-fixed-header2');
            $('.header2').css('visibility', 'hidden');
            $('.header2').find('.header-dropdown').removeClass("show-header-dropdown");

        } else {
            $('.fixed-header2').removeClass('show-fixed-header2');
            $('.header2').css('visibility', 'visible');
            $('.fixed-header2').find('.header-dropdown').removeClass("show-header-dropdown");
        }

    });

    /*[ Show menu mobile ]
    ===========================================================*/
    $('.btn-show-menu-mobile').on('click', function () {
        $(this).toggleClass('is-active');
        $('.wrap-side-menu').slideToggle();
    });

    var arrowMainMenu = $('.arrow-main-menu');

    for (var i = 0; i < arrowMainMenu.length; i++) {
        $(arrowMainMenu[i]).on('click', function () {
            $(this).parent().find('.sub-menu').slideToggle();
            $(this).toggleClass('turn-arrow');
        })
    }

    $(window).resize(function () {
        if ($(window).width() >= 992) {
            if ($('.wrap-side-menu').css('display') == 'block') {
                $('.wrap-side-menu').css('display', 'none');
                $('.btn-show-menu-mobile').toggleClass('is-active');
            }
            if ($('.sub-menu').css('display') == 'block') {
                $('.sub-menu').css('display', 'none');
                $('.arrow-main-menu').removeClass('turn-arrow');
            }
        }
    });


    /*[ remove top noti ]
    ===========================================================*/
    $('.btn-romove-top-noti').on('click', function () {
        $(this).parent().remove();
    })


    /*[ Block2 button wishlist ]
    ===========================================================*/
    $('.block2-btn-addwishlist').on('click', function (e) {
        e.preventDefault();
        $(this).addClass('block2-btn-towishlist');
        $(this).removeClass('block2-btn-addwishlist');
        $(this).off('click');
    });

    /*[ +/- num product ]
    ===========================================================*/
    $('.btn-num-product-down').on('click', function (e) {
        e.preventDefault();
        var numProduct = Number($(this).next().val());
        if (numProduct > 1) $(this).next().val(numProduct - 1);
    });

    $('.btn-num-product-up').on('click', function (e) {
        e.preventDefault();
        var numProduct = Number($(this).prev().val());
        $(this).prev().val(numProduct + 1);
    });


    /*[ Show content Product detail ]
    ===========================================================*/
    $('.active-dropdown-content .js-toggle-dropdown-content').toggleClass('show-dropdown-content');
    $('.active-dropdown-content .dropdown-content').slideToggle('fast');

    $('.js-toggle-dropdown-content').on('click', function () {
        $(this).toggleClass('show-dropdown-content');
        $(this).parent().find('.dropdown-content').slideToggle('fast');
    });


    /*[ Play video 01]
    ===========================================================*/
    var srcOld = $('.video-mo-01').children('iframe').attr('src');

    $('[data-target="#modal-video-01"]').on('click', function () {
        $('.video-mo-01').children('iframe')[0].src += "&autoplay=1";

        setTimeout(function () {
            $('.video-mo-01').css('opacity', '1');
        }, 300);
    });

    $('[data-dismiss="modal"]').on('click', function () {
        $('.video-mo-01').children('iframe')[0].src = srcOld;
        $('.video-mo-01').css('opacity', '0');
    });

})(jQuery);

String.format = function () {
    var s = arguments[0];
    for (var i = 0; i < arguments.length - 1; i++) {
        var reg = new RegExp("\\{" + i + "\\}", "gm");
        s = s.replace(reg, arguments[i + 1]);
    }
    return s;
};

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}

function getInstaFotos() {
    $.get("https://api.instagram.com/v1/users/self/media/recent?access_token=1026440603.2255e34.7b77b058f5c343aa940fb5fa2ae0d8f2&count=5",function callbackFunction(data, status) {
        console.log(data);
        var imgList = data["data"];
        var content = "";
        for(var i = 0, len = imgList.length; i < len; ++i) {
            var pic = imgList[i];
            var name = pic["caption"]["id"];
            var src = pic["images"]["standard_resolution"]["url"];
            var url=pic["link"];
            var like = pic["likes"]["count"];
            var caption = pic["caption"]["text"];
            var user = "Photo by @" + pic["user"]["username"];
            content += '<div class="block4 wrap-pic-w">\n' +
                '            <img alt="{0}" src="{1}">\n' +
                '            <a class="block4-overlay sizefull ab-t-l trans-0-4" href="{2}" target="_blank">\n' +
                '               <span class="block4-overlay-heart s-text9 flex-m trans-0-4 p-l-40 p-t-25">\n' +
                '                 <i aria-hidden="true" class="icon_heart_alt fs-20 p-r-12"></i>\n' +
                '                 <span class="p-t-2">{3}</span>\n' +
                '               </span>\n' +
                '                <div class="block4-overlay-txt trans-0-4 p-l-40 p-r-25 p-b-30">\n' +
                '                    <p class="s-text10 m-b-15 h-size1 of-hidden">{4}</p>' +
                '                    <span class="s-text9">\n' +
                '                       {5}' +
                '                    </span>\n' +
                '                </div>\n' +
                '            </a>\n' +
                '        </div>';
            content = String.format(content, name, src, url, like, caption, user);
        }

        $('#insta-img').html(content);
    });
}