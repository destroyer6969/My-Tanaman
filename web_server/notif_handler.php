<?php
header('Content-Type: application/json');
error_reporting(0);
$conn = new mysqli("127.0.0.1", "root", "", "mytanaman");
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}
$sql = "select * from informasi";
$result_ = $conn->query($sql);
$info = "";
while($informasi = $result_->fetch_assoc()) {
	$sql = "select suhu, kelembaban, cahaya, sudah_disinari from sensors s1 where waktu = (select max(waktu) from sensors s2 where s1.nama = s2.nama) and nama='".$informasi["nama"]."' order by waktu";
	$result = $conn->query($sql);
	$row = $result->fetch_assoc();
	$temp = "";
	$cnt = 0;
	if($row["suhu"]==null){
		$temp = $temp."Data suhu tidak ada";
		$cnt+=1;
	}
	else{
		if($row["suhu"]>$informasi["suhu_atas"]){
			$temp = $temp."Suhu > ".$informasi["suhu_atas"]."C";
			$cnt+=1;
		}
		else if($row["suhu"]<$informasi["suhu_bawah"]){
			$temp = $temp."Suhu < ".$informasi["suhu_bawah"]."C";
			$cnt+=1;
		}
	}
	if($row["cahaya"]==null){
		if($cnt>0) $temp = $temp.", ";
		$temp = $temp."Data cahaya tidak ada";
		$cnt+=1;
	}
	else{
		if($row["cahaya"]>$informasi["cahaya_atas"]){
			if($cnt>0) $temp = $temp.", ";
			$temp = $temp."Cahaya > ".$informasi["cahaya_atas"]."Lux";
			$cnt+=1;
		}
		else if($row["cahaya"]<$informasi["cahaya_bawah"]){
			if($cnt>0) $temp = $temp.", ";
			$temp = $temp."Cahaya < ".$informasi["cahaya_bawah"]."Lux";
			$cnt+=1;
		}
	}
	
	if($row["kelembaban"]==null){
		if($cnt>0) $temp = $temp.", ";
		$temp = $temp."Data kelembaban tidak ada";
	}
	else{
		if($row["kelembaban"]>$informasi["kelembaban_atas"]){
			if($cnt>0) $temp = $temp.", ";
			$temp = $temp."Kelembaban > ".$informasi["kelembaban_atas"]."%";
			$cnt+=1;
		}
		else if($row["kelembaban"]<$informasi["kelembaban_bawah"]){
			if($cnt>0) $temp = $temp.", ";
			$temp = $temp."Kelembaban < ".$informasi["kelembaban_bawah"]."%";
			$cnt+=1;
		}
	}
	
	if($row["sudah_disinari"]==null){
		if($cnt>0) $temp = $temp.", ";
		$temp = $temp."Data sudah disinari tidak ada";
	}
	else{
		if($row["sudah_disinari"]>$informasi["lama_cahaya"]){
			if($cnt>0) $temp = $temp.", ";
			$temp = $temp."Lama pencahayaan > ".$informasi["lama_cahaya"]."jam";
			$cnt+=1;
		}
		else if($row["sudah_disinari"]<$informasi["lama_cahaya"]){
			if($cnt>0) $temp = $temp.", ";
			$temp = $temp."Lama pencahayaan < ".$informasi["lama_cahaya"]."jam";
			$cnt+=1;
		}
	}
	if($cnt>0) $info=$info."Masalah pada ".$informasi["nama"].":\n\t".$temp.".\n\n";
}
$obj->info = $info;
$objJSON = json_encode($obj);
echo $objJSON;
?>