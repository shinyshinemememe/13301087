# ��wsgirefģ�鵼��:
from wsgiref.simple_server import make_server
# ���������Լ���д��application����:
from hello import application

# ����һ����������IP��ַΪ�գ��˿���8888����������application:
httpd = make_server('', 8888, application)
print('Serving HTTP on port 8888...')
# ��ʼ����HTTP����:
httpd.serve_forever()