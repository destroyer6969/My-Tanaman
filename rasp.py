import mysql.connector
import serial
import random
from copy import copy
from time import sleep

host = "127.0.0.1"
user = "root"
pwd = ""
db = "mytanaman"

mydb = mysql.connector.connect(host=host, user=user, passwd=pwd, database=db, autocommit=True)
mycursor = mydb.cursor()

serialConn = {"Sawi":serial.Serial("/dev/ttyUSB0", 19200, timeout=None),
                "Tomat":serial.Serial("/dev/ttyUSB1", 19200, timeout=None),
                "Bayam":serial.Serial("/dev/ttyUSB2", 19200, timeout=None)}
                
def readData(com):
    data = com.read(50)
    l = len(data)
    i=0
    while i<l and data[i]!='A': i+=1
    i+=1
    a=i
    while i<l and data[i]!='B': i+=1
    data = (data[a:i]).split(',')
    # com.flushInput()
    if len(data)<4: return None
    return data
    
while(True):
    for key in serialConn:
        query = "select relay1, relay2, relay3, relay4, relay5, relay6, relay7, relay8 from informasi where nama = '"+key+"'"
        mycursor.execute(query)
        relay = mycursor.fetchone()
        data = readData(serialConn[key])
        serialConn[key].write("A{}{}{}{}{}{}{}{}B".format(relay[0],relay[1],relay[2],relay[3],relay[4],relay[5],relay[6],relay[7]))
        if data is None: continue
        query = "insert into sensors (nama, suhu, cahaya, kelembaban, sudah_disinari) values ('{}', {}, {}, {}, {})".format(key, data[0], data[1], data[2], data[3])
        mycursor.execute(query)
    sleep(5)

mydb.close()
serialConn.close()