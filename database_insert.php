<?php

    $con=mysqli_connect("35.188.230.66","root","ece480team16","patientdata");

    if (!$con) {
        die("Failed to connect to MySQL: " . mysqli_connect_error());
    }

    $tablename = $_POST['table_name'];
    $time = $_POST['time'];
    $user_id = $_POST['user_id'];
    $response1 = $_POST['response1'];
    $response2 = $_POST['response2'];
    $response3 = $_POST['response3'];

    $query = "INSERT INTO '$tablename' VALUES '$time', '$response1', '$response2', '$response3', '$user_id')";

    if(mysqli_query($con,$Sql_Query)){
        echo 'Data Submitted Successfully';
    } else {
        echo 'Try Again';
    }

    mysqli_close($con);
?>