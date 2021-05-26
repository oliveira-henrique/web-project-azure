# language: pt
# charset: UTF-8

@Plan_Id=000011
@Des_Suite_Id=000021
@Qa_Suite_Id=000022
@Hom_Suite_Id=000023
Funcionalidade: Login
   Eu como cliente gostaria de acessar o sistema via login somente com credenciais validas

  @Test_Id=000001
   Cenario: Executar validacao veiculo
    Dado eu estou na tela Enter Vehicle Data
    Quando eu informar os dados  Enter Vehicle Data
    Quando eu informo os dados na tela Enter Insurant Data
    Quando eu informo os dados na tela Enter Product Data
    Quando eu informo os dados na tela Select Price Option
    Quando eu informo os dados na tela Send Quote
    Entao valida exibição da mensagem de sucesso
