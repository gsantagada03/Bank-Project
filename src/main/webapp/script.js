var username = document.getElementById("username");
var password = document.getElementById("password");
var form = document.getElementById("regForm");
var errorUsername = document.getElementById("usernameError");
var errorPassword = document.getElementById("passwordError");

function usernameRegex(username) {
	const regex = /^[a-zA-Z0-9_]{3,20}$/;
	return regex.test(username);
}

function passwordRegex(password) {
	const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	return regex.test(password);
}

form.addEventListener("submit", function(event) {
	var usernameValue = username.value;
	var passwordValue = password.value;

	if (!usernameRegex(usernameValue)) {
		event.preventDefault();
		errorUsername.style.visibility = "visible";
	} else {
		errorUsername.style.visibility = "hidden";
	}

	if (!passwordRegex(passwordValue)) {
		event.preventDefault();
		errorPassword.style.visibility = "visible";
	} else {
		errorPassword.style.visibility = "hidden";
	}
});