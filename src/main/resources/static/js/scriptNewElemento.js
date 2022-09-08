// js 


$(function () {
    console.log("ready!");
    closeAlertBox();
});

function closeAlertBox() {
    setTimeout(function () {
        // close alert box after 10 s 
        let alertBox = document.getElementById("idAlertBox").click();
        window.location.href = "/elementiView"
    }, 10000);

}


