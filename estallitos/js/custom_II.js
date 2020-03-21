//------- Contact Form Submition ---------//
  function checkRequire(formId , targetResp){
    targetResp.html('');
    var email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
    var url = /(http|ftp|https):\/\/[\w-]+(\.[\w-]+)+([\w.,@?^=%&amp;:\/~+#-]*[\w@?^=%&amp;\/~+#-])?/;
    var image = /\.(jpe?g|gif|png|PNG|JPE?G)$/;
    var mobile = /^[\s()+-]*([0-9][\s()+-]*){6,20}$/;
    var facebook = /^(https?:\/\/)?(www\.)?facebook.com\/[a-zA-Z0-9(\.\?)?]/;
    var twitter = /^(https?:\/\/)?(www\.)?twitter.com\/[a-zA-Z0-9(\.\?)?]/;
    var google_plus = /^(https?:\/\/)?(www\.)?plus.google.com\/[a-zA-Z0-9(\.\?)?]/;
    var check = 0;
    $('#er_msg').remove();
    var target = (typeof formId == 'object')? $(formId):$('#'+formId);
    target.find('input , textarea , select').each(function(){
      if($(this).hasClass('require')){
        if($(this).val().trim() == ''){
          check = 1;
          $(this).focus();
          targetResp.html('You missed out some fields.');
          $(this).addClass('error');
          return false;
        }else{
          $(this).removeClass('error');
        }
      }
      if($(this).val().trim() != ''){
        var valid = $(this).attr('data-valid');
        if(typeof valid != 'undefined'){
          if(!eval(valid).test($(this).val().trim())){
            $(this).addClass('error');
            $(this).focus();
            check = 1;
            targetResp.html($(this).attr('data-error'));
            return false;
          }else{
            $(this).removeClass('error');
          }
        }
      }
    });
    return check;
  }

(function($){
  "use strict";
  
	 // Preloader 
    jQuery(window).on('load', function() {
        jQuery("#status").fadeOut();
        jQuery("#preloader").delay(350).fadeOut("slow");
    });
	
	// on ready function
	jQuery(document).ready(function($) {
	var $this = $(window);

$(".submitForm").on("click", function() {
        console.log("Sending contact");
    var _this = $(this);
    var targetForm = _this.closest('form');
    var errroTarget = targetForm.find('.response');
    var check = checkRequire(targetForm , errroTarget);
    if(check == 0){
      var formDetail = new FormData(targetForm[0]);
      formDetail.append('form_type' , _this.attr('form-type'));
      $.ajax({
        method : 'post',
        url : 'ajax.php',
        data:formDetail,
        cache:false,
        contentType: false,
        processData: false
      }).done(function(resp){
                console.log("Contact sent");
        if(resp == 1){
                    console.log("Result = OK");
          targetForm.find('input').val('');
          targetForm.find('textarea').val('');
          errroTarget.html('<p style="color:green;">El mail de contacto fue enviado.</p>');
        }else{
                    console.log("Result = FAILED");
          errroTarget.html('<p style="color:red;">¡Ups! Hubo un problema. Intentar nuevamente.</p>');
        }
      });
    }
  });


	// scrolling animation js
	
	 var $winW = function() {
        return $(window).width();
    };
    var $winH = function() {
        return $(window).height();
    };
    var $screensize = function(element) {
        $(element).width($winW()).height($winH());
    };
    var screencheck = function(mediasize) {
        if (typeof window.matchMedia !== "undefined") {
            var screensize = window.matchMedia("(max-width:" + mediasize + "px)");
            if (screensize.matches) {
                return true;
            } else {
                return false;
            }
        } else {
            if ($winW() <= mediasize) {
                return true;
            } else {
                return false;
            }
        }
    };
            $('.animated-row').each(function() {
                var $this = $(this);
                $this.find('.animate').each(function(i) {
                    var $item = $(this);
                    var animation = $item.data('animate');
                    $item.on('inview', function(event, isInView) {
                        if (isInView) {
                            setTimeout(function() {
                                $item.addClass('animated ' + animation).removeClass('animate');
                            }, i * 50);
                        } else if (!screencheck(767)) {
                            $item.removeClass('animated ' + animation).addClass('animate');
                        }
                    });
                });
            });
			
			// single page scrolling js
			
	 if ($('.fullpage-default').length) {
            var myFullpage = new fullpage('.fullpage-default', {
                licenseKey: ' C7F41B00-5E824594-9A5EFB99-B556A3D5',
                anchors: ['inicio', 'nosotros', 'empresa', 'productos', 'contacto', 'mensaje'],
                menu: '#nav',
                lazyLoad: true,
                navigation: true,
                navigationPosition: 'right',
                scrollOverflow: true,
                responsiveWidth: 992,
                responsiveHeight: 600,
                responsiveSlides: true
            });
        }
		
		// owl js
		
		$(document).ready(function() {
              $('.ck_gallery_slider_wrapper .owl-carousel').owlCarousel({
                loop: true,
                margin: 0,
				autoplay:true,
                responsiveClass: true,
				smartSpeed: 1200,
				navText: ['<i class="flaticon-left-arrow"></i>', '<i class="flaticon-right-arrow"></i>'],
                responsive: {
                  0: {
                    items: 1,
                    nav: true
                  },
                  600: {
                    items: 2,
                    nav: true,
					margin: 2
                  },
                  900: {
                    items: 3,
                    nav: true,
					margin: 2
                  },
                  1000: {
                    items: 4,
                    nav: true,
                    loop: true,
                    margin: 2
                  }
                }
              })
            })
			
			$(document).ready(function() {
              $('.ck_team_slider_wrapper .owl-carousel').owlCarousel({
                loop: true,
                margin: 0,
				autoplay:true,
                responsiveClass: true,
				smartSpeed: 1200,
				navText: ['<i class="flaticon-left-arrow"></i>', '<i class="flaticon-right-arrow"></i>'],
                responsive: {
                  0: {
                    items: 1,
                    nav: true
                  },
                  800: {
                    items: 2,
                    nav: true,
					margin: 15
                  },
                  1000: {
                    items: 3,
                    nav: true,
                    loop: true,
                    margin: 20
                  }
                }
              })
            })
			
			
			$(document).ready(function() {
              $('.ck_testi_slider_wrapper .owl-carousel').owlCarousel({
                loop: true,
                margin: 0,
				autoplay:false,
                responsiveClass: true,
				smartSpeed: 1200,
				animateOut: 'fadeInUp',
				animateIn: 'fadeInUp',
				navText: ['<i class="flaticon-left-arrow"></i>', '<i class="flaticon-right-arrow"></i>'],
                responsive: {
                  0: {
                    items: 1,
                    nav: true
                  },
                  600: {
                    items: 1,
                    nav: true
                  },
                  1000: {
                    items: 1,
                    nav: true,
                    loop: true,
                    margin: 20
                  }
                }
              })
            })
			
			$(document).ready(function() {
              $('.ck_blog_slider_wrapper .owl-carousel').owlCarousel({
                loop: true,
                margin: 0,
				autoplay:true,
                responsiveClass: true,
				smartSpeed: 1200,
				navText: ['<i class="flaticon-left-arrow"></i>', '<i class="flaticon-right-arrow"></i>'],
                responsive: {
                  0: {
                    items: 1,
                    nav: true
                  },
                  600: {
                    items: 1,
                    nav: true
                  },
				  900: {
                    items: 1,
                    nav: true
                  },
                  1200: {
                    items: 2,
                    nav: true,
                    loop: true,
                    margin: 20
                  }
                }
              })
            })
			
			
			$(document).ready(function() {
              $('.ck_elem_slider_wrapper .owl-carousel').owlCarousel({
                loop: true,
                margin: 0,
				autoplay:true,
                responsiveClass: true,
				smartSpeed: 1200,
				navText: ['<i class="flaticon-left-arrow"></i>', '<i class="flaticon-right-arrow"></i>'],
                responsive: {
                  0: {
                    items: 1,
                    nav: true
                  },
                  600: {
                    items: 2,
                    nav: true,
					margin: 15
                  },
                  1000: {
                    items: 3,
                    nav: true,
                    loop: true,
                    margin: 20
                  }
                }
              })
            })
			
			
			


$('#cssmenu li.active').addClass('open').children('ul').show();
	$('#cssmenu li.has-sub>a').on('click', function(){
		$(this).removeAttr('href');
		var element = $(this).parent('li');
		if (element.hasClass('open')) {
			element.removeClass('open');
			element.find('li').removeClass('open');
			element.find('ul').slideUp(200);
		}
		else {
			element.addClass('open');
			element.children('ul').slideDown(200);
			element.siblings('li').children('ul').slideUp(200);
			element.siblings('li').removeClass('open');
			element.siblings('li').find('li').removeClass('open');
			element.siblings('li').find('ul').slideUp(200);
		}
	});
		
		
	
	});
})(); 