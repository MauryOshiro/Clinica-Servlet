<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="WEB-INF/comum/css.jsp"/>
</head>
<body>
	<section class="content">
		<h1>Bem vindo ao sistema da clínica!</h1>
		<br />
		<div class="loginCentralizado">
			<div class="box box-primary">			
				<c:if test="${not empty usuarioLogado}">
			        Você é ${usuarioLogado.nome} ${usuarioLogado.sobrenome}<br />
					<form action="logout" method="post">
						<button class="btn btn-danger" type="submit">Logout</button>
					</form>
				</c:if>
				<c:if test="${empty usuarioLogado}">
					<div class="box-header with-border">
						<h3 class="box-title">Login</h3>
					</div>
					<form role="form" action="login" method="post">
						<div class="box-body">
							<div class="form-group">
								<label>
									Usuário:
								</label>
								<input class="form-control" placeholder="Digite o seu login" type="text" name="usuario">	
							</div>
							<div class="form-group">
								<label>
									Senha:
								</label>
								<input class="form-control" placeholder="Sua senha" type="password" name="senha">
							</div>
							<c:if test="${not empty falhaLogin}">
								<div class="form-group has-error">
									<label class="control-label" for="inputError">
										<i class="fa fa-times-circle-o"></i>
										${falhaLogin}							
									</label>
								</div>
							</c:if>
						</div>
						<div class="box-footer">
							<button class="btn btn-primary" type="submit">Logar</button>
							<button class="btn btn-warning" type="reset">Limpar</button>
						</div>
					</form>
				</c:if>
			</div>
		</div>
	</section>
	<c:import url="WEB-INF/comum/js.html"/>
</body>
</html>