<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agendamento</title>
	<c:import url="../../comum/css.jsp"/>
</head>
<body class="skin-green sidebar-mini">
	<div class="wrapper">
		<c:import url="../../comum/header.jsp"/>
		<c:import url="../../comum/menuLateral.jsp"/>
		<div class="content-wrapper">
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Agendas</h3>
					</div>
					<div class="box-body">
					<form role="form" action="buscaAgenda" method="post">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label>Unidade</label>
									<select class="form-control" name="idUnidade" id="idUnidade" onchange="carregaProfissional()">										
										<c:forEach var="unidade" items="${unidades}">
											<option value="${unidade.id}">${unidade.descricao}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label>Profissional</label>
									<select class="form-control" name="idProfissional" id="idProfissional">
										<c:forEach var="profissional" items="${profissionais}">
											<option value="${profissional.idProfissional}">${profissional.nome} ${profissional.sobrenome}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="form-group">
									<label>Data</label>
									<div class="input-group date">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input class="form-control pull-right" type="text" placeholder="mm/dd/aaaa" id="datepicker" name="dataAgenda"/>
									</div>
								</div>
							</div>
						</div>
					</form>
						<table id="tabelaAgenda" class="table table-bordered table-hover-maury">
							<thead>
								<tr>
									<th>Selecionar</th>
									<th>Horário</th>
									<th>Paciente</th>
									<th>CPF do paciente</th>
									<th>Profissional</th>
									<th>Tipo do Atendimento</th>
									<th>Presente?</th>
								</tr>
							</thead>
							<tbody id="tabelaAgendaBody">
								<c:forEach var="ap" items="${agendasPaciente}">
									<tr class="tabelaAgenda">
										<td>checkbox</td>
										<td>${ap.hora.horario}</td>
										<td>${ap.paciente.nome} ${ap.paciente.sobrenome}</td>
										<td>${ap.paciente.cpf}</td>
										<td>${ap.profissional.nome} ${ap.profissional.sobrenome}</td>
										<td>${ap.tipoAtendimento}</td>
										<td>checkbox</td>
									</tr>
								</c:forEach>
								
								<c:forEach var="ac" items="${agendasCompromisso}">
									<tr class="tabelaAgenda">
										<td>checkbox</td>
										<td>${ac.hora.horario}</td>
										<td></td>
										<td></td>
										<td>${ac.profissional.nome} ${ac.profissional.sobrenome}</td>
										<td>${ac.tipoAtendimento}</td>
										<td>checkbox</td>
									</tr>
								</c:forEach>
								
								<c:forEach var="al" items="${agendasLivres}">
									<tr>
										<td>checkbox</td>
										<td>${al.hora.horario}</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td>checkbox</td>
									</tr>
								</c:forEach>
								<!-- <tr>
									<td>08:00</td>
									<td>Maury</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>09:00</td>
									<td>Henrique</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>10:00</td>
									<td>Henrique</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>11:00</td>
									<td>Keith</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>12:00</td>
									<td>Keith</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>13:00</td>
									<td>Keith</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>14:00</td>
									<td>Sueco</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr class="tabelaAgenda">
									<td>15:00</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>16:00</td>
									<td>Sueco</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>17:00</td>
									<td>Maury</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>18:00</td>
									<td>Maury</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr>
								<tr>
									<td>19:00</td>
									<td>Maury</td>
									<td>402.466.068-35</td>
									<td>Cristiano</td>
									<td>Terapia</td>
									<td>SIM</td>
									<td>Não</td>
								</tr> -->
							</tbody>
						</table>
					</div>
				</div>
			</section>
		</div>
	</div>	
	<c:import url="../../comum/js.html"/>
	<script src="js/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="js/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#tabelaAgenda').DataTable({
			      'paging'      : true,
			      'lengthChange': false,
			      'searching'   : false,
			      'ordering'    : true,
			      'info'        : true,
			      'autoWidth'   : false
			});
			
			$('#datepicker').datepicker({
      			autoclose: true
    		});
		});
		
		function carregaProfissional(){
			//alert("Chamaou o javascript");
			var idUnidade = document.getElementById('idUnidade').value;
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange = function(){
				if(xhttp.readyState === 4 && xhttp.status === 200){
					document.getElementById('idProfissional').innerHTML = xhttp.responseText;
				} else {
					//alert("Problema. readystate: "+xhttp.readystate+" status: "+xhttp.status);
				}
			}
			
			xhttp.open("POST","carregaComboBoxProfissional.jsp?idUnidade="+idUnidade,true);
			xhttp.send();
		}
		
	</script>
</body>
</html>