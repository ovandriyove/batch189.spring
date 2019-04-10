<html>
<head>
<title>Calculator</title>
<script src="assets/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<p>Calculator</p>
	<table>
		<tr>
			<td>Bilangan 1 :</td>
			<td><input type="text" id="angka1"></td>
		</tr>
		<tr>
			<td>Bilangan 2 :</td>
			<td><input type="text" id="angka2"></td>
		</tr>
		<tr>
			<td>Hasil :</td>
			<td><input type="text" id="hasil"></td>
		</tr>
	</table>
	<td><button onclick="tambah()">+</button>
	<td><button onclick="kurang()">-</button>
	<td><button onclick="kali()">*</button>
	<td><button onclick="bagi()">/</button> 
	
	<script>
		function getAngka(x){
			return Number($("#"+x).val());
		}
		function tambah(){
			var hasil = getAngka("angka1")+getAngka("angka2");
			$("#hasil").val(hasil);
		}
		function kurang(){
			var angka1 = Number($("#angka1").val());
			var angka2 = Number($("#angka2").val());
			var hasil = angka1-angka2;
			$("#hasil").val(hasil);
		}
		function kali(){
			var angka1 = Number(document.getElementById("angka1").value);
			var angka2 = Number(document.getElementById("angka2").value);
			var hasil = angka1*angka2;
			document.getElementById("hasil").value=hasil;
		}
		function bagi(){
			var angka1 = Number($("#angka1").val());
			var angka2 = Number($("#angka2").val());
			var hasil = angka1/angka2;
			$("#hasil").val(hasil);
		}
		//$(document).ready(function(){
			//alert("Dokumen Sudah Ready");
		//});
	</script>
</body>
</html>