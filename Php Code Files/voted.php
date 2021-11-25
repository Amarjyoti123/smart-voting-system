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

$v_value =$_POST['vvalue'];
$id =$_GET['Rg'];

$sql = "UPDATE voterlist SET value='$v_value' WHERE voter_id='$id'";

if (mysqli_query($conn, $sql)) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . mysqli_error($conn);
}

mysqli_close($conn);
?>







