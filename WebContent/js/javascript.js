/**
 *
 */


function check(loginForm){
	if(loginForm.s_id.value == '') {
        return doError('会員IDは入力必須項目です。');
    }
    if(loginForm.pass.value == '') {
        return doError('パスワードは入力必須項目です。');
    }

    //エラーなし
    return true;
};
doError = function doError(msg) {
    alert(msg);
    return false;
};
function checkmail(mail){
	if(mail.email.value == '') {
        return doError('メールアドレスを入力してください。');
    }
	return true;
}
function checkcardno(card){
	if(card.cardno.value == '') {
        return doError('クレジット番号を入力してください。');
    }
	if(card.cardno.value.length != 16) {
        return doError('クレジットカードの入力形式が不正です。');
    }
	return true;
}
function checkkosu(kosu) {
	if(kosu.zaiko.value == 0) {
        return doError('aaa。');
    }
}


function zaikoch(){
	var zaiko = document.getElementById('zaiko').value;

	alert(zaiko);
}