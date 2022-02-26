$(document).ready(function () {

    $("#goBack").on("click", function () {
        window.location.href = "/settings/index";
    });

    $("#techStackEditButton").on("click", function(){
        let arr = {
            techStackId: 1,
            description: $('#techStackTextArea').val()
        };

        ajaxCall("/techStack/setTechStack", arr);
    });

    $("#whoAmIEditButton").on("click", function (){
        let entireArray = [];
        let object = {};
        $('#subscription').find('input').each(function () {
            const id = this.id;
            if (id != null && id !== "") {
                const idSplit = id.split('_');

                if (id.includes("description")) {
                    object[idSplit[0]] = this.value;
                    entireArray.push(object);
                    object = {};
                } else {
                    object[idSplit[0]] = this.value;
                }
            }
        });
        $('#detailInfo').find('input').each(function () {
            const id = this.id;
            if (id != null && id !== "") {
                const idSplit = id.split('_');

                if (id.includes("description")) {
                    object[idSplit[0]] = this.value;
                    entireArray.push(object);
                    object = {};
                } else {
                    object[idSplit[0]] = this.value;
                }
            }
        });

        // alert(JSON.stringify(entireArray));

        ajaxCall("/information/setInformations", entireArray);
    });

    $("#whatDidYouDoButton").on("click", function (){
        let entireArray = [];
        let object = {};
        $('.whatDidYouDoTable').find('.whatDidYouDoForm').each(function () {
            const id = this.id;
            if (id != null && id !== "") {
                const idSplit = id.split('_');

                if (id.includes("description")) {
                    object[idSplit[0]] = $('#' + this.id).val();
                    entireArray.push(object);
                    object = {};
                } else {
                    object[idSplit[0]] = this.value;
                }
            }
        });

        ajaxCall("/thingsDone/setThingsDones", entireArray);
    });

    $("#careerAndAwardsButton").on("click", function (){
        let entireArray = [];
        let object = {};
        $('.threeDimensionTable').find('input').each(function () {
            const id = this.id;
            if (id != null && id !== "") {
                const idSplit = id.split('_');

                if (id.includes("moreDescription")) {
                    object[idSplit[0]] = this.value;
                    entireArray.push(object);
                    object = {};
                } else {
                    object[idSplit[0]] = this.value;
                }
            }
        });

        ajaxCall("/history/setHistories", entireArray);
    });

    $("#logout").on("click", function (){
        logoutAjaxCall("/settings/logout");
    });

    function ajaxCall(url, jsonObject) {
        $.ajax({
            url: url,
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(jsonObject),
            dataType: "json",
            success: function (data) {
                window.location.href = "/settings/index";
            }
        });
    }

    function logoutAjaxCall(url) {
        $.ajax({
            url: url,
            type: "GET",
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                window.location.href = "/settings/index";
            }
        });
    }
});