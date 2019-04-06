<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo paciente</title>
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
						<h3 class="box-title">Novo paciente</h3>
					</div>
					<div class="box-body">
						<form role="form" action="novoPaciente" method="post">
							<div class="row">
							<!-- Essa tela de cadastro está dividida em 2 colunas de tamanho 6 do Bootsdtrap -->
								<div class="col-sm-6">
									<div class="form-group">
										<label>Nome</label>
										<input class="form-control" type="text" placeholder="Ex.: Maury Mitsuyuki" name="nomePaciente"/>
									</div>
									
									<div class="row">
										<div class="col-sm-10">
											<div class="form-group">
												<label>Sobrenome</label>
												<input class="form-control" type="text" placeholder="Ex.: Oshiro" name="sobrenomePaciente"/>
											</div>
										</div>
										<div class="col-sm-2">
											<div class="form-group">
												<label>Sexo</label>
												<select class="form-control" name="sexoPaciente">
													<option>F</option>
													<option>M</option>
												</select>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group">
												<label>RG</label>
												<input class="form-control" type="text" placeholder="Ex.: 16.052.933-5 até 15 dígitos" name="rgPaciente"/>
											</div>
										</div>
										
										<div class="col-sm-4">
											<div class="form-group">
												<label>CPF</label>
												<input class="form-control" type="text" placeholder="Ex.: 16.052.933-5" name="cpfPaciente" data-inputmask='"mask": "999.999.999-99"' data-mask/>
											</div>	
										</div>
										
										<div class="col-sm-4">
											<div class="form-group">
												<label>Data de nascimento</label>
												<div class="input-group date">
													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input class="form-control pull-right" type="text" placeholder="mm/dd/aaaa" id="datepicker" name="dataNascimentoPaciente"/>
												</div>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<label>Origem</label>
										<select class="form-control" name="origem" id="tipoOrigem" onchange="carregaOrigem()">
											<option value="1">Clínica</option>
											<option value="2">Empresa</option>
											<option value="3">Nenhuma das opções</option>
										</select>
									</div>
									
									<div id="origem">
										
									</div>
									
									<label>Possui convênio?</label>
									<div class="row">
										<div class="col-sm-2">
											<div class="form-group">
												<div class="radio">
													<label>
														<input class="" type="radio" name="possuiConvenio" value="true" checked>
														Sim
													</label>
												</div>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<div class="radio">
													<label>
														<input type="radio" name="possuiConvenio" value="false">
														Não (particular)
													</label>
												</div>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Qual convênio?</label>
												<select class="form-control" name="idConvenio">										
													<c:forEach var="convenio" items="${convenios}">
														<option value="${convenio.idCon}">${convenio.nomeFantasia}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Nível de escolaridade</label>
												<select class="form-control" name="nivelEscolaridadePaciente">
													<option>Ensino fundamental incompleto</option>
													<option>Ensino fundamental completo</option>
													<option>Ensino médio incompleto</option>
													<option>Ensino médio completo</option>
													<option>Ensino superior incompleto</option>
													<option>Ensino superior completo</option>
												</select>
											</div>
										</div>
									</div>
									
								</div>
								
								<!-- Segunda coluna do formulário -->
								<div class="col-sm-6">
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Tipo de via</label>
												<select class="form-control" name="tipoViaPaciente">
													<option>Alameda</option>
													<option>Avenida</option>
													<option>Beco</option>
													<option>Estrada</option>
													<option>Rodovia</option>
													<option selected="selected">Rua</option>
													<option>Travessa</option>
												</select>
											</div>
										</div>
										<div class="col-sm-9">
											<div class="form-group">
												<label>Logradouro</label>
												<input class="form-control" type="text" placeholder="Ex.: Senador Fláquer" name="logradouroPaciente"/>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Número</label>
												<input class="form-control" type="number" name="logradouroNumeroPaciente"/>
											</div>										
										</div>
										<div class="col-sm-9">
											<div class="form-group">
												<label>Complemento</label>
												<input class="form-control" type="text" name="complementoPaciente"/>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Bairro</label>
												<input class="form-control" type="text" name="bairroPaciente"/>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label>CEP</label>
												<input class="form-control" type="text" placeholder="09280-290" name="cepPaciente" data-inputmask='"mask": "99999-999"' data-mask/>
											</div>		
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label>UF</label>
												<select class="form-control" name="ufPaciente">
													<option>AC</option>
													<option>AL</option>
													<option>AP</option>
													<option>AM</option>
													<option>BA</option>
													<option>CE</option>
													<option>DF</option>
													<option>ES</option>
													<option>GO</option>
													<option>MA</option>
													<option>MT</option>
													<option>MS</option>
													<option>MG</option>
													<option>PA</option>
													<option>PB</option>
													<option>PR</option>
													<option>PE</option>
													<option>PI</option>
													<option>RR</option>
													<option>RO</option>
													<option>RJ</option>
													<option>RN</option>
													<option>RS</option>
													<option>SC</option>
													<option selected="selected">SP</option>
													<option>SE</option>
													<option>TO</option>
												</select>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<label>Cidade</label>
										<input class="form-control" type="text" placeholder="Santo André" name="cidadePaciente"/>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Telefone Principal</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-phone"></i>
													</div>
													<input class="form-control" type="text" placeholder="(11) 2222-5555" name="telefonePrincipalPaciente" data-inputmask='"mask": "(99) 9999-9999"' data-mask>
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Telefone Alternativo</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-phone"></i>
													</div>
													<input class="form-control" type="text" placeholder="(11) 2222-5555" name="telefoneSecundarioPaciente" data-inputmask='"mask": "(99) 9999-9999"' data-mask>
												</div>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Celular Principal</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-phone"></i>
													</div>
													<input class="form-control" type="text" placeholder="(11) 97777-5555" name="celularPrincipalPaciente" data-inputmask='"mask": "(99) 99999-9999"' data-mask>	
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Celular Alternativo</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-phone"></i>
													</div>
													<input class="form-control" type="text" placeholder="(11) 97777-5555" name="celularSecundarioPaciente" data-inputmask='"mask": "(99) 99999-9999"' data-mask>	
												</div>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<label>E-mail</label>
										<input class="form-control" type="email" placeholder="Ex.: paciente@gmail.com" name="emailPaciente"/>
									</div>
									
									<div class="form-group">
										<label>Observações (opcional)</label>
										<textarea class="form-control" rows="3" placeholder="Digite qualquer observação sobre este cadastro" name="observacaoPaciente"></textarea>
									</div>
								</div>
							</div>
							
							<button class="btn btn-primary" type="submit">Confirmar</button>
							<button class="btn btn-warning" type="reset">Limpar</button>
						</form>
					</div>
				</div>
			</section>
		</div>
	</div>
	<c:import url="../../comum/js.html"/>
	<script>
		$(function(){
			$('.select2').select2()
			
			$('#datepicker').datepicker({
      			autoclose: true
    		})
    		
    		$('[data-mask]').inputmask()
		});
		
		function carregaOrigem(){
			alert("Chamaou o javascript");
			var tipoOrigem = document.getElementById('tipoOrigem').value;
			var xhttp = new XMLHttpRequest();
			
			if(tipoOrigem == 1){
				alert("tipoOrigem: "+tipoOrigem)
				xhttp.onreadystatechange = function(){
					if(xhttp.readyState === 4 && xhttp.status === 200){
						document.getElementById('origem').innerHTML = xhttp.responseText;
					} else {
						//alert("Problema. readystate: "+xhttp.readystate+" status: "+xhttp.status);
					}
				}
				
				xhttp.open("POST","carregaCampoOrigem.jsp?tipoOrigem="+tipoOrigem,true);
				xhttp.send();
			}


		}
	</script>
</body>
</html>