<?php 
  $hostname = "localhost";
  $dbname = "amir";
  $dbpass = "123456";
  $con = new mysqli($hostname,$dbname,$dbpass,'amir');

  $jasonData = array();
  $sql="select Username,Password from User_Login";

$usernames = array();
$passwords = array();

$Usql = $con->query("select Username from User_Login") or die('Could not query');
$Psql = $con->query("select Password from User_Login") or die('Could not query');

//if(mysql_num_rows($Usql) && mysql_num_rows($Psql))
if(true){
    echo '{"Username":[';

    $first = true;
    $user=mysql_fetch_assoc($Usql);
    while($user=$Usql->fetch_row()){
        //  cast results to specific data types
        
        if($first) {
            $first = false;
        } else {
            echo ',';
        }
        echo '"Name":';
        echo '"';
        print $user[0];
        echo '"';
    }
    echo ']},';
    echo '{"Password":[';
    $first = true;
    while($pass=$Psql->fetch_row()){
        //  cast results to specific data types

        if($first) {
            $first = false;
        } else {
            echo ',';
        }
        echo '"';
        print $pass[0];
        echo '"';
    }
    
    echo ']}';
} else {
    echo '[]';
}

  $con->close();