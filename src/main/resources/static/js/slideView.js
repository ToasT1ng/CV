$(document).ready(function () {
    let currentWindowHeight;
    let currentDivPositionByPercent;
    let upDivPositionByPercent;
    let downDivPositionByPercent;

    setParams();
    $(".upArrow").hide();

    let divPosition = 1;
    let divCount = $("#mainFrame > div").length;

    let upScrollBoolean = true;
    let downScrollBoolean = true;
    let scrollWaitTime = 1000;
    let animateTime = 750;
    let fadeSpeed = 100;

    $( window ).resize( function() {
        setParams();
        for (let index = 1; index <= divCount; index++) {
            if (index < divPosition) {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: upDivPositionByPercent}, 0);
            } else if (index === divPosition) {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: currentDivPositionByPercent}, 0);
            } else {
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: downDivPositionByPercent}, 0);
            }
        }
    });

    function setParams() {
        currentWindowHeight = $(window).height();
        currentDivPositionByPercent = currentWindowHeight * 0.2;
        upDivPositionByPercent = currentWindowHeight * -0.8;
        downDivPositionByPercent = currentWindowHeight * 1.2;
    }


    $("html").on('mousewheel',function(wheelScroll){
        var wheelPos = wheelScroll.originalEvent.wheelDelta;
        if(wheelPos > 0){
            if (upScrollBoolean) {
                upButtonFunction.call($("#upButton"));
            }

        } else {
            if (downScrollBoolean) {
                downButtonFunction.call($("#downButton"));
            }
        }
    });

    function upButtonFunction() {
        upScrollBoolean = false;
        goUp();
        setTimeout($.proxy(function () {
            upScrollBoolean = true;
        }, this), scrollWaitTime);
    }

    $("#upButton").on("click", function() {
        if (upScrollBoolean) {
            upButtonFunction.call(this);
        }

    });

    function downButtonFunction() {
        downScrollBoolean = false;
        goDown();
        setTimeout($.proxy(function () {
            downScrollBoolean = true;
        }, this), scrollWaitTime);
    }

    $("#downButton").on("click", function () {
        if (downScrollBoolean) {
            downButtonFunction.call(this);
        }
    });

    $("#topButton").on("click", function () {
        goToTop();
    });

    function goDown() {
        if (divPosition < divCount) {
            $(".upArrow").show();
            $('#mainFrame > div:nth-child('+divPosition+')').animate({top: "-=" + currentWindowHeight}, animateTime);
            $('#mainFrame > div:nth-child('+divPosition+')').fadeOut(fadeSpeed);
            divPosition++;
            $('#mainFrame > div:nth-child('+divPosition+')').fadeIn(fadeSpeed);
            $('#mainFrame > div:nth-child('+divPosition+')').animate({top: "-=" + currentWindowHeight}, animateTime);

            if (divPosition === divCount) {
                $(".downArrow").hide();
            }
        }
    }

    function goUp() {
        if (divPosition > 1) {
            $(".downArrow").show();
            $('#mainFrame > div:nth-child('+divPosition+')').animate({top: "+=" + currentWindowHeight}, animateTime);
            $('#mainFrame > div:nth-child('+divPosition+')').fadeOut(fadeSpeed);
            divPosition--;
            $('#mainFrame > div:nth-child('+divPosition+')').fadeIn(fadeSpeed);
            $('#mainFrame > div:nth-child('+divPosition+')').animate({top: "+=" + currentWindowHeight}, animateTime);

            if (divPosition === 1) {
                $(".upArrow").hide();
            }
        }
    }

    function goToTop() {
        $(".upArrow").hide();
        for (let index = 1; index <= divCount; index++) {
            if (index === 1) {
                $('#mainFrame > div:nth-child('+index+')').fadeIn(0);
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: currentDivPositionByPercent}, 0);
            } else {
                $('#mainFrame > div:nth-child('+index+')').fadeOut(0);
                $('#mainFrame > div:nth-child(' + index + ')').animate({top: downDivPositionByPercent}, 0);
            }
        }
        divPosition = 1;
    }
});


