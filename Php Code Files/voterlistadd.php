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
$v_name =$_POST['vname'];
$v_id =$_POST['vid'];
$v_phone =$_POST['vphoneno'];
$v_password =$_POST['vpassword'];
$v_value =$_POST['vvalue'];
$v_pin =$_POST['vpin'];
$sql = "INSERT INTO voterlist (voter_name, voter_id,phoneno,password,pin,value)
VALUES ('$v_name', '$v_id', '$v_phone','$v_password', '$v_pin','$v_value')";
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>