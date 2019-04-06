<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="main-sidebar" style="height: 100%;">
	<section class="sidebar">
		<ul class="sidebar-menu tree" data-widget="tree">
			<li class="header">Atendimento</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-files-o"></i>
					<span>Pacientes</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li>
						<a href="cadastrarPaciente.jsp">
							<i class="fa fa-circle-o"></i>
							Cadastrar novo paciente
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consultar
						</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="agendamento.jsp">
					<i class="fa fa-calendar"></i>
					<span>Agendamento</span>
				</a>
			</li>
			
			<li class="header">Financeiro</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-pie-chart"></i>
					<span>Faturamento</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Registrar entrada
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consultar entradas
						</a>
					</li>
				</ul>
			</li>
			
			<li class="treeview">
				<a href="#">
					<i class="fa fa-pie-chart"></i>
					<span>Despesas</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Registrar saída
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consultar saídas
						</a>
					</li>
				</ul>
			</li>
			
			<li class="treeview">
				<a href="#">
					<i class="fa fa-pie-chart"></i>
					<span>Fluxo de Caixa</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Cadastro de Portadores
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consultar portadores
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Cadastro de lançamentos
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consulta de lançamentos
						</a>
					</li>
				</ul>
			</li>
			
			<li class="header">Sistema</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-edit"></i>
					<span>Funcionários</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li>
						<a href="cadastrarFuncionario.jsp">
							<i class="fa fa-circle-o"></i>
							Cadastrar
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consultar
						</a>
					</li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-edit"></i>
					<span>Profissionais</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li>
						<a href="cadastrarProfissional.jsp">
							<i class="fa fa-circle-o"></i>
							Cadastrar
						</a>
					</li>
					<li>
						<a href="#">
							<i class="fa fa-circle-o"></i>
							Consultar
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</section>
</aside>