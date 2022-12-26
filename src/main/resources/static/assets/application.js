$(document).ready(function () {
    $("#account-form").hide();
    var loginForm = $("#login-form").show();
    loginForm.submit(function(e) {
        e.preventDefault();
        console.log("got login information"+loginForm.serialize());
        var datum = {};
	    datum["username"] = $("#loginId").val();
	    datum["password"] = $("#loginPassword").val();
	    var json = JSON.stringify(datum);
	    console.log("got user information"+json);
        $.post({
                url: '/authenticate',
                processData: false,
	            contentType: 'application/json',
                data:json,
                success: function(response, status) {
                    console.log(response.token);
                    console.log(status);
                    $("#jwtTokenHeader").val(response.token);
                    $("#login-form").hide();
                    var form = $("#account-form").show();
				    form.steps({
				        headerTag: "h3",
				        bodyTag: "fieldset",
				        transitionEffect: "slideLeft",
				        onStepChanging: function (event, currentIndex, newIndex) {
				            console.log("Allways allow previous action even if the current form is not valid!");
				            if (currentIndex > newIndex) {
				                return true;
				            }
				            console.log("Forbid next action on Warning step if the user is to young");
				            if (newIndex === 3 && Number($("#age-2").val()) < 18) {
				                return false;
				            }
				            console.log("Needed in some cases if the user went back (clean up)");
				            if (currentIndex < newIndex) {
				                // To remove error styles
				                form.find(".body:eq(" + newIndex + ") label.error").remove();
				                form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
				            }
				            form.validate().settings.ignore = ":disabled,:hidden";
				            return form.valid();
				        },
				        onStepChanged: function (event, currentIndex, priorIndex) {
				            console.log("Used to skip the Warning step if the user is old enough.");
				            if (currentIndex === 2 && Number($("#age-2").val()) >= 18) {
				                form.steps("next");
				            }
				            console.log("Used to skip the Warning step if the user is old enough and wants to the previous step.");
				            if (currentIndex === 2 && priorIndex === 3) {
				                form.steps("previous");
				            }
				        },
				        onFinishing: function (event, currentIndex) {
				            form.validate().settings.ignore = ":disabled";
				            return form.valid();
				        },
				        onFinished: function (event, currentIndex) {
				            form.submit();
				        }
				    }).validate({
				        errorPlacement: function errorPlacement(error, element) {
				            element.before(error);
				        },
				        rules: {
				            confirm: {
				                equalTo: "#password-2"
				            }
				        }
				    });
                }
        });

    });
});