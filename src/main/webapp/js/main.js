(function(b){b.fn.lazyload=function(n,e){if(!this.length){return}var a=("http:"==document.location.protocol)?"http://www.lady8844.com/images/index/201412/images/w.gif":"http://www.lady8844.com/images/index/201412/images/w.gif";var k=b.extend({type:null,offsetParent:null,source:"data-src2",placeholderImage:a,placeholderClass:"loading",threshold:300},n||{}),B=this,l,A,o=function(r){var c=r.scrollLeft,p=r.scrollTop,i=r.offsetWidth,q=r.offsetHeight;while(r.offsetParent){c+=r.offsetLeft;p+=r.offsetTop;r=r.offsetParent}return{left:c,top:p,width:i,height:q}},h=function(){var c=document.documentElement,s=document.body,q=window.pageXOffset?window.pageXOffset:(c.scrollLeft||s.scrollLeft),p=window.pageYOffset?window.pageYOffset:(c.scrollTop||s.scrollTop),i=c.clientWidth,r=c.clientHeight;return{left:q,top:p,width:i,height:r}},j=function(p,i){var r,q,v,u,t,c,s=k.threshold?parseInt(k.threshold):0;r=p.left+p.width/2;q=i.left+i.width/2;v=p.top+p.height/2;u=i.top+i.height/2;t=(p.width+i.width)/2;c=(p.height+i.height)/2;return Math.abs(r-q)<(t+s)&&Math.abs(v-u)<(c+s)},f=function(c){if(k.placeholderImage&&k.placeholderClass){c.attr("src",k.placeholderImage).addClass(k.placeholderClass)}},d=function(i,c,p){if(i){p.attr("src",c).removeAttr(k.source);if(e){e(c,p)}}},g=function(){A=h(),B=B.filter(function(){return b(this).attr(k.source)});b.each(B,function(){var c=b(this).attr(k.source);if(!c){return}switch(k.type){case"image":f(b(this));break;default:break}});b.each(B,function(){var c=b(this).attr(k.source);if(!c){return}var i=(!k.offsetParent)?A:o(b(k.offsetParent).get(0)),q=o(this),p=j(i,q);switch(k.type){case"image":d(p,c,b(this));break;default:break}})},m=function(){if(B.length>0){clearTimeout(l);l=setTimeout(function(){g()},10)}};g();if(!k.offsetParent){b(window).bind("scroll",function(){m()}).bind("reset",function(){m()}).bind("resize",function(){m()})}else{b(k.offsetParent).bind("scroll",function(){m()})}}})(jQuery)
!function(a){a.fn.ladySlide=function(b){var c=a.extend({autoPlay:!0,delayTime:5500,interTime:600,trigger:0,triggerEvent:1,defaultIndex:0,panle:"#panle",prev:"#prev",next:"#next",startSlide:null,endSlide:null},b||{});return this.each(function(){function r(){o&&clearInterval(o),o=setInterval(function(){m=d,m++,t(m)},c.delayTime)}function s(){o&&clearInterval(o)}function t(a){n=0;var b=a;a==l&&(b=0),-1==a&&(b=l-1),0!=c.trigger&&e.children().eq(b).addClass("active").siblings().removeClass("active"),f.children().eq(b+1).addClass("active").siblings().removeClass("active"),"function"==typeof c.startSlide&&c.startSlide(f,a),f.stop(!0,!1).animate({left:-a*k},c.interTime,function(){a==l&&(f.css({left:0}),a=0),-1==a&&(f.css({left:-1*(l-1)*k}),a=l-1),n=1,d=a,"function"==typeof c.endSlide&&c.endSlide(f,a)})}var e,m,o,p,q,b=a(this),d=c.defaultIndex,f=b.find(c.panle),g=f.children(),h=b.find(c.prev),i=b.find(c.next),k=(f.parent().height(),f.parent().width()),l=f.children().length,n=1;1==c.trigger?(q='<div class="trigger">',f.children().each(function(a){q+=d==a?'<span class="active">'+(a+1)+"</span>":"<span>"+(a+1)+"</span>"}),q+="</div>",f.parent().after(q),e=b.find(".trigger")):null!=c.trigger&&0!=c.trigger&&(e=a(c.trigger,b)),f.prepend(g.eq(l-1).clone().css("marginLeft",-k)),f.append(g.eq(0).clone()),f.css({width:k*(l+2),left:-d*k}),g.eq(d).addClass("active"),c.autoPlay&&r(),0!=c.trigger&&e.children().bind("mouseenter",function(){if(s(),1==c.triggerEvent){var b=a(this).index();p=setTimeout(function(){t(b)},200)}}).bind("mouseleave",function(){c.autoPlay&&r(),p&&clearTimeout(p)}).bind("click",function(){2==c.triggerEvent&&t(a(this).index())}),h.click(function(){return n?(m=d,m--,t(m),void 0):!1}),i.click(function(){return n?(m=d,m++,t(m),void 0):!1}),f.bind("mouseenter",function(){s()}).bind("mouseleave",function(){c.autoPlay&&r()}),h.bind("mouseenter",function(){s()}).bind("mouseleave",function(){c.autoPlay&&r()}),i.bind("mouseenter",function(){s()}).bind("mouseleave",function(){c.autoPlay&&r()})})}}(jQuery);

var browser = {
    isIE6:$.browser.msie && $.browser.version == "6.0" && !$.support.style,
    isIE7:$.browser.msie && $.browser.version == "7.0",
	isIE8:$.browser.msie && $.browser.version == "8.0"
};
var fadeSpeed=600;
if(browser.isIE6||browser.isIE7||browser.isIE8){ fadeSpeed=0;}

var lazyload2 = function(a, b) {
    if (typeof a.attr(b) != "undefined") {
        a.attr("src", a.attr(b));
        a.removeAttr(b);
    }
};

var lady = {};
lady.tab = function(a, b, c, f) {
    var d = ".item", e = "active";
    $(a).children(d).bind(c, function() {
        var a = $(this), g=$(b).children(d).eq(a.index());
        a.addClass(e).siblings(d).removeClass(e), g.addClass(e).siblings(d).removeClass(e);
		if(f==1){
		g.siblings(d).stop(true, false).animate({opacity:0}, fadeSpeed, function(){ g.siblings(d).css({display:"none"})});
		g.css({display:"block"}).stop(true, false).animate({opacity:1}, fadeSpeed);
		}
		$(b).children(d).find("img").each(function(){
			lazyload2($(this), "data-src2");
		})
    })
};


var date=new Date();
var week=date.getDay();
var $tabnav=$(".tabnav li"),$tabcon=$(".tabcontent li");
var index=0;
if(week==2 || week==6)
    index=1;
else if(week==3 || week==0)
    index=2;
else if(week==4)
    index=3;

$($tabcon[0]).attr("class","item");
$($tabnav[0]).attr("class","item");
$($tabcon[index]).attr("class","item one active");
$($tabnav[index]).attr("class","item active");


$(function() {
 
$("img[data-src2]").lazyload({type:"image",placeholderClass:"loading"}); 

var focusLen=$("#focus li").length;
$(".copy-2").html($("#focus li:eq(1)").html());
$(".copy-1").html($("#focus li").eq(focusLen-2).html());

var lazyload3 = function(obj) {
    $(".m-hd").each(function() {
        var ele = $(this);
        if (obj + 1000 > ele.offset().top && !ele.hasClass("checked")) {
            ele.addClass("checked");
            $(this).find("img").each(function() {
                var a = $(this);
                if (typeof a.attr("data-src3") != "undefined") {
                    a.attr("src", a.attr("data-src3"));
                    a.removeAttr("data-src3");
                }
            });
        }
    });
};
lazyload3($("#backtotop").offset().top);

$("#focus").ladySlide({
    prev:".focus-prev",
    next:".focus-next",
    trigger:"#focus-trigger",
    autoPlay:true,
    startSlide:function(ele, index) {
        if (index == -1) {
            index = focusLen-1;
        } else if (index == focusLen) {
            index = 0;
        }
        $(".trigger-cover").stop(true, false).animate({left:$("#focus .trigger span").eq(index).position().left}, 500);
    }
});

$(".m-hd .s").ladySlide({
    trigger:".trigger",
    panle:".panle ul",
    autoPlay:true
});
$(".m-hd .f").ladySlide({
    trigger:".control",
    panle:".pic ul",
    autoPlay:true,
    delayTime:5000,
    startSlide:function(ele, index) {
        $(".title", ele.parent().parent()).find("a").eq(index-1).css("display", "none").siblings().css("display", "block");
    }
});


if($("#missamy").length>0){
$("#missamy").ladySlide({
    panle:".panle ul",
    autoPlay:true,
    next:".mnext"
});
}

$("#missamy").hover(function() {
    $("#missamy").find(".mnext").stop(true, true).fadeIn(500);
}, function() {
    $("#missamy").find(".mnext").stop(true, true).fadeOut(500);
});

$(".missamy .close").click(function(){
    $(this).parent().css("display", "none");
})

$(".carousel").carousel({
        carouselWidth:750,
        carouselHeight:282,
		frontWidth:280,
        frontHeight:280,
		hMargin:1.09,
		backZoom:.71,
		slidesPerScroll:3,
		autoplay:true,
		directionNav:true
});
		  
 
$(".pic-style").hover(function() {
    $(this).prepend('<div class="cover"><b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b></div>');
}, function() {
    var a = $(this).children(".cover");
    a.length && a.remove();
});


    var tip = $(".sort li .tip");
    tip.each(function() {
        var a = $(this);
        a.css({left:a.data("l"), top:a.data("t") + 48});
    });
    tip.hover(function() {
        $(this).stop(true, false).animate({width:220}, 500).children("span").css("display", "block");
		$(this).parent().addClass("active");
    }, function() {
        var a = $(this);
        a.stop(true, false).animate({width:15}, 500, function() {
            a.children("span").css("display", "none");
			a.parent().removeClass("active");
        });
    });

	lady.tab(".bbs-tab .m-trigger", ".bbs-tab .panle", "mouseover");
	lady.tab(".tool-item .trigger", ".tool-item .panle", "mouseover");
	lady.tab(".bea-pro .m-trigger", ".bea-pro .panle", "mousedown");
	lady.tab("#three #control", "#three .panle", "mousedown", 1);
	lady.tab(".tabnav ul", ".tabcontent", "mouseover", 1);


var kuIndex=1;
$(".ku-com .ku-tit .title").click(function() {
    var ele = $(".ku-com .ku-item .item"), t1 = $(".ku-com .ku-tit .title1"), t2 = $(".ku-com .ku-tit .title2");
    if (kuIndex == 1) {
        $(this).html('<span>奢侈品库<i class="i2"></i></span>').stop(true, false).animate({top:185}, 400);
        t2.css("top", 250);
        t1.stop(true, false).animate({top:0}, 600);
        ele.eq(0).stop(true, false).animate({opacity:0}, fadeSpeed, function() {ele.eq(0).css({display:"none"});});
        ele.eq(1).css({display:"block"}).stop(true, false).animate({opacity:1}, fadeSpeed);
		ele.eq(1).children(".pic-style").each(function(){
			lazyload2($(this).find("img"), "data-src1");	   
		})
        kuIndex = 2;
    } else if (kuIndex == 2) {
        $(this).html('<span>化妆品库<i class="i1"></i></span>').stop(true, false).animate({top:0}, 400);
        t1.css("top", -155);
        t2.stop(true, false).animate({top:100}, 600);
        ele.eq(1).stop(true, false).animate({opacity:0}, fadeSpeed, function() {ele.eq(1).css({display:"none"});
        });
        ele.eq(0).css({display:"block"}).stop(true, false).animate({opacity:1}, fadeSpeed);
        kuIndex = 1;
    }
});

var team = function() {
    var a = 1, b = true;
    var c = function() {
        if (b) {
            b = false;
            if (a == 2) {a = 0;}
            $(".team ul").stop(true, false).animate({left:-300 * a}, 500, function() {b = true;});
            a++;
        }
    };
    return {
        play:c
    };
}();
$("#team .change").click(function() {
	team.play();
});

var setime1;
$(".sort-fas .s3 li").hover(function() {
    var a = $(this);
	if(!a.hasClass("active")){
    setime1 = setInterval(function() {
        clearInterval(setime1);
        a.addClass("active");
        a.stop().animate({width:326}, 500).siblings().stop().animate({width:151}, 500, function() {
            a.siblings().removeClass("active");
        });
    }, 100);
	}
}, function() {
   if (setime1) clearInterval(setime1);
});



$(window).scroll(function() {
	var rollTop=$(document).scrollTop(); 
    if (rollTop > 300) {
        if (browser.isIE6) {
            topbar.css("display", "block");
        } else {
            topbar.stop(true, false).animate({top:0}, 50);
        }
    } else {
        if (browser.isIE6) {
            topbar.css("display", "none");
        } else {
            topbar.stop(true, false).animate({top:-58}, 50);
        }
    }
	
	lazyload3(rollTop);
});





});

var topbar=$("#topbar");
$(".topbar .nav2 li").hover(function(){
	$(this).stop(true, false).animate({width:180}, 500);
	$(this).find("dd").fadeIn(200);
},function(){
	$(".topbar .nav2 li").stop(true, false).animate({width:70}, 500);
	$(".topbar .nav2 dd").fadeOut(200);
})





var foodInp=$('#food-input');
function search_product() {
    var k = foodInp.val();
    if(k == ''){
		foodInp.focus();
        return false;
		}
    k = $.trim(k);
    k = k.replace(/\//g, '').replace(/\\/g, '');
    var _action = '';
    if($(".food-therapy .select_txt").attr("data-value")==2){
        _action = "http://food.lady8844.com/s/t_0/k_"+encodeURIComponent(k)+"/se_/m_/c_/";
    }else{
        _action = "http://food.lady8844.com/diy/p_/h_/c_/r_/a_/t_/o_/s_/f_/i_/u_/y_/k_"+encodeURIComponent(k)+"/";
    }
    if(_action != ''){
        window.open(_action);
    }
}

foodInp.bind('keydown', function (e) {
    var key = e.which;
    if (key == 13) {
        search_product();
    }
});



$(".select_box").click(function(e) {
    e.stopPropagation();
    $(this).find(".option").toggle();
    $(this).toggleClass("select_index");
    $(this).parent().siblings().find(".option").hide();
    $(this).parent().siblings().find(".select_box").removeClass("select_index");
});
$(document).click(function(e) {
    var eo = $(e.target);
    if ($(".select_box").is(":visible") && eo.attr("class") != "option" && !eo.parent(".option").length) $(".option").hide();
});
var hot_num = 150;
$(".option a").click(function() {
    var value = $(this).text();
    var data_val=$(this).attr('data-value');
    $(this).parent().siblings(".select_txt").text(value);
    $("#select_value").val(value);
    hot_num = $(this).attr("title");
    if(typeof data_val != "undefined"){
        $(this).parent().siblings(".select_txt").attr({
            'data-value':data_val
        });
    }
});



$("#J_searchInput .search-button").click(function(e) {
    e.stopPropagation();
    var param='';
    var s=$('#J_searchInput .select_txt').attr("data-value");
    if(s!=null && s!=''){
        param='?s='+s;
    }
    window.open('http://fitness.lady8844.com/method/'+param);
});

$("#hot_search").click(function() {
    var txt = $("#hot_item").html();
    var hour = $("#key-heat1").val();
    if (hour == "") {
        alert("请输入运动时间，以小时为单位！");
        $("#key-heat1").focus();
        return
    }
    var val = hot_num * hour;
    alert("您做的运动是：" + txt + "\r\n运动的时间是：" + hour + "小时\r\n您消耗的热量是：" + val + "千焦")
});
$("#key-heat2").keydown(function(e){
    var e = e || event,
    keycode = e.which || e.keyCode;
    if (keycode==13) {
        var foot = document.getElementById('key-heat2').value;
        if (foot!='请输入食物名字' && foot!='') {
            var foot1 = encodeURI(foot);
            window.open('http://fitness.lady8844.com/rlcx?k='+foot1);
        }
    }
});
$("#food_search").click(function() {
    var txt = $("#key-heat2").val();
    if (txt.length == 0) {
        alert("请输入食物名称！");
        return
    }

    var foot = document.getElementById('key-heat2').value;
    if (foot!='请输入食物名字' && foot!='') {
        var foot1 = encodeURI(foot);
        window.open('http://fitness.lady8844.com/rlcx?k='+foot1);
    }

var val = 0;
switch(txt){case"VC饼干":val=5720;break;case"艾窝窝":case"松花蛋(鸭)":case"瓦罐鸡汤(肉)":case"猪耳":val=1900;break;case"鹌鹑":val=1896.6;break;case"螯虾":val=3000;break;case"八爪鱼":val=1730.8;break;case"巴梨":val=582.3;break;case"芭蕉":val=1602.9;break;case"鲅鱼":val=1525;break;case"白菜苔":val=297.6;break;case"白豆角":case"草莓":val=309.3;break;case"白姑鱼":val=2238.8;break;case"白果":val=3550;break;case"白兰瓜":val=381.8;break;case"白木耳":val=2083.3;break;case"白萝卜":val=210.5;break;case"白葡萄酒":case"蟹肉":val=620;break;case"白薯":val=1209.3;break;case"白薯干":case"红薯干":case"地瓜干":case"油炸土豆片":case"薯片":case"油炸土豆片/薯片":case"白薯干/红薯干/地瓜干":val=6120;break;case"叉叉":val=10000;break;case"白水羊头":val=1930;break;case"白芸豆":case"绿茶":val=2960;break;case"白芝麻":val=5170;break;case"蚌肉":val=1127;break;case"鲍鱼":val=1292.3;break;case"北豆腐":val=980;break;case"啤酒":case"苦菜":val=350;break;case"荸荠":val=756;break;case"比目鱼":val=1486.1;break;case"边鱼":val=1771.4;break;case"鳊鱼":case"武昌鱼":case"鳊鱼/武昌鱼":val=2288.1;break;case"扁豆":val=406.6;break;case"标准粉":case"桂花藕粉":case"莲子":val=3440;break;case"冰棍":case"鸭蛋白":val=470;break;case"冰淇淋":val=1260;break;case"冰糖":case"麻烘糕":case"酸三色糖":val=3970;break;case"奶油饼干":case"麦乳精":val=4290;break;case"冰砖":case"素大肠":case"虾皮":case"薰干":val=1530;break;case"白兰瓜":val=381.8;break;case"白木耳":val=2083.3;break;case"白萝卜":val=210.5;break;case"菠菜":val=269.7;break;case"菠萝":val=602.9;break;case"菠萝豆":val=3920;break;case"菜干":case"甜面酱":case"乌鸦肉":val=1360;break;case"菜瓜":val=204.5;break;case"菜花":val=292.7;break;case"菜籽油":case"茶油":case"豆油":case"花生油":case"葵花籽油":case"棉籽油":val=8990;break;case"蚕豆干":case"荞麦粉":case"铁观音":val=3040;break;case"蚕豆":val=3354.8;break;case"草菇":val=230;break;case"草莓":case"白豆角":val=309.3;break;case"草莓酱":val=2690;break;case"草鱼":val=1391;break;case"叉烧肉":case"蒜肠":val=2970;break;case"茶肠":case"杏脯":val=3290;break;case"长茄子":val=197.9;break;case"炒肝":val=960;break;case"蛏子":val=701.8;break;case"橙子":val=635.1;break;case"臭豆腐":case"醋":val=1300;break;case"春卷":case"硬皮糕点":case"慈姑":val=4630;break;case"大白菜":val=180.7;break;case"大葱":val=365.9;break;case"大红菇":val=20005;break;case"大黄米":case"绿豆糕":val=3490;break;case"大黄鱼":val=1454.5;break;case"大腊肠":val=2670;break;case"大麻哈鱼":val=1986.1;break;case"大麻油":case"鸭油":case"猪油":val=8970;break;case"大麦":val=3070;break;case"大肉肠":case"酱羊肉":val=2720;break;case"大蒜":val=1482.4;break;case"大头菜":case"强化牛奶":val=510;break;case"大叶芥菜":case"盖菜":case"大叶芥菜/盖菜":val=197.2;break;case"大枣":val=3386.4;break;case"带鱼":val=1671.1;break;case"淡菜":val=1632.4;break;case"蛋糕":case"挂面":case"机米":case"玉米糁":val=3470;break;case"蛋黄酥":case"山楂精":case"油条":val=3860;break;case"蛋麻脆":val=4520;break;case"蛋清肠":val=2780;break;case"刀豆":case"李子杏":val=380.4;break;case"堤鱼":val=2984.4;break;case"地瓜粉":case"白薯粉":case"红薯粉":case"地瓜粉/白薯粉/红薯粉":case"卤干":case"苹果脯":case"玉米":val=3360;break;case"土豆粉":case"粉条":val=3370;break;case"冬菜":case"米粥":case"杏仁露":val=460;break;case"冬菇":val=2465.1;break;case"冬瓜":val=137.5;break;case"冬果梨":val=425.3;break;case"冬寒菜":val=517.2;break;case"豆瓣酱":val=1780;break;case"豆瓣辣酱":case"无花果":case"羊奶":val=590;break;case"豆腐干":case"桂圆":case"水面筋":val=1400;break;case"豆腐脑":case"豆汁":val=100;break;case"豆腐皮":val=4090;break;case"豆腐丝":case"豆浆粉":case"莲子糖水":val=2010;break;case"豆鼓":case"油豆腐":val=2440;break;case"豆浆":val=130;break;case"豆角":val=312.5;break;case"豆奶":case"酱萝卜":val=300;break;case"豆沙":val=2430;break;case"对虾":val=1524.6;break;case"鹅":val=3888.9;break;case"鹅蛋白":val=480;break;case"鹅肝":val=1290;break;case"鹅油卷":val=4610;break;case"鹅肫":val=1000;break;case"红豆馅":case"腭针鱼":case"三鲜豆皮":val=2400;break;case"二锅头":val=3520;break;case"发菜":case"酱牛肉":case"腊羊肉":case"全麦面包":val=2460;break;case"番茄酱":val=810;break;case"番石榴":val=422.7;break;case"方便面":case"奶片":val=4720;break;case"方腿":val=1170;break;case"非洲黑鲫鱼":val=1452.8;break;case"肥猪肉":val=8160;break;case"粉皮":case"甘蔗汁":val=640;break;case"粉丝":val=3350;break;case"风干肠":val=2830;break;case"蜂蜜":case"果丹皮":val=3210;break;case"凤尾酥":val=5110;break;case"麸皮":val=2200;break;case"茯苓夹饼":case"炼乳":case"碗糕":val=3320;break;case"福橘":val=671.6;break;case"福来酥":val=4650;break;case"腐乳":case"鸡胸脯肉":case"豌豆黄":val=1330;break;case"腐竹":val=4590;break;case"腐竹皮":val=4890;break;case"富强粉":case"通心粉":val=3500;break;case"钙奶饼干":val=4440;break;case"干蚕豆":val=3677.4;break;case"干红果":val=1520;break;case"干姜":val=2873.7;break;case"干豌豆":case"桂圆肉":val=3130;break;case"干枣":case"绿豆面":val=3300;break;case"橄榄":val=612.5;break;case"高粱米":val=3510;break;case"鸽":val=4785.7;break;case"公麻鸭":val=5714.3;break;case"狗母鱼":val=1492.5;break;case"狗肉":val=1450;break;case"枸杞菜":case"色拉油":case"香油":val=898;break;case"灌肠":case"羊肝":val=1340;break;case"桂林腐乳":val=2040;break;case"桂鱼":val=1918;break;case"桂圆干":val=7378.4;break;case"果料酸奶":case"酸豆乳":val=670;break;case"果味奶":case"芦笋":val=200;break;case"哈密瓜":val=478.9;break;case"海参":case"酱油":val=710;break;case"海带":val=785.7;break;case"海鲫鱼":val=3433.3;break;case"海蛎肉":val=660;break;case"海鳗":val=1820.9;break;case"海米":val=1950;break;case"海棠":val=848.8;break;case"海棠脯":case"杏酱":val=2860;break;case"海虾":val=1549;break;case"海蟹":val=1727.3;break;case"海蛰皮":val=330;break;case"蚶子":val=2629.6;break;case"旱芹":val=212.1;break;case"合锦菜":val=750;break;case"河蚌":val=1565.2;break;case"河鳗":val=2154.8;break;case"河虾":val=976.7;break;case"河蚬":val=1342.9;break;case"河蟹":val=2452.4;break;case"核桃":val=14581.4;break;case"核桃薄脆":val=4800;break;case"荷兰豆":case"蓟菜":val=306.8;break;case"黑豆":val=3810;break;case"黑麻香酥":case"鸡腿酥":case"酥糖":val=4360;break;case"黑米":case"煎饼":val=3330;break;case"黑木耳":val=2050;break;case"黑洋酥":val=4170;break;case"黑枣":val=2326.5;break;case"黑芝麻":val=5310;break;case"红菜苔":val=557.7;break;case"红茶":val=2940;break;case"红果":val=1250;break;case"红果肠":val=2600;break;case"红橘":val=512.8;break;case"红螺":val=2163.6;break;case"红葡萄酒":case"红酒":case"红葡萄酒/红酒":case"火鸡肫":val=910;break;case"红薯":val=1100;break;case"红糖":val=3890;break;case"红小豆":case"甲级龙井":val=3090;break;case"红肖梨":val=344.8;break;case"红芸豆":case"石花菜":val=3140;break;case"红鳟鱼":val=1736.8;break;case"胡椒粉":case"薏米":val=3570;break;case"胡萝卜":val=443.3;break;case"胡麻油":case"辣椒油":val=4500;break;case"胡子鲇":val=2920;break;case"胡子鲇":val=2920;break;case"葫芦":val=160.9;break;case"虎皮芸豆":val=3340;break;case"花茶":val=2810;break;case"花卷":val=2170;break;case"花生":val=8295.8;break;case"花生酱":val=5940;break;case"黄豆":val=3590;break;case"黄豆粉":val=4180;break;case"黄豆芽":val=440;break;case"黄姑鱼":val=2111.1;break;case"黄瓜":val=163;break;case"黄花菜":val=2030.6;break;case"黄酱":case"猪脑":val=1310;break;case"黄米":val=3420;break;case"黄蘑":val=1865.2;break;case"黄鳍鱼":val=2384.6;break;case"黄鳝":val=693.2;break;case"黄桃":val=580.6;break;case"黄油":val=8920;break;case"黄油渣":val=5990;break;case"茴香":val=279.1;break;case"混糖糕点":val=4530;break;case"火鸡肝":case"鸭心":val=1430;break;case"火鸡腿":case"鸭胸脯肉":case"羊肾":val=900;break;case"火腿":case"面包":val=3180;break;case"火腿肠":case"珍珠白蘑":val=2120;break;case"鸡翅":val=2811.6;break;case"鸡蛋":val=1586.2;break;case"鸡蛋白":case"萝卜干":case"苜蓿":val=600;break;case"鸡肝":case"烤麸":val=1210;break;case"鸡肉":val=3878.8;break;case"鸡肉松":val=4400;break;case"鸡汤":case"苏打饼干":val=4080;break;case"鸡腿":val=2623.2;break;case"鸡心":val=1720;break;case"鸡血":case"桑葚":val=490;break;case"鸡胗":val=1180;break;case"鸡爪":val=4233.3;break;case"基围虾":val=1683.3;break;case"蓟菜":val=306.8;break;case"鲫鱼":val=2000;break;case"尖嘴白":val=1712.5;break;case"减肥笋瓜":val=131.9;break;case"江米":case"粳米":case"籼米":val=3480;break;case"江米条":val=4390;break;case"豇豆":val=299;break;case"酱豆腐":case"牛蹄筋":val=1510;break;case"酱黄瓜":val=240;break;case"酱驴肉":case"泥鳅":val=1600;break;case"酱苤蓝丝":case"巧克力豆奶":val=390;break;case"酱鸭":val=3325;break;case"酱汁肉":val=5718.8;break;case"茭白":val=310.8;break;case"茭笋":val=324.7;break;case"焦圈":val=5440;break;case"芥蓝":val=243.6;break;case"芥末":val=4760;break;case"金橘":case"猪血":val=550;break;case"金丝小枣":val=3975.3;break;case"金线鱼":case"豌豆":val=2500;break;case"金针菇":case"柠檬汁":val=260;break;case"京八件":case"状元饼":val=4350;break;case"京白梨":val=683.5;break;case"京式黄酥":case"油面筋":val=4900;break;case"韭菜":val=288.9;break;case"韭黄":case"腌雪里红":val=250;break;case"酒枣":val=1593.4;break;case"橘子汁":case"银鱼":val=1190;break;case"蕨菜":case"驴肉":val=2510;break;case"开花豆":val=4460;break;case"开口笑":val=5120;break;case"烤鸡":val=3287.7;break;case"烤鸭":val=5450;break;case"可可粉":case"无核蜜枣":val=3200;break;case"肯德基炸鸡":val=3985.7;break;case"空心菜":val=263.2;break;case"口蘑":val=2420;break;case"口头鱼":val=2392.9;break;case"苦瓜":val=234.6;break;case"快鱼":val=2239.4;break;case"葵花子":val=11846.2;break;case"葵花子仁":val=6060;break;case"腊肠":val=5840;break;case"腊肉":val=1810;break;case"辣酱(麻)":val=1350;break;case"辣椒":val=2409.1;break;case"辣椒糊":case"芹菜叶":val=310;break;case"辣萝卜条":case"凉粉":val=370;break;case"辣油豆瓣酱":val=1840;break;case"烙饼":val=2550;break;case"李子":val=395.6;break;case"李子杏":val=380.4;break;case"鲤鱼":val=2018.5;break;case"荔枝":val=958.9;break;case"栗羊羹":val=3010;break;case"栗子":val=4726;break;case"鲢鱼":val=1672.1;break;case"鲮鱼":val=1666.7;break;case"龙虾":val=1956.5;break;case"芦柑":val=558.4;break;case"鲈鱼":val=1724.1;break;case"卤猪杂":val=1860;break;case"卤煮鸡":val=3028.6;break;case"驴打滚":val=1940;break;case"绿豆":case"杂豆":val=3160;break;case"绿豆芽":val=180;break;case"罗非鱼":val=1781.8;break;case"麻花":val=5240;break;case"麻香糕":val=4010;break;case"马肉":val=1220;break;case"麦穗鱼":val=1333.3;break;case"馒头":val=2330;break;case"芒果":val=533.3;break;case"毛豆":val=2320.8;break;case"毛竹笋":val=313.4;break;case"梅童鱼":val=1793.7;break;case"美味香酥卷":val=3680;break;case"猕猴桃":val=674.7;break;case"米粉":case"香米":val=3460;break;case"米花糖":val=3840;break;case"密云小枣":val=2326.1;break;case"蜜橘":val=552.6;break;case"蜜麻花":case"燕麦片":val=3670;break;case"蜜桃":val=465.9;break;case"绵白糖":case"猪肉松":val=3960;break;case"面包鱼":val=1596.2;break;case"面西胡瓜":val=113.6;break;case"明太鱼":val=1955.6;break;case"明虾":val=1491.2;break;case"墨鱼":val=1188.4;break;case"母麻鸭":val=6146.7;break;case"母乳":case"猪小肠":val=650;break;case"牡蛎":val=730;break;case"木耳菜":val=263.2;break;case"木瓜":val=314;break;case"奶豆腐":case"西瓜脯":val=3050;break;case"奶疙瘩":case"酥皮糕点":val=4260;break;case"奶酪":val=3280;break;case"奶皮子":val=4600;break;case"奶糖":case"香油炒面":val=4070;break;case"奶油":val=7200;break;case"南瓜":val=258.8;break;case"南瓜子":val=8441.2;break;case"年糕":val=1540;break;case"鲇鱼":val=1569.2;break;case"柠檬":val=530.3;break;case"柠檬汽水":val=380;break;case"牛肚":case"酸奶":val=720;break;case"牛肺":case"油茶":val=940;break;case"牛肝":val=1390;break;case"牛俐生菜":val=185.2;break;case"牛奶":val=540;break;case"牛奶粉":val=5100;break;case"全脂牛奶粉":val=4780;break;case"牛肉干":val=5500;break;case"牛肉辣瓣酱":val=1270;break;case"牛肉松":val=4450;break;case"牛舌":val=1960;break;case"牛油":val=8350;break;case"藕":val=795.5;break;case"藕粉":val=3720;break;case"泡泡糖":val=5294.1;break;case"枇杷":val=629;break;case"郫县辣酱":val=890;break;case"琵琶虾":val=2531.3;break;case"片口鱼":val=1544.1;break;case"苤蓝":val=384.6;break;case"平菇":val=215.1;break;case"平鱼":val=2028.6;break;case"苹果":val=702.4;break;case"苹果酱":val=2770;break;case"苹果梨":val=510.6;break;case"葡萄":val=595.2;break;case"葡萄干":val=3410;break;case"普中红蘑":val=2140;break;case"起酥":val=4990;break;case"汽水(特制)":val=420;break;case"巧克力":val=5860;break;case"茄子":val=277.8;break;case"芹菜":val=298.5;break;case"青萝卜":val=326.3;break;case"青蒜":val=357.1;break;case"青鱼":val=1841.3;break;case"琼脂":val=3110;break;case"曲奇饼":val=5460;break;case"人参果":val=909.1;break;case"肉鸡":val=5256.8;break;case"沙丁鱼":val=1313.4;break;case"沙鸡":val=3585.4;break;case"沙梭鱼":val=1694.4;break;case"沙枣":val=4878;break;case"鲨鱼":val=1964.3;break;case"山药":val=674.7;break;case"南乳":val=1380;break;case"烧饼":val=3260;break;case"烧鹅":val=3958.9;break;case"烧麦":case"汤包":val=2380;break;case"生菜":val=138.3;break;case"生蚝":case"脱脂酸奶":case"羊血":case"南豆腐":val=570;break;case"石斑鱼":val=1491.2;break;case"石榴":val=1105.3;break;case"柿饼":val=2577.3;break;case"柿子":val=816.1;break;case"柿子椒":val=268.3;break;case"双孢蘑菇":val=226.8;break;case"水发木耳":val=210;break;case"水芹":val=216.7;break;case"丝瓜":val=241;break;case"四季豆":val=291.7;break;case"松蘑":val=1120;break;case"松子":val=19967.7;break;case"松子仁":val=6980;break;case"酥梨":val=597.2;break;case"素火腿":val=2110;break;case"素鸡":val=1920;break;case"素什锦":val=1730;break;case"素虾":val=5760;break;case"酸菜":val=140;break;case"酸梅精":val=3940;break;case"蒜黄":val=216.5;break;case"蒜苗":val=451.2;break;case"梭子蟹":val=1938.8;break;case"苔菜":val=1480;break;case"鲐鱼":val=2348.5;break;case"糖蒜":val=1540.5;break;case"桃":val=516.9;break;case"桃脯":val=3100;break;case"桃酱":val=2730;break;case"桃酥":val=4810;break;case"田螺":val=2307.7;break;case"甜菜":val=833.3;break;case"甜辣黄瓜":val=990;break;case"填鸭":val=5653.3;break;case"茼蒿":val=256.1;break;case"土豆":val=808.5;break;case"土鸡":val=2137.9;break;case"兔肉":val=1020;break;case"豌豆苗":val=295.9;break;case"维夫饼干":val=5280;break;case"味精":val=2680;break;case"莴笋":val=225.8;break;case"莴笋叶":val=202.2;break;case"乌骨鸡":val=2312.5;break;case"乌鱼蛋":val=904.1;break;case"乌枣":val=3864.4;break;case"乌贼":case"猪肺":val=866;break;case"午餐肠":val=2610;break;case"午餐肉":val=2290;break;case"西瓜":val=576.3;break;case"西瓜子":val=13325.6;break;case"西红柿":val=195.9;break;case"西葫芦":val=246.6;break;case"西兰花":case"绿菜花":case"西兰花/绿菜花":val=397.6;break;case"西洋菜/豆瓣菜":val=232.9;break;case"喜乐":val=530;break;case"喜鹊肉":val=1280;break;case"鲜贝":val=770;break;case"鲜赤贝":val=1794.1;break;case"鲜姜":val=431.6;break;case"鲜蘑":val=202;break;case"鲜扇贝":val=1714.3;break;case"鲜玉米":val=2304.3;break;case"鲜枣":val=1402.3;break;case"咸肉":case"莜麦面":val=3850;break;case"苋菜":val=424.7;break;case"香菜":val=382.7;break;case"香肠":val=5080;break;case"香椿":val=618.4;break;case"香干":val=1470;break;case"香菇":val=2221.1;break;case"香瓜":val=333.3;break;case"香海螺":val=2762.7;break;case"香蕉":val=1542.4;break;case"小白菜":val=185.2;break;case"小葱":val=328.8;break;case"小豆粥":val=610;break;case"小肚":case"羊舌":val=2250;break;case"小红肠":case"炸糕":val=2800;break;case"小黄花鱼":val=1571.4;break;case"小米":val=3580;break;case"小泥肠":val=2950;break;case"小水萝卜":val=287.9;break;case"小叶芥菜":val=272.7;break;case"小叶橘":val=469.1;break;case"心里美萝卜":val=238.6;break;case"杏":val=395.6;break;case"杏丁蘑":case"紫菜":val=2070;break;case"杏仁":val=5140;break;case"雪花梨":val=476.7;break;case"雪里红":val=255.3;break;case"血糯米":val=3430;break;case"鸭":val=3529.4;break;case"鸭翅":val=2179.1;break;case"鸭肝":case"喜鹊肉":val=1280;break;case"鸭广梨":val=657.9;break;case"鸭梨":val=524.4;break;case"鸭皮":case"芝麻南糖":val=5380;break;case"鸭舌":val=4016.4;break;case"鸭血":val=580;break;case"鸭掌":val=2542.4;break;case"鸭肫":val=989.2;break;case"盐水鸭":val=3851.9;break;case"羊大肠":val=700;break;case"羊肚":val=870;break;case"羊角豆":val=420.5;break;case"全脂羊奶粉":val=4980;break;case"羊脑":val=1420;break;case"羊肉串":val=2340;break;case"羊肉干":val=5880;break;case"羊心":val=1130;break;case"羊油":val=8240;break;case"杨梅":val=341.5;break;case"杨桃":val=329.5;break;case"洋葱":val=433.3;break;case"椰子":val=7000;break;case"野兔肉":val=840;break;case"樱桃":val=575;break;case"油饼":val=3990;break;case"油菜":val=264.4;break;case"油菜苔":val=215.1;break;case"油豆角":val=222.2;break;case"油炸豆瓣":val=4050;break;case"油炸豆花":val=4000;break;case"柚子":val=594.2;break;case"鱿鱼":val=765.3;break;case"鱼子酱":val=2520;break;case"榆钱":val=360;break;case"玉兰片":val=430;break;case"玉米面":val=3400;break;case"玉米油":val=8950;break;case"芋头":val=940.5;break;case"圆白菜":val=255.8;break;case"月饼":val=4280;break;case"芸豆":val=260.4;break;case"榨菜":val=290;break;case"章鱼":val=520;break;case"榛蘑":val=2039;break;case"榛子":val=28285.7;break;case"芝麻酱":val=6180;break;case"猪大肠":val=1910;break;case"猪大排":val=3882.4;break;case"猪肚":val=1145.8;break;case"猪肝":val=2030;break;case"猪口条":val=2478.7;break;case"猪排骨":val=3861.1;break;case"猪瘦肉":val=5916.7;break;case"猪蹄":val=4433.3;break;case"猪蹄筋":val=1560;break;case"猪心":val=1226.8;break;case"猪腰子":val=1032.3;break;case"猪肘棒":val=3701.5;break;case"竹笋":val=2802.6;break;case"竹笋/鞭笋":val=244.4;break;case"竹笋/春笋":val=303;break;case"砖茶":val=2060;break;case"紫皮大蒜":val=1528.1;break;case"紫雪糕":val=2280;break;case"雪梨":val=476.7;break;default:val="nothing";break}});
