<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<button class="btn" id="AddHandmakeFormToggle">ADD HANDMAKE - You can show or hide form by clicking this button</button>
</div>
		
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="AddHandmakeForm">
          <div class="panel panel-default">
          <form action="item?action=additem" method="post" enctype="multipart/form-data">
          	<h4 id="item-title">add new handmake form</h4>
          	<hr>
              <div class="panel-body form-horizontal payment-form">
              	<div class="form-group files">
	    			<input  id="2" type="file" name="image2">
   					<img id="avatar2" src="#" alt="" />
	  			</div>
                  <div class="form-group">
                      <label for="concept" class="col-sm-3 control-label">Name</label>
                      <div class="col-sm-9">
                          <input type="text" class="form-control" id="concept" name="name" required>
                      </div>
                  </div>
                  <div class="form-group">
                      <label for="description" class="col-sm-3 control-label">Description</label>
                      <div class="col-sm-9">
                          <input type="text" class="form-control" id="description" name="description" required>
                      </div>
                  </div>
                  <div class="form-group">
                      <label for="amount" class="col-sm-3 control-label">Amount</label>
                      <div class="col-sm-9">
                          <input name="amount" type="number" value="1" min="1" max="1000000" class="form-control" id="amount" required>
                      </div>
                  </div> 
                  <div class="form-group">
                      <label for="amount" class="col-sm-3 control-label">Price</label>
                      <div class="col-sm-9">
                      	<div class="input-group"> 
			       		<span class="input-group-addon">&#8376;</span>
			        	<input name="price" type="number" value="0" min="0" class="form-control currency" required />
			    	</div>	
                     	</div>
                  </div>
                  <div class="form-group">
                      <label for="status" class="col-sm-3 control-label">Category name</label>
                      <div class="col-sm-9">
                          <select class="form-control" id="status" name="categorynameselect" onchange="OtherCategory(this.value)" required>
                              <option value="">...select...</option>
                              <c:forEach items="${categories}" var="category"> 
                              	<option value="<c:out value="${category.name}"/>"><c:out value="${category.name}"/></option>
                              </c:forEach>
                              <option value="other">other</option>
                          </select>
                      </div>
                  </div> 
                  <div class="form-group" id="OtherCategory">
                      <label for="concept" class="col-sm-3 control-label">Category name</label>
                      <div class="col-sm-9">
                          <input type="text" class="form-control" id="concept" name="categorynameinput">
                      </div>
                  </div> 
    
                  
                      <div class="col-sm-12 text-right">
                          <input type="submit" class="btn btn-default" value="+Add">
					   </div>
                  
              </div>
          </form>
          </div>            
      </div>