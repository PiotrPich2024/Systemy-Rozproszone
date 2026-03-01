import socket

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(('0.0.0.0', 12345))

server.listen(5)

while True:
    client, addr = server.accept()
    print(f'Connection from {addr}')

    data = client.recv(1024)
    print(f'Received: {data.decode()}')

    client.send(b'Hello from server!')
    client.close()