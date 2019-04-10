<html>
<head>
<meta charset="ISO-8859-1">
<title>Biodata</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
  	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
  	<script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
  	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

</head>
<body class="bg-light">
    <div class="container-fluid">
        <div class="row">
            
            <div class="col-md-3">
            	<h4 class="mb-3 mt-3">Form Mahasiswa</h4>
            	<form id=form-mahasiswa>
                <div class="mb-3">
                    <label for="nama">Nama</label>
                    <input type="text" class="form-control" id="nama" name="nama" required>
                </div>
                <div class="mb-3">
                    <label for="nim">NIM</label>
                    <input type="text" class="form-control" id="nim" name="nim" required>
                </div>
                <div class="mb-3">
                    <label for="jurusan">Jurusan</label>
                    <input type="text" class="form-control" id="jurusan" name="jurusan" required>
                </div>
                <div class="mb-3">
                    <label for="alamat">Alamat</label>
                    <input type="text" class="form-control" id="alamat" name="alamat" required>
                </div>
                <div class="mb-3">
                    <label for="tanggalLahir">Tanggal Lahir</label>
                    <input type="text" class="form-control" id="tanggalLahir" name="tanggalLahir" required>
                </div>
                <div class="mb-3">
                    <label for="telp">Telepon</label>
                    <input type="text" class="form-control" id="telp" name="telp" required>
                </div>
                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" required>
                </div>
                <hr class="mb-4">
                <input class="btn btn-primary btn-lg" type="button" value="Submit" onclick="simpan()">
                <input class="btn btn-secondary btn-lg" type="button" value="Reset" onclick="resetList()">
                </form>
            </div>
            
            <div class="col-md-9">
            	<h4 class="mb-3 mt-3">Data Mahasiswa</h4>
				<div class="table-responsive">
				  <table class="table table-striped table-sm">
				    <thead>
				      <tr>
				        <th>NIM</th>
				        <th>Nama</th>
				        <th>Alamat</th>
				        <th>Jurusan</th>
				        <th>Tanggal Lahir</th>
				        <th>Telepon</th>
				        <th>Email</th>
				        <th>Action</th>
				      </tr>
				    </thead>
				    <tbody id="dataMahasiswa">
				    </tbody>
				  </table>
				</div>    
            </div>
            
        </div>
    </div>
	<script>
		var modus = 'insert';

		function getFormData($form){
		    var unindexed_array = $form.serializeArray();
		    var indexed_array = {};

		    $.map(unindexed_array, function(n, i){
		        indexed_array[n['name']] = n['value'];
		    });

		    return indexed_array;
		}
		
		function resetList() {
			location = 'biodata-reset';
		}
		function tampilkanData(d) {
			var s = '';
			$(d).each(function(index, element) {
				s += '<tr>';
				s += '<td>' + element.nim + '</td>';
				s += '<td>' + element.nama + '</td>';
				s += '<td>' + element.alamat + '</td>';
				s += '<td>' + element.jurusan + '</td>';
				s += '<td>' + element.tanggalLahir + '</td>';
				s += '<td>' + element.telp + '</td>';
				s += '<td>' + element.email + '</td>';
				s += '<td>' + 
						'<input class="btn btn-secondary btn-sm" type="button" value="Edit" onclick="load(\'' + element.nim + '\')">' +
						'<input class="btn btn-danger btn-sm" type="button" value="Hapus" onclick="hapus(\'' + element.nim + '\')">' +
				     '</td>';
			    s += '</tr>';
			})
            $('#dataMahasiswa').html(s);
		}
        function loadData() {
            $.ajax({
                type: 'get',
                url: 'biodata-rest/',
                success: function(d) {
                    tampilkanData(d);
                }
            });
        }
        function simpan() {
            var method = 'post';
            var data;
			if(modus == 'insert') {
				method = 'post';
				data = getFormData($('#form-mahasiswa'));
			} else {
				method = 'put';
				data = getFormData($('#form-mahasiswa'));
			}
			console.log(data);
			$.ajax({
                type: method,
                url: 'biodata-rest/',
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json',
                success: function(d) {
                    loadData();
                    modus = 'insert';
                    $('#nim, #nama, #alamat, #jurusan, #tanggalLahir, #telp, #email').val('');
                },
                error: function(d) {

                }
            });
        }
        function hapus(nim) {
            $.ajax({
                type: 'delete',
                url: 'biodata-rest/' + nim,
                success: function(d) {
                    loadData();
                },
                error: function(d) {

                }
            });
        }
        function load(nim) {
			$.ajax({
				type: 'get',
				url: 'biodata-rest/' + nim,
				success: function(d) {
					$('#nama').val(d.nama);
					$('#nim').val(d.nim);
					$('#alamat').val(d.alamat);
					$('#jurusan').val(d.jurusan);
					$('#tanggalLahir').val(d.tanggalLahir);
					$('#telp').val(d.telp);
					$('#email').val(d.email);
					modus = 'update';
				}
			});
        } 
        $(document).ready(function() {
            loadData();
        });
	</script>
</body>
</html>