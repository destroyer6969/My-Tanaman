<?php
header('Content-Type: application/json');
error_reporting(0);
$conn = new mysqli("127.0.0.1", "root", "", "mytanaman");
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}
if(strlen($_POST["nama"])!=0){
	$sql = "select nama, relay1, relay2, relay3, relay4, relay5, relay6, relay7, relay8 from informasi where nama='".$_POST["nama"]."'";
	$result = $conn->query($sql);
	$row = $result->fetch_assoc();
	$myObj->nama = $row["nama"];
	$myObj->relay1 = $row["relay1"];
	$myObj->relay2 = $row["relay2"];
	$myObj->relay3 = $row["relay3"];
	$myObj->relay4 = $row["relay4"];
	$myObj->relay5 = $row["relay5"];
	$myObj->relay6 = $row["relay6"];
	$myObj->relay7 = $row["relay7"];
	$myObj->relay8 = $row["relay8"];
	$sql = "select suhu, kelembaban, cahaya, sudah_disinari from sensors s1 where waktu = (select max(waktu) from sensors s2 where s1.nama = s2.nama) and nama='".$_POST["nama"]."'order by waktu";
	$result = $conn->query($sql);
	$row = $result->fetch_assoc();
	$myObj->suhu = $row["suhu"];
	$myObj->cahaya = $row["cahaya"];
	$myObj->kelembaban = $row["kelembaban"];
	$myObj->sudah_disinari = $row["sudah_disinari"];
	$objJSON = json_encode($myObj);
	echo $objJSON;
}
else{
	$sql = "update informasi set ".$_POST["relay_name"]." = ".$_POST["state"]." where nama = '".$_POST["id"]."'";
	$result = $conn->query($sql);
	$myObj->info = $sql;
	$objJSON = json_encode($myObj);
	echo $objJSON;
}
?>