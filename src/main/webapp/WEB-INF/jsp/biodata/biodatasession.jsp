<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biodata</title>
<link rel="stylesheet" type="text/css" href="../assets/css/style.css">
<link rel="stylesheet"
	href="../assets/css/bootstrap.min.css">
<script
	src="../assests/js/jquery.min.js"></script>
<script
	src="../assets/js/bootstrap.min.js"></script>
<script
	src="../assets/js/popper.min.js"></script>
</head>
<body>
	<div class="jumbotron tesxt-center">
		<h1>
			<center>Biodata</center>
		</h1>
	</div>
	<form class="form-style-5" method="post" action="biodata-save">
		Nama:<br> <input class="form-control" type="text" name="nama" required><br> <br>
		NIM:<br> <input class="form-control" type="text" name="nim"><br>
		Jurusan:<br> <input class="form-control" type="text" name="jurusan"><br> 
		Universitas:<br> <input class="form-control" type="text" name="universitas"><br> 
		Tanggal Lahir:<br> <input class="form-control" type="text" name="tanggalLahir"><br> 
		<input type="Submit" class="btn btn-secondary" value="Send Letter" > 
		<input type="button" class="btn btn-secondary" value="Reset" onclick="ketikaKlik()">
	</form>
	<table>
		<c:forEach items="${list}" var="a">
			<tr>
				<td>${a.nama}<td></td></td>
				<td>${a.nim}<td></td></td>
				<td>${a.jurusan}<td></td></td>
				<td>${a.universitas}<td></td></td>
				<td>${a.tanggalLahir}<td></td></td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function ketikaKlik() {
			location = 'biodata-reset';
		}
	</script>
</body>
</html>