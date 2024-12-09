document.querySelectorAll('.tr-click').forEach(function(tr){
    tr.addEventListener('click', function () {
        var index = tr.id.trim();
        window.location.href = '/notice/openNoticeDetail?notice_num=' + index;
    })
})