<script type="text/javascript">

$(document).ready(function(){
	$("input[type=file]").change(function(){
        var input = $(this)[0];
        if (input.files && input.files[0]) {
        	
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#avatar'+input.id)
                    .attr('src', e.target.result)
                    .width(90+"%")
                    .height(90+"%");
            };

            reader.readAsDataURL(input.files[0]);
        }
    });
});




function OtherCategory2($value){
	if($value=="other"){
		$("#OtherCategory2").show(1000);
	}else if($value==""){
		$("#OtherCategory2").hide(1000);
	}else{
		$("#OtherCategory2").hide(1000);
	}
}


function OtherCategory($value){
	if($value=="other"){
		$("#OtherCategory").show(1000);
	}else if($value==""){
		$("#OtherCategory").hide(1000);
	}else{
		$("#OtherCategory").hide(1000);
	}
}

$(document).ready(function(){
    $("button#AddHandmakeFormToggle").click(function(){
        $("#AddHandmakeForm").toggle(1000);
    });
});
</script>
