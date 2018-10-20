<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    </div>
    
    	 
    <script>
    
	    jQuery.fn.dataTableExt.oSort["cur-desc"] = function(x,y) {
	        var valX = parseInt($("<div>" + x + "</div>").find('span').html());
	        var valY = parseInt($("<div>" + y + "</div>").find('span').html());
	        return valX <= valY;
	    }
	    jQuery.fn.dataTableExt.oSort["cur-asc"] = function(x,y) {
	        var valX = parseInt($("<div>" + x + "</div>").find('span').html());
	        var valY = parseInt($("<div>" + y + "</div>").find('span').html());
	        return valX >= valY;
	    }
	    
	    jQuery.fn.dataTableExt.oSort["cur-desc"] = function(x,y) {
	        var valX = parseInt($("<div>" + x + "</div>").find('span.for-sorting').html());
	        var valY = parseInt($("<div>" + y + "</div>").find('span.for-sorting').html());
	        return valX <= valY;
	    }
	    jQuery.fn.dataTableExt.oSort["cur-asc"] = function(x,y) {
	        var valX = parseInt($("<div>" + x + "</div>").find('span.for-sorting').html());
	        var valY = parseInt($("<div>" + y + "</div>").find('span.for-sorting').html());
	        return valX >= valY;
	    }
	    $(".datatime-picker").datetimepicker({
	    	lang:'en'
	    });
	    
    </script>
   
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                  <b>Version</b> 2.3.8
                </div>
                <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
                reserved.
            </footer>
        </div>
        
        
    </body>
</html>