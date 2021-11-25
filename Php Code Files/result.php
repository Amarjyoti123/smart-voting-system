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
 $email = $_POST['Email'];
 $password = $_POST['Password'];
 
 $sql = "SELECT * FROM register WHERE email = '$email' AND password='$password'";
 
 $result = mysqli_query($conn,$sql);
 
 $check = mysqli_fetch_array($result);
 
 if(isset($check)){
 echo 'success';
 }else{
 echo 'failure';
 }
 }






?>