// 회원가입 폼 제출 시 AJAX로 서버에 전송
$("#registerForm").submit(function (event) {
    event.preventDefault();  // 기본 폼 제출 동작을 막음

    var formData = $(this).serialize();  // 폼 데이터를 직렬화하여 전송

    $.ajax({
        type: "POST",
        url: "/user/registerProcess",
        data: formData,  // 폼 데이터를 서버로 전송
        success: function (response) {
            // 회원가입 성공 후 alert 창을 띄우고, 로그인 페이지로 이동
            alert("회원 가입 성공.");
            location.href = "/user/login";  // 로그인 페이지로 리디렉션
        },
        error: function () {
            alert("회원 가입 실패!");
        }
    });
});