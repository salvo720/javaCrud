// js 


$(function () {
    console.log("ready!");
    takeDataFropApi();
});

function takeDataFropApi() {
    // $.ajax({
    //     url: "/api/dashboardElementi",
    //     data: '',
    //     dataType: 'json',
    //     method: 'GET',
    // }).done(function (data) {
    //     console.log(data)
    // }).fail(function () {
    //     console.log("request error");
    // });

    $('#tableElementi').DataTable({
        ajax:
        {
            url: "/api/dashboardElementi",
            dataSrc: '',
        },
        columns: [
            { data: 'id' },
            { data: 'nome' },
            { data: 'serialeprodotto' },
            { data: 'quantita' },

        ],
    });
}


