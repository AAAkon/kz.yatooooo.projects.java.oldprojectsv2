<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Library System</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="resources/vendors/bootstrap/css/bootstrap.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="resources/vendors/datatables/dataTables.bootstrap.css">
        <!-- iCheck for checkboxes and radio inputs -->
        <link rel="stylesheet" href="resources/vendors/iCheck/all.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="resources/vendors/font-awesome/css/font-awesome.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="resources/vendors/admin-lte/css/AdminLTE.css">
        <!-- Font -->
        <link rel="stylesheet" href="resources/vendors/sans-pro/font.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="resources/vendors/admin-lte/css/skins/skin-green-light.min.css">
        <link rel="stylesheet" href="resources/vendors/admin-lte/css/skins/skin-blue-light.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="resources/vendors/iCheck/flat/blue.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="resources/vendors/morris/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="resources/vendors/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="resources/vendors/datepicker/datepicker3.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="resources/vendors/daterangepicker/daterangepicker.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="resources/vendors/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
        <!-- jquery datatable -->
        <link rel="stylesheet" href="resources/vendors/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
        <!-- Date Time Picker -->
        <link rel="stylesheet" href="resources/vendors/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
        <!-- jQuery 2.2.3 -->
        <script src="resources/vendors/jQuery/jquery-2.2.3.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="resources/vendors/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
          $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.6 -->
        <script src="resources/vendors/bootstrap/js/bootstrap.min.js"></script>
        <!-- DataTables -->
        <script src="resources/vendors/datatables/jquery.dataTables.min.js"></script>
        <script src="resources/vendors/datatables/dataTables.bootstrap.min.js"></script>
        <!-- Morris.js charts -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="resources/vendors/morris/morris.min.js"></script>
        <!-- Sparkline -->
        <script src="resources/vendors/sparkline/jquery.sparkline.min.js"></script>
        <!-- jvectormap -->
        <script src="resources/vendors/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="resources/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="resources/vendors/knob/jquery.knob.js"></script>
        <!-- daterangepicker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="resources/vendors/daterangepicker/daterangepicker.js"></script>
        <!-- datepicker -->
        <script src="resources/vendors/datepicker/bootstrap-datepicker.js"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="resources/vendors/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
        <!-- Slimscroll -->
        <script src="resources/vendors/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="resources/vendors/fastclick/fastclick.js"></script>
        <!-- iCheck 1.0.1 -->
        <script src="resources/vendors/iCheck/icheck.min.js"></script>
        <!-- AdminLTE App -->
        <script src="resources/vendors/admin-lte/js/app.min.js"></script>
        
        <!-- AdminLTE for demo purposes -->
        <script src="resources/vendors/admin-lte/js/demo.js"></script>
        
        <!-- moment.js -->
        <script src="resources/vendors/momentjs/moment.js"></script>
        <script src="resources/vendors/momentjs/locale/ru.js"></script>
        
        <!-- datetimepicker.js -->
        <script src="resources/vendors/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
        
        <!-- Custom style -->
        <link rel="stylesheet" href="resources/style.css">
        
        <!-- Tender -->
        <script src="resources/scripts.js"></script>
        
        <style>
        	.hover-danger:hover{
        		color:red;
        	}
        	.text-white{
        		color:white;
        	}
        	.little-bottom-margins{
				margin-bottom: 5px;
			}
			
			.little-top-margins{
				margin-top: 5px;
			}
			
			.little-right-margins{
				margin-right: 5px;
			}

			.add_post_btn{
				position: fixed;
				bottom: 25px; 
				right: 25px;
			}

        </style>
        
    </head>
    <body class="hold-transition skin-blue-light sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="." class="logo">
                  <!-- mini logo for sidebar mini 50x50 pixels -->
                  <span class="logo-mini"><b>L</b>S</span>
                  <!-- logo for regular state and mobile devices -->
                  <span class="logo-lg"><b>Library</b>System</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                  <!-- Sidebar toggle button-->
                  <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                  </a>

                  <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                      <c:if test="${loggedUser != null}">
                      <!-- Notifications: style can be found in dropdown.less -->
                      <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <i class="fa fa-bell-o"></i>
                          <span class="label label-warning">5</span>
                        </a>
                        <ul class="dropdown-menu">
                        
                          <li class="header">You have 5 new notifications</li>
                          <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li>
                                    <a href="#">
                                        <i class="fa fa-wpforms text-red"></i> Deadline for something
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-clock-o text-red"></i> Delivery time
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-warning text-yellow"></i> Info about something
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-users text-yellow"></i> Information about something
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-dollar text-yellow"></i> Payment to something
                                    </a>
                                </li>
                                
                            </ul>
                          </li>
                          <li class="footer"><a href="#">View All</a></li>
                        </ul>
                      </li>
                      <!-- Tasks: style can be found in dropdown.less -->
                      
                      <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <i class="fa fa-flag-o"></i>
                          <span class="label label-danger">6</span>
                        </a>
                        <ul class="dropdown-menu">
                          <li class="header">You have 6 active projects</li>
                          <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- Task item -->
                                    <a href="#">
                                      <h3 style='white-space: normal'>
                                        Delivery of auto for AO "First Aid"
                                        <small class="pull-right">Filling Requirements</small>
                                      </h3>
                                      <div class="progress xs">
                                        <div class="progress-bar progress-bar-yellow" style="width: 0%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                          <span class="sr-only">0% Complete</span>
                                        </div>
                                        
                                      </div>
                                    </a>
                                </li>
                                <li><!-- Task item -->
                                    <a href="#">
                                      <h3 style='white-space: normal'>
                                        Delivery of components on the auto JSC "KazAgro"
                                        <small class="pull-right">Upcoming Project</small>
                                      </h3>
                                      <div class="progress xs">
                                        <div class="progress-bar progress-bar-yellow" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                          <span class="sr-only">20% Complete</span>
                                        </div>
                                        
                                      </div>
                                    </a>
                                </li>
                                <li><!-- Task item -->
                                    <a href="#">
                                      <h3 style='white-space: normal'>
                                        Software development for JSC "State Corporation"
                                        <small class="pull-right">Won</small>
                                      </h3>
                                      <div class="progress xs">
                                        <div class="progress-bar progress-bar-red" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                          <span class="sr-only">40% Complete</span>
                                        </div>
                                        
                                      </div>
                                    </a>
                                </li>
                              
                            </ul>
                          </li>
                          <li class="footer">
                            <a href="#">View All</a>
                          </li>
                        </ul>
                      </li>
                      <!-- User Account: style can be found in dropdown.less -->
                      
                      <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <img src="resources/vendors/admin-lte/img/user2-160x160.jpg" class="user-image" alt="User Image">
                          <span class="hidden-xs">${loggedUser.getName()}</span>
                        </a>
                        <ul class="dropdown-menu">
                          <!-- User image -->
                          <li class="user-header">
                            <img src="resources/vendors/admin-lte/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                            <br/>
                            <span class="text-white">${loggedUser.getName()}</span>
                          </li>
                          <!-- Menu Body -->
                          
                          <c:if test="${loggedUser.isAdmin() }">
                          		<li class="user-body">
	                        		<div class="text-center">
	                              		<a href="adminUsers">User management</a>
	                              	</div>
                    			</li>
                          </c:if>
                              
                          <!-- Menu Footer-->
                          <li class="user-footer">
                            <div class="pull-left">
                              <a href="#" class="btn btn-default btn-flat">Profile</a>
                            </div>
                            <div class="pull-right">
                              <a href="authLogout" class="btn btn-default btn-flat">Log out</a>
                            </div>
                          </li>
                        </ul>
                      </li>
                      </c:if>
                    </ul>
                  </div>
                </nav>
              </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                          <img src="resources/vendors/admin-lte/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                          <p>${loggedUser.getName()}</p>
                          <a href="#">
                          	<i class="fa fa-circle text-primary"></i> 
                          	<c:choose>
                          		<c:when test="${loggedUser.isAdmin()}">
                          			Admin
                          		</c:when>
                          		<c:otherwise>
                          			Member
                          		</c:otherwise>
                          	</c:choose>
                          </a>
                        </div>
                    </div>
                    
                    
                    
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">Navigation</li>

							<c:if test="${loggedUser != null}">
		                       <li class="active treeview">
		                          <a href="#">
		                            <i class="fa fa-files-o"></i> <span>Books</span>
		                            <span class="pull-right-container">
		                              <i class="fa fa-angle-left pull-right"></i>
		                            </span>
		                          </a>
		                          <ul class="treeview-menu">
		                          	<li class="${action == 'books' ? 'active' : '' }">
		                                <a href="books">
		                                	<i class="fa fa-circle-o"></i> Book list</span>
		                                </a>        
		                            </li> 
		                          		                            
		                          </ul>
		                        </li>
	                        </c:if>
                          
	                        <c:if test="${loggedUser.isAdmin()}">
	                            <li class="active treeview">
		                          <a href="#">
		                            <i class="fa fa-files-o"></i> <span>Admin</span>
		                            <span class="pull-right-container">
		                              <i class="fa fa-angle-left pull-right"></i>
		                            </span>
		                          </a>
		                          <ul class="treeview-menu">
		                          	<li class="${action == 'adminBookRequests' ? 'active' : '' }">
		                                <a href="adminBookRequests">
		                                	<i class="fa fa-circle-o"></i> Book requests</span>
		                                </a>        
		                            </li>
	                            	<li class="${action == 'adminBookReturns' ? 'active' : '' }">
		                                <a href="adminBookReturns">
		                                	<i class="fa fa-circle-o"></i> Book returns</span>
		                                </a>        
		                            </li>
		                          </ul>
		                        </li>
	                        </c:if> 
	                        
	                        <c:if test="${loggedUser.isMember()}">
	                            <li class="active treeview">
		                          <a href="#">
		                            <i class="fa fa-files-o"></i> <span>Member</span>
		                            <span class="pull-right-container">
		                              <i class="fa fa-angle-left pull-right"></i>
		                            </span>
		                          </a>
		                          <ul class="treeview-menu">
		                          	<li class="${action == 'memberBookRequests' ? 'active' : '' }">
		                                <a href="memberBookRequests">
		                                	<i class="fa fa-circle-o"></i> Book requests</span>
		                                </a>        
		                            </li>
		                            <li class="${action == 'memberBookReturns' ? 'active' : '' }">
		                                <a href="memberBookReturns">
		                                	<i class="fa fa-circle-o"></i> Book returns</span>
		                                </a>        
		                            </li>
		                            
		                          </ul>
		                        </li>
	                        </c:if>    
	                        
	                        <li class="active treeview">
	                          <a href="#">
	                            <i class="fa fa-files-o"></i> <span>Forum</span>
	                            <span class="pull-right-container">
	                              <i class="fa fa-angle-left pull-right"></i>
	                            </span>
	                          </a>
	                          <ul class="treeview-menu">
	                          	<li class="${action == 'posts' ? 'active' : '' }">
	                                <a href="posts">
	                                	<i class="fa fa-circle-o"></i> Discussion board</span>
	                                </a>        
	                            </li> 
	                          		                            
	                          </ul>
	                        </li> 
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- /.content -->
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        