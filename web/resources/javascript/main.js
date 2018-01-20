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
                    switch(res){
                        case 'principal':
                            window.location = "Vistas/Principal/principal.jsp"; 
                            break;
                        case 'lista_imagenes':
                            window.location = "Vistas/Principal/principal.jsp"; 
                            break;
                    }
                }else{
                    alert("Credenciales invalidas");
                }
            });
        
        }
    });
});
  
