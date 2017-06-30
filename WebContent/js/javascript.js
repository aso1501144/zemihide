/**
 *
 */

function check(loginForm) {
	if (loginForm.s_id.value == '') {
		return doError('学生IDは入力必須項目です。');
	}
	if (loginForm.pass.value == '') {
		return doError('パスワードは入力必須項目です。');
	}

	// エラーなし
	return true;
};
doError = function doError(msg) {
	alert(msg);
	return false;
};

function genreselect() {
	obj = document.kamoku.genre;
	index = obj.selectIndex;

	switch (index) {
	case "英語":

		break;

	case "IT":

		break;

	case "コミュニケーション":

		break;

	default:
		break;
	}
}