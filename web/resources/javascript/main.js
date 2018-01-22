$(function()
{   //Formulario login
   $('#frm-login').validate({
      rules:{
           usuario:{
               required : true
           },
           clave:{
               required: true
          
           }
       },
       messages:{
            usuario : {
                required: "El campo usuario es obligatorio"
            },
            clave:{
                required : "El campo password es obligatorio"
              
            }
       },
       submitHandler:function(form){
            var data =  $("#frm-login").serialize();
            $.post('Login', data, function(res, est, jqXHR){
                if(res != 'error'){
                    window.location = "Vistas/Principal/principal.jsp"; 
                }else{
                    alert("Credenciales invalidas");
                }
            });
        
        }
    });
});
  
