import socket       

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(('127.0.0.1', 12345))
client.send(b'Hello from client!')
data = client.recv(1024)
print(f'Received: {data.decode()}')
client.close()