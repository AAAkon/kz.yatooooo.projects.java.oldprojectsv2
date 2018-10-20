<script>
function ChangePrice(amount,price){
	document.getElementById('purchase-price').innerHTML = ""+price * amount+"  &#8376;";
	document.getElementById('price').value = price * amount;
}
</script>