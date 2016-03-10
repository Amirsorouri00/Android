<?php

$hostname = "localhost";
$dbname = "amir";
$dbpass = "123456";
$con = mysql_connect($hostname,$dbname,$dbpass);
mysql_select_db("amir",$con);

$user = $_POST ['username'];

/*
$user = "mohsen";
$pass = "123";
*/

$sqlQ="select * from User_Login where Username = '$user'  ";
$result = mysql_Query($sqlQ);
$row = mysql_fetch_array($result);

if($row[0]){
print $row[1];
}else{
print "No User";
}
mysql_close($con);

?>