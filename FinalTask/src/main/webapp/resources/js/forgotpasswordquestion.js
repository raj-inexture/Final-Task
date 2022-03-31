// Select Security Question Data

var optionsSecurity = [{
	"text": "What is your nickname?",
	"value": "What is your nickname?"
},
{
	"text": "What is the name of your first pet?",
	"value": "What is the name of your first pet?"
},
{
	"text": "What was your first car?",
	"value": "What was your first car?"
},
{
	"text": "What elementary school did you attend?",
	"value": "What elementary school did you attend?"
},
{
	"text": "What is the name of the town where you were born?",
	"value": "What is the name of the town where you were born?"
},
];

var selectSecurityBox = document.getElementById('securityquestion');

for (var i = 0, l = optionsSecurity.length; i < l; i++) {
	var optionsecure = optionsSecurity[i];
	selectSecurityBox.options.add(new Option(optionsecure.text, optionsecure.value));
}