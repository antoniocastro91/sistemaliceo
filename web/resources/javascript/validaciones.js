     $(function(){
          $('#frm-registousuario').validate({
             rules:{
                     usuario:{
                         required : true
                     },
                     clave:{
                         required: true
                     },
                     estado:{
                         required : true
                     },
                     email:{
                         required: true
                     }
                 },
                 messages:{
                      usuario : {
                          required: "El campo usuario es obligatorio"
                      },
                      clave:{
                          required : "El campo clave es obligatorio"
                      },
                      email:{
                          required : "El campo email es obligatorio"
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
                    alert("correo no valido");
                }else{
                    alert("correo valido");
                }
                
            });
            
            //Validaciones para RegistroFichas
          $('#frm-registropieza').validate({
             rules:{
                     numinv:{
                         required : true
                     }, 
                     descrip:{
                         required: true
                     },
                     nombre:{
                         required : true
                     },
                     forma:{
                         required: true
                     },
                     material:{
                         required: true
                     },
                     tecnica:{
                         required: true
                     },
                     color:{
                         required: true
                     },
                     periodo:{
                         required: true
                     },
                     alto:{
                         required: true
                     },
                     ancho:{
                         required: true
                     },
                     largo:{
                         required: true
                     },
                     diametro:{
                         required: true
                     },
                     grosor:{
                         required: true
                     },
                     peso:{
                         required: true
                     },
                     procedencia:{
                         required: true
                     },
                     condicion:{
                         required: true
                     },
                     formaadquisicion:{
                         required: true
                     },
                     fechaadquisi:{
                         required: true
                     },
                     regimenpro:{
                         required: true
                     },
                     custodio:{
                         required: true
                     },
                     fechainv:{
                         required: true
                     },
                     observaciones:{
                         required: true
                     }
                 },
                 messages:{
                      numinv : {
                          required: "El campo Num Inv es obligatorio"
                      },
                      descrip:{
                          required : "El campo Descripcion es obligatorio"
                      },
                      forma:{
                          required : "El campo forma es obligatorio"
                      },
                      material:{
                          required : "El campo material es obligatorio"
                      },
                      tecnica:{
                          required : "El campo tecnica es obligatorio"
                      },
                      color:{
                          required : "El campo color es obligatorio"
                      },
                      periodo:{
                          required : "El campo periodo es obligatorio"
                      },
                      alto:{
                          required : "El campo alto es obligatorio"
                      },
                      ancho:{
                          required : "El campo ancho es obligatorio"
                      },
                      largo:{
                          required : "El campo largo es obligatorio"
                      },
                      diametro:{
                          required : "El campo largo es obligatorio"
                      },
                      grosor:{
                          required : "El campo grosor es obligatorio"
                      },
                      peso:{
                          required : "El campo peso es obligatorio"
                      },
                      procedencia:{
                          required : "El campo procedencia es obligatorio"
                      },
                      condicion:{
                          required : "El campo condicion es obligatorio"
                      },
                      formaadquisicion:{
                          required : "El campo formaadquisicion es obligatorio"
                      },
                      fechaadquisi:{
                          required : "El campo fecha es obligatorio"
                      },
                      regimenpro:{
                          required : "El campo regimenpro es obligatorio"
                      },
                      custodio:{
                          required : "El campo custodio es obligatorio"
                      },
                      fechainv:{
                          required : "El campo fecha es obligatorio"
                      },
                      observaciones:{
                          required : "El campo observaciones es obligatorio"
                      }
               },
                        errorPlacement: function(error, element) {
                        error.insertAfter($(element).parent());
                }
  
            });       
            
    });
    