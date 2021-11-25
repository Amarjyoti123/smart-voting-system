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
$id =$_GET['Rg'];
$sql = "SELECT * FROM nomini_list   WHERE pin='".$id."'AND party='BSP'";

$result = $conn->query($sql);

if ($result->num_rows >0) {
 
 
 while($row[] = $result->fetch_assoc()) {
 
 $tem = $row;
 
 $json = json_encode($tem);
 
 
 }
 
} else {
 echo "No Results Found.";
}
 echo $json;
$conn->close();
 
?>