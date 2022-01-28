$(document).ready(function () {
    var theHeight = $(window).height();
    var pos = 1;
    var count = $("#mainFrame > div").length;

    var upBool = true;
    var downBool = true;
    var waitTime = 1000;
    var animateTime = 750;

    $( window ).resize( function() {
        theHeight = $(window).height();
        var currentPositionPercent = theHeight * 0.2;
        var upPositionPercent = theHeight * -0.8;
        var downPositionPercent = theHeight * 1.2;
        for (var index = 1; index <= count; index++) {
            if (index < pos) {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: upPositionPercent}, 0);
            } else if (index === pos) {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: currentPositionPercent}, 0);
            } else {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: downPositionPercent}, 0);
            }
        }
    });


    $("html").on('mousewheel',function(e){
        var wheel = e.originalEvent.wheelDelta;
        if(wheel > 0){
            if (upBool) {
                upButtonFunction.call($("#upButton"));
            }

        } else {
            if (downBool) {
                downButtonFunction.call($("#downButton"));
            }
        }
    });

    function upButtonFunction() {
        upBool = false;
        goUp();
        setTimeout($.proxy(function () {
            upBool = true;
        }, this), waitTime);
    }

    $("#upButton").on("click", function() {
        if (upBool) {
            upButtonFunction.call(this);
        }

    });

    function downButtonFunction() {
        downBool = false;
        goDown();
        setTimeout($.proxy(function () {
            downBool = true;
        }, this), waitTime);
    }

    $("#downButton").on("click", function () {
        if (downBool) {
            downButtonFunction.call(this);
        }
    });

    $("#topButton").on("click", function () {
        goToTop();
    });

    function goDown() {
        if (pos < count) {
            $('#mainFrame > div:nth-child('+pos+')').animate({top: "-=" + theHeight}, animateTime);
            $('#mainFrame > div:nth-child('+pos+')').fadeOut(100);
            pos++;
            $('#mainFrame > div:nth-child('+pos+')').fadeIn(100);
            $('#mainFrame > div:nth-child('+pos+')').animate({top: "-=" + theHeight}, animateTime);
        }
    }

    function goUp() {
        if (pos > 1) {
            $('#mainFrame > div:nth-child('+pos+')').animate({top: "+=" + theHeight}, animateTime);
            $('#mainFrame > div:nth-child('+pos+')').fadeOut(100);
            pos--;
            $('#mainFrame > div:nth-child('+pos+')').fadeIn(100);
            $('#mainFrame > div:nth-child('+pos+')').animate({top: "+=" + theHeight}, animateTime);
        }
    }

    function goToTop() {
        theHeight = $(window).height();
        var currentPositionPercent = theHeight * 0.2;
        var downPositionPercent = theHeight * 1.2;
        for (var index = 1; index <= count; index++) {
            if (index === 1) {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: currentPositionPercent}, 0);
            } else {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: downPositionPercent}, 0);
            }
        }
        pos = 1;
    }
});


