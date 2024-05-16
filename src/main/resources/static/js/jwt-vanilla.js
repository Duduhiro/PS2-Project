var userElement = document.getElementById('username');
var passwordElement = document.getElementById('password');

userElement.addEventListener('keypress', function(event) {
	if (event.key === 'Enter') {
		event.preventDefault();
		getToken();
	}
});

passwordElement.addEventListener('keypress', function(event) {
	if (event.key === 'Enter') {
		event.preventDefault();
		getToken();
	}
});

function getToken() {
	var loginUrl = "/authenticate"
	var xhr = new XMLHttpRequest();
    var message = document.getElementById('loginError');
	var user = userElement.value;
	var password = passwordElement.value;

	xhr.open('POST', loginUrl, true);
	xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xhr.addEventListener('load', function() {
		var responseObject = JSON.parse(this.response);
		console.log(responseObject);
		if (responseObject.token) {
			localStorage.setItem('token', responseObject.token);
			localStorage.setItem('username', user);
			window.location.replace("/auth.html");
		} else {
			userElement.classList.add('is-invalid');
            passwordElement.classList.add('is-invalid');
            message.classList.remove('d-none');
		}
	});

	var sendObject = JSON.stringify({ username: user, password: password });

	console.log('going to send', sendObject);

	xhr.send(sendObject);
}

// make the request to the secret API endpoint
function getSecret() {

	var url = "/hello"
	var xhr = new XMLHttpRequest();
	var tokenElement = document.getElementById('token');
	var resultElement = document.getElementById('result');
	xhr.open('GET', url, true);
	xhr.setRequestHeader("Authorization", "Bearer " + tokenElement.innerHTML);
	xhr.addEventListener('load', function() {
		var responseObject = JSON.parse(this.response);
		console.log(responseObject);
		resultElement.innerHTML = this.responseText;
	});

	xhr.send(null);
}