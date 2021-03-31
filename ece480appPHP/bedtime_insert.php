<?php

$con=mysqli_connect("35.188.230.66","root","ece480team16","patientdata");

if (!$con) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}

$bedtime = $_GET['bedtime'];
$fatigue_level = $_GET['fatigue_level'];
$sleepiness_level = $_GET['sleepiness_level'];
$user_id = $_GET['user_id'];

$query = "INSERT INTO bedtime_questions VALUES ('$bedtime', '$fatigue_level', '$sleepiness_level', '$user_id')";

if(mysqli_query($con, $query)){
    echo 'Data Submitted Successfully';
} else {
    echo mysqli_error($con);
}

mysqli_close($con);
?><?php
