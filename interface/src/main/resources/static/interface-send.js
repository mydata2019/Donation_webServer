$(document).ready(function () {

  $("#if-form").submit(function (event) {
	alert("인증 수행");
    // 폼 기본 제출 막기
    event.preventDefault();

    var $form = $(this),
      id = $form.find("input[name='id']").val(),
      pw = $form.find("input[name='pw']").val(),
      user_id = $form.find("input[name='user_id']").val(),
      org_id = $form.find("input[name='org_id']").val();

    // API 에 맞게 데이터를 조합하기
    var data = {id: id, pw: pw, user_id: user_id, org_id: org_id};
    
    var  = '/Interface/Auth';

    // POST 로 데이터 보내기
    $.ajax({
      url: url,
      type: 'POST',
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      async: false,
      success: function (result) {
        alert('성공여부 : ' + result.linkYn);
      }
    });

  });
  
  
  $("#data-form").submit(function (event) {
		alert("기부이력 가져오기 실행");
	    // 폼 기본 제출 막기
	    event.preventDefault();

	    var $form = $(this),
	      id = $form.find("input[name='id']").val(),
	      user_id = $form.find("input[name='user_id']").val(),
	      org_id = $form.find("input[name='org_id']").val();

	    // API 에 맞게 데이터를 조합하기
	    var data = {id: id, user_id: user_id, org_id: org_id};
	    
	    var url = '/Interface/GetDonation';

	    // POST 로 데이터 보내기
	    $.ajax({
	      url: url,
	      type: 'POST',
	      data: JSON.stringify(data),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      async: false,
	      success: function (result) {
	          alert('성공여부 : ' + result.getYn);
	      }
	    });

	  });
  
});
