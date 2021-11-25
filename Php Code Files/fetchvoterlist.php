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
if($_SERVER['REQUEST_METHOD']=='GET'){
$id  = $_GET['Rg'];
$sql = "SELECT * FROM voterlist WHERE voter_id='".$id."'";
 
 $r = mysqli_query($conn,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
 "name"=>$res['voter_name'],
 "id"=>$res['voter_id'],
 "pin2"=>$res['pin'],
 "value2"=>$res['value'],
 "password2"=>$res['password'],
 "phoneno2"=>$res['phoneno'],

  )
 );
 
 echo json_encode(array("result"=>$result));
 
 mysqli_close($conn);
}
 
?>