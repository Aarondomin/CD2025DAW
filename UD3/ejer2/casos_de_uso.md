1. Identificación de actores

- Usuario normal
- Traballador
- Axente


```mermaid
flowchart LR
    actorUsuario([Cliente])
    actorAgente([Agente de viajes])


    casoBusca((Busca vuelo))
    casoReserva((Realiza Reserva))
    casoPaga((Paga reserva))
    casoGestiona((Modifica/Candela))
    casoServicio((Vuelo, Hotel, Coche))
    casoFecha((Fecha Inicio y Fecha fin))
    casoDestino((Destino))


    actorUsuario --> casoBusca
    actorUsuario --> casoReserva
    actorAgente --> casoBusca
    actorAgente --> casoReserva
    actorAgente --> casoGestiona
    

    casoReserva--<include>-->casoPaga
    casoBusca--<include>-->casoServicio
    casoBusca--<include>-->casoFecha
    casoBusca--<include>-->casoDestino


``` 