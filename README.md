1- Todo depende de la logica utilizada, si vamos al caso se necesitarian "n" numero de Threads, puede ser 1 que ejecute 100 veces la acción como también se pueden instanciar 5 threads y que se de el hipotetico caso de que solo ingresen 4 threads a consumir el stock. 
2- Los bloques Synchronized son utilizados para limitar un metodo sin hacer todo el metodo Synchronized, sirven para ser multiaccedidos por los hilos de ejecución, a su vez estos bloques permiten la interacción con la acción especifica, en caso de no querer que accedan se setea una variable que hace al thread en un ciclo de wait() hasta que se notifique y la variable previamente mencionada este liberada.
3- En este caso nuestro recurso compartido es BeerHouse, como su nombre lo dice es un bloque que comparte con multiples hilos de ejecucción aqui es donde se almacenan nuestros bloques Synchronized.
4- Formas de instanciar un Thread:
    a-Extender de Thread,realizar un override del metodo .run(),instanciar nuestra clase y ejecutar metodo .start()
    b-Implementar Runnable,tambien realizar override de .run(),instanciar un Thread mediante new Thread(NuestraClase) e iniciar el metodo .star() en la instancia del Thread.
    c-Implementar Callable, es similar al uso de Runnable solo que esta interfaz permite el retorno de datos y emitir una Exception en caso de no poder retornar datos.
