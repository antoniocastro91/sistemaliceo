$(function()
{
    $('#frm-login').validate({
  submitHandler:function(form){
           var data =  $("#frm-login").serialize();
            $.post('Login', data, function(res, est, jqXHR){
               if(res == '1'){
                    
                    alert("Bienvenido admin, presione aceptar para ser redireccionado al MenuPirncipal")
                    setTimeout(function(){
                     window.location = "MenuMain.jsp";   
                        
                    },100);
                    
                }else if(res =='2'){
                    alert("Bienvenido usuario,presione aceptar para ser redireccionado al MenuPirncipal")
                    setTimeout(function(){
                     window.location = "MenuUsuario.jsp";   
                        
                    },100);
                    
                }else{
                    alert("Credenciales invalidas")
                }
                 });
        }
    });
});