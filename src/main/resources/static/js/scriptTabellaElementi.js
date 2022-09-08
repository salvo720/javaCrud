// js 


$(function () {
    console.log("ready!");
    takeDataFropApi();
    DatatableElementi();
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
}

function DatatableElementi() {
    $('#tableElementi').DataTable({
        paging: true,
        search: true,
        pageLength: 10,
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
                    return `<a type = "button" class="button btn btn-warning" id = "buttonNewElemento"
                    onclick = window.location.href="/updateElementoView/` + row.id + `" ><i class="fa-sharp fa-solid fa-pen-to-square fa-xl"></i></a>`
                }
            },
            {
                render: function (data, type, row) {
                    return `<button type = "button" class="button btn btn-danger" id = "buttonNewElemento"
                    onclick = window.location.href="/deleteElemento/` + row.id + `" > <i class="fa fa-trash fa-xl"></i></button>`
                },
            }
        ],
    });
}


