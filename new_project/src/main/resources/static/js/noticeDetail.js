$(document).ready(function(){
    $("#list").on("click", function(){
        location.href = "/notice/list";
    });

    $("#edit").on("click", function(){
        var frm = $("#frm")[0];
        frm.action = "/notice/updateNotice";
        frm.submit();
    });

    $("#delete").on("click", function(){
        var frm = $("#frm")[0];
        frm.action = "/notice/deleteNotice";
        frm.submit();
    });
});