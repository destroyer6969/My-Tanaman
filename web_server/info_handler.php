<?php
header('Content-Type: application/json');
error_reporting(0);
$conn = new mysqli("127.0.0.1", "root", "", "mytanaman");
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}
if(strlen($_POST["nama"])!=0){
	if(strlen($_POST["del"])==0){
		$sql = "insert into informasi (nama, suhu_atas, suhu_bawah, cahaya_atas, cahaya_bawah, kelembaban_atas, kelembaban_bawah, lama_cahaya, tgl_tanam) values ('".$_POST["nama"]."',".$_POST["suhu_atas"].",".$_POST["suhu_bawah"].",".$_POST["cahaya_atas"].",".$_POST["cahaya_bawah"].",".$_POST["kelembaban_atas"].",".$_POST["kelembaban_bawah"].",".$_POST["lama_cahaya"].",'".$_POST["tgl_tanam"]."')";
		$obj->info = $sql;
		$objJSON = json_encode($obj);
		echo $objJSON;
		$result = $conn->query($sql);
	}
	else{
		$sql = "delete from informasi where nama='".$_POST["nama"]."'";
		$result = $conn->query($sql);
	}
}
else{
	$sql = "select * from informasi";
	$result = $conn->query($sql);
	$info = "";
	while($row = $result->fetch_assoc()) {
		$date1=date_create($row["tgl_tanam"]);
		$date2=date_create(date('Y-m-d'));
		$diff=date_diff($date1,$date2);
		$info=$info."Nama: ".$row["nama"]."; Suhu Atas: ".$row["suhu_atas"]."; Suhu Bawah: ".$row["suhu_bawah"]."; Cahaya Atas: ".$row["cahaya_atas"]."; Cahaya Bawah: ".$row["cahaya_bawah"]."; Kelembaban Atas: ".$row["kelembaban_atas"]."; Kelembaban Bawah: ".$row["kelembaban_bawah"]."; Lama Cahaya: ".$row["lama_cahaya"]." jam; Tanggal Tanam: ".$row["tgl_tanam"].", Usia Tanam: ".$diff->format("%a")." hari\n\n";
	}
	$obj->info = $info;
	$objJSON = json_encode($obj);
	echo $objJSON;
}
?>