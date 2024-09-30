#language: pt
Funcionalidade: Reserva

  Cenário: Fazer uma Reserva
    Quando realizar uma reserva com os detalhes do restaurante escolhido
    Então a reserva deve ser confirmada com sucesso


  #Cenario: Buscar Reserva
  #  Dado que uma reserva já foi realizada
   # Quando realizar a busca das reservas realizadas
    #Entao as reservas devem ser apresentadas

  #Cenario: Alterar Data Reserva
   # Dado que uma reserva já foi realizada
    #Quando realizar a alteração da data da reserva
    #Entao deve apresentar a nova data da reserva

 # Cenario: Alterar Hora Reserva
  #  Dado que uma reserva já foi realizada
   # Quando realizar a alteração da hora da reserva
    #Entao deve apresentar a nova hora da reserva

#  Cenario: Excluir reserva
 #   Dado que uma reserva ja foi realizada
  #  Quando requisitar a remoção da reserva
   # Entao a reserva devera ser excluida com sucesso
