$(document).ready(function () {

  $("#if-form").submit(function (event) {
    // 폼 기본 제출 막기
    event.preventDefault();

    var $form = $(this),
    reqSerNum = $form.find("input[name='reqSerNum']").val();
//      svcNum = $form.find("input[name='svcNum']").val(),
//      ppsAmt = $form.find("input[name='ppsAmt']").val()
    // API 에 맞게 데이터를 조합하기
    var data = {req_ser_num: reqSerNum};

    // POST 로 데이터 보내기
    $.ajax({
      url: '/receiveIF',
      type: 'POST',
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      async: false,
      success: function (result) {
        $('.result-message').empty().append(result.chg_Cd);
      }
    });

  });
});
