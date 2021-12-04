const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});


function checkLogin(){
	let email=document.getElementById("email").value;
	let pass=document.getElementById("password").value;
	
	if(email.trim()==""){
		alert("Email Field is required");
		return false;
	}
	if(pass.trim()==""){
		alert("Password Field is required");
		return false;
	}
	return true;
}

function checkRegis(){
	let name=document.getElementById("name").value;
	let email=document.getElementById("mail").value;
	let pass=document.getElementById("pass").value;
	
	if(name.trim()==""){
		alert("Username Field is required");
		return false;
	}
	if(email.trim()==""){
		alert("Email Field is required");
		return false;
	}
	if(pass.trim()==""){
		alert("Password Field is required");
		return false;
	}
	return true;
}