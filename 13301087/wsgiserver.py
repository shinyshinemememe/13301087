import socket
import StringIO
import sys
import os

class WSGIServer(object):
    def headers(self,client):
        buf = "HTTP/1.0 200 OK\r\n" + "Server:http\r\n" + "Content-Type: text/html\r\n" + "\r\n"
        client.send(buf)

    def read_file(self,path,client):
        if os.path.exists(path):
            path = str(path)
            st2 = open(path, "r")
            self.headers(client)
            self.cat(client, st2)

    def parse_request(self,text,client):
        self.request_line = text.splitlines()[0]
        self.request_line = self.request_line.rstrip('\r\n')
        (self.request_method,  
         self.path, 
         self.request_version  
         ) = self.request_line.split()

        if self.request_method == 'GET':
            split_path=self.path.split("?")
            if(split_path!='/favicon.ico'):
                print len(split_path),str(self.path)
                if len(split_path) > 1:
                    self.url = split_path[0]
                    self.quire_string = split_path[1]
                    result = self.app(self.get_environ(), self.start_response,client)
                    self.finish_response(result)

                else:
                    print 3
                    self.url = split_path[0][1:]
                    print self.url
                    self.read_file(self.url,client)
        else:   
            self.quire_string=str(text).split("\r\n\r\n")
            result = self.app(self.get_environ(), self.start_response)
            self.finish_response(result)

    def start_response(self,status,response_headers,exc_info=None):
        server_headers = [
            ('Date', 'Tue, 22 Mar 2016 12:54:48 GMT'),
            ('Server', 'WSGIServer 0.2'),]
        self.headers_set = [status, response_headers + server_headers]

    def finish_response(self,result):
        try:
            status, response_headers = self.headers_set
            response = 'HTTP/1.1 {status}\r\n'.format(status=status)
            for header in response_headers:
                response += '{0}: {1}\r\n'.format(*header)
            response += '\r\n'
            for data in result:
                response += data
           
            print(''.join(
                '> {line}\n'.format(line = line)
                for line in response.splitlines()
            ))
            client_connection.sendall(response)
			
        finally:
            client_connection.close()

    def cat(self,client,file1):
        linenow = file1.readline()
        client.send(linenow)
        while (linenow):
            client.send(linenow)
            linenow = file1.readline()

    def app(self,environ,start_response,client):
        status = '200 OK'
        response_headers = [('Content-Type','text/plain')]
        start_response(status,response_headers)
        s = environ.get("PATH_INFO")
        print 1111
        judge = 0
        if(len(str(s).split("."))==1):
            judge = 0
        else:
            if(str(s).split(".")[1]=='html'):
                judge = 1
        if judge == 1:
            if os.path.exists(s):
                path=str(s)[1:]
                st1 = open(path,"r")
                self.headers(client)
                self.cat(client,st1)
            else:
                return ["404 NOT FOUND"]
        else:
            return ['Hello wsgi ' + '^_^' + s]

    def get_environ(self):
        env = {}
        env['wsgi.version'] = (1, 0)
        env['wsgi.url_scheme'] = 'http'
        env['wsgi.input'] = StringIO.StringIO(self.request_line)
        env['wsgi.errors'] = sys.stderr
        env['wsgi.multithread'] = False
        env['wsgi.multiprocess'] = False
        env['wsgi.run_once'] = False       
        env['REQUEST_METHOD'] = str(self.request_method)  
        env['PATH_INFO'] = str(self.url)  
        env['SERVER_NAME'] = "server"  
        env['SERVER_PORT'] = port  
        env['quire_string'] = str(self.quire_string)  
        return env

address_family = socket.AF_INET
socket_type = socket.SOCK_STREAM
port = 3333

s = socket.socket(address_family, socket_type)
s.bind(("127.0.0.1", port))
s.listen(1)

while True:
    client_connection, client_address = s.accept()
    data = client_connection.recv(2048)
    wsgi = WSGIServer()
    wsgi.parse_request(data,client_connection)
s.close()