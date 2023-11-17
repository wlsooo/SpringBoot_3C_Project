function previewImage(input) {
    var preview = document.querySelector('.image');
    var file = input.files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.style.backgroundImage = 'url(' + reader.result + ')';
    };

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.style.backgroundImage = null;
    }
}

function resetImageSelection() {
    var input = document.getElementById('fileInput');
    input.value = null; // Reset the input field
    document.querySelector('.image i').classList.remove('active');
    document.querySelector('.image .upload-text').style.display = 'inline-block';
}

function previewImage(input) {
    var preview = document.querySelector('.image');
    var file = input.files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.style.backgroundImage = 'url(' + reader.result + ')';
        document.querySelector('.image i').classList.add('active');
        document.querySelector('.image .upload-text').style.display = 'none';
    };

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.style.backgroundImage = null;
        document.querySelector('.image i').classList.remove('active');
        document.querySelector('.image .upload-text').style.display = 'inline-block';
    }
}
