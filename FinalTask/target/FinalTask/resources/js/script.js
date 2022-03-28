(function ($) {
    'use strict';
    /*==================================================================
        [ Daterangepicker ]*/
    try {
        $('.js-datepicker').daterangepicker({
            "singleDatePicker": true,
            "showDropdowns": true,
            "autoUpdateInput": false,
            locale: {
                format: 'DD/MM/YYYY'
            },
        });

        var myCalendar = $('.js-datepicker');
        var isClick = 0;

        $(window).on('click', function () {
            isClick = 0;
        });

        $(myCalendar).on('apply.daterangepicker', function (ev, picker) {
            isClick = 0;
            $(this).val(picker.startDate.format('DD/MM/YYYY'));

        });

        $('.js-btn-calendar').on('click', function (e) {
            e.stopPropagation();

            if (isClick === 1) isClick = 0;
            else if (isClick === 0) isClick = 1;

            if (isClick === 1) {
                myCalendar.focus();
            }
        });

        $(myCalendar).on('click', function (e) {
            e.stopPropagation();
            isClick = 1;
        });

        $('.daterangepicker').on('click', function (e) {
            e.stopPropagation();
        });


    } catch (er) {
        console.log(er);
    }
    /*[ Select 2 Config ]
        ===========================================================*/

    try {
        var selectSimple = $('.js-select-simple');

        selectSimple.each(function () {
            var that = $(this);
            var selectBox = that.find('select');
            var selectDropdown = that.find('.select-dropdown');
            selectBox.select2({
                dropdownParent: selectDropdown
            });
        });

    } catch (err) {
        console.log(err);
    }


})(jQuery);

var options = [{
        "text": "Andaman and Nicobar Islands",
        "value": "Andaman and Nicobar Islands"
    },
    {
        "text": "Andhra Pradesh",
        "value": "Andhra Pradesh"
    },
    {
        "text": "Arunachal Pradesh",
        "value": "Arunachal Pradesh"
    },
    {
        "text": "Assam",
        "value": "Assam"
    },
    {
        "text": "Bihar",
        "value": "Bihar"
    },
    {
        "text": "Chandigarh",
        "value": "Chandigarh"
    },
    {
        "text": "Chhattisgarh",
        "value": "Chhattisgarh"
    },
    {
        "text": "Dadra and Nagar Haveli",
        "value": "Dadra and Nagar Haveli"
    },
    {
        "text": "Daman and Diu",
        "value": "Daman and Diu"
    },
    {
        "text": "Delhi",
        "value": "Delhi"
    },
    {
        "text": "Goa",
        "value": "Goa"
    },
    {
        "text": "Gujarat",
        "value": "Gujarat"
    },
    {
        "text": "Haryana",
        "value": "Haryana"
    },
    {
        "text": "Himachal Pradesh",
        "value": "Himachal Pradesh"
    },
    {
        "text": "Jammu and Kashmir",
        "value": "Jammu and Kashmir"
    },
    {
        "text": "Jharkhand",
        "value": "Jharkhand"
    },
    {
        "text": "Karnataka",
        "value": "Karnataka"
    },
    {
        "text": "Kerala",
        "value": "Kerala"
    },
    {
        "text": "Lakshadweep",
        "value": "Lakshadweep"
    },
    {
        "text": "Madhya Pradesh",
        "value": "Madhya Pradesh"
    },
    {
        "text": "Maharashtra",
        "value": "Maharashtra"
    },
    {
        "text": "Manipur",
        "value": "Manipur"
    },
    {
        "text": "Meghalaya",
        "value": "Meghalaya"
    },
    {
        "text": "Mizoram",
        "value": "Mizoram"
    },
    {
        "text": "Nagaland",
        "value": "Nagaland"
    },
    {
        "text": "Odisha",
        "value": "Odisha"
    },
    {
        "text": "Puducherry",
        "value": "Puducherry"
    },
    {
        "text": "Punjab",
        "value": "Punjab"
    },
    {
        "text": "Rajasthan",
        "value": "Rajasthan"
    },
    {
        "text": "Sikkim",
        "value": "Sikkim"
    },
    {
        "text": "Tamil Nadu",
        "value": "Tamil Nadu"
    },
    {
        "text": "Telangana",
        "value": "Telangana"
    },
    {
        "text": "Tripura",
        "value": "Tripura"
    },
    {
        "text": "Uttar Pradesh",
        "value": "Uttar Pradesh"
    },
    {
        "text": "Uttarakhand",
        "value": "Uttarakhand"
    },
    {
        "text": "West Bengal",
        "value": "West Bengal"
    }
];

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

var selectBox = document.getElementById('states');

for (var i = 0, l = options.length; i < l; i++) {
    var option = options[i];
    selectBox.options.add(new Option(option.text, option.value));
}

var selectSecurityBox = document.getElementById('securityquestion');

for (var i = 0, l = optionsSecurity.length; i < l; i++) {
    var optionsecure = optionsSecurity[i];
    selectSecurityBox.options.add(new Option(optionsecure.text, optionsecure.value));
}