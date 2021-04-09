<?php

$con=mysqli_connect("mysql-user.cse.msu.edu","huangmax","A56081598","huangmax");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$time = $_GET['time'];
$user_id = $_GET['user_id'];
$response1 = $_GET['response1'];
$response2 = $_GET['response2'];
$response3 = $_GET['response3'];

$query = "INSERT INTO wakeup_questions VALUES ('$time', '$response1', '$response2', '$response3', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?>