# SocketProgramming
Network programming : writing programs that can be executed over various
    computer devices, in which all the devices are connected to each other to
    share resources using a network.

    All the Java program communications over the network are done at the application
    layer.

    TCP - secure communication.
          connection oriented
    UDP - connection less protocol


    Socket - one endpoint of a two-way communication between two applications.

    Java Socket programming is used to communicate b/w applications working on
    different JRE.
        Socket and ServerSocket for connection oriented programming
        DatagramSocket and DatagramPacket are used for connection-less socket programming.

    Steps for TCP connection b/w two computers:
        -> server instantiates a ServerSocket object, indicating at which port number
        communication will occur.
        -> the server requests the accept() method of ServerSocket class. This program
        pauses until a client connects to the server on the given port.
        -> the constructor of the Socket class strives to connect the client to the
        designated server and the port number.

        the client's OutputStream is correlated to server's InputStream.
        client's InputStream is combined with the server's OutputStream.
