<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 



<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-black" style="z-index:3;width:200px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="./images/avatar2.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>Admin</strong></span><br>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
    </div>
  </div>
  
  <hr>
  
  <div class="w3-container">
    <h5><b><a href="adminMain.html">어드민 목록</a></b></h5>
    <hr>
  </div>
  <div class="w3-bar-block">
    <a href="review?command=memberlistAllAdmin" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user"></i>&nbsp; 회원 목록 </a>
    <a href="review?command=boardlistAllAdmin" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-text-o"></i>&nbsp; 게시글 목록</a>
    <a href="review?command=commentlistAllAdmin" class="w3-bar-item w3-button w3-padding"><i class="fa fa-comments-o"></i>&nbsp; 댓글 목록</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user-times"></i>&nbsp; 관리자 명단</a>
    <a href="login.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>&nbsp; 로그아웃하기</a><br><br>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:200px;margin-top:43px;">

  <!-- Header -->
  
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> 빠른 실행</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    <div class="w3-quarter">
   <a href="review?command=memberlistAllAdmin">
      <div class="w3-container w3-red w3-padding-16">
        <div class="w3-left"><i class="fa fa-user w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>--</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>회원목록</h4>
      </div>
      </a>
    </div>
    
    <div class="w3-third">
      <div class="w3-container w3-blue w3-padding-16">
      <a href="review?command=boardlistAllAdmin">
        <div class="w3-left"><i class="fa fa-eye w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>99</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>게시글 목록</h4>
      </div>
      </a>
    </div>
    <div class="w3-third">
    <a href="review?command=commentlistAllAdmin">
      <div class="w3-container w3-teal w3-padding-16">
        <div class="w3-left"><i class="fa fa-comment w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>23</h3>
        </div>
        <div class="w3-clear"></div>
        <h4>댓글 목록</h4>
      </div>
      </a>
    </div>
    

  <div class="w3-row-padding w3-margin-bottom">

