**SPRING** 

WebSocketStompClient - STOMP над WebSocket клиента , который подключается с помощью реализации в WebSocketClient том числе SockJsClient.
StompSession
StompClientSupport
StompExceptionEvent
StompMessageHandler - испускает StompReceiptEvent

StompSessionManager - Абстракция для управления сеансом STOMP и подключения / отключения StompSessionHandler.

AbstractStompSessionManager


MessageConverter

**SI**
org.springframework.integration.Message

StompReceiptEvent -> StompIntegrationEvent - Базовый класс для всех ApplicationEvents, сгенерированных адаптерами STOMP.


StompInboundChannelAdapter -> MessageProducerSupport - из STOMP
<int-stomp:inbound-channel-adapter
                           id=""                     1
                           channel=""                2
                           error-channel=""          3
                           stomp-session-manager=""  4
                           header-mapper=""          5
                           mapped-headers=""         6
                           destinations=""           7
                           send-timeout=""           8
                           payload-type=""           9
                           auto-startup=""           10
                           phase=""/>  

MessageProducer


TextWebSocketHandler, BinaryWebSocketHandler



StompIntegrationEvent - испускает это событие




Message Channel -> 



Handshake - рукопожатие


ervice-activator - это тип конечной точки для подключения бина в качестве сервиса.


часто используется как динамическая альтернатива статически настроенному выходному каналу 
