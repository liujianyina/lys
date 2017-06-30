window.onload = function () {

    function BgChenge() {
        var content_top_right = document.getElementById('content_top_right');
        if (content_top_right) {
            var content_top_right_os = content_top_right.style;
            content_top_right_os.backgroundImage = 'url(img/jardiniere' + (parseInt(Math.random() * 6) + 1) + '.jpg)';
        }

    };

    setInterval(BgChenge, 3000);
};