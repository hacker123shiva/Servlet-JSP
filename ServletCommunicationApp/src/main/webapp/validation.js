function validateForm() {
  // Get form input values
  var name = document.getElementById("name").value;
  var age = document.getElementById("age").value;
  var email = document.getElementById("email").value;
  var mobile = document.getElementById("mobile").value;

  // Regular expressions for validation
  var nameRegex = /^[a-zA-Z ]+$/;
  var ageRegex = /^[1-9][0-9]?$/;
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  var mobileRegex = /^\d{10}$/;

  // Validate each input field
  if (!nameRegex.test(name)) {
    alert("Invalid name");
    return false;
  }

  if (!ageRegex.test(age)) {
    alert("Invalid age");
    return false;
  }

  if (!emailRegex.test(email)) {
    alert("Invalid email");
    return false;
  }

  if (!mobileRegex.test(mobile)) {
    alert("Invalid mobile number");
    return false;
  }

  // If all fields are valid, proceed with form submission
  return true;
}
