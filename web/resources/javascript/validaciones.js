     $(function(){
                $('#frm-registousuario').validate({
             rules:{
                     usuario:{
                         required : true
                     },
                     password:{
                         required: true
                     },
                     estado:{
                         required : true
                     },
                     nivel:{
                         required: true
                     }
                 },
                 messages:{
                      usuario : {
                          required: "El campo usuario es obligatorio"
                      },
                      password:{
                          required : "El campo password es obligatorio"
                      }
                     
                 },
                 errorPlacement: function(error, element) {
                  
                        error.insertAfter($(element).parent());
                }
           
            });
            $("#email").focusout(function(){
                valor = document.getElementById("email").value;
                 if( !(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(valor)) ) 
                 {
                    console.log("correo no valido");
                }else{
                    console.log("correo valido");
                }
                
            });
            
    });
    