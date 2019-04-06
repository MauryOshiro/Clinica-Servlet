<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo funcionário</title>
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
						<h3 class="box-title">Novo funcionário</h3>
					</div>
					<div class="box-body">
						<form role="form" action="novoFuncionario" method="post">
							<div class="row">
							<!-- Essa tela de cadastro está dividida em 2 colunas de tamanho 6 do Bootsdtrap -->
								<div class="col-sm-6">
									<div class="form-group">
										<label>Nome</label>
										<input class="form-control" type="text" placeholder="Ex.: Maury Mitsuyuki" name="nome"/>
									</div>
									
									<div class="row">
										<div class="col-sm-10">
											<div class="form-group">
												<label>Sobrenome</label>
												<input class="form-control" type="text" placeholder="Ex.: Oshiro" name="sobrenome"/>
											</div>
										</div>
										<div class="col-sm-2">
											<div class="form-group">
												<label>Sexo</label>
												<select class="form-control" name="sexo">
													<option>F</option>
													<option>M</option>
												</select>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>RG</label>
												<input class="form-control" type="text" placeholder="Ex.: 16.052.933-5 até 15 dígitos" name="rg"/>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>CPF</label>
												<input class="form-control" type="text" placeholder="Ex.: 16.052.933-5" name="cpf" data-inputmask='"mask": "999.999.999-99"' data-mask/>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Data de nascimento</label>
												<div class="input-group date">
													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input class="form-control pull-right" type="text" placeholder="mm/dd/aaaa" id="dataNascimento" name="dataNascimento"/>
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Nível de escolaridade</label>
												<select class="form-control" name="nivelEscolaridade">
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
									
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Tipo de via</label>
												<select class="form-control" name="tipoVia">
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
												<input class="form-control" type="text" placeholder="Ex.: Senador Fláquer" name="logradouro"/>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label>Número</label>
												<input class="form-control" type="number" name="logradouroNumero"/>
											</div>										
										</div>
										<div class="col-sm-9">
											<div class="form-group">
												<label>Complemento</label>
												<input class="form-control" type="text" name="complemento"/>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Bairro</label>
												<input class="form-control" type="text" name="bairro"/>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label>CEP</label>
												<input class="form-control" type="text" placeholder="09280-290" name="cep" data-inputmask='"mask": "99999-999"' data-mask/>
											</div>		
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label>UF</label>
												<select class="form-control" name="uf">
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
										<input class="form-control" type="text" placeholder="Santo André" name="cidade"/>
									</div>
								</div>
								
								<div class="col-sm-6">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Telefone Principal</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-phone"></i>
													</div>
													<input class="form-control" type="text" placeholder="(11) 2222-5555" name="telefonePrincipal" data-inputmask='"mask": "(99) 9999-9999"' data-mask>
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
													<input class="form-control" type="text" placeholder="(11) 2222-5555" name="telefoneSecundario" data-inputmask='"mask": "(99) 9999-9999"' data-mask>
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
													<input class="form-control" type="text" placeholder="(11) 97777-5555" name="celularPrincipal" data-inputmask='"mask": "(99) 99999-9999"' data-mask>	
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
													<input class="form-control" type="text" placeholder="(11) 97777-5555" name="celularSecundario" data-inputmask='"mask": "(99) 99999-9999"' data-mask>	
												</div>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>E-mail</label>
												<input class="form-control" type="email" placeholder="Ex.: paciente@gmail.com" name="email"/>
											</div>	
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Observações (opcional)</label>
												<textarea class="form-control" rows="3" placeholder="Digite qualquer observação sobre este cadastro" name="observacao"></textarea>
											</div>	
										</div>
									</div>

									<div class="row">
										<div class="col-sm-4">
											<div class="form-group">
												<label> Departamento</label>
												<input class="form-control" type="text" placeholder="Ex.: Secretaria" name="departamento">
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<label>Cargo</label>
												<select class="form-control" name="idCargo">
													<c:forEach var="cargo" items="${cargos}">
														<option value="${cargo.id}">${cargo.descricao}</option>
													</c:forEach>
													<!--<option value="1">Supervisor</option>
													<option value="2">Psicólogo</option>
													<option value="3">Nutricionista</option>
													<option value="4">Secretária</option> -->
												</select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<label>Data da admissão</label>
												<div class="input-group date">
													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input class="form-control pull-right" type="text" placeholder="mm/dd/aaaa" id="dataAdmissao" name="dataAdmissao"/>
												</div>
											</div>
										</div>
									</div>
	
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Usuário</label>
												<input class="form-control" type="text" placeholder="Usuário para ser usado na tela de login" name="login">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Senha</label>
												<input class="form-control" type="password" placeholder="Senha" name="senha">
											</div>
										</div>
									</div>
									
									<label>Tipo de usuário</label>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group">
												<div class="radio">
													<label>
														<input type="radio" name="tipoUsuario" value="Comum" checked>
														Comum
													</label>
												</div>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<div class="radio">
													<label>
														<input type="radio" name="tipoUsuario" value="Administrador">
														Administrador
													</label>
												</div>
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Terá acesso a quais módulos?</label>
												<select class="form-control" multiple="multiple" name="modulos">
													<c:forEach var="modulo" items="${modulos}">
														<option value="${modulo.id}">${modulo.nomeModulo}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Trabalhará em quais unidades da clínica?</label>
												<select class="form-control" multiple="multiple" name="unidades">
													<c:forEach var="unidade" items="${unidadesDaEmpresa}">
														<c:choose>
															<c:when test="${unidade.ativo == true}">
																<option value="${unidade.id}">${unidade.descricao}</option>
															</c:when>
															<c:otherwise>
																<option value="${unidade.id}" disabled>${unidade.descricao} (desabilitado)</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</div>
										</div>
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
			$('.select2').select2();
			
			$('#dataNascimento').datepicker({
      			autoclose: true
    		});
    		
    		$('#dataAdmissao').datepicker({
      			autoclose: true
    		});
    		
    		$('[data-mask]').inputmask();
		})
	</script>
</body>
</html>