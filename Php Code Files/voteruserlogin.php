<?php
$servername = "localhost";
$username = "id2339034_aptron";
$password = "aptron";
$dbname = "id2339034_bibek";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 $v2id = $_POST['v_id'];
 $v2password = $_POST['v_Password'];
 
$sql = "SELECT * FROM voterlist WHERE voter_id = '$v2id' AND password='$v2password'"; 
 $result = mysqli_query($conn,$sql);
 
 $check = mysqli_fetch_array($result);
 
 if(isset($check)){
 echo 'success';
 }else{
 echo 'failure';
 }
 }