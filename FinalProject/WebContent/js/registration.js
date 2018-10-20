<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#avatar')
                .attr('src', e.target.result)
                .width(100+"%")
                .height(100+"%");
            $('#avatar').css({'border-width':'3px','border-style':'solid','border-color':'#ff99ff'});
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>