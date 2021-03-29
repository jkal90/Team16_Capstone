<?php

    $con=mysqli_connect("35.188.230.66","root","ece480team16","patientdata");

    if (mysqli_connect_errno($con)) {
        echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }

    $tablename = $_GET['table_name'];
    $time = $_GET['time'];
    $user_id = $_GET['user_id'];
    $response1 = $_GET['response1'];
    $response2 = $_GET['response2'];
    $response3 = $_GET['response3'];

    $result = mysqli_query($con,"INSERT INTO $tablename VALUES ($time, $response1, $response2,
        $response3, $user_id)");

    mysqli_close($con);
?>