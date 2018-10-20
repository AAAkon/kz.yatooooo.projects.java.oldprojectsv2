<script>

function ChangePrice(amount,price){
	document.getElementById('purchase-price').innerHTML = "Price: "+price * amount+"  &#8376;";
}



function AddToBasket(){
	
	var id = $('#id').val();
	var amount = $('#amount').val();
	
	
	var params = {
			id: $('#id').val(),
	    	amount: $('#amount').val()
	};
		
	$.ajax({
	    url: 'item?action=AddToBasket&' + $.param(params),
	    type: 'post'
	});
	
	
}
</script>