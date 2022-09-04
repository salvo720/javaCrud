// js 


$(function () {
    console.log("ready!");
    takeDataFropApi();
});

function takeDataFropApi() {
    // test api work 
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
        paging: true,
        search: true,
        pageLength: 50,
        ajax:
        {
            url: "/api/elementiJson",
            dataSrc: '',
        },
        columns: [
            { data: 'id' },
            { data: 'nome' },
            { data: 'serialeprodotto' },
            { data: 'quantita' },
            {
                render: function (data, type, row) {
                    return `<button type = "button" class="button btn btn-warning" id = "buttonNewElemento"
                th: href = "@{/updateElemento?id={` + row.id + `}}" ><i class="fa-sharp fa-solid fa-pen-to-square fa-xl"></i></button >`
                }
            },
            {
                render: function (data, type, row) {
                    return `<button type = "button" class="button btn btn-danger" id = "buttonNewElemento"
                th:href = "@{/deleteElemento?id={` + row.id + `}}" > <i class="fa fa-trash fa-xl"></i></button >`
                },
            }
        ],
    });
}


