// Toggle Button for Adding and Removing Addresses

var template = $('#addresssection .addressclass:first').clone();

// Counter
var sectionsCount = $('.addressclass').length;

var addressline1 = $("input[name='addressline1']");

if (sectionsCount == 1) {
	//remove section
	$('.remove').parent().addClass('toggleButton');
} else {
	$('.remove').parent().removeClass('toggleButton');
}

// Add Address
$('body').on('click', '.addsection', function() {

	sectionsCount++;

	$('.remove').parent().removeClass('toggleButton');

	var section = template.clone().find(':input[type="text"]').val("").each(function() {

		//set id to store the updated section number
		var newId = this.id + sectionsCount;

		//update for label
		$(this).prev().attr('for', newId);

		//update id
		this.id = newId;

	}).end()

		//inject new section
		.appendTo('#addresssection');
	return false;
});

//remove section
$('#addresssection').on('click', '.remove', function() {

	//decrement
	sectionsCount--;

	if (sectionsCount == 1) {
		//remove section
		$('.remove').parent().addClass('toggleButton');
	} else {
		$('.remove').parent().removeClass('toggleButton');
	}

	//fade out section
	$(this).parent().fadeOut(300, function() {
		//remove parent element (main section)
		$(this).parent().parent().empty();
		return false;
	});
	return false;
});