<?php
$hostname = "localhost";
$dbname = "amir";
$dbpass = "123456";
$con = new mysqli($hostname,$dbname,$dbpass,'amir');

$user = $_POST ['username'];
$pass = $_POST ['password'];
/*
$user = "John";
$pass = "789";
*/

$sql="INSERT INTO User_Login (Username, Password) VALUES ('$user', '$pass')";
$result = $con->query($sql);

if ($result) {
    echo  "New record created successfully";
} else {
    echo "Error";
}
$con->close();
?>