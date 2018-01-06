/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
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
                if(res == '1'){
                    alert("Bienvenido admin, presione aceptar para ser redireccionado al MenuPirncipal")
                    setTimeout(function(){
                     window.location = "MenuMain.jsp";   
                    },100);
                }else if(res =='2'){
                      
                        alert("Bienvenido usuario,presione aceptar para ser redireccionado al MenuPirncipal")
                        setTimeout (function () {
                         window.location = "MenuUsuario.jsp";   
                    },100);
                    
                }else{
                    
                    alert("Credenciales invalidas")
                }
            });
        
        }
        
     });
});