<?php
$servername = "localhost";
$username = "id2339034_aptron";
$password = "aptron";
$dbname = "id2339034_bibek";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$name =$_POST['name'];
$email =$_POST['email'];
$password2 =$_POST['password'];
$age =$_POST['age'];
$sql = "INSERT INTO register (name, email,password,age)
VALUES ('$name', '$email', '$password2', '$age')";
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>