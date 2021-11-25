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
$v_name =$_POST['cname'];
$v_id =$_POST['cid'];
$v_phone =$_POST['cparty'];
$v_value =$_POST['cvote'];
$v_pin =$_POST['cpin'];
$sql = "INSERT INTO nomini_list (name, nomini_id,party,pin,vote)
VALUES ('$v_name', '$v_id', '$v_phone', '$v_pin','$v_value')";
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>