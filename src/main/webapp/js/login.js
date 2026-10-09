$(document).ready(function () {
    $('#loginForm').on('submit', function (event) {
        let isValid = true;

        const username = $('#username').val().trim();
        const password = $('#password').val();

        clearErrors();

        if (!username) {
            showError('username', 'Username is required.');
            isValid = false;
        } else if (!/^(?=.{6,30}$)([a-zA-Z0-9._@-]+)$/.test(username)) {
            showError('username', 'Username must be 6 to 30 characters and may contain letters, numbers, dot, underscore, @, hyphen.');
            isValid = false;
        }

        if (!password) {
            showError('password', 'Password is required.');
            isValid = false;
        } else if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$/.test(password)) {
            showError('password', 'Password must be at least 8 characters with uppercase, lowercase, number, and special character.');
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault();
        }
    });

    function showError(fieldId, message) {
        $('#' + fieldId).addClass('input-error');
        $('#' + fieldId + 'Error').text(message);
    }

    function clearErrors() {
        $('#username, #password').removeClass('input-error');
        $('#usernameError, #passwordError').text('');
        $('#serverError').text('');
    }
});
