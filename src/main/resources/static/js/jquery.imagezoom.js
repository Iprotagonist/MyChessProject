(function($){

	$.fn.imagezoom = function(options){

		var settings = {
			xzoom: 310,
			yzoom: 310,
			offset: 10,
			position: "BTR",
			preload: 1
		};

		if(options) {
			$.extend(settings, options);
		}

		var noalt = '';

		var self = this;

		$(this).bind("mouseenter", function(ev){

			var imageLeft = $(this).offset().left;//Ԫ����߾�
			var imageTop = $(this).offset().top;//Ԫ�ض��߾�


			var imageWidth = $(this).get(0).offsetWidth;//ͼƬ���
			var imageHeight = $(this).get(0).offsetHeight;//ͼƬ�߶�

			var boxLeft = $(this).parent().offset().left;//������߾�
			var boxTop = $(this).parent().offset().top;//���򶥱߾�
			var boxWidth = $(this).parent().width();//������
			var boxHeight = $(this).parent().height();//����߶�

			noalt= $(this).attr("alt");//ͼƬ����
			var bigimage = $(this).attr("rel");//��ͼ��ַ
			$(this).attr("alt",'');//���ͼƬalt


			if($("div.zoomDiv").get().length == 0){
				$(document.body).append("<div class='zoomDiv'><img class='bigimg' src='"+bigimage+"'/></div><div class='zoomMask'>&nbsp;</div>");//�Ŵ󾵿�����
			}


			if(settings.position == "BTR"){
				//�����������Ļ��� ���Ŵ󾵷����ұ�
				if(boxLeft + boxWidth + settings.offset + settings.xzoom > screen.width){
					leftpos = boxLeft  - settings.offset - settings.xzoom;
				}else{
					leftpos = boxLeft + boxWidth + settings.offset;
				}
			}else{
				leftpos = imageLeft - settings.xzoom - settings.offset;
				if(leftpos < 0){
					leftpos = imageLeft + imageWidth  + settings.offset;
				}
			}

			$("div.zoomDiv").css({ top: boxTop,left: leftpos });
			$("div.zoomDiv").width(settings.xzoom);
			$("div.zoomDiv").height(settings.yzoom);
			$("div.zoomDiv").show();

			$(this).css('cursor','crosshair');

			$(document.body).mousemove(function(e){

				mouse = new MouseEvent(e);
				if(mouse.x<imageLeft || mouse.x>imageLeft+imageWidth || mouse.y<imageTop || mouse.y>imageTop+imageHeight){
					mouseOutImage();
					return;
				}

				var bigwidth = $(".bigimg").get(0).offsetWidth;
				var bigheight = $(".bigimg").get(0).offsetHeight;

				var scaley ='x';
				var scalex ='y';


				//�������ֲ�ߴ�
				if(isNaN(scalex)|isNaN(scaley)){
					var scalex = (bigwidth/imageWidth);
					var scaley = (bigheight/imageHeight);
					$("div.zoomMask").width((settings.xzoom)/scalex );
					$("div.zoomMask").height((settings.yzoom)/scaley);
					$("div.zoomMask").css('visibility','visible');
				}



				xpos = mouse.x- $("div.zoomMask").width()/2 ;
				ypos = mouse.y- $("div.zoomMask").height()/2 ;
				
				xposs = mouse.x- $("div.zoomMask").width()/2 - imageLeft;
				yposs = mouse.y- $("div.zoomMask").height()/2 - imageTop ;
				
				xpos = (mouse.x - $("div.zoomMask").width()/2 < imageLeft ) ? imageLeft : (mouse.x + $("div.zoomMask").width()/2 > imageWidth + imageLeft ) ?  (imageWidth + imageLeft -$("div.zoomMask").width()): xpos;
				ypos = (mouse.y - $("div.zoomMask").height()/2 < imageTop ) ? imageTop : (mouse.y + $("div.zoomMask").height()/2  > imageHeight + imageTop ) ?  (imageHeight + imageTop - $("div.zoomMask").height()) : ypos;


				$("div.zoomMask").css({ top:ypos,left:xpos});
				$("div.zoomDiv").get(0).scrollLeft = xposs * scalex;
				$("div.zoomDiv").get(0).scrollTop  = yposs * scaley;


			});

		});


		function mouseOutImage(){
			$(self).attr("alt",noalt);
			$(document.body).unbind("mousemove");
			$("div.zoomMask").remove();
			$("div.zoomDiv").remove();
		}

		//Ԥ����
		count = 0;
		if(settings.preload){
			$('body').append("<div style='display:none;' class='jqPreload"+count+"'></div>");

			$(this).each(function(){

				var imagetopreload= $(this).attr("rel");

				var content = jQuery('div.jqPreload'+count+'').html();

				jQuery('div.jqPreload'+count+'').html(content+'<img src=\"'+imagetopreload+'\">');

			});

		}

	}

})(jQuery);


function MouseEvent(e) {
	this.x = e.pageX;
	this.y = e.pageY;
}