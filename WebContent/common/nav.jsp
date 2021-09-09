<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white " style="z-index: 3; width: 250px;" id="mySidebar">
	<br>
	<div class="w3-container w3-row">
		<div class="w3-col s4">
			<img src="./images/whowho.jpg" class="w3-circle w3-margin-right"
				style="width: 46px">
		</div>
		<div class="w3-col s8 w3-bar">
				<span>반가워요!<strong>${sessionScope.user.nickName}</strong></span><br> <a href="#"
					class="w3-bar-item w3-button"><i class="fa fa-user"></i></a> <a
					href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>

		</div>
	</div>
	<hr>
	<div class="w3-container">
		<h5>메뉴</h5>
	</div>
	<div class="w3-bar-block">
		<a href="#"
			class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
			onclick="w3_close()" title="close menu"><i
			class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a> <a href="${pageContext.request.contextPath}/review?command=boardlistAllUser"
			class="w3-bar-item w3-button w3-padding w3-blue"><i
			class="fa fa-users fa-fw"></i>&nbsp; 전체 게시글</a> <a href="${pageContext.request.contextPath}/review?command=boardlistAllUser"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-eye fa-fw"></i>&nbsp; 자유 후기</a> <a href="${pageContext.request.contextPath}/review?command=boardlistAllUser"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-users fa-fw"></i>&nbsp; 영화 후기</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bullseye fa-fw"></i>&nbsp; 맛집 후기</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-diamond fa-fw"></i>&nbsp; 게임 후기</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bell fa-fw"></i>&nbsp; IT/테크 후기</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-cog fa-fw"></i>&nbsp; 로그아웃하기</a><br> <br>
	</div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity"
	onclick="w3_close()" style="cursor: pointer" title="close side menu"
	id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

	<!-- Header -->

	<header class="w3-container" style="padding-top: 22px">
		<h5>
			<b><i class="fa fa-dashboard"></i>아무 후기나 구경해라</b>
		</h5>
	</header>

	<div class="w3-row-padding w3-margin-bottom">
		<div class="w3-quarter">
			<div class="w3-container w3-red w3-padding-16">
				<div class="w3-left">
					<i class="fa fa-comment w3-xxxlarge"></i>
				</div>
				<div class="w3-right">
					<h3>?</h3>
				</div>
				<div class="w3-clear"></div>
				<h4>인기글</h4>
			</div>
		</div>
		<div class="w3-quarter">
			<div class="w3-container w3-blue w3-padding-16">
				<div class="w3-left">
					<i class="fa fa-eye w3-xxxlarge"></i>
				</div>
				<div class="w3-right">
					<h3>?</h3>
				</div>
				<div class="w3-clear"></div>
				<h4>전체 게시글</h4>
			</div>
		</div>
		<div class="w3-quarter">
			<div class="w3-container w3-teal w3-padding-16">
				<div class="w3-left">
					<i class="fa fa-share-alt w3-xxxlarge"></i>
				</div>
				<div class="w3-right">
					<h3>?</h3>
				</div>
				<div class="w3-clear"></div>
				<h4>맛집 후기</h4>
			</div>
		</div>
		<div class="w3-quarter">
			<div class="w3-container w3-orange w3-text-white w3-padding-16">
				<div class="w3-left">
					<i class="fa fa-users w3-xxxlarge"></i>
				</div>
				<div class="w3-right">
					<h3>?</h3>
				</div>
				<div class="w3-clear"></div>
				<h4>영화 후기</h4>
			</div>
		</div>
	</div>