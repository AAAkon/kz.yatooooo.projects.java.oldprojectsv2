/**
 * 
 */

function getDatatableLanguages() {
	return {
	    "decimal":        "",
	    "emptyTable":     "Данные отсутствуют",
	    "info":           "Показывается _START_ - _END_, всего записей: _TOTAL_",
	    "infoEmpty":      "Показывается 0 - 0 из 0 записей",
	    "infoFiltered":   "(количество без фильтра: _MAX_)",
	    "infoPostFix":    "",
	    "thousands":      ",",
	    "lengthMenu":     "Показать _MENU_ записей",
	    "loadingRecords": "Загрузка...",
	    "processing":     "Обработка...",
	    "search":         "Поиск:",
	    "zeroRecords":    "По вашему запросу ничего не найденно",
	    "paginate": {
	        "first":      "Первая",
	        "last":       "Последняя",
	        "next":       "Следующая",
	        "previous":   "Предыдущая"
	    },
	    "aria": {
	        "sortAscending":  ": activate to sort column ascending",
	        "sortDescending": ": activate to sort column descending"
	    }
	};
}

$(document).ready(function () {
	if ($('.countdown').length > 0) {
		setInterval(function() {
			var items = $('.countdown');
			
			for (var i=0; i<items.length; i++) {
				var str = $(items[i]).html();
				var ar = str.split(" ");
				var subAr = ar[2].split(":");
				var date = (parseInt(ar[0]) * 3600 * 24) + parseInt(subAr[0]) * 3600 + parseInt(subAr[1]) * 60 + parseInt(subAr[2]);
				date--;
				var days = Math.floor(date / (24 * 3600));
				date -= days * 24 * 3600;
				var hours = Math.floor(date / 3600);
				if (hours < 10) hours = "0" + hours;
				date -= hours * 3600;
				var minutes = Math.floor(date / 60);
				if (minutes < 10) minutes = "0" + minutes;
				date -= minutes * 60;
				var seconds = date;
				if (seconds < 10) seconds = "0" + seconds;
				var str = days + " " + ar[1] + " " + hours + ":" + minutes + ":" + seconds;
				$(items[i]).html(str);
			}
			
		}, 1000);
	}
	
	//Date picker
	$('.datatime-picker').datetimepicker({
		format: "DD MMMM YYYY HH:mm",
		locale: 'ru'
	});
});

!function(a){a.fn.datepicker.dates.ru={days:["Воскресенье","Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"],daysShort:["Вск","Пнд","Втр","Срд","Чтв","Птн","Суб"],daysMin:["Вс","Пн","Вт","Ср","Чт","Пт","Сб"],months:["января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря"],monthsShort:["Янв","Фев","Мар","Апр","Май","Июн","Июл","Авг","Сен","Окт","Ноя","Дек"],today:"Сегодня",clear:"Очистить",format:"dd.mm.yyyy",weekStart:1,monthsTitle:"Месяцы"}}(jQuery);


		
