<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="main-header">
	<a href="cadastrarPaciente.jsp" class="logo">
		<span class="logo-mini">Clínica</span>
		<span class="logo-lg">
			<img width="80%" src="" alt="Logo da clínica">
		</span>
	</a>
	<nav class="navbar navbar-static-top">
		<a class="sidebar-toggle" href="#" data-toggle="push-menu" role="button">
			<span class="sr-only">Toggle Navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!--<li>
					${usuarioLogado.nome} ${usuarioLogado.sobrenome}
				</li>-->
				<li class="dropdown user user-menu">
					<a class="dropdown-toggle" href="#" data-toggle="dropdown">
						<span class="hidden-xs">${usuarioLogado.nome} ${usuarioLogado.sobrenome}</span>
					</a>
					
				<li class="dropdown messages-menu">
					<form action="logout" method="post">
						<button class="btn btn-danger" type="submit">Logout</button>
					</form>
				</li>
			</ul>
		</div>
	</nav>
</header>