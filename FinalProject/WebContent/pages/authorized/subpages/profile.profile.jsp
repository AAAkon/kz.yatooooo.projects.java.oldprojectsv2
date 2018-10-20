<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <c:forEach items="${user}" var="user">     
  	 <div class="well profile">
          <div class="col-sm-12">
          	<div class="col-lg-5 col-md-12 col-sm-12 col-xs-12  ">
                  <figure>
                      <img src="<c:out value="${user.imagepath}"/>" width="250px" height="250px">
                      <figcaption class="ratings">
                          <p>Ratings
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                               <span class="fa fa-star-o"></span>
                          </a> 
                          </p>
                      </figcaption>
                  </figure>
              </div>
              <div class="col-lg-7 col-md-12 col-sm-12 col-xs-12 ">
                  <h2 class="profile-info"><c:out value="${user.name}"/> <c:out value="${user.surname}" /></h2>
                  <p><strong>City: </strong><span class="profile-info"><c:out value="${user.city }"/></span></p>
                  <p><strong>Address: </strong><span class="profile-info"><c:out value="${user.address }"/></span></p>
                  <p><strong>Phone no: </strong><span class="profile-info"><c:out value="${user.phoneno }"/></span></p>
                  <p><strong>Email: </strong><span class="profile-info"><c:out value="${user.email }"/></span></p>
                  <p>
                   <c:if test="${user.isright==true}">
                       <span class="tags isright">Right user</span>
                   </c:if>
                   <c:if test="${user.isdeleted==true}">
                       <span class="tags isdeleted">Deleted user</span>
                   </c:if>
                   <c:if test="${user.isadmin==true}">
                       <span class="tags isadmin">Admin</span>
                   </c:if> 
                  </p>
              </div>             
          </div>            
          <div class="col-xs-12 divider text-center">
              <div class="col-xs-12 col-sm-4 emphasis">
                  <h2><strong> 20,7K </strong></h2>                    
                  <p><small>Followers</small></p>
                  <button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Follow </button>
              </div>
              <div class="col-xs-12 col-sm-4 emphasis">
                  <h2><strong>245</strong></h2>                    
                  <p><small>Following</small></p>
                  <button class="btn btn-info btn-block"><span class="fa fa-user"></span> View Profile </button>
              </div>
              <div class="col-xs-12 col-sm-4 emphasis">
                  <h2><strong>43</strong></h2>                    
                  <p><small>Snippets</small></p>
                  <div class="btn-group dropup btn-block">
                    <button type="button" class="btn btn-primary"><span class="fa fa-gear"></span> Options </button>
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                      <span class="caret"></span>
                      <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu text-left" role="menu">
                      <li><a href="#"><span class="fa fa-envelope pull-right"></span> Send an email </a></li>
                      <li><a href="#"><span class="fa fa-list pull-right"></span> Add or remove from a list  </a></li>
                      <li class="divider"></li>
                      <li><a href="#"><span class="fa fa-warning pull-right"></span>Report this user for spam</a></li>
                      <li class="divider"></li>
                      <li><a href="#" class="btn disabled" role="button"> Unfollow </a></li>
                    </ul>
                  </div>
              </div>
          </div>
  	 </div>
 </c:forEach>
 </div>