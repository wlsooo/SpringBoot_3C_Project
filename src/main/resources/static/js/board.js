document.addEventListener('DOMContentLoaded', function () {
    // 모든 버튼 요소를 가져옵니다.
    var buttons = document.querySelectorAll('button[type=button]');

    // 각 버튼에 클릭 이벤트를 추가합니다.
    buttons.forEach(function (button) {
        button.addEventListener('click', function () {
            // 모든 버튼의 클래스를 초기화합니다.
            buttons.forEach(function (btn) {
                btn.classList.remove('selected');
            });

            // 클릭된 버튼에 selected 클래스를 추가합니다.
            button.classList.add('selected');
        });
    });
});