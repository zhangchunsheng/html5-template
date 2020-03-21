$(function () {
    $('.swiper-container').each(function (index,ele) {
        var wrapper = $(this).find('.swiper-wrapper');
        var itemSpace = wrapper.data('space');
        var item = wrapper.data('item');
        var itemPage = wrapper.data('pagi');
        var itemNav = wrapper.data('nav');
        var delay = wrapper.data('delay');
        var pagination = '';
        var nextEl = '';
        var prevEl = '';
       
        if(itemPage == 1) {
            pagination = $(this).find('.swiper-pagination');
        }
        else {
            pagination = ''
        }
        if(itemNav == 1) {
            nextEl = $(this).parent().find('.button-next');
            prevEl = $(this).parent().find('.button-prev');
        }
        else {
            nextEl = '';
            prevEl = '';
        }
        var swiper = new Swiper(this, {
            autoHeight: true,
            slidesPerView: item,
            spaceBetween: itemSpace,
            pagination: {
                el: pagination,
                clickable: true
            },
            navigation: {
                nextEl: nextEl,
                prevEl: prevEl
            },
            autoplay: {
                delay: delay,
                disableOnInteraction: false
            },
            loop: true
        })
    });

    $('.navbar-toggles').click(function(){
        $('.vertical-wrapper').slideToggle('slow');
    })
    $('.close').click(function() {
        $('.top-ads').css('display','none');
        // Store
        sessionStorage.setItem("checkHeaderTop", "hidden");
    })
    
    if(typeof(Storage) !== "undefined") { 
        var ssid = sessionStorage.getItem('checkHeaderTop');
        if(ssid) {
            if(ssid == 'hidden') {
                $('.top-ads').css('display','none');
            }
        }else {
            $('.top-ads').css('display','block');
        }
    }else {
        $('.top-ads').css('display','block');
    }

    //custome tab
    $('.flash-sale li.tab-link').click(function () {
        var tab_id = $(this).data('tab');
        
        $('.flash-sale li.tab-link').removeClass('current-tab');
        $('.flash-sale .tab-contents').removeClass('current');

        $(this).addClass('current-tab');
        $('#'+tab_id).addClass('current');
    })
    
    
    $(window).scroll(function () {
        if ($(this).scrollTop() > 650) {
            $('#sticky-tool').css('display','block');
        }
        else {
            $('#sticky-tool').css('display','none');
        }
    })
        
})