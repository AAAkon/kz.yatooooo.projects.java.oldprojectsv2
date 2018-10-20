<div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 ">
<% if(request.getSession().getAttribute("userN")!=null && request.getSession().getAttribute("userI")!=null){%>
	
	<div id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn navlinks" onclick="closeNav()">&times;</a>
	  <a href="/FinalProject/home" class="navlinks">Store</a>
	  <a href="/FinalProject/myprofile" class="navlinks">Profile</a>
	  <% if(request.getSession().getAttribute("userP").equals("admin")){ %>
	  	<a href="/FinalProject/users" class="navlinks">Users</a>
	  <%} %>
	  <a href="/FinalProject/logout" class="navlinks">logout</a>
	  
	  <div class="created col-md-12">
	    <h4>Website created By</h4> 
	    <h2>Abilgazy Akezhan</h2>
	  </div>
	  <div class="follow col-md-12">
	    <h4>Follow us on social networks:</h4>
	    <ul class="social-network social-circle">
	        <li><a href="https://web.facebook.com/" class="icon icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
	        <li><a href="https://www.google.kz/" class="icon icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
	        <li><a href="https://vk.com/akonora" class="icon icoVk" title="Linkedin"><i class="fa fa-vk"></i></a></li>
	    </ul>       
	  </div>
	</div>
	
	<div id="main">
	   <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menu</span>
	</div>

<% }else{ %>

	<div id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn navlinks" onclick="closeNav()">&times;</a>
	  <a href="/FinalProject/home" class="navlinks">Store</a>
	  <a href="page?page=login" class="navlinks">Login</a>
	  <a href="page?page=registration" class="navlinks">Registration</a>
	  
	  <div class="created col-md-12">
	    <h4>Website created By</h4> 
	    <h4>Abilgazy Akezhan</h4>
	  </div>
	  <div class="follow col-md-12">
	    <h4>Follow us on social networks:</h4>
	    <ul class="social-network social-circle">
	        <li><a href="https://web.facebook.com/" class="icon icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
	        <li><a href="https://www.google.kz/" class="icon icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
	        <li><a href="https://vk.com/akonora" class="icon icoVk" title="Linkedin"><i class="fa fa-vk"></i></a></li>
	    </ul>       
	  </div>
	</div>
	
	<div id="main">
	   <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menu</span>
	</div>
	
<% } %>       
</div>        
  
      
<!-- Style -->
<%@include file="../css/navbarright.css" %>



<!-- Script -->
<%@include file="../js/navbarright.js"  %>