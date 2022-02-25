$(document).ready(function () {

    $("#goBack").on("click", function () {
        window.location.href = "/settings/index";
    });

    $("#techStackEditButton").on("click", function(){
        let arr = {
            techStackId: 0,
            description: $('#techStackTextArea').val()
        };

        ajaxCall("http://localhost:8080/techStack/setTechStack", arr);
    });

    $("#whoAmIEditButton").on("click", function (){
        let entireArray = [];
        let object = {};
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

        ajaxCall("http://localhost:8080/information/setInformations", entireArray);
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

        ajaxCall("http://localhost:8080/thingsDone/setThingsDones", entireArray);
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

        ajaxCall("http://localhost:8080/history/setHistories", entireArray);
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
});